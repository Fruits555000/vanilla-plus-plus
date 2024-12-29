package net.Fruits555000.vanilla_plus.datagen;

import net.Fruits555000.vanilla_plus.VanillaPlusMod;
import net.Fruits555000.vanilla_plus.block.ModBlocks;
import net.Fruits555000.vanilla_plus.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, VanillaPlusMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.COCONUT.get());
        basicItem(ModItems.COCONUT_HALF.get());
        basicItem(ModItems.COCONUT_HUSK.get());
        basicItem(ModItems.FLOUR.get());

        wallItem(ModBlocks.LAPIS_LAZULI_BRICK_WALL, ModBlocks.LAPIS_LAZULI_BRICKS);
    }

    public void wallItem(RegistryObject<? extends Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  ResourceLocation.fromNamespaceAndPath(VanillaPlusMod.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
}
