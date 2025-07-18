package net.Cheesedude11.Ores_and_Bosses;

import net.Cheesedude11.Ores_and_Bosses.block.ModBlocks;
import net.Cheesedude11.Ores_and_Bosses.compontent.ModDataComponents;
import net.Cheesedude11.Ores_and_Bosses.effects.ModEffects;
import net.Cheesedude11.Ores_and_Bosses.enchantment.ModEnchantmentEffects;
import net.Cheesedude11.Ores_and_Bosses.event.FlameArmorEffectHandler;
import net.Cheesedude11.Ores_and_Bosses.event.FrostAbilityEventHandler;
import net.Cheesedude11.Ores_and_Bosses.event.LightningHammerAbilityHandler;
import net.Cheesedude11.Ores_and_Bosses.event.MagnetDashHandler;
import net.Cheesedude11.Ores_and_Bosses.item.ModCreativeModeTabs;
import net.Cheesedude11.Ores_and_Bosses.item.ModItems;
import net.Cheesedude11.Ores_and_Bosses.util.ModItemProperties;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(OresAndBosses.MODID)
public class OresAndBosses {
    public static final String MODID = "oresandbosses";
    private static final Logger LOGGER = LogUtils.getLogger();

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public OresAndBosses(IEventBus modEventBus, ModContainer modContainer) {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (ExampleMod) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);

        ModCreativeModeTabs.register(modEventBus);
        NeoForge.EVENT_BUS.register(FlameArmorEffectHandler.class);
        NeoForge.EVENT_BUS.register(MagnetDashHandler.class);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        NeoForge.EVENT_BUS.register(FrostAbilityEventHandler.class);
        NeoForge.EVENT_BUS.register(new LightningHammerAbilityHandler());
        ModDataComponents.register(modEventBus);
        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
        ModEffects.register(modEventBus);
        ModEnchantmentEffects.register(modEventBus);
        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
       if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
           event.accept(ModItems.STEAL);
           event.accept(ModItems.RAW_STEEL);
           event.accept(ModItems.STEEL);
       }
       if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS){
           event.accept(ModBlocks.STEEL_BLOCK);
           event.accept(ModBlocks.STEEL_ORE);

       }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

            ModItemProperties.addCustomItemProperties();
        }
    }
}