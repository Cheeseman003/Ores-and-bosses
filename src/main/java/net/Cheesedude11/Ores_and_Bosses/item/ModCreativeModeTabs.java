package net.Cheesedude11.Ores_and_Bosses.item;

import net.Cheesedude11.Ores_and_Bosses.OresAndBosses;
import net.Cheesedude11.Ores_and_Bosses.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
   public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
           DeferredRegister.create(Registries.CREATIVE_MODE_TAB, OresAndBosses.MODID);

   public static final Supplier<CreativeModeTab> MODDED_ITEMS_TAB = CREATIVE_MODE_TAB.register("modded_items_tab",
           () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.RAW_STEEL.get()))
                   .title(Component.translatable( "modded_items"))
                   .displayItems((itemDisplayParameters, output) -> {
                       output.accept(ModItems.STEAL);
                       output.accept(ModItems.STEEL);
                       output.accept(ModItems.RAW_STEEL);
                       output.accept(ModBlocks.STEEL_BLOCK);
                       output.accept(ModBlocks.STEEL_ORE);
                       output.accept(ModBlocks.SPARK_ORE);
                       output.accept(ModBlocks.STEEL_DEEPSLATE_ORE);
                       output.accept(ModBlocks.URANIUM_ORE);
                       output.accept(ModItems.URANIUM);
                       output.accept(ModBlocks.FROST_ORE);
                       output.accept(ModBlocks.EFLAME_ORE);
                       output.accept(ModItems.FROST_CHUNK);
                       output.accept(ModItems.FROST_INGOT);
                       output.accept(ModItems.SPARK_INGOT);
                       output.accept(ModItems.RAW_SPARK);
                       output.accept(ModItems.EFLAME);

                       output.accept(ModItems.FROST_HELMET);
                       output.accept(ModItems.FROST_CHESTPLATE);
                       output.accept(ModItems.FROST_LEGGINGS);
                       output.accept(ModItems.FROST_BOOTS);
                       output.accept(ModItems.FROST_BITE);
                       output.accept(ModItems.FROST_PICK);
                       output.accept(ModItems.FROST_AXE);
                       output.accept(ModItems.FROST_SHOVEL);
                       output.accept(ModItems.FROST_HOE);

                       output.accept(ModItems.SPARK_EDGE);
                       output.accept(ModItems.SPARK_PICKAXE);
                       output.accept(ModItems.SPARK_AXE);
                       output.accept(ModItems.SPARK_SHOVEL);
                       output.accept(ModItems.SPARK_HOE);

                       output.accept(ModItems.FLAME_BORN_KATANA);
                       output.accept(ModItems.FLAME_PICKAXE);
                       output.accept(ModItems.FLAME_AXE);
                       output.accept(ModItems.FLAME_SHOVEL);
                       output.accept(ModItems.FLAME_HOE);

                       output.accept(ModItems.COPPER_SWORD);
                       output.accept(ModItems.COPPER_PICKAXE);
                       output.accept(ModItems.COPPER_AXE);
                       output.accept(ModItems.COPPER_SHOVEL);
                       output.accept(ModItems.COPPER_HOE);



                       output.accept(ModItems.DIAMOND_HAMMER);
                       output.accept(ModItems.LIGHTNING_HAMMER);


                       output.accept(ModBlocks.FROSTEDLIGHT);
                       output.accept(ModItems.FEAR_ARMOR_TRIM);



    })


                   .build());


   public static void register(IEventBus eventBus) {
       CREATIVE_MODE_TAB.register(eventBus);
   }
}
