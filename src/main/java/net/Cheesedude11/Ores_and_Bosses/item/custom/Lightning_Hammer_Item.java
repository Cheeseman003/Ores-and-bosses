package net.Cheesedude11.Ores_and_Bosses.item.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import java.util.Properties;

public class Lightning_Hammer_Item extends SwordItem {
    public Lightning_Hammer_Item(Tier p_tier, Properties p_properties) {
        super(p_tier, p_properties);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        Level level = target.level();

        if (!level.isClientSide && level instanceof ServerLevel serverLevel) {
            if (RandomSource.create().nextFloat() < 0.5f) { // 25% chance
                LightningBolt lightning = new LightningBolt(EntityType.LIGHTNING_BOLT, serverLevel);
                lightning.moveTo(target.getX(), target.getY(), target.getZ());                if (attacker instanceof Player player) {
                    lightning.setCause((ServerPlayer) player);
                }
                serverLevel.addFreshEntity(lightning);
            }
        }

        return super.hurtEnemy(stack, target, attacker);
    }
}