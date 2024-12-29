package net.Fruits555000.vanilla_plus.datagen;

import net.Fruits555000.vanilla_plus.VanillaPlusMod;
import net.Fruits555000.vanilla_plus.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, VanillaPlusMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.LAPIS_LAZULI_BRICKS.get())
                .add(ModBlocks.LAPIS_LAZULI_BRICK_SLAB.get())
                .add(ModBlocks.LAPIS_LAZULI_BRICK_STAIRS.get())
                .add(ModBlocks.LAPIS_LAZULI_BRICK_WALL.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.LAPIS_LAZULI_BRICKS.get())
                .add(ModBlocks.LAPIS_LAZULI_BRICK_SLAB.get())
                .add(ModBlocks.LAPIS_LAZULI_BRICK_STAIRS.get())
                .add(ModBlocks.LAPIS_LAZULI_BRICK_WALL.get());

        tag(BlockTags.WALLS).add(ModBlocks.LAPIS_LAZULI_BRICK_WALL.get());
    }
}
