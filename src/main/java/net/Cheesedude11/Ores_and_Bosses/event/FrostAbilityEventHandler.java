package net.Cheesedude11.Ores_and_Bosses.event;

import net.Cheesedude11.Ores_and_Bosses.item.custom.ShiverheartSword;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

import java.util.List;


public class FrostAbilityEventHandler {

    @SubscribeEvent
    public static void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
        Player player = event.getEntity();
        Level level = player.level();
        ItemStack stack = event.getItemStack();

        if (!(stack.getItem() instanceof ShiverheartSword)) return;

        // Cooldown check before anything else
        if (player.getCooldowns().isOnCooldown(stack.getItem())) return;

        // Add cooldown right away to prevent spamming
        player.getCooldowns().addCooldown(stack.getItem(), 15 * 15); // 20 seconds

        // Prevent default right-click action
        event.setCanceled(true);

        if (!level.isClientSide) {
            double coneRange = 5.0;
            double coneCosAngle = Math.cos(Math.toRadians(45)); // 45 degrees cone
            Vec3 look = player.getLookAngle().normalize();

            // Frost burst damage + slow effect
            List<LivingEntity> targets = level.getEntitiesOfClass(LivingEntity.class,
                    player.getBoundingBox().inflate(coneRange),
                    e -> e != player && e.isAlive());

            for (LivingEntity target : targets) {
                Vec3 dirToTarget = target.position().subtract(player.position()).normalize();
                double dot = look.dot(dirToTarget);

                if (dot >= coneCosAngle) {
                    target.hurt(player.damageSources().magic(), 5.0f);
                    target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 2));
                    target.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 60, 1));
                }
            }

            // Freeze water nearby
            BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
            for (BlockPos nearby : BlockPos.betweenClosed(player.blockPosition().offset(-2, -1, -2), player.blockPosition().offset(2, -1, 2))) {
                pos.set(nearby);
                if (level.getBlockState(pos).is(Blocks.WATER)) {
                    level.setBlockAndUpdate(pos, Blocks.FROSTED_ICE.defaultBlockState());
                }
            }

            // Sound
            level.playSound(null, player.blockPosition(), SoundEvents.GLASS_BREAK, SoundSource.PLAYERS, 1.0f, 0.6f);

            // Particle cone burst
            ServerLevel serverLevel = (ServerLevel) level;
            int particleCount = 60;
            double coneAngleRad = Math.toRadians(45);

            for (int i = 0; i < particleCount; i++) {
                double distance = player.getRandom().nextDouble() * coneRange;
                double angleOffset = player.getRandom().nextDouble() * coneAngleRad;
                double rotation = player.getRandom().nextDouble() * Math.PI * 2;

                Vec3 basePos = player.position().add(0, player.getEyeHeight(), 0).add(look.scale(distance));

                Vec3 perpendicular1 = look.cross(new Vec3(0, 1, 0));
                if (perpendicular1.lengthSqr() < 0.001) {
                    perpendicular1 = look.cross(new Vec3(1, 0, 0));
                }
                perpendicular1 = perpendicular1.normalize();
                Vec3 perpendicular2 = look.cross(perpendicular1).normalize();

                double radius = distance * Math.tan(angleOffset);

                double offsetX = perpendicular1.x * Math.cos(rotation) * radius + perpendicular2.x * Math.sin(rotation) * radius;
                double offsetY = perpendicular1.y * Math.cos(rotation) * radius + perpendicular2.y * Math.sin(rotation) * radius;
                double offsetZ = perpendicular1.z * Math.cos(rotation) * radius + perpendicular2.z * Math.sin(rotation) * radius;

                double px = basePos.x + offsetX;
                double py = basePos.y + offsetY;
                double pz = basePos.z + offsetZ;

                serverLevel.sendParticles(ParticleTypes.SNOWFLAKE, px, py, pz, 1, 0, 0, 0, 0);
            }
        }
    }
}

