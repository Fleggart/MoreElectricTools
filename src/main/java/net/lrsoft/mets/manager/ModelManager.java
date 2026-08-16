package net.lrsoft.mets.manager;

import ic2.core.item.tool.RenderCrossed;
import net.lrsoft.mets.MoreElectricTools;
import net.lrsoft.mets.blade.EntityDriveEx;
import net.lrsoft.mets.blade.EntitySlashDimensionEx;
import net.lrsoft.mets.blade.RenderDriveEx;
import net.lrsoft.mets.blade.RenderSlashDimensionEx;
import net.lrsoft.mets.block.tileentity.TileEntityLighterBlock;
import net.lrsoft.mets.block.tileentity.TileEntityWirelessPowerTransmissionNode;
import net.lrsoft.mets.entity.EntityGunBullet;
import net.lrsoft.mets.entity.EntityHyperGunBullet;
import net.lrsoft.mets.entity.EntityPlasmaBullet;
import net.lrsoft.mets.entity.EntityRocket;
import net.lrsoft.mets.item.blade.BladeManager;
import net.lrsoft.mets.item.blade.BladeModelManager;
import net.lrsoft.mets.item.crafting.ItemCraftingManager;
import net.lrsoft.mets.renderer.BulletRenderer;
import net.lrsoft.mets.renderer.LighterRenderer;
import net.lrsoft.mets.renderer.PlasmaBulletRenderer;
import net.lrsoft.mets.renderer.RocketRender;
import net.lrsoft.mets.renderer.TransmissionNodeRenderer;
import net.lrsoft.mets.renderer.particle.EntityParticleGroup;
import net.lrsoft.mets.renderer.particle.EntityParticleSpray;
import net.lrsoft.mets.renderer.particle.InstantParticleRender;
import net.lrsoft.mets.renderer.particle.ParticleRenderer;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(value = Side.CLIENT, modid = MoreElectricTools.MODID)
public class ModelManager {
    @SubscribeEvent
    public static void onItemModelInit(ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(ItemManager.superLapotronCrystal, 0,
                new ModelResourceLocation(ItemManager.superLapotronCrystal.getRegistryName(), "inventory"));
        ModelLoader.setCustomModelResourceLocation(ItemManager.chargingSuperLapotronCrystal, 0,
                new ModelResourceLocation(ItemManager.chargingSuperLapotronCrystal.getRegistryName(), "inventory"));
        
        ModelLoader.setCustomModelResourceLocation(ItemManager.advancedLithiumBattery, 0,
                new ModelResourceLocation(ItemManager.advancedLithiumBattery.getRegistryName(), "inventory"));
        ModelLoader.setCustomModelResourceLocation(ItemManager.lithiumBattery, 0,
                new ModelResourceLocation(ItemManager.lithiumBattery.getRegistryName(), "inventory"));
        ModelLoader.setCustomModelResourceLocation(ItemManager.thoriumBattery, 0,
                new ModelResourceLocation(ItemManager.thoriumBattery.getRegistryName(), "inventory"));
        ModelLoader.setCustomModelResourceLocation(ItemManager.electricWirlessManager, 0,
                new ModelResourceLocation(ItemManager.electricWirlessManager.getRegistryName(), "inventory"));
        ModelLoader.setCustomModelResourceLocation(ItemManager.geomagneticDetector, 0,
                new ModelResourceLocation(ItemManager.geomagneticDetector.getRegistryName(), "inventory"));
        
        ItemCraftingManager.onCraftingItemModelInit();

        if (Loader.isModLoaded("flammpfeil.slashblade")) {
            BladeModelManager.onModelInit();
        }
    }
    
    @SubscribeEvent
    public static void onBlockModelInit(ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(BlockManager.niobiumOre), 0, new ModelResourceLocation(BlockManager.niobiumOre.getRegistryName(),"normal"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(BlockManager.titaniumOre), 0, new ModelResourceLocation(BlockManager.titaniumOre.getRegistryName(),"normal"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(BlockManager.titaniumBlock), 0, new ModelResourceLocation(BlockManager.titaniumBlock.getRegistryName(),"normal"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(BlockManager.titaniumScaffold), 0, new ModelResourceLocation(BlockManager.titaniumScaffold.getRegistryName(),"normal"));
        
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(BlockManager.geomagneticPedestal), 0, new ModelResourceLocation(BlockManager.geomagneticPedestal.getRegistryName(),"normal"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(BlockManager.geomagneticAntenna), 0, new ModelResourceLocation(BlockManager.geomagneticAntenna.getRegistryName(),"normal"));
        
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLighterBlock.class, new LighterRenderer());
    }
    
    @SubscribeEvent
    public static void onFluidModelInit(ModelRegistryEvent event) {
        registerFluidRender(FluidManager.crudeOilBlock, FluidManager.crudeOil);
        registerFluidRender(FluidManager.dieselOilBlock, FluidManager.dieselOil);
    }
    
    @SubscribeEvent
    public static void onEntityModelInit(ModelRegistryEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(EntityParticleGroup.class, new IRenderFactory<EntityParticleGroup>() {
            public Render<EntityParticleGroup> createRenderFor(RenderManager manager) {
                return (Render<EntityParticleGroup>) new ParticleRenderer(manager);
            }
        });
        
        RenderingRegistry.registerEntityRenderingHandler(EntityParticleSpray.class, new IRenderFactory<EntityParticleSpray>() {
            public Render<EntityParticleSpray> createRenderFor(RenderManager manager) {
                return (Render<EntityParticleSpray>) new InstantParticleRender(manager);
            }
        });
        
        if (Loader.isModLoaded("flammpfeil.slashblade")) {
            RenderingRegistry.registerEntityRenderingHandler(EntitySlashDimensionEx.class, new IRenderFactory<EntitySlashDimensionEx>() {
                public Render createRenderFor(RenderManager manager) {
                    return (Render)new RenderSlashDimensionEx(manager);
                }
            });
            
            RenderingRegistry.registerEntityRenderingHandler(EntityDriveEx.class, new IRenderFactory<EntityDriveEx>() {
                public Render createRenderFor(RenderManager manager) {
                    return (Render)new RenderDriveEx(manager);
                }
            });
        }
    }
    
    private static final ResourceLocation fluidLocation = new ResourceLocation(MoreElectricTools.MODID, "fluid");
    
    public static void registerFluidRender(BlockFluidBase blockFluid, Fluid fluid) {
        final Item itemFluid = Item.getItemFromBlock(blockFluid);
        ModelLoader.setCustomMeshDefinition(itemFluid, new ItemMeshDefinition() {
            @Override
            public ModelResourceLocation getModelLocation(ItemStack stack) {
                return new ModelResourceLocation(fluidLocation, "type=" + fluid.getName());
            }
        });
        ModelLoader.setCustomStateMapper(blockFluid, new StateMapperBase() {
            @Override
            protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
                return new ModelResourceLocation(fluidLocation, "type=" + fluid.getName());
            }
        });
    }
}
