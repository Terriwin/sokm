package net.terriwin.sokm.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.terriwin.sokm.block.ModBlocks;
import net.terriwin.sokm.sokm;
import net.terriwin.sokm.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, sokm.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        this.tag(ModTags.Blocks.creativbleblock)
                .add(ModBlocks.lignitecoal_block.get()).addTag(ModTags.Blocks.creativbleblock);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.lignitecoal_block.get(),
                        ModBlocks.lignitecoal_ore.get(),
                        ModBlocks.deepslate_lignitecoal_ore.get()

                );

        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.lignitecoal_block.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.lignitecoal_block.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.lignitecoal_block.get());

    }
}
