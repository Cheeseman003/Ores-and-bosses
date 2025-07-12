package net.Cheesedude11.Ores_and_Bosses.enchantment.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.phys.Vec3;

public class FireBallEnchantmentEffect implements EnchantmentEntityEffect {
    public static final MapCodec<FireBallEnchantmentEffect> CODEC = MapCodec.unit(FireBallEnchantmentEffect::new);

    @Override
    public void apply(ServerLevel serverLevel, int i, EnchantedItemInUse enchantedItemInUse, Entity entity, Vec3 vec3) {
        if(i == 1){
            EntityType.FIREBALL.spawn(serverLevel, entity.getOnPos(), MobSpawnType.TRIGGERED);
        }
        if(i == 2){
            EntityType.FIREBALL.spawn(serverLevel, entity.getOnPos(), MobSpawnType.TRIGGERED);
            EntityType.FIREBALL.spawn(serverLevel, entity.getOnPos(), MobSpawnType.TRIGGERED);
        }

    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> codec() {
        return CODEC;
    }
}
