package net.Fruits555000.vanilla_plus.item;

import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties COCONUT_HALF = new FoodProperties.Builder().nutrition(3).saturationModifier(0.6F).usingConvertsTo(ModItems.COCONUT_HUSK.get()).build();
}
