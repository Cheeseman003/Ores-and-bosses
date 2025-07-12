package net.Cheesedude11.Ores_and_Bosses.worldgen;

import net.Cheesedude11.Ores_and_Bosses.OresAndBosses;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ModBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_STEEL_ORE = registerKey("add_steel_ore");
    public static final ResourceKey<BiomeModifier> ADD_FROST_ORE = registerKey("add_frost_ore");
    public static final ResourceKey<BiomeModifier> ADD_SPARK_ORE = registerKey("add_spark_ore");
    public static final ResourceKey<BiomeModifier> ADD_EFLAME_ORE = registerKey("add_eflame_ore");
    public static final ResourceKey<BiomeModifier> ADD_URANIUM_ORE = registerKey("add_uranium_ore");

    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_STEEL_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.STEEL_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_FROST_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.FROST_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_SPARK_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.SPARK_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_EFLAME_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.EFLAME_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_URANIUM_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.URANIUM_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        //context.register(ADD_STEEL_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                //HolderSet.direct(biomes.getOrThrow(Biomes.PLAINS), biomes.getOrThrow(Biomes.DESERT)),
                //HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.STEEL_ORE_PLACED_KEY)),
                //GenerationStep.Decoration.UNDERGROUND_ORES));

    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(OresAndBosses.MODID, name));
    }
}
