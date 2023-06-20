package net.bovid.spellcards.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab SPELL_TAB = new CreativeModeTab("spelltab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.FIREBALL.get());
        }
    };
    public static final CreativeModeTab BLOCK_TAB = new CreativeModeTab("blocktab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.MANACRYSTAL.get());
        }
    };
}
