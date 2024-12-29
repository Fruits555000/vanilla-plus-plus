package net.Fruits555000.vanilla_plus.datagen;

import net.Fruits555000.vanilla_plus.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider pRegistries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), pRegistries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.LAPIS_LAZULI_BRICKS.get());
        dropSelf(ModBlocks.LAPIS_LAZULI_BRICK_SLAB.get());
        dropSelf(ModBlocks.LAPIS_LAZULI_BRICK_STAIRS.get());
        dropSelf(ModBlocks.LAPIS_LAZULI_BRICK_WALL.get());
    };

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}