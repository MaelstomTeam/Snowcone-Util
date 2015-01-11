package com.maelstrom.snowcone.extendables;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ExtendableBlock extends Block {
	
	private String mod_id;

	protected ExtendableBlock(Material material, String local, String modid) {
		super(material);
		this.setBlockName(modid + "." + local);
		setBlockTextureName(modid + ":" + local);
		mod_id = modid;
	}
	
//    @SideOnly(Side.CLIENT)
//    protected String getTextureName(){
//        return this.getUnlocalizedName().substring(5 + mod_id.length() + 1);
//    }
}