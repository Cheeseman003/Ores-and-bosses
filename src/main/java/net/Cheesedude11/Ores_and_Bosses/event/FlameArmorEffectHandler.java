package net.Cheesedude11.Ores_and_Bosses.event;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

import java.util.HashMap;
import java.util.UUID;

public class FlameArmorEffectHandler {

    public static final HashMap<UUID, Integer> fireTime = new HashMap<>();

    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Post event) {
        Player player = event.getEntity();
        UUID id = player.getUUID();
        Level level = player.level();

        if (level.isClientSide) return;

        if (isWearingFullFlameArmor(player)) {
            BlockPos pos = player.blockPosition();
            BlockState state = level.getBlockState(pos);

            boolean inFireOrLava = state.is(Blocks.FIRE)
                    || state.is(Blocks.SOUL_FIRE)
                    || state.is(Blocks.LAVA);


            if (inFireOrLava) {
                int time = fireTime.getOrDefault(id, 0) + 1;
                fireTime.put(id, time);

                if (time >= 80 && !hasHeatOverloadBuffs(player)) {
                    player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 160, 1)); // 8s
                    player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 160, 1));    // 8s
                    fireTime.put(id, 0); // Reset
                }
            } else {
                fireTime.put(id, 0); // Reset if no longer in fire
            }
        } else {
            fireTime.put(id, 0); // Reset if not wearing armor
        }
    }

    private static boolean hasHeatOverloadBuffs(Player player) {
        return player.hasEffect(MobEffects.MOVEMENT_SPEED) && player.hasEffect(MobEffects.DAMAGE_BOOST);
    }

    private static boolean isWearingFullFlameArmor(Player player) {
        for (ItemStack stack : player.getArmorSlots()) {
            if (stack.isEmpty()) return false;
            String id = stack.getItem().getDescriptionId();
            if (!(id.contains("flame_helmet") || id.contains("flame_chestplate") ||
                    id.contains("flame_leggings") || id.contains("flame_boots"))) {
                return false;
            }
        }
        return true;
    }
}