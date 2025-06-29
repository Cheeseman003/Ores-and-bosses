package net.Cheesedude11.Ores_and_Bosses.event;

import net.Cheesedude11.Ores_and_Bosses.OresAndBosses;
import net.Cheesedude11.Ores_and_Bosses.item.ModItems;
import net.Cheesedude11.Ores_and_Bosses.item.custom.HammerItem;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

import java.util.HashSet;
import java.util.Set;

@EventBusSubscriber
public class ModEvents {

    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Post event) {
        Player player = event.getEntity();

        if (!player.level().isClientSide && isWearingFullFrostArmor(player)) {
            player.setTicksFrozen(0); // reset freezing
            player.setIsInPowderSnow(false); // optional safety
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


    }


