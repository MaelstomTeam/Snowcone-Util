package com.maelstrom.snowcone.registers;

import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.common.event.FMLStateEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;

public class ItemRegistry {

	protected static void registItem(Item item, String itemName, String modID, CreativeTabs tab){
		GameRegistry.registerItem(item, itemName, modID);
		if(tab != null)
			item.setCreativeTab(tab);
		else
			item.setCreativeTab(CreativeTabs.tabAllSearch);
//		1.8 update
//		if(event.getSide() == Side.CLIENT) {
//		    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(modID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
//		}
	}
}
