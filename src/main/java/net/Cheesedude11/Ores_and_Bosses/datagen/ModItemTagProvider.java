package net.Cheesedude11.Ores_and_Bosses.datagen;

import net.Cheesedude11.Ores_and_Bosses.OresAndBosses;
import net.Cheesedude11.Ores_and_Bosses.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {

    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, OresAndBosses.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {


        tag(ItemTags.MACE_ENCHANTABLE)
                .add(ModItems.DIAMOND_HAMMER.get())
                .add(ModItems.LIGHTNING_HAMMER.get());

        tag(ItemTags.SWORDS)
                .add(ModItems.FROST_BITE.get());
        tag(ItemTags.SWORDS)
                .add(ModItems.SPARK_EDGE.get());
        tag(ItemTags.SWORDS)
                .add(ModItems.FLAME_BORN_KATANA.get());
        tag(ItemTags.SWORDS)
                .add(ModItems.COPPER_SWORD.get());



        tag(ItemTags.PICKAXES)
                .add(ModItems.FROST_PICK.get());
        tag(ItemTags.PICKAXES)
                .add(ModItems.SPARK_PICKAXE.get());
        tag(ItemTags.PICKAXES)
                .add(ModItems.FLAME_PICKAXE.get());
        tag(ItemTags.PICKAXES)
                .add(ModItems.COPPER_PICKAXE.get());



        tag(ItemTags.AXES)
                .add(ModItems.FROST_AXE.get());
        tag(ItemTags.AXES)
                .add(ModItems.SPARK_AXE.get());
        tag(ItemTags.AXES)
                .add(ModItems.FLAME_AXE.get());
        tag(ItemTags.AXES)
                .add(ModItems.COPPER_AXE.get());



        tag(ItemTags.SHOVELS)
                .add(ModItems.FROST_SHOVEL.get());
        tag(ItemTags.SHOVELS)
                .add(ModItems.SPARK_SHOVEL.get());
        tag(ItemTags.SHOVELS)
                .add(ModItems.FLAME_SHOVEL.get());
        tag(ItemTags.SHOVELS)
                .add(ModItems.COPPER_SHOVEL.get());




        tag(ItemTags.HOES)
                .add(ModItems.FROST_HOE.get());
        tag(ItemTags.HOES)
                .add(ModItems.SPARK_HOE.get());
        tag(ItemTags.HOES)
                .add(ModItems.FLAME_HOE.get());
        tag(ItemTags.HOES)
                .add(ModItems.COPPER_HOE.get());

        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.FROST_HELMET.get())
                .add(ModItems.FROST_CHESTPLATE.get())
                .add(ModItems.FROST_LEGGINGS.get())
                .add(ModItems.FROST_BOOTS.get());
        tag(ItemTags.HEAD_ARMOR_ENCHANTABLE)
                .add(ModItems.FROST_HELMET.get());
        tag(ItemTags.LEG_ARMOR_ENCHANTABLE)
                .add(ModItems.FROST_LEGGINGS.get());
        tag(ItemTags.CHEST_ARMOR_ENCHANTABLE)
                .add(ModItems.FROST_CHESTPLATE.get());
        tag(ItemTags.FOOT_ARMOR_ENCHANTABLE)
                .add(ModItems.FROST_BOOTS.get());

        this.tag(ItemTags.TRIM_MATERIALS)
                .add(ModItems.FROST_INGOT.get());


        this.tag(ItemTags.TRIM_TEMPLATES)
                .add(ModItems.FEAR_ARMOR_TRIM.get());
    }
}
