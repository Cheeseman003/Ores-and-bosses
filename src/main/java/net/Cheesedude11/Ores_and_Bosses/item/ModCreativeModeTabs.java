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



    })


                   .build());


   public static void register(IEventBus eventBus) {
       CREATIVE_MODE_TAB.register(eventBus);
   }
}
