package net.Fruits555000.vanilla_plus_plus.item;

import net.Fruits555000.vanilla_plus_plus.VanillaPlusMod;
import net.Fruits555000.vanilla_plus_plus.item.custom.FuelItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.swing.text.DefaultFormatterFactory;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, VanillaPlusMod.MOD_ID);

    public static final RegistryObject<Item> FLOUR = ITEMS.register("flour",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> COCONUT = ITEMS.register("coconut",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> COCONUT_HUSK = ITEMS.register("coconut_husk",
            () -> new FuelItem(new Item.Properties(), 150));

    public static final RegistryObject<Item> COCONUT_HALF = ITEMS.register("coconut_half",
            () -> new Item(new Item.Properties().food(ModFoodProperties.COCONUT_HALF)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}