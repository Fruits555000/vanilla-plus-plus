package net.Fruits555000.vanilla_plus.datagen;

import net.Fruits555000.vanilla_plus.VanillaPlusMod;
import net.Fruits555000.vanilla_plus.block.ModBlocks;
import net.Fruits555000.vanilla_plus.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        List<ItemLike> COCONUT_HUSK = List.of(ModItems.COCONUT_HUSK.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LAPIS_LAZULI_BRICKS.get())
                .pattern("LL")
                .pattern("LL")
                .define('L', Blocks.LAPIS_BLOCK)
                .unlockedBy(getHasName(Blocks.LAPIS_BLOCK), has(Blocks.LAPIS_BLOCK)).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.FLOUR.get())
                .requires(Items.WHEAT)
                .unlockedBy(getHasName(Items.WHEAT), has(Items.WHEAT)).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.COCONUT_HALF.get())
                .requires(ModItems.COCONUT.get())
                .unlockedBy(getHasName(ModItems.COCONUT.get()), has(ModItems.COCONUT.get())).save(pRecipeOutput);

        stairBuilder(ModBlocks.LAPIS_LAZULI_BRICK_STAIRS.get(), Ingredient.of(ModBlocks.LAPIS_LAZULI_BRICKS.get()))
                .unlockedBy(getHasName(ModBlocks.LAPIS_LAZULI_BRICKS.get()), has(ModBlocks.LAPIS_LAZULI_BRICKS.get())).save(pRecipeOutput);

        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LAPIS_LAZULI_BRICK_SLAB.get(), ModBlocks.LAPIS_LAZULI_BRICKS.get());
        wall(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LAPIS_LAZULI_BRICK_WALL.get(), ModBlocks.LAPIS_LAZULI_BRICK_WALL.get());

        OreSmelting(pRecipeOutput, COCONUT_HUSK, RecipeCategory.MISC, Items.CHARCOAL, 0.15f, 100, "");

        stoneCutting(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LAPIS_LAZULI_BRICKS.get(), Items.LAPIS_BLOCK, 1);
    }

    protected static void stoneCutting(RecipeOutput pRecipeOutput, RecipeCategory pCategory, ItemLike pResult, ItemLike pMaterial, int pResultCount) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(pMaterial), pCategory, pResult, pResultCount)
                .unlockedBy(getHasName(pMaterial), has(pMaterial))
                .save(pRecipeOutput, VanillaPlusMod.MOD_ID + ":" + getConversionRecipeName(pResult, pMaterial) + "_stonecutting");
    }

    protected static void OreSmelting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        OreCooking(pRecipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_smelting");
    }

    private static <T extends AbstractCookingRecipe> void OreCooking(RecipeOutput pRecipeOutput, RecipeSerializer<T> pSerializer, AbstractCookingRecipe.Factory<T> pRecipeFactory,
            List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pSuffix) {
        for (ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pSerializer, pRecipeFactory)
                    .group(pGroup)
                    .unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pRecipeOutput, VanillaPlusMod.MOD_ID + ":" + getItemName(pResult) + pSuffix + "_" + getItemName(itemlike));
        }
    }
}
