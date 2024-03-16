package net.terriwin.sokm.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.terriwin.sokm.block.custom.FuelBlock;
import net.terriwin.sokm.item.ModItems;
import net.terriwin.sokm.item.custom.FuelItem;
import net.terriwin.sokm.sokm;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, sokm.MOD_ID  );

    public  static  final RegistryObject<Block> lignitecoal_block = registryObject("lignitecoal_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COAL_BLOCK)));
    public  static  final RegistryObject<Block> lignitecoal_ore = registryObject("lignitecoal_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.COAL_ORE).requiresCorrectToolForDrops(), UniformInt.of(3,6)));
    public  static  final RegistryObject<Block> deepslate_lignitecoal_ore = registryObject("deepslate_lignitecoal_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_COAL_ORE).requiresCorrectToolForDrops(), UniformInt.of(4,8)));






    private  static <T extends Block> RegistryObject<T> registryObject(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        if (name.equals("lignitecoal_block")) {
            registerFuelBlockItem(name, toReturn, 12800);
        } else registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),new Item.Properties()));
    }
    private static <T extends Block> RegistryObject<Item> registerFuelBlockItem(String name, RegistryObject<T> block, int burnTime){
        return ModItems.ITEMS.register(name, () -> new FuelBlock(block.get(),new Item.Properties(), burnTime));
    }




    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
