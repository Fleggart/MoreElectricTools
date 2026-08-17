package net.lrsoft.mets.block;

import java.lang.reflect.Constructor;
import java.util.Set;

import ic2.api.tile.IEnergyStorage;
import ic2.core.IC2;
import ic2.core.block.ITeBlock;
import ic2.core.block.TileEntityBlock;
import ic2.core.item.block.ItemBlockTileEntity;
import ic2.core.ref.TeBlock.DefaultDrop;
import ic2.core.ref.TeBlock.HarvestTool;
import ic2.core.ref.TeBlock.ITePlaceHandler;
import ic2.core.ref.IC2Material;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.ModContainer;
import ic2.core.util.StackUtil;
import ic2.core.util.Util;
import ic2.core.profile.Version;
import net.lrsoft.mets.MoreElectricTools;
import net.lrsoft.mets.block.tileentity.*;

public enum MetsBlockWithTileEntity implements ITeBlock {
    // 所有机器已移除，保留空枚举
    ;

    public static final ResourceLocation loc = new ResourceLocation(MoreElectricTools.MODID, "te");
    private Class<? extends TileEntityBlock> teClass;
    private final int itemMeta;
    private final boolean hasActive;
    private final Set<EnumFacing> supportedFacings;
    private final boolean allowWrenchRotating;
    private final HarvestTool harvestTool;
    private final DefaultDrop defaultDrop;
    private final float hardness;

    private static final MetsBlockWithTileEntity[] VALUES;

    MetsBlockWithTileEntity(Class<? extends TileEntityBlock> teClass, int itemMeta, boolean hasActive,
            Set<EnumFacing> supportedFacings, boolean allowWrenchRotating, HarvestTool harvestTool,
            DefaultDrop defaultDrop, float hardness, float explosionResistance, EnumRarity rarity, Material material,
            boolean transparent) {
        this.teClass = teClass;
        this.itemMeta = itemMeta;
        this.hasActive = hasActive;
        this.supportedFacings = supportedFacings;
        this.allowWrenchRotating = allowWrenchRotating;
        this.harvestTool = harvestTool;
        this.defaultDrop = defaultDrop;
        this.hardness = hardness;
        this.explosionResistance = explosionResistance;
        this.rarity = rarity;
        this.material = material;
        this.transparent = transparent;
    }

    private final float explosionResistance;private final EnumRarity rarity;private final Material material;private final boolean transparent;private TileEntityBlock dummyTe;private ITePlaceHandler placeHandler;

    static {
        VALUES = new MetsBlockWithTileEntity[0];
    }

    public static void buildDummies() {
        // No machines to build dummies for
    }

    @Override
    public int getId() {
        return this.itemMeta;
    }

    @Override
    public String getName() {
        return this.name();
    }

    @Override
    public boolean allowWrenchRotating() {
        return this.allowWrenchRotating;
    }

    @Override
    public DefaultDrop getDefaultDrop() {
        return this.defaultDrop;
    }

    @Override
    public TileEntityBlock getDummyTe() {
        return this.dummyTe;
    }

    @Override
    public float getExplosionResistance() {
        return this.explosionResistance;
    }

    @Override
    public float getHardness() {
        return this.hardness;
    }

    @Override
    public HarvestTool getHarvestTool() {
        return this.harvestTool;
    }

    @Override
    public ResourceLocation getIdentifier() {
        return loc;
    }

    @Override
    public EnumRarity getRarity() {
        return this.rarity;
    }

    @Override
    public Set<EnumFacing> getSupportedFacings() {
        return this.supportedFacings;
    }

    @Override
    public Class<? extends TileEntityBlock> getTeClass() {
        return this.teClass;
    }

    @Override
    public boolean hasActive() {
        return this.hasActive;
    }

    @Override
    public boolean hasItem() {
        return (this.teClass != null && this.itemMeta != -1);
    }
}
