package net.Cheesedude11.Ores_and_Bosses.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;

import javax.annotation.Nullable;
import java.util.List;

public class ShiverheartSword extends SwordItem {
    private static final String HIT_COUNT_KEY = "shiverheart_hit_count";
    private static final int SHATTER_THRESHOLD = 3;

    public ShiverheartSword(Tier tier, Properties properties) {
        super(tier, properties);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (!target.level().isClientSide) {
            CompoundTag data = target.getPersistentData();
            int hitCount = data.getInt(HIT_COUNT_KEY);
            hitCount++;

            if (hitCount >= SHATTER_THRESHOLD) {
                // Shatter effect

                float bonusDamage = 6.0f;
                if (attacker instanceof Player player) {
                    target.hurt(player.damageSources().playerAttack(player), bonusDamage);
                } else {
                    target.hurt(target.damageSources().magic(), bonusDamage);
                }

                int stunDuration = 40; // 2 seconds
                target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, stunDuration, 4));
                target.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, stunDuration, 0));

                // Reset hit count
                data.putInt(HIT_COUNT_KEY, 0);

            } else {
                // Normal slow effect per hit
                target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 1, false, false));
                data.putInt(HIT_COUNT_KEY, hitCount);
            }
        }

        return super.hurtEnemy(stack, target, attacker);
    }

    // Cooldown bar and tooltip remain unchanged
    @Override
    public boolean isBarVisible(ItemStack stack) {
        return true;
    }

    @Override
    public int getBarWidth(ItemStack stack) {
        var player = Minecraft.getInstance().player;
        if (player == null) return 0;

        float cooldown = player.getCooldowns().getCooldownPercent(this, 0f);
        return Math.round(13 - cooldown * 13);
    }

    @Override
    public int getBarColor(ItemStack stack) {
        return 0x66ccff; // icy blue
    }

    // Tooltip with ability info + lore

    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.translatable("shiverheart.lore"));
        tooltip.add(Component.translatable("shiverheart.ability"));
        tooltip.add(Component.translatable("shiverheart.slow"));
        tooltip.add(Component.translatable("shiverheart.cooldown"));
        tooltip.add(Component.translatable("shiverheart.abilitytip"));

    }
}