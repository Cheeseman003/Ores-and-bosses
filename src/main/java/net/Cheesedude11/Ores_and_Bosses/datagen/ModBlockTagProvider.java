package net.Cheesedude11.Ores_and_Bosses.datagen;

import net.Cheesedude11.Ores_and_Bosses.OresAndBosses;
import net.Cheesedude11.Ores_and_Bosses.block.ModBlocks;
import net.Cheesedude11.Ores_and_Bosses.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, OresAndBosses.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.STEEL_BLOCK.get())
                .add(ModBlocks.STEEL_ORE.get())
                .add(ModBlocks.STEEL_DEEPSLATE_ORE.get())
                .add(ModBlocks.URANIUM_ORE.get())
                .add(ModBlocks.FROST_ORE.get())
                .add(ModBlocks.FROSTEDLIGHT.get())
                .add(ModBlocks.SPARK_ORE.get())
                .add(ModBlocks.EFLAME_ORE.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.STEEL_BLOCK.get())
                .add(ModBlocks.STEEL_ORE.get())
                .add(ModBlocks.STEEL_DEEPSLATE_ORE.get())
                .add(ModBlocks.FROST_ORE.get())
                .add(ModBlocks.EFLAME_ORE.get())
                .add(ModBlocks.SPARK_ORE.get())
                .add(ModBlocks.EFLAME_ORE.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.URANIUM_ORE.get());

        tag(ModTags.Blocks.NEEDS_ELEMENTAL_TOOL)
                .addTag(BlockTags.NEEDS_IRON_TOOL);

        tag(ModTags.Blocks.INCORRECT_FOR_ELEMENTAL_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_IRON_TOOL)
                .remove(ModTags.Blocks.NEEDS_ELEMENTAL_TOOL);

        tag(ModTags.Blocks.NEEDS_COPPER_TOOL)
                .add(Blocks.IRON_ORE)
                .add(Blocks.DEEPSLATE_IRON_ORE)
                .addTag(BlockTags.NEEDS_STONE_TOOL);


        tag(ModTags.Blocks.INCORRECT_FOR_COPPER_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_STONE_TOOL)
                .remove(ModTags.Blocks.NEEDS_COPPER_TOOL);


        tag(BlockTags.INCORRECT_FOR_STONE_TOOL)
                .add(Blocks.DEEPSLATE_IRON_ORE)
                .add(Blocks.IRON_ORE);
    }
}
