package net.Cheesedude11.Ores_and_Bosses.worldgen;

import net.Cheesedude11.Ores_and_Bosses.OresAndBosses;
import net.Cheesedude11.Ores_and_Bosses.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_STEEL_ORE_KEY = registerKey("steel_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_DEEPSLATE_STEEL_ORE_KEY = registerKey("deepslate_steel_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_FROST_ORE_KEY = registerKey("frost_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_SPARK_ORE_KEY = registerKey("spark_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_URANIUM_ORE_KEY = registerKey("uranium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_EFLAME_ORE_KEY = registerKey("eflame_ore");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {

        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplaceables = new BlockMatchTest(Blocks.NETHERRACK);
        RuleTest endstoneReplaceables = new BlockMatchTest(Blocks.END_STONE);

        List<OreConfiguration.TargetBlockState> overworldOresSteel = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.STEEL_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> overworldOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.SPARK_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> overworldOresFrost = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.FROST_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> overworldOresFlame = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.EFLAME_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> overworldOresUranium = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.URANIUM_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> overworldOresDSteel = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.STEEL_DEEPSLATE_ORE.get().defaultBlockState()));



        register(context, OVERWORLD_STEEL_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOresSteel, 8));
        register(context, OVERWORLD_EFLAME_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOresFlame, 8));
        register(context, OVERWORLD_FROST_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOresFrost, 8));
        register(context, OVERWORLD_SPARK_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 8));
        register(context, OVERWORLD_DEEPSLATE_STEEL_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOresDSteel, 12));
        register(context, OVERWORLD_URANIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOresUranium, 4));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(OresAndBosses.MODID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
