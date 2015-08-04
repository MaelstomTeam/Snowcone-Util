package com.maelstrom.snowcone.extendables;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ExtendableBlock extends Block {
	
	private String mod_id;

	protected ExtendableBlock(Material material, String local, String modid) {
		super(material);
		this.setBlockName(modid + "." + local.replace('/', '.'));
		setBlockTextureName(modid + ":" + local);
		mod_id = modid;
	}
}