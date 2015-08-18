package com.maelstrom.snowcone.registers;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockRegistry {
	
	protected static enum HarvestType {
		PICKAXE,
		AXE,
		SHOVEL
	}
	//register basic block
	protected static void registerBlock(Block block, String blockName, CreativeTabs tab){
		registerBlock(block, blockName, null, -1, tab, null);
	}
	
	//register block
	protected static void registerBlock(Block block, String blockName, HarvestType type, int harvestLevel, CreativeTabs tab, Class<? extends TileEntity> tile){
		GameRegistry.registerBlock(block, blockName);
		
		//harvest type isn't define skip
		if(type != null){
			//check if harvest level is greater then or equal to zero otherwise use zero
			if(harvestLevel >= 0)
				block.setHarvestLevel(enumToString(type), harvestLevel);
			else
				block.setHarvestLevel(enumToString(type), 0);
		}
		//check if tab is available else use another creative tab
		if(tab != null)
			block.setCreativeTab(tab);
		//if tile class is avalible and block is an instance of tile provider
		if(tile != null && block instanceof ITileEntityProvider)			//not sure what would happen if multiple blocks all use the same tile entity
			GameRegistry.registerTileEntity(tile, "TILEENTITY-" + blockName);
	}
	
	//convert harvest levels to strings
	private static String enumToString(HarvestType lvl){
		switch(lvl){
		case AXE:
			return HarvestType.AXE.name();
		case PICKAXE:
			return "pickaxe";
		case SHOVEL:
			return "shovel";
		default:
			return null;
		}
	}
}
