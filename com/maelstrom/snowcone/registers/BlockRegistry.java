package com.maelstrom.snowcone.registers;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockRegistry {
	
	protected static enum HarvestType {
		PICKAXE,
		AXE,
		SHOVEL
	}
	
	protected static void registerBlock(Block block, String blockName, CreativeTabs tab){
		registerBlock(block, blockName, null, -1, tab);
	}
	
	protected static void registerBlock(Block block, String blockName, HarvestType type, int harvestLevel, CreativeTabs tab){
		GameRegistry.registerBlock(block, blockName);
		
		if(type != null)
			if(harvestLevel >= 0)
				block.setHarvestLevel(enumToString(type), harvestLevel);
			else
				block.setHarvestLevel(enumToString(type), 0);
		
		if(tab != null)
			block.setCreativeTab(tab);
		else
			block.setCreativeTab(CreativeTabs.tabBlock);
	}
	
	private static String enumToString(HarvestType lvl){
		switch(lvl){
		case AXE:
			return "axe";
		case PICKAXE:
			return "pickaxe";
		case SHOVEL:
			return "shovel";
		default:
			return null;
		}
	}
}
