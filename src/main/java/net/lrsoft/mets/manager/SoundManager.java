package net.lrsoft.mets.manager;

import net.lrsoft.mets.MoreElectricTools;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = MoreElectricTools.MODID)
public class SoundManager {
	public static SoundEvent laser_bullet_shoot = new SoundEvent(new ResourceLocation(MoreElectricTools.MODID, "laser_bullet_shoot"));
	public static SoundEvent lighter_place = new SoundEvent(new ResourceLocation(MoreElectricTools.MODID, "lighter_place"));
	
	@SubscribeEvent
	public static void onSoundEventRegistration(RegistryEvent.Register<SoundEvent> event) 
	{
	    event.getRegistry().register(laser_bullet_shoot.setRegistryName("laser_bullet_shoot"));
	    event.getRegistry().register(lighter_place.setRegistryName("lighter_place"));
	}
	
}