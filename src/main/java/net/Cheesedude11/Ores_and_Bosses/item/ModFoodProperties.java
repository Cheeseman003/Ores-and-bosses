package net.Cheesedude11.Ores_and_Bosses.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties URANIUM = new FoodProperties.Builder().nutrition(50).saturationModifier(50f)
            .alwaysEdible().effect(() -> new MobEffectInstance(MobEffects.HARM, 20, 100), 0.50f).build();
}
