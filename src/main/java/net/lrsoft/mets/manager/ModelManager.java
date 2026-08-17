package net.lrsoft.mets.manager;

import ic2.api.recipe.Recipes;
import ic2.core.block.BlockTileEntity;
import ic2.core.block.TeBlockRegistry;
import ic2.core.ref.TeBlock;
import ic2.core.util.StackUtil;
import net.lrsoft.mets.MoreElectricTools;
import net.lrsoft.mets.block.MetsBlockWithTileEntity;
import net.lrsoft.mets.block.UniformResourceBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.OreDictionary;

@Mod.EventBusSubscriber(modid = MoreElectricTools.MODID)
public class BlockManager {
    public static Block niobiumOre;
    public static Block titaniumOre;
    public static Block titaniumBlock;
    public static Block titaniumScaffold;

    static {
        niobiumOre = new UniformResourceBlock("niobium_ore", 2.5f, 2);
        titaniumOre = new UniformResourceBlock("titanium_ore", 2.5f, 2);
        titaniumBlock = new UniformResourceBlock("titanium_block", Material.IRON, 5.0f, 1);
        
        titaniumScaffold = new UniformResourceBlock("titanium_scaffold", Material.GLASS, SoundType.METAL, 5.0f, 1) {
            @Override
            public boolean isOpaqueCube(IBlockState state) {
                return false;
            }

            @Override
            public BlockRenderLayer getBlockLayer() {
                return BlockRenderLayer.CUTOUT;
            }

            @Override
            public boolean isFullCube(IBlockState state) {
                return false;
            }
        };
    }

    // 已移除 onTeBlockInit 方法 - 所有机器已删除

    public static void onBlockRecipeInit() {
        // Compressor recipe for titanium block
        Recipes.compressor.addRecipe(
                Recipes.inputFactory.forOreDict("ingotTitanium", 9), null, false, new ItemStack(titaniumBlock));
    }

    @SubscribeEvent
    public static void onCommonBlockInit(RegistryEvent.Register<Block> event) {
        event.getRegistry().register(niobiumOre);
        event.getRegistry().register(titaniumOre);
        event.getRegistry().register(titaniumBlock);
        event.getRegistry().register(titaniumScaffold);
        // 所有机器方块已移除
    }

    @SubscribeEvent
    public static void onCommonBlockItemInit(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new ItemBlock(niobiumOre).setRegistryName(niobiumOre.getRegistryName()));
        event.getRegistry().register(new ItemBlock(titaniumOre).setRegistryName(titaniumOre.getRegistryName()));
        event.getRegistry().register(new ItemBlock(titaniumBlock).setRegistryName(titaniumBlock.getRegistryName()));
        event.getRegistry().register(new ItemBlock(titaniumScaffold).setRegistryName(titaniumScaffold.getRegistryName()));
        // 所有机器ItemBlock已移除
    }

    private static ItemStack getAllTypeStack(ItemStack itemstack) {
        return new ItemStack(itemstack.getItem(), 1, OreDictionary.WILDCARD_VALUE);
    }

    private static ItemStack getAllTypeStack(Item item) {
        return new ItemStack(item, 1, OreDictionary.WILDCARD_VALUE);
    }
}
