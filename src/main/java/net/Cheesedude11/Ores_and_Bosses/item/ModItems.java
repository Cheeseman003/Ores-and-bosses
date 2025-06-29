package net.Cheesedude11.Ores_and_Bosses.item;

import net.Cheesedude11.Ores_and_Bosses.OresAndBosses;
import net.Cheesedude11.Ores_and_Bosses.item.custom.HammerItem;
import net.Cheesedude11.Ores_and_Bosses.item.custom.Lightning_Hammer_Item;
import net.Cheesedude11.Ores_and_Bosses.item.custom.ModArmorItem;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(OresAndBosses.MODID);

    public static final DeferredItem<Item> STEAL = ITEMS.register("steal",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_STEEL = ITEMS.register("raw_steel",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> STEEL = ITEMS.register("steel",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> FROST_INGOT = ITEMS.register("frost_ingot",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SPARK_INGOT = ITEMS.register("spark_ingot",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> EFLAME = ITEMS.register("eflame",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RAW_SPARK = ITEMS.register("raw_spark",
            () -> new Item(new Item.Properties()));


    public static final DeferredItem<Item> FROST_CHUNK = ITEMS.register("frost_chunk",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> URANIUM = ITEMS.register("uranium",
            () -> new Item(new Item.Properties().food(ModFoodProperties.URANIUM)));

    public static final DeferredItem<SwordItem> FROST_BITE = ITEMS.register("frost_bite",
            () -> new SwordItem(ModToolTiers.ELEMENTAL, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.ELEMENTAL, 3, -2.8f))));
    public static final DeferredItem<SwordItem> SPARK_EDGE = ITEMS.register("spark_edge",
            () -> new SwordItem(ModToolTiers.ELEMENTAL, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.ELEMENTAL, 3, -2.8f))));
    public static final DeferredItem<SwordItem> FLAME_BORN_KATANA = ITEMS.register("flame_born_katana",
            () -> new SwordItem(ModToolTiers.ELEMENTAL, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.ELEMENTAL, 3, -2.8f))));
    public static final DeferredItem<SwordItem> COPPER_SWORD = ITEMS.register("copper_sword",
            () -> new SwordItem(ModToolTiers.COPPER, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.COPPER, 2.5f, -2.8f))));





    public static final DeferredItem<PickaxeItem> FROST_PICK = ITEMS.register("frost_pick",
            () -> new PickaxeItem(ModToolTiers.ELEMENTAL, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.ELEMENTAL, 0.6f, -2.4f))));
    public static final DeferredItem<PickaxeItem> SPARK_PICKAXE = ITEMS.register("spark_pickaxe",
            () -> new PickaxeItem(ModToolTiers.ELEMENTAL, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.ELEMENTAL, 0.6f, -2.4f))));
    public static final DeferredItem<PickaxeItem> FLAME_PICKAXE = ITEMS.register("flame_pickaxe",
            () -> new PickaxeItem(ModToolTiers.ELEMENTAL, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.ELEMENTAL, 0.6f, -2.4f))));
    public static final DeferredItem<PickaxeItem> COPPER_PICKAXE = ITEMS.register("copper_pickaxe",
            () -> new PickaxeItem(ModToolTiers.COPPER, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.COPPER, 0.6f, -2.4f))));



    public static final DeferredItem<ShovelItem> FROST_SHOVEL = ITEMS.register("frost_shovel",
            () -> new ShovelItem(ModToolTiers.ELEMENTAL, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.ELEMENTAL, 0.5f, -3.0f))));
    public static final DeferredItem<ShovelItem> SPARK_SHOVEL = ITEMS.register("spark_shovel",
            () -> new ShovelItem(ModToolTiers.ELEMENTAL, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.ELEMENTAL, 0.5f, -3.0f))));
    public static final DeferredItem<ShovelItem> FLAME_SHOVEL = ITEMS.register("flame_shovel",
            () -> new ShovelItem(ModToolTiers.ELEMENTAL, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.ELEMENTAL, 0.5f, -3.0f))));
    public static final DeferredItem<ShovelItem> COPPER_SHOVEL = ITEMS.register("copper_shovel",
            () -> new ShovelItem(ModToolTiers.COPPER, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.COPPER, 0.5f, -3.0f))));




    public static final DeferredItem<AxeItem> FROST_AXE = ITEMS.register("frost_axe",
            () -> new AxeItem(ModToolTiers.ELEMENTAL, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.ELEMENTAL, 5, -3.2f))));
    public static final DeferredItem<AxeItem> SPARK_AXE = ITEMS.register("spark_axe",
            () -> new AxeItem(ModToolTiers.ELEMENTAL, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.ELEMENTAL, 5, -3.2f))));
    public static final DeferredItem<AxeItem> FLAME_AXE = ITEMS.register("flame_axe",
            () -> new AxeItem(ModToolTiers.ELEMENTAL, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.ELEMENTAL, 5, -3.2f))));
    public static final DeferredItem<AxeItem> COPPER_AXE = ITEMS.register("copper_axe",
            () -> new AxeItem(ModToolTiers.COPPER, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.COPPER, 5, -3.2f))));



    public static final DeferredItem<HoeItem> FROST_HOE = ITEMS.register("frost_hoe",
            () -> new HoeItem(ModToolTiers.ELEMENTAL, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.ELEMENTAL, 0.25f, -3.0f))));
    public static final DeferredItem<HoeItem> SPARK_HOE = ITEMS.register("spark_hoe",
            () -> new HoeItem(ModToolTiers.ELEMENTAL, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.ELEMENTAL, 0.25f, -3.0f))));
    public static final DeferredItem<HoeItem> FLAME_HOE = ITEMS.register("flame_hoe",
            () -> new HoeItem(ModToolTiers.ELEMENTAL, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.ELEMENTAL, 0.25f, -3.0f))));
    public static final DeferredItem<HoeItem> COPPER_HOE = ITEMS.register("copper_hoe",
            () -> new HoeItem(ModToolTiers.COPPER, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.COPPER, 0.25f, -3.0f))));



    public static final DeferredItem<HammerItem> DIAMOND_HAMMER = ITEMS.register("diamond_hammer",
            () -> new HammerItem(Tiers.DIAMOND, new Item.Properties()
                    .attributes(HammerItem.createAttributes(Tiers.DIAMOND, 6, -3.5f))));

    public static final DeferredItem<Lightning_Hammer_Item> LIGHTNING_HAMMER = ITEMS.register("lightning_hammer",
            () -> new Lightning_Hammer_Item(ModToolTiers.ELEMENTAL, new Item.Properties()
                    .attributes(HammerItem.createAttributes(Tiers.DIAMOND, 8, -3.5f))));

    public static final DeferredItem<ArmorItem> FROST_HELMET = ITEMS.register("frost_helmet",
            () -> new ModArmorItem(ModArmorMaterials.FROST_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(16))){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.oresandbosses.frost_boots.tooltip"));
                    tooltipComponents.add(Component.translatable("tooltip.oresandbosses.frost_boots.freezing"));
                    tooltipComponents.add(Component.translatable("tooltip.oresandbosses.frost_boots.slow"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<ArmorItem> FROST_CHESTPLATE = ITEMS.register("frost_chestplate",
            () -> new ArmorItem(ModArmorMaterials.FROST_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(16))){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.oresandbosses.frost_boots.tooltip"));
                    tooltipComponents.add(Component.translatable("tooltip.oresandbosses.frost_boots.freezing"));
                    tooltipComponents.add(Component.translatable("tooltip.oresandbosses.frost_boots.slow"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<ArmorItem> FROST_LEGGINGS = ITEMS.register("frost_leggings",
            () -> new ArmorItem(ModArmorMaterials.FROST_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(16))){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.oresandbosses.frost_boots.tooltip"));
                    tooltipComponents.add(Component.translatable("tooltip.oresandbosses.frost_boots.freezing"));
                    tooltipComponents.add(Component.translatable("tooltip.oresandbosses.frost_boots.slow"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<ArmorItem> FROST_BOOTS = ITEMS.register("frost_boots",
            () -> new ArmorItem(ModArmorMaterials.FROST_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(16))){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.oresandbosses.frost_boots.tooltip"));
                    tooltipComponents.add(Component.translatable("tooltip.oresandbosses.frost_boots.freezing"));
                    tooltipComponents.add(Component.translatable("tooltip.oresandbosses.frost_boots.slow"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });


    public static final DeferredItem<Item> FEAR_ARMOR_TRIM = ITEMS.register("fear_armor_trim_smithing_template",
            () -> SmithingTemplateItem.createArmorTrimTemplate(ResourceLocation.fromNamespaceAndPath(OresAndBosses.MODID, "fear")));







    public static void register(IEventBus eventBus)  {
        ITEMS.register(eventBus);
    }
}
