package net.Cheesedude11.Ores_and_Bosses.util;

import net.Cheesedude11.Ores_and_Bosses.OresAndBosses;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {

    public static class Blocks {
        public static final TagKey<Block> NEEDS_ELEMENTAL_TOOL = createTag( "needs_elemental_tool");
        public static final TagKey<Block> INCORRECT_FOR_ELEMENTAL_TOOL = createTag( "incorrect_for_elemental_tool");
        public static final TagKey<Block> INCORRECT_FOR_COPPER_TOOL = createTag( "incorrect_for_copper_tool");
        public static final TagKey<Block> NEEDS_COPPER_TOOL = createTag( "needs_copper_tool");


        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(OresAndBosses.MODID, name));
        }
    }

    public static class Items {


        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(OresAndBosses.MODID, name));
        }
    }


}
