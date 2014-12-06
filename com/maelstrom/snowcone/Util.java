package com.maelstrom.snowcone;

import net.minecraft.init.Blocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid="snowconeUtil", name="Snowcone Util", version="1.0", useMetadata = true)
public class Util {
	
	@Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
		//print loading util
		extendPotionAmountBy(128);
	}
	
	@Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){
		
	}
	//update over each version if obfuscation name changes
	private void extendPotionAmountBy(int amount) {
		net.minecraft.potion.Potion[] potionTypes = null;
		for (java.lang.reflect.Field f : net.minecraft.potion.Potion.class.getDeclaredFields()) {
			f.setAccessible(true);
			try {
				if (f.getName().equals("potionTypes") || f.getName().equals("field_76425_a")) {
					java.lang.reflect.Field modfield = java.lang.reflect.Field.class.getDeclaredField("modifiers");
					modfield.setAccessible(true);
					modfield.setInt(f, f.getModifiers() & ~java.lang.reflect.Modifier.FINAL);
			
					potionTypes = (net.minecraft.potion.Potion[])f.get(null);
					final net.minecraft.potion.Potion[] newPotionTypes = new net.minecraft.potion.Potion[amount];
					System.arraycopy(potionTypes, 0, newPotionTypes, 0, potionTypes.length);
					f.set(null, newPotionTypes);
					}
				}
			catch (Exception e) {
				//log error
			}
		}
	}
	
	public static boolean isObfuscatedEnv() {
		try {
			Blocks.class.getField("air");
			return false;
		}catch (Throwable e){}
		return true;
	}
}