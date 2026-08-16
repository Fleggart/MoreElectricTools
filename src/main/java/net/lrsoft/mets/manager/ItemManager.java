package net.lrsoft.mets.manager;

import ic2.api.item.IC2Items;
import ic2.api.recipe.Recipes;
import net.lrsoft.mets.MoreElectricTools;
import net.lrsoft.mets.item.ElectricFirstAidLifeSupport;
import net.lrsoft.mets.item.ElectricFishingRod;
import net.lrsoft.mets.item.ElectricForceFieldGenerator;
import net.lrsoft.mets.item.ElectricLighter;
import net.lrsoft.mets.item.ElectricNutritionSupply;
import net.lrsoft.mets.item.ElectricWirlessManager;
import net.lrsoft.mets.item.GeomagneticDetector;
import net.lrsoft.mets.item.battery.AdvancedLithiumBattery;
import net.lrsoft.mets.item.battery.ChargingSuperLapotronCrystal;
import net.lrsoft.mets.item.battery.LithiumBattery;
import net.lrsoft.mets.item.battery.SuperLapotronCrystal;
import net.lrsoft.mets.item.battery.ThoriumBattery;
import net.lrsoft.mets.item.blade.BladeManager;
import net.lrsoft.mets.item.crafting.ItemCraftingManager;
import net.lrsoft.mets.item.weapon.AdvancedElectricSubmachineGun;
import net.lrsoft.mets.item.weapon.ElectricPlasmaGun;
import net.lrsoft.mets.item.weapon.ElectricRocketLauncher;
import net.lrsoft.mets.item.weapon.ElectricShield;
import net.lrsoft.mets.item.weapon.ElectricSubmachineGun;
import net.lrsoft.mets.item.weapon.NanoBow;
import net.lrsoft.mets.item.weapon.TachyonDisruptor;
import net.lrsoft.mets.item.weapon.TacticalLaserSubmachineGun;
import net.lrsoft.mets.util.SpecialRecipesHelper;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.oredict.OreDictionary;

@Mod.EventBusSubscriber(modid = MoreElectricTools.MODID)
public class ItemManager {
	
	public static SuperLapotronCrystal superLapotronCrystal;
	public static ChargingSuperLapotronCrystal chargingSuperLapotronCrystal;
	public static AdvancedLithiumBattery advancedLithiumBattery;
	public static LithiumBattery lithiumBattery;
	public static ThoriumBattery thoriumBattery;
	
	public static ElectricFirstAidLifeSupport electricFirstAidLifeSupport;
	public static ElectricNutritionSupply electricNutritionSupply;
	public static ElectricFishingRod electricFishingRod;
	public static ElectricShield electricShield;
	public static ElectricForceFieldGenerator electricForceFieldGenerator;
	public static ElectricLighter electricLighter;
	
	public static ElectricWirlessManager electricWirlessManager;
	public static GeomagneticDetector geomagneticDetector;
	
	public static NanoBow nanoBow;
	public static ElectricSubmachineGun electricSubmachineGun;
	public static AdvancedElectricSubmachineGun advancedElectricSubmachineGun;
	public static TacticalLaserSubmachineGun tacticalLaserSubmachineGun;
	public static ElectricRocketLauncher electricRocketLauncher;
	public static ElectricPlasmaGun electricPlasmaGun;
	public static TachyonDisruptor tachyonDisruptor;
	
	static 
	{
		superLapotronCrystal = new SuperLapotronCrystal();
		chargingSuperLapotronCrystal = new ChargingSuperLapotronCrystal();
		
		advancedLithiumBattery = new AdvancedLithiumBattery();
		lithiumBattery = new LithiumBattery();
		thoriumBattery = new ThoriumBattery();
		
		electricFirstAidLifeSupport = new ElectricFirstAidLifeSupport();
		electricNutritionSupply = new ElectricNutritionSupply();
		electricFishingRod = new ElectricFishingRod();
		electricShield = new ElectricShield();
		electricForceFieldGenerator = new ElectricForceFieldGenerator();
		electricWirlessManager = new ElectricWirlessManager();
		nanoBow = new NanoBow();
		electricLighter = new ElectricLighter();
		geomagneticDetector = new GeomagneticDetector();
		
		electricSubmachineGun = new ElectricSubmachineGun();
		advancedElectricSubmachineGun = new AdvancedElectricSubmachineGun();
		tacticalLaserSubmachineGun = new TacticalLaserSubmachineGun();
		electricRocketLauncher = new ElectricRocketLauncher();
		electricPlasmaGun = new ElectricPlasmaGun();
		tachyonDisruptor = new TachyonDisruptor();
	}
	
	@SubscribeEvent
	public static void onItemInit(RegistryEvent.Register<Item> event)
	{
		event.getRegistry().register(superLapotronCrystal);
		event.getRegistry().register(chargingSuperLapotronCrystal);
		event.getRegistry().register(advancedLithiumBattery);
		event.getRegistry().register(lithiumBattery);
		event.getRegistry().register(thoriumBattery);
		event.getRegistry().register(electricFirstAidLifeSupport);
		event.getRegistry().register(electricNutritionSupply);
		event.getRegistry().register(electricFishingRod);
		event.getRegistry().register(electricShield);
		event.getRegistry().register(nanoBow);
		event.getRegistry().register(electricSubmachineGun);
		event.getRegistry().register(advancedElectricSubmachineGun);
		event.getRegistry().register(tacticalLaserSubmachineGun);
		event.getRegistry().register(electricRocketLauncher);
		event.getRegistry().register(electricForceFieldGenerator);
		event.getRegistry().register(electricLighter);
		event.getRegistry().register(geomagneticDetector);
		
		event.getRegistry().register(electricPlasmaGun);
		event.getRegistry().register(electricWirlessManager);
		event.getRegistry().register(tachyonDisruptor);
		
		OreDictionary.registerOre("superLapotronCrystal", superLapotronCrystal);
		OreDictionary.registerOre("advancedLithiumBattery", advancedLithiumBattery);
		OreDictionary.registerOre("lithiumBattery", lithiumBattery);
		
		ItemCraftingManager.onCraftingItemInit(event);
		
		onRecipeInit();
		ItemCraftingManager.onCraftingItemRecipeInit();
		
		if (Loader.isModLoaded("flammpfeil.slashblade")) 
		{
			BladeManager.onBladeInit();
		}
	}
	
	private static void onRecipeInit() 
	{
		Recipes.advRecipes.addRecipe(new ItemStack(superLapotronCrystal), 
				new Object[] {
						"SCS",
						"SDS",
						"SCS",
						'S', ItemCraftingManager.niobium_titanium_plate,
						'C', Recipes.inputFactory.forOreDict("circuitElite"),
						'D', getAllTypeStack(IC2Items.getItem("lapotron_crystal"))
				});
		
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
		
		if(ConfigManager.EnableElectricNutritionSupplyCost)
		{
			Recipes.advRecipes.addRecipe(new ItemStack(electricNutritionSupply), 
					new Object[] {
							"SPS",
							"HCH",
							"SBS",
							'P', IC2Items.getItem("treetap"),
							'S', IC2Items.getItem("casing", "gold"),
							'C', IC2Items.getItem("crafting", "circuit"),
							'H', IC2Items.getItem("heat_exchanger"),
							'B', getAllTypeStack(lithiumBattery)
					});			
		}

		
		Recipes.advRecipes.addRecipe(new ItemStack(electricFishingRod), 
				new Object[] {
						" SL",
						"SDL",
						" SL",
						'S', IC2Items.getItem("casing", "iron"),
						'L', Items.STRING,
						'D', IC2Items.getItem("crafting", "small_power_unit")
				});
		
		Recipes.advRecipes.addRecipe(new ItemStack(nanoBow), 
				new Object[] {
						"CMS",
						"CBA",
						"CMS",
						'C', IC2Items.getItem("crafting", "carbon_plate"),
						'B', getAllTypeStack(IC2Items.getItem("energy_crystal")),
						'M', IC2Items.getItem("crafting", "electric_motor"),
						'S', Items.LEAD,
						'A', IC2Items.getItem("crafting", "advanced_circuit")
				});		
		
		// 移除 PlasmaAirCannon 合成配方
		// Recipes.advRecipes.addRecipe(new ItemStack(plasmaAirCannon), 
		// 		new Object[] {
		// 				"CCB",
		// 				"LPA",
		// 				"LLB",
		// 				'C', IC2Items.getItem("crafting", "coil"),
		// 				'B', getAllTypeStack(lithiumBattery),
		// 				'L', IC2Items.getItem("crafting", "alloy"),
		// 				'P', IC2Items.getItem("fluid_cell"),
		// 				'A', IC2Items.getItem("crafting", "advanced_circuit")
		// 		});
		
		Recipes.advRecipes.addRecipe(new ItemStack(electricShield), 
				new Object[] {
						"SAS",
						"SBS",
						"SDS",
						'S', IC2Items.getItem("plate", "steel"),
						'B', getAllTypeStack(lithiumBattery),
						'D', IC2Items.getItem("crafting", "power_unit"),
						'A', IC2Items.getItem("crafting", "advanced_circuit")
				});
		
		if(ConfigManager.EnableElectricFirstAidLifeSupportRecipe)
		{
			Recipes.advRecipes.addRecipe(new ItemStack(electricFirstAidLifeSupport), 
					new Object[] {
							"ITI",
							"MBM",
							"ITI",
							'M', getAllTypeStack(electricForceFieldGenerator),
							'B', getAllTypeStack(IC2Items.getItem("lapotron_crystal")),
							'I', IC2Items.getItem("crafting", "iridium"),
							'T', Recipes.inputFactory.forOreDict("circuitElite")
					});
		}
		
		Recipes.advRecipes.addRecipe(new ItemStack(electricSubmachineGun), new Object[]
				{
				"SSB",
				"LJC",
				"SSD",
				'S', IC2Items.getItem("plate", "iron"),
				'B', getAllTypeStack(lithiumBattery),
				'L', ItemCraftingManager.lens,
				'J', IC2Items.getItem("neutron_reflector"),
				'C', IC2Items.getItem("crafting", "advanced_circuit"),
				'D', IC2Items.getItem("crafting", "power_unit")
				});
		
		Recipes.advRecipes.addRecipe(new ItemStack(advancedElectricSubmachineGun), new Object[]
				{
				"SSB",
				"LJC",
				"SSD",
				'S', ItemCraftingManager.niobium_titanium_plate,
				'B', getAllTypeStack(IC2Items.getItem("lapotron_crystal")),
				'L', ItemCraftingManager.diamond_lens,
				'J', IC2Items.getItem("iridium_reflector"),
				'C', Recipes.inputFactory.forOreDict("circuitElite"),
				'D', getAllTypeStack(electricSubmachineGun)
				});
		
		Recipes.advRecipes.addRecipe(new ItemStack(electricRocketLauncher), new Object[]
				{
				"SSB",
				"XLC",
				"SFD",
				'S', Recipes.inputFactory.forOreDict("plateTitanium"),
				'B', getAllTypeStack(IC2Items.getItem("energy_crystal")),
				'X', IC2Items.getItem("crafting", "coil"),
				'L', IC2Items.getItem("upgrade", "ejector"),
				'C', IC2Items.getItem("crafting", "advanced_circuit"),
				'F', IC2Items.getItem("frequency_transmitter"),
				'D', IC2Items.getItem("crafting", "power_unit")
				});
		
		Recipes.advRecipes.addRecipe(new ItemStack(chargingSuperLapotronCrystal), new Object[]
				{
				"EBS",
				"BOB",
				"SBE",
				'B', getAllTypeStack(ItemManager.superLapotronCrystal),
				'E', IC2Items.getItem("crafting", "advanced_circuit"),
				'S', IC2Items.getItem("advanced_heat_exchanger"),
				'O', getAllTypeStack(IC2Items.getItem("charging_lapotron_crystal"))
				});
		
		Recipes.advRecipes.addRecipe(new ItemStack(electricForceFieldGenerator), new Object[]
				{
				"SCS",
				"MBM",
				"SCS",
				'S', Recipes.inputFactory.forOreDict("casingTitanium"),
				'B', getAllTypeStack(IC2Items.getItem("energy_crystal")),
				'M', getAllTypeStack(electricNutritionSupply),
				'C', IC2Items.getItem("crafting", "advanced_circuit")
				});
		
		Recipes.advRecipes.addRecipe(new ItemStack(electricLighter), new Object[]
			   {"NSB",
				"LJC",
				"NSD",
				'S', IC2Items.getItem("plate", "iron"),
				'B', getAllTypeStack(advancedLithiumBattery),
				'L', ItemCraftingManager.lens,
				'J', Items.GLOWSTONE_DUST,
				'N', IC2Items.getItem("neutron_reflector"),
				'C', IC2Items.getItem("crafting", "advanced_circuit"),
				'D', IC2Items.getItem("crafting", "power_unit")
				});
		
		Recipes.advRecipes.addRecipe(new ItemStack(electricWirlessManager), new Object[]
				   {"SCS",
					"CTC",
					"SBS",
					'S', Recipes.inputFactory.forOreDict("plateTitanium"),
					'B', getAllTypeStack(lithiumBattery),
					'T', IC2Items.getItem("frequency_transmitter"),
					'C', IC2Items.getItem("crafting", "advanced_circuit"),
					});
		
		Recipes.advRecipes.addRecipe(new ItemStack(geomagneticDetector), new Object[]
				   {"SCS",
					"CTC",
					"SBS",
					'S', Recipes.inputFactory.forOreDict("plateTitanium"),
					'B', getAllTypeStack(lithiumBattery),
					'T', IC2Items.getItem("te", "tesla_coil"),
					'C', IC2Items.getItem("crafting", "advanced_circuit"),
					});
		
		Recipes.advRecipes.addRecipe(new ItemStack(electricPlasmaGun), new Object[]
				{
					"TSB",
					"OOC",
					"TSD",
					'S', ItemCraftingManager.niobium_titanium_plate,
					'B', getAllTypeStack(IC2Items.getItem("energy_crystal")),
					'O', IC2Items.getItem("crafting", "coil"),
					'J', IC2Items.getItem("iridium_reflector"),
					'T', IC2Items.getItem("upgrade", "ejector"),
					'C', Recipes.inputFactory.forOreDict("circuitElite"),
					'D', getAllTypeStack(electricSubmachineGun)
					});
		
		Recipes.advRecipes.addRecipe(new ItemStack(tachyonDisruptor), new Object[]
				{
					"OSB",
					"TTC",
					"OSD",
					'S', ItemCraftingManager.nano_living_metal,
					'B', getAllTypeStack(superLapotronCrystal),
					'O', ItemCraftingManager.neutron_plate,
					'T', ItemCraftingManager.field_generator,
					'C', Recipes.inputFactory.forOreDict("circuitUltimate"),
					'D', getAllTypeStack(tacticalLaserSubmachineGun)
					});
		
		//Other
		try 
		{
			SpecialRecipesHelper.onInitLiquidRecipe();
		}catch(Exception expt)
		{
			System.out.println("[METS]:Fail to init liquid recipe.");
			expt.printStackTrace();
		}
	}	
	
	public static ItemStack getAllTypeStack(ItemStack itemstack) {
		return new ItemStack(itemstack.getItem(), 1, OreDictionary.WILDCARD_VALUE);
	}

	public static ItemStack getAllTypeStack(Item item) {
		return new ItemStack(item, 1, OreDictionary.WILDCARD_VALUE);
	}
}