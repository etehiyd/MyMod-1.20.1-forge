package com.etehiyd.mymod.block;

import com.etehiyd.mymod.MyMod;
import com.etehiyd.mymod.item.LeadBlockItem;
import com.etehiyd.mymod.item.ModFoods;
import com.etehiyd.mymod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.BiFunction;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MyMod.MOD_ID);

    public static final RegistryObject<Block> LEAD_BLOCK = registerBlockWithCustomItem("lead_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(3.0F, 6.0F).requiresCorrectToolForDrops()),
            (block, properties) -> new LeadBlockItem(block, properties.food(ModFoods.LEAD_BLOCK)));

    public static final RegistryObject<Block> RAW_LEAD_BLOCK = registerBlock("raw_lead_block", () -> new Block(BlockBehaviour.Properties.of().strength(5.0F, 6.0F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> NETHER_ASH_BLOCK = registerBlock("nether_ash_block", () -> new FallingBlock(BlockBehaviour.Properties.copy(Blocks.SAND)));
    public static final RegistryObject<Block> LEAD_ORE = registerBlock("lead_ore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.COPPER_ORE)));
    public static final RegistryObject<Block> DEEPSLATE_LEAD_ORE = registerBlock("deepslate_lead_ore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_COPPER_ORE)));

    private static <T extends Block> void registerBlockItems(String name, RegistryObject<T> block, Item.Properties itemProperties) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), itemProperties));
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        /*RegistryObject<T> blocks = BLOCKS.register(name, block);
        registerBlockItems(name, blocks);
        return blocks;*/
        return registerBlock(name, block, new Item.Properties());
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, Item.Properties itemProperties) {
        RegistryObject<T> blocks = BLOCKS.register(name, block);
        registerBlockItems(name, blocks, itemProperties);
        return blocks;
    }

    private static <T extends Block> RegistryObject<T> registerBlockWithCustomItem(String name, Supplier<T> block, BiFunction<Block, Item.Properties, BlockItem> itemFactory){
        RegistryObject<T> blocks = BLOCKS.register(name, block);
        ModItems.ITEMS.register(name, () -> itemFactory.apply(blocks.get(), new Item.Properties()));
        return blocks;
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
