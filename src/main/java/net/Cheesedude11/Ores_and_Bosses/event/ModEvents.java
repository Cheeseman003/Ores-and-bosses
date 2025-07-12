package net.Cheesedude11.Ores_and_Bosses.event;

import net.Cheesedude11.Ores_and_Bosses.OresAndBosses;
import net.Cheesedude11.Ores_and_Bosses.item.ModItems;
import net.Cheesedude11.Ores_and_Bosses.item.custom.HammerItem;
import net.Cheesedude11.Ores_and_Bosses.item.custom.ShiverheartSword;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.player.ArrowLooseEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@EventBusSubscriber
public class ModEvents {

    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Post event) {
        Player player = event.getEntity();

        if (!player.level().isClientSide && isWearingFullFrostArmor(player)) {
            player.setTicksFrozen(0); // reset freezing
            player.setIsInPowderSnow(false);
        }


        if (!player.level().isClientSide && isWearingFullFrostArmor(player)) {
            System.out.println("Player wearing full Frost Armor, applying slow to mobs.");

            int radius = 5;
            AABB area = player.getBoundingBox().inflate(radius);

            player.level().getEntitiesOfClass(Mob.class, area).forEach(mob -> {
                mob.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 1));
            });
        }
    }

    public static boolean isWearingFullFrostArmor(Player player) {
        Item head = player.getInventory().getArmor(3).getItem();
        Item chest = player.getInventory().getArmor(2).getItem();
        Item legs = player.getInventory().getArmor(1).getItem();
        Item feet = player.getInventory().getArmor(0).getItem();

        return head == ModItems.FROST_HELMET.get()
                && chest == ModItems.FROST_CHESTPLATE.get()
                && legs == ModItems.FROST_LEGGINGS.get()
                && feet == ModItems.FROST_BOOTS.get();
    }








    @SubscribeEvent
    public static void livingDamage(LivingDamageEvent.Pre event) {
        if (event.getEntity() instanceof Sheep sheep && event.getSource().getDirectEntity() instanceof Player player){
            if(player.getMainHandItem().getItem() == Items.END_ROD) {
                player.sendSystemMessage(Component.literal(player.getName().getString() + " just shoved a dildo up a sheeps ass"));
                sheep.addEffect(new MobEffectInstance(MobEffects.OOZING, 20, 5));
                player.getMainHandItem().shrink(1);
            }

        }
    }



    private static final Set<BlockPos> HARVESTED_BLOCKS = new HashSet<>();

    // Done with the help of https://github.com/CoFH/CoFHCore/blob/1.19.x/src/main/java/cofh/core/event/AreaEffectEvents.java
    // Don't be a jerk License
    @SubscribeEvent
    public static void onHammerUsage(BlockEvent.BreakEvent event) {
        Player player = event.getPlayer();
        ItemStack mainHandItem = player.getMainHandItem();

        if(mainHandItem.getItem() instanceof HammerItem hammer && player instanceof ServerPlayer serverPlayer) {
            BlockPos initialBlockPos = event.getPos();
            if(HARVESTED_BLOCKS.contains(initialBlockPos)) {
                return;
            }

            for(BlockPos pos : HammerItem.getBlocksToBeDestroyed(1, initialBlockPos, serverPlayer)) {
                if(pos == initialBlockPos || !hammer.isCorrectToolForDrops(mainHandItem, event.getLevel().getBlockState(pos))) {
                    continue;
                }

                HARVESTED_BLOCKS.add(pos);
                serverPlayer.gameMode.destroyBlock(pos);
                HARVESTED_BLOCKS.remove(pos);
            }
        }
    }

    @SubscribeEvent
    public static void onRightClick(PlayerInteractEvent.RightClickItem event) {
        Player player = event.getEntity();
        Level level = player.level();
        ItemStack stack = event.getItemStack();

        if (!(stack.getItem() instanceof ShiverheartSword)) return;

        if (!level.isClientSide) {
            // Check cooldown
            if (player.getCooldowns().isOnCooldown(stack.getItem())) {
                return;
            }

            // Perform cone ability here

            Vec3 look = player.getLookAngle();

            // Define cone range and angle
            double coneRange = 5.0;
            double coneCosAngle = Math.cos(Math.toRadians(45)); // 45 degree cone

            // Search entities in a sphere around player
            List<LivingEntity> targets = level.getEntitiesOfClass(LivingEntity.class, player.getBoundingBox().inflate(coneRange),
                    e -> e != player && e.isAlive());

            for (LivingEntity target : targets) {
                Vec3 dirToTarget = target.position().subtract(player.position()).normalize();
                double dot = look.dot(dirToTarget);
                if (dot >= coneCosAngle) {
                    // In cone — apply damage & slow
                    target.hurt(player.damageSources().magic(), 5.0f);
                    target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 2));
                }
            }

            // Play particles & sound here if you want

            // Add cooldown
            player.getCooldowns().addCooldown(stack.getItem(), 20 * 20); // 20 seconds

            // Cancel event to prevent default right click behavior if needed
            event.setCanceled(true);
        }
    }
}



