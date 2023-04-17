package net.ematsu.enderling.item;

import net.ematsu.enderling.EnderlingMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, EnderlingMod.MOD_ID);

    public static final RegistryObject<Item> Ender_Key = ITEMS.register("ender_key",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.ENDERLING_TAB)));
    public static final RegistryObject<Item> Enderling = ITEMS.register("enderling",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.ENDERLING_TAB)));

    public static  void  register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
