package net.lrsoft.mets.manager;

import net.lrsoft.mets.MoreElectricTools;
import net.minecraftforge.common.config.Config;

@Config(modid = MoreElectricTools.MODID) 
public class ConfigManager {
	 @Config.RequiresMcRestart
	 public static boolean WeaponDamagesTerrain = true;
	 @Config.RequiresMcRestart
	 public static boolean EnableOreGenerate = true;
	 @Config.RequiresMcRestart
	 public static boolean EnableMoreStirlingGenerator = false;
	 @Config.RequiresMcRestart
	 public static boolean EnableFastTESR = false;
	 @Config.RequiresMcRestart
	 public static boolean EnableLighterDynamicSource = true;
	 @Config.RequiresMcRestart
	 public static boolean EnableEUSlashBladeRecipe = true;
	
	 @Config.RequiresWorldRestart
	 public static double AdvancedIridiumSwordBaseCost = 800d;
	 @Config.RequiresWorldRestart
	 public static float AdvancedIridiumSwordBaseAttackDamage = 25f;
	 
	 @Config.RequiresWorldRestart
	 public static double PlasmaAirCannonBaseCost = 1000d;
	 @Config.RequiresWorldRestart
	 public static double PlasmaAirCannonBaseDamage = 10d;
	 
	 @Config.RequiresWorldRestart
	 public static double HeavyQuantumSuitDamageEnergyCost = 10000d;
	 @Config.RequiresWorldRestart
	 public static double AdvancedQuantumSuitDamageEnergyCost = 10000d;
	 @Config.RequiresWorldRestart
	 public static double AdvancedQuantumSuitCureCost = 30000d;
	 
	 @Config.RequiresWorldRestart
	 public static double ElectricSubmachineGunCost = 100d;
	 
	 @Config.RequiresWorldRestart
	 public static int ElectricRocketLauncherInterval = 1500;
	 @Config.RequiresWorldRestart
	 public static double ElectricRocketLauncherCost = 50000d;
	 
	 @Config.RequiresWorldRestart
	 public static double AdvancedElectricSubmachineGunCost = 5000d;
	 
	 @Config.RequiresWorldRestart
	 public static double TacticalLaserSubmachineGunCost = 10000d;
	 
	 @Config.RequiresWorldRestart
	 public static double LaserTowerCost = 250d;
	 
	 @Config.RequiresWorldRestart
	 public static double AdvancedLaserTowerCost = 2500d;
}
