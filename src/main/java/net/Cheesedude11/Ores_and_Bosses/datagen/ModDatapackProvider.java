package net.Cheesedude11.Ores_and_Bosses.datagen;

import net.Cheesedude11.Ores_and_Bosses.OresAndBosses;
import net.Cheesedude11.Ores_and_Bosses.enchantment.ModEnchantments;
import net.Cheesedude11.Ores_and_Bosses.trim.ModTrimMaterials;
import net.Cheesedude11.Ores_and_Bosses.trim.ModTrimPatterns;
import net.Cheesedude11.Ores_and_Bosses.worldgen.ModBiomeModifiers;
import net.Cheesedude11.Ores_and_Bosses.worldgen.ModConfiguredFeatures;
import net.Cheesedude11.Ores_and_Bosses.worldgen.ModPlacedFeatures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModDatapackProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.TRIM_MATERIAL, ModTrimMaterials::bootstrap)
            .add(Registries.TRIM_PATTERN, ModTrimPatterns::bootstrap)
            .add(Registries.ENCHANTMENT, ModEnchantments::bootstrap)

            .add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap)
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ModBiomeModifiers::bootstrap);

    public ModDatapackProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(OresAndBosses.MODID));
    }
}
