package net.Cheesedude11.Ores_and_Bosses.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;

public class SlimeyEffect extends MobEffect {
    public SlimeyEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        if (livingEntity.horizontalCollision) {
            Vec3 initialVec = livingEntity.getDeltaMovement();
            Vec3 climbVec = new Vec3(initialVec.x, 0.20, initialVec.z);
            livingEntity.setDeltaMovement(climbVec.scale(0.96D));
            return true;
        }

            return super.applyEffectTick(livingEntity, amplifier);
        }

        @Override
        public boolean shouldApplyEffectTickThisTick ( int duration, int amplifier){
            return true;
        }

}
