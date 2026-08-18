package net.lrsoft.mets.manager;

import net.lrsoft.mets.MoreElectricTools;
import net.lrsoft.mets.blade.EntityDriveEx;
import net.lrsoft.mets.blade.EntitySlashDimensionEx;
import net.lrsoft.mets.blade.RenderDriveEx;
import net.lrsoft.mets.blade.RenderSlashDimensionEx;
import net.lrsoft.mets.item.blade.BladeModelManager;
import net.lrsoft.mets.item.crafting.ItemCraftingManager;
import net.lrsoft.mets.renderer.particle.EntityParticleGroup;
import net.lrsoft.mets.renderer.particle.EntityParticleSpray;
import net.lrsoft.mets.renderer.particle.InstantParticleRender;
import net.lrsoft.mets.renderer.particle.ParticleRenderer;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(value = Side.CLIENT, modid = MoreElectricTools.MODID)
public class ModelManager {
    @SubscribeEvent
    public static void onItemModelInit(ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(ItemManager.advancedLithiumBattery, 0,
                new ModelResourceLocation(ItemManager.advancedLithiumBattery.getRegistryName(), "inventory"));
        ModelLoader.setCustomModelResourceLocation(ItemManager.lithiumBattery, 0,
                new ModelResourceLocation(ItemManager.lithiumBattery.getRegistryName(), "inventory"));
        ModelLoader.setCustomModelResourceLocation(ItemManager.thoriumBattery, 0,
                new ModelResourceLocation(ItemManager.thoriumBattery.getRegistryName(), "inventory"));

        ItemCraftingManager.onCraftingItemModelInit();

        if (Loader.isModLoaded("flammpfeil.slashblade")) {
            BladeModelManager.onModelInit();
        }
    }

    @SubscribeEvent
    public static void onBlockModelInit(ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(BlockManager.niobiumOre), 0, 
                new ModelResourceLocation(BlockManager.niobiumOre.getRegistryName(), "normal"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(BlockManager.titaniumOre), 0, 
                new ModelResourceLocation(BlockManager.titaniumOre.getRegistryName(), "normal"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(BlockManager.titaniumBlock), 0, 
                new ModelResourceLocation(BlockManager.titaniumBlock.getRegistryName(), "normal"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(BlockManager.titaniumScaffold), 0, 
                new ModelResourceLocation(BlockManager.titaniumScaffold.getRegistryName(), "normal"));
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
                    return (Render) new RenderSlashDimensionEx(manager);
                }
            });

            RenderingRegistry.registerEntityRenderingHandler(EntityDriveEx.class, new IRenderFactory<EntityDriveEx>() {
                public Render createRenderFor(RenderManager manager) {
                    return (Render) new RenderDriveEx(manager);
                }
            });
        }
    }
}
