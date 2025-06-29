package net.Cheesedude11.Ores_and_Bosses.datagen;

import net.Cheesedude11.Ores_and_Bosses.OresAndBosses;
import net.Cheesedude11.Ores_and_Bosses.block.ModBlocks;
import net.Cheesedude11.Ores_and_Bosses.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.MinecartItem;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        List<ItemLike> STEEL_SMELTABLES = List.of(ModItems.RAW_STEEL,
                ModBlocks.STEEL_DEEPSLATE_ORE, ModBlocks.STEEL_ORE);
        List<ItemLike> MOLTEN_STEEL_SMEALTABLES = List.of(ModItems.STEEL);

        List<ItemLike> SPARK_SMELTABLES = List.of(ModItems.RAW_SPARK, ModBlocks.SPARK_ORE);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,ModItems.FROST_INGOT.get())
                        .pattern("   ")
                        .pattern(" BB")
                        .pattern(" BB")
                         .define('B', ModItems.FROST_CHUNK.get())
                                 .unlockedBy("has_frost_chunk", has(ModItems.FROST_CHUNK)).save(recipeOutput);






        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,ModItems.FROST_BITE.get())
                .pattern(" X ")
                .pattern(" X ")
                .pattern(" B ")
                .define('X', ModItems.FROST_INGOT.get())
                .define('B', Items.STICK)
                .unlockedBy("has_frost_ingot", has(ModItems.FROST_INGOT)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,ModItems.SPARK_EDGE.get())
                .pattern(" X ")
                .pattern(" X ")
                .pattern(" B ")
                .define('X', ModItems.SPARK_INGOT.get())
                .define('B', Items.STICK)
                .unlockedBy("has_spark_ingot", has(ModItems.SPARK_INGOT)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,ModItems.FLAME_BORN_KATANA.get())
                .pattern(" X ")
                .pattern(" X ")
                .pattern(" B ")
                .define('X', ModItems.EFLAME.get())
                .define('B', Items.STICK)
                .unlockedBy("has_eflame", has(ModItems.EFLAME)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,ModItems.COPPER_SWORD.get())
                .pattern(" X ")
                .pattern(" X ")
                .pattern(" B ")
                .define('X', Items.COPPER_INGOT)
                .define('B', Items.STICK)
                .unlockedBy("has_copper", has(Items.COPPER_INGOT)).save(recipeOutput);





        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,ModItems.FROST_PICK.get())
                .pattern("XXX")
                .pattern(" B ")
                .pattern(" B ")
                .define('X', ModItems.FROST_INGOT.get())
                .define('B', Items.STICK)
                .unlockedBy("has_frost_ingot", has(ModItems.FROST_INGOT)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,ModItems.SPARK_PICKAXE.get())
                .pattern("XXX")
                .pattern(" B ")
                .pattern(" B ")
                .define('X', ModItems.SPARK_INGOT.get())
                .define('B', Items.STICK)
                .unlockedBy("has_spark_ingot", has(ModItems.SPARK_INGOT)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,ModItems.FLAME_PICKAXE.get())
                .pattern("XXX")
                .pattern(" B ")
                .pattern(" B ")
                .define('X', ModItems.EFLAME.get())
                .define('B', Items.STICK)
                .unlockedBy("has_eflame", has(ModItems.EFLAME)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,ModItems.COPPER_PICKAXE.get())
                .pattern("XXX")
                .pattern(" B ")
                .pattern(" B ")
                .define('X', Items.COPPER_INGOT)
                .define('B', Items.STICK)
                .unlockedBy("has_copper", has(Items.COPPER_INGOT)).save(recipeOutput);



        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,ModItems.FROST_AXE.get())
                .pattern("XX ")
                .pattern("XB ")
                .pattern(" B ")
                .define('X', ModItems.FROST_INGOT.get())
                .define('B', Items.STICK)
                .unlockedBy("has_frost_ingot", has(ModItems.FROST_INGOT)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,ModItems.SPARK_AXE.get())
                .pattern("XX ")
                .pattern("XB ")
                .pattern(" B ")
                .define('X', ModItems.SPARK_INGOT.get())
                .define('B', Items.STICK)
                .unlockedBy("has_spark_ingot", has(ModItems.SPARK_INGOT)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,ModItems.FLAME_AXE.get())
                .pattern("XX ")
                .pattern("XB ")
                .pattern(" B ")
                .define('X', ModItems.EFLAME.get())
                .define('B', Items.STICK)
                .unlockedBy("has_eflame", has(ModItems.EFLAME)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,ModItems.COPPER_AXE.get())
                .pattern("XX ")
                .pattern("XB ")
                .pattern(" B ")
                .define('X', Items.COPPER_INGOT)
                .define('B', Items.STICK)
                .unlockedBy("has_copper", has(Items.COPPER_INGOT)).save(recipeOutput);




        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,ModItems.FROST_SHOVEL.get())
                .pattern(" X ")
                .pattern(" B ")
                .pattern(" B ")
                .define('X', ModItems.FROST_INGOT.get())
                .define('B', Items.STICK)
                .unlockedBy("has_frost_ingot", has(ModItems.FROST_INGOT)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,ModItems.SPARK_SHOVEL.get())
                .pattern(" X ")
                .pattern(" B ")
                .pattern(" B ")
                .define('X', ModItems.SPARK_INGOT.get())
                .define('B', Items.STICK)
                .unlockedBy("has_spark_ingot", has(ModItems.SPARK_INGOT)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,ModItems.FLAME_SHOVEL.get())
                .pattern(" X ")
                .pattern(" B ")
                .pattern(" B ")
                .define('X', ModItems.EFLAME.get())
                .define('B', Items.STICK)
                .unlockedBy("has_eflame", has(ModItems.EFLAME)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,ModItems.COPPER_SHOVEL.get())
                .pattern(" X ")
                .pattern(" B ")
                .pattern(" B ")
                .define('X', Items.COPPER_INGOT)
                .define('B', Items.STICK)
                .unlockedBy("has_copper", has(Items.COPPER_INGOT)).save(recipeOutput);


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,ModItems.FROST_HOE.get())
                .pattern("XX ")
                .pattern(" B ")
                .pattern(" B ")
                .define('X', ModItems.FROST_INGOT.get())
                .define('B', Items.STICK)
                .unlockedBy("has_frost_ingot", has(ModItems.FROST_INGOT)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,ModItems.SPARK_HOE.get())
                .pattern("XX ")
                .pattern(" B ")
                .pattern(" B ")
                .define('X', ModItems.SPARK_INGOT.get())
                .define('B', Items.STICK)
                .unlockedBy("has_spark_ingot", has(ModItems.SPARK_INGOT)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,ModItems.FLAME_HOE.get())
                .pattern("XX ")
                .pattern(" B ")
                .pattern(" B ")
                .define('X', ModItems.EFLAME.get())
                .define('B', Items.STICK)
                .unlockedBy("has_eflame", has(ModItems.EFLAME)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,ModItems.COPPER_HOE.get())
                .pattern("XX ")
                .pattern(" B ")
                .pattern(" B ")
                .define('X', Items.COPPER_INGOT)
                .define('B', Items.STICK)
                .unlockedBy("has_copper", has(Items.COPPER_INGOT)).save(recipeOutput);




        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,ModItems.DIAMOND_HAMMER.get())
                .pattern("XYX")
                .pattern("XBX")
                .pattern(" B ")
                .define('X', Items.DIAMOND_BLOCK)
                .define('Y', Items.HEAVY_CORE)
                .define('B', Items.STICK)
                .unlockedBy("has_diamond", has(Items.DIAMOND)).save(recipeOutput);





        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.FROST_HELMET.get())
                .pattern("BBB")
                .pattern("B B")
                .pattern("   ")
                .define('B', ModItems.FROST_INGOT.get())
                .unlockedBy("has_frost_chunk", has(ModItems.FROST_INGOT)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.FROST_CHESTPLATE.get())
                .pattern("B B")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.FROST_INGOT.get())
                .unlockedBy("has_frost_chunk", has(ModItems.FROST_INGOT)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.FROST_LEGGINGS.get())
                .pattern("BBB")
                .pattern("B B")
                .pattern("B B")
                .define('B', ModItems.FROST_INGOT.get())
                .unlockedBy("has_frost_chunk", has(ModItems.FROST_INGOT)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.FROST_BOOTS.get())
                .pattern("B B")
                .pattern("B B")
                .pattern("   ")
                .define('B', ModItems.FROST_INGOT.get())
                .unlockedBy("has_frost_chunk", has(ModItems.FROST_INGOT)).save(recipeOutput);






        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.STEEL_BLOCK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.STEEL.get())
                .unlockedBy("has_steel", has(ModItems.STEEL)).save(recipeOutput);


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.FROSTEDLIGHT.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.FROST_CHUNK.get())
                .unlockedBy("has_frost_chunk", has(ModItems.FROST_CHUNK)).save(recipeOutput);


        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.STEEL.get(), 9)
                .requires(ModBlocks.STEEL_BLOCK)
                .unlockedBy("has_steel_block", has(ModBlocks.STEEL_BLOCK)).save(recipeOutput);
        oreSmelting(recipeOutput, STEEL_SMELTABLES, RecipeCategory.MISC, ModItems.STEEL.get(), 0.25f, 200, "steel");
        oreBlasting(recipeOutput, STEEL_SMELTABLES, RecipeCategory.MISC, ModItems.STEEL.get(), 0.25f, 100, "steel");
        oreBlasting(recipeOutput, MOLTEN_STEEL_SMEALTABLES, RecipeCategory.MISC, ModItems.STEAL.get(), 0.35f, 250, "molten_steel");
        oreSmelting(recipeOutput, MOLTEN_STEEL_SMEALTABLES, RecipeCategory.MISC, ModItems.STEAL.get(), 0.35f, 350, "molten_steel");
        oreSmelting(recipeOutput, SPARK_SMELTABLES, RecipeCategory.MISC, ModItems.SPARK_INGOT.get(), 0.35f, 250, "spark_ingot");
        oreBlasting(recipeOutput, SPARK_SMELTABLES, RecipeCategory.MISC, ModItems.SPARK_INGOT.get(), 0.35f, 150, "spark_ingot");


        trimSmithing(recipeOutput, ModItems.FEAR_ARMOR_TRIM.get(), ResourceLocation.fromNamespaceAndPath(OresAndBosses.MODID, "fear"));
    }
}
