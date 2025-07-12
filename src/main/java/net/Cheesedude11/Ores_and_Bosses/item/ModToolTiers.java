package net.Cheesedude11.Ores_and_Bosses.item;

import net.Cheesedude11.Ores_and_Bosses.util.ModTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolTiers {
    public static final Tier ELEMENTAL = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_ELEMENTAL_TOOL,
    300, 6.5f, 3.0f, 20, () -> Ingredient.of(ModItems.FROST_INGOT, ModItems.STEEL, ModItems.SPARK_INGOT, ModItems.EFLAME));

    public static final Tier COPPER = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_COPPER_TOOL,
            200, 5.5f, 2.0f, 11, () -> Ingredient.of(Items.COPPER_INGOT));
}
