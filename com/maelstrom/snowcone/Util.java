package com.maelstrom.snowcone;

import java.awt.Color;
import java.util.Calendar;
import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.common.MinecraftForge;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.GuiModList;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid="snowconeUtil", name="Snowcone Util", version="1.2.1", useMetadata = true)
public class Util {
	
	@Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
		//print loading util
		extendPotionAmountBy(128);
		new PrivateWorkAround();
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	@Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){
		
	}

	
	int rngLast = 0;
	int rng = 0;
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void guiDraw(GuiScreenEvent.DrawScreenEvent event){
		if(event.gui instanceof GuiModList){
			GuiModList gui = (GuiModList) event.gui;
			if(gui.modIndexSelected(PrivateWorkAround.ModID())){
		        Calendar calendar = Calendar.getInstance();
				GL11.glPushMatrix();
		        GL11.glTranslatef((float)(300), 50.0F, 0.0F);
				GL11.glRotated(-10, 0, 0, 1);
		        float f1 = 1.8F - MathHelper.abs(MathHelper.sin((float)(Minecraft.getSystemTime() % 1000L) / 1000.0F * (float)Math.PI * 2.0F) * 0.1F);
		        f1 = f1 * 100.0F / (float)(Minecraft.getMinecraft().fontRenderer.getStringWidth("HAPPY B-DAY HYBOLIC!!") + 32);
		        GL11.glScalef(f1, f1, f1);
		        //EVENTS
				if(calendar.get(2) + 1 == 2 && calendar.get(5) == 7)
					event.gui.drawCenteredString(Minecraft.getMinecraft().fontRenderer, "HAPPY B-DAY Nadir!!", 0, 0, Color.yellow.hashCode());
		        else if((calendar.get(2) + 1 == 12 && calendar.get(5) == 16))   
					event.gui.drawCenteredString(Minecraft.getMinecraft().fontRenderer, "HAPPY B-DAY SporNight!!", 0, 0, Color.yellow.hashCode());
		        else if((calendar.get(2) + 1 == 10 && calendar.get(5) == 31))
					event.gui.drawCenteredString(Minecraft.getMinecraft().fontRenderer, "Spooky Scary Skeletons!", 0, 0, Color.yellow.hashCode());
		        else if((calendar.get(2) + 1 == 4 && calendar.get(5) == 4))
					event.gui.drawCenteredString(Minecraft.getMinecraft().fontRenderer, "HAPPY B-DAY SnowconeUtil!", 0, 0, Color.yellow.hashCode());
		        /* add the first day out of alpha here
		        else if((calendar.get(2) + 1 == 10 && calendar.get(5) == 31))
					event.gui.drawCenteredString(Minecraft.getMinecraft().fontRendererObj, "HAPPY B-DAY Arcane Mechina!", 0, 0, Color.yellow.hashCode());
		         */
				
		        else{
		        	if (rng == 0)
		        		event.gui.drawCenteredString(Minecraft.getMinecraft().fontRenderer, "Don't worry It's Lemon!", 0, 0, Color.yellow.hashCode());
		        	else if (rng == 1)
		        		event.gui.drawCenteredString(Minecraft.getMinecraft().fontRenderer, "It's not icecream!", 0, 0, Color.yellow.hashCode());
		        	else if (rng == 2)
		        		event.gui.drawCenteredString(Minecraft.getMinecraft().fontRenderer, "1,403rd times the charm right?", 0, 0, Color.yellow.hashCode());
		        }
				GL11.glPopMatrix();
				if(rngLast != rng)
					rngLast = rng;
			}else{
				if(new Random().nextInt(11) == 10)
					while(rngLast == rng)
						rng = new Random().nextInt(3);
				else
					rng = 0;
			}
		}
	}
	//update over each version if obfuscation name changes
	@Deprecated
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