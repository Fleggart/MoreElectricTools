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
    // 所有机器配置已移除
}
