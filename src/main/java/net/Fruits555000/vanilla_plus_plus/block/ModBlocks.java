package net.Fruits555000.vanilla_plus_plus.block;

import net.Fruits555000.vanilla_plus_plus.VanillaPlusMod;
import net.Fruits555000.vanilla_plus_plus.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, VanillaPlusMod.MOD_ID);

    public static final RegistryObject<Block> LAPIS_LAZULI_BRICKS = registerBlock("lapis_lazuli_bricks",
            () ->  new Block(BlockBehaviour.Properties.of()
                    .strength(3).explosionResistance(3).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final RegistryObject<StairBlock> LAPIS_LAZULI_BRICK_STAIRS = registerBlock("lapis_lazuli_brick_stairs",
            () -> new StairBlock(ModBlocks.LAPIS_LAZULI_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(3).explosionResistance(3).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final RegistryObject<SlabBlock> LAPIS_LAZULI_BRICK_SLAB = registerBlock("lapis_lazuli_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of()
                    .strength(3).explosionResistance(3).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final RegistryObject<WallBlock> LAPIS_LAZULI_BRICK_WALL = registerBlock("lapis_lazuli_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of()
                    .strength(3).explosionResistance(3).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static  <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
