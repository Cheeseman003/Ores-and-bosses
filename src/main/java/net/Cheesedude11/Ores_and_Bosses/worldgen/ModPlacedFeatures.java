package net.Cheesedude11.Ores_and_Bosses.worldgen;

import net.Cheesedude11.Ores_and_Bosses.OresAndBosses;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {

    public static final ResourceKey<PlacedFeature> STEEL_ORE_PLACED_KEY = registerKey("steel_ore_placed");
    public static final ResourceKey<PlacedFeature> FROST_ORE_PLACED_KEY = registerKey("frost_ore_placed");
    public static final ResourceKey<PlacedFeature> EFLAME_ORE_PLACED_KEY = registerKey("eflame_ore_placed");
    public static final ResourceKey<PlacedFeature> URANIUM_ORE_PLACED_KEY = registerKey("uranium_ore_placed");
    public static final ResourceKey<PlacedFeature> SPARK_ORE_PLACED_KEY = registerKey("spark_ore_placed");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, STEEL_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_STEEL_ORE_KEY),
                ModOrePlacement.commonOrePlacement(10, HeightRangePlacement.triangle(VerticalAnchor.absolute(-5), VerticalAnchor.absolute(80))));
        register(context, FROST_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_FROST_ORE_KEY),
                ModOrePlacement.commonOrePlacement(10, HeightRangePlacement.triangle(VerticalAnchor.absolute(-5), VerticalAnchor.absolute(80))));
        register(context, EFLAME_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_EFLAME_ORE_KEY),
                ModOrePlacement.commonOrePlacement(10, HeightRangePlacement.triangle(VerticalAnchor.absolute(-5), VerticalAnchor.absolute(80))));
        register(context, SPARK_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_SPARK_ORE_KEY),
                ModOrePlacement.commonOrePlacement(10, HeightRangePlacement.triangle(VerticalAnchor.absolute(-5), VerticalAnchor.absolute(80))));
        register(context, URANIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_URANIUM_ORE_KEY),
                ModOrePlacement.rareOrePlacement(60, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(0))));

    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(OresAndBosses.MODID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

}
