package net.bovid.spellcards.item;

import net.bovid.spellcards.SpellCards;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SpellCards.MOD_ID);

    public static final RegistryObject<Item> FIREBALL = ITEMS.register("fireball",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SPELL_TAB)));
    public static final RegistryObject<Item> FROSTBOLT = ITEMS.register("frostbolt",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SPELL_TAB)));
    public static final RegistryObject<Item> MANACRYSTAL = ITEMS.register("manacrystal",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SPELL_TAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
