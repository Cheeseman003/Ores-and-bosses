package net.Cheesedude11.Ores_and_Bosses.datagen;

import net.Cheesedude11.Ores_and_Bosses.block.ModBlocks;
import net.Cheesedude11.Ores_and_Bosses.item.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;

import java.util.Map;
import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.STEEL_BLOCK.get());
        dropSelf(ModBlocks.FROSTEDLIGHT.get());

        add(ModBlocks.URANIUM_ORE.get(),
                block -> createOreDrop(ModBlocks.URANIUM_ORE.get(), ModItems.URANIUM.get()));

        add(ModBlocks.STEEL_DEEPSLATE_ORE.get(),
                block -> createOreDrop(ModBlocks.STEEL_DEEPSLATE_ORE.get(), ModItems.RAW_STEEL.get()));

        add(ModBlocks.STEEL_ORE.get(),
             block -> createOreDrop(ModBlocks.STEEL_ORE.get(), ModItems.RAW_STEEL.get()));

        add(ModBlocks.SPARK_ORE.get(),
                block -> createOreDrop(ModBlocks.SPARK_ORE.get(), ModItems.RAW_SPARK.get()));

        add(ModBlocks.FROST_ORE.get(),
                block -> createOreDrop(ModBlocks.FROST_ORE.get(), ModItems.FROST_CHUNK.get()));

        add(ModBlocks.EFLAME_ORE.get(),
                block -> createOreDrop(ModBlocks.EFLAME_ORE.get(), ModItems.EFLAME.get()));

    }


    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
