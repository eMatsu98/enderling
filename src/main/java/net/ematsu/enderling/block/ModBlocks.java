package net.ematsu.enderling.block;

import net.ematsu.enderling.EnderlingMod;
import net.ematsu.enderling.item.ModCreativeModTab;
import net.ematsu.enderling.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, EnderlingMod.MOD_ID);

    public static final RegistryObject<Block> ENDERLING_PLANKS = regissterBlock("enderling_planks",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(2f).requiresCorrectToolForDrops().sound(SoundType.WOOD)), ModCreativeModTab.ENDERLING_TAB);

    public static final RegistryObject<Block> ENDERLING_ORE = regissterBlock("enderling_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3f).requiresCorrectToolForDrops(),
                    UniformInt.of(3, 7)), ModCreativeModTab.ENDERLING_TAB);

    private static <T extends Block> RegistryObject<T> regissterBlock(String name, Supplier<T> block, CreativeModeTab tab){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItems(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItems(String name, RegistryObject<T> block, CreativeModeTab tab){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
