package net.Cheesedude11.Ores_and_Bosses.enchantment;


import com.mojang.serialization.MapCodec;
import net.Cheesedude11.Ores_and_Bosses.OresAndBosses;
import net.Cheesedude11.Ores_and_Bosses.enchantment.custom.FireBallEnchantmentEffect;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModEnchantmentEffects {
    public static final DeferredRegister<MapCodec<? extends EnchantmentEntityEffect>> ENTITY_ENCHANTMENT_EFFECTS =
            DeferredRegister.create(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, OresAndBosses.MODID);

    public static final Supplier<MapCodec<? extends EnchantmentEntityEffect>> FIREBALL =
            ENTITY_ENCHANTMENT_EFFECTS.register("fire_ball",() -> FireBallEnchantmentEffect.CODEC);

    public static void register(IEventBus eventBus) {
        ENTITY_ENCHANTMENT_EFFECTS.register(eventBus);
    }

}
