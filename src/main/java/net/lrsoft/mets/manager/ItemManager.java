package net.lrsoft.mets.manager;

import ic2.api.item.IC2Items;
import ic2.api.recipe.Recipes;
import net.lrsoft.mets.MoreElectricTools;
import net.lrsoft.mets.item.battery.AdvancedLithiumBattery;
import net.lrsoft.mets.item.battery.LithiumBattery;
import net.lrsoft.mets.item.battery.SuperLapotronCrystal;
import net.lrsoft.mets.item.battery.ThoriumBattery;
import net.lrsoft.mets.item.blade.BladeManager;
import net.lrsoft.mets.item.crafting.ItemCraftingManager;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.OreDictionary;

@Mod.EventBusSubscriber(modid = MoreElectricTools.MODID)
public class ItemManager {
    
    public static AdvancedLithiumBattery advancedLithiumBattery;
    public static LithiumBattery lithiumBattery;
    public static ThoriumBattery thoriumBattery;
    
    static {
        advancedLithiumBattery = new AdvancedLithiumBattery();
        lithiumBattery = new LithiumBattery();
        thoriumBattery = new ThoriumBattery();
    }
    
    @SubscribeEvent
    public static void onItemInit(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(advancedLithiumBattery);
        event.getRegistry().register(lithiumBattery);
        event.getRegistry().register(thoriumBattery);
        
        OreDictionary.registerOre("advancedLithiumBattery", advancedLithiumBattery);
        OreDictionary.registerOre("lithiumBattery", lithiumBattery);
        
        ItemCraftingManager.onCraftingItemInit(event);
        
        onRecipeInit();
        ItemCraftingManager.onCraftingItemRecipeInit();
        
        if (Loader.isModLoaded("flammpfeil.slashblade")) {
            BladeManager.onBladeInit();
        }
    }
    
    private static void onRecipeInit() {
        Recipes.advRecipes.addRecipe(new ItemStack(advancedLithiumBattery), 
                new Object[] {
                        "CSC",
                        "SLS",
                        "SPS",
                        'C', IC2Items.getItem("cable", "type:copper,insulation:1"),
                        'S', IC2Items.getItem("casing", "steel"),
                        'L', IC2Items.getItem("dust", "lithium"),
                        'P', IC2Items.getItem("dust", "lead")
                });
        
        Recipes.advRecipes.addRecipe(new ItemStack(lithiumBattery), 
                new Object[] {
                        " C ",
                        "SLS",
                        "SLS",
                        'C', IC2Items.getItem("cable", "type:copper,insulation:1"),
                        'S', IC2Items.getItem("casing", "copper"),
                        'L', IC2Items.getItem("dust", "lithium")
                });
        
        Recipes.advRecipes.addRecipe(new ItemStack(thoriumBattery), 
                new Object[] {
                        " C ",
                        "SLS",
                        "SLS",
                        'C', IC2Items.getItem("cable", "type:tin,insulation:1"),
                        'S', IC2Items.getItem("casing", "lead"),
                        'L', Recipes.inputFactory.forOreDict("dustThorium")
                });
    }
    
    public static ItemStack getAllTypeStack(ItemStack itemstack) {
        return new ItemStack(itemstack.getItem(), 1, OreDictionary.WILDCARD_VALUE);
    }

    public static ItemStack getAllTypeStack(Item item) {
        return new ItemStack(item, 1, OreDictionary.WILDCARD_VALUE);
    }
}
