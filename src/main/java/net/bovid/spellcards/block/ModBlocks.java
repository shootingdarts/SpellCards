package net.bovid.spellcards.block;

import net.bovid.spellcards.SpellCards;
import net.bovid.spellcards.item.ModCreativeModeTab;
import net.bovid.spellcards.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, SpellCards.MOD_ID);

    public static final RegistryObject<Block> MANA_CRYSTAL_BLOCK = registerBlock("mana_crystal_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.AMETHYST).strength(6).requiresCorrectToolForDrops().lightLevel(value -> 15)), ModCreativeModeTab.CRYSTAL_TAB);
    public static final RegistryObject<Block> MANA_CRYSTAL_ORE = registerBlock("mana_crystal_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.AMETHYST).strength(6f).requiresCorrectToolForDrops().lightLevel((p_50872_) -> {return 15;}),
                    UniformInt.of(3,7)), ModCreativeModeTab.CRYSTAL_TAB);
    public static final RegistryObject<Block> DEEPSLATE_MANA_CRYSTAL_ORE = registerBlock("deepslate_mana_crystal_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.AMETHYST).strength(7f).requiresCorrectToolForDrops().lightLevel((p_50872_) -> {return 15;}),
                    UniformInt.of(3,7)), ModCreativeModeTab.CRYSTAL_TAB);


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
