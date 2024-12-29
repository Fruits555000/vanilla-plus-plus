package net.Fruits555000.vanilla_plus.datagen;

import net.Fruits555000.vanilla_plus.VanillaPlusMod;
import net.Fruits555000.vanilla_plus.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fluids.capability.wrappers.BlockWrapper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, VanillaPlusMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.LAPIS_LAZULI_BRICKS);

        slabBlock(ModBlocks.LAPIS_LAZULI_BRICK_SLAB.get(),  blockTexture(ModBlocks.LAPIS_LAZULI_BRICKS.get()), blockTexture(ModBlocks.LAPIS_LAZULI_BRICKS.get()));
        blockItem(ModBlocks.LAPIS_LAZULI_BRICK_SLAB);

        stairsBlock(ModBlocks.LAPIS_LAZULI_BRICK_STAIRS.get(), blockTexture(ModBlocks.LAPIS_LAZULI_BRICKS.get()));
        blockItem(ModBlocks.LAPIS_LAZULI_BRICK_STAIRS);
        wallBlock(ModBlocks.LAPIS_LAZULI_BRICK_WALL.get(), blockTexture(ModBlocks.LAPIS_LAZULI_BRICKS.get()));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void blockItem(RegistryObject<? extends Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("vanilla_plus:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockItem(RegistryObject<? extends Block> blockRegistryObject, String appendix) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("vanilla_plus:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath() + appendix));
    }
}
