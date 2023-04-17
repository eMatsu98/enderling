package net.ematsu.enderling.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModTab {
    public  static final CreativeModeTab ENDERLING_TAB = new CreativeModeTab("enderlingtab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.Enderling.get());
        }
    };
}
