package net.Cheesedude11.Ores_and_Bosses.event;

import net.Cheesedude11.Ores_and_Bosses.item.custom.Lightning_Hammer_Item;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

import java.util.List;

public class LightningHammerAbilityHandler {
    @SubscribeEvent
    public void onRightClick(PlayerInteractEvent.RightClickItem event) {
        Player player = event.getEntity();
        Level level = player.level();
        ItemStack stack = event.getItemStack();

        if (!(stack.getItem() instanceof Lightning_Hammer_Item)) return;
        if (level.isClientSide) return;

        // Cooldown check
        if (player.getCooldowns().isOnCooldown(stack.getItem())) return;

        double radius = 4.0;
        List<LivingEntity> targets = level.getEntitiesOfClass(LivingEntity.class,
                player.getBoundingBox().inflate(radius),
                e -> e != player && e.isAlive());

        for (LivingEntity entity : targets) {
            entity.hurt(player.damageSources().indirectMagic(player, player), 5.0f);
        }

        // Spawn particles on each affected entity
        if (level instanceof ServerLevel serverLevel) {
            int particleCount = 100; // Adjust for density

            for (int i = 0; i < particleCount; i++) {
                double offsetX = (player.getRandom().nextDouble() * 2 - 1) * radius;
                double offsetY = (player.getRandom().nextDouble() * 1.5); // vertical range
                double offsetZ = (player.getRandom().nextDouble() * 2 - 1) * radius;

                double px = player.getX() + offsetX;
                double py = player.getY() + offsetY + 0.5; // lift to torso/head height
                double pz = player.getZ() + offsetZ;

                serverLevel.sendParticles(
                        ParticleTypes.SONIC_BOOM,
                        px, py, pz,
                        1,      // count per spawn
                        0, 0, 0, // no spread (we control placement)
                        0.01
                );
            }
        }

        // Sound & cooldown
        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.TRIDENT_THUNDER, SoundSource.PLAYERS, 1.0f, 1.2f);
        player.getCooldowns().addCooldown(stack.getItem(), 20 * 15); // 15 seconds

        event.setCanceled(true); // prevent eating, blocking, etc.
    }
}
