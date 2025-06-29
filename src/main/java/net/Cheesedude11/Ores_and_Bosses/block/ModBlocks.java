package net.Cheesedude11.Ores_and_Bosses.block;

import net.Cheesedude11.Ores_and_Bosses.OresAndBosses;
import net.Cheesedude11.Ores_and_Bosses.block.custom.FrostedLight;
import net.Cheesedude11.Ores_and_Bosses.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(OresAndBosses.MODID);

    public static final DeferredBlock<Block> STEEL_BLOCK = registerBlock("steel_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .requiresCorrectToolForDrops().strength(3f).sound(SoundType.METAL)));

    public static final DeferredBlock<Block> STEEL_ORE = registerBlock("steel_ore",
            () -> new DropExperienceBlock(UniformInt.of(2,4),
                    BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> SPARK_ORE = registerBlock("spark_ore",
            () -> new DropExperienceBlock(UniformInt.of(2,4),
                    BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> STEEL_DEEPSLATE_ORE = registerBlock("steel_deepslate_ore",
            () -> new DropExperienceBlock(UniformInt.of(2,4),
                    BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> URANIUM_ORE = registerBlock("uranium_ore",
            () -> new DropExperienceBlock(UniformInt.of(4,7),
                    BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> FROST_ORE = registerBlock("frost_ore",
            () -> new DropExperienceBlock(UniformInt.of(2,4),
                    BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> EFLAME_ORE = registerBlock("eflame_ore",
            () -> new DropExperienceBlock(UniformInt.of(2,4),
                    BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> FROSTEDLIGHT = registerBlock("frostedlight",
            () -> new FrostedLight(BlockBehaviour.Properties.of().strength(1f).sound(SoundType.GLASS)
                    .requiresCorrectToolForDrops().lightLevel(state -> state.getValue(FrostedLight.CLICKED) ? 9999 : 0)));


    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
