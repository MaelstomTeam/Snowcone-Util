package com.maelstrom.snowcone.extendables;

import net.minecraft.item.Item;

public abstract class ExtendableItem extends Item {
	
	protected final String mod_id;
	
	public ExtendableItem(String name, String modid){
		super();
		setUnlocalizedName(modid+"."+name);
		mod_id = modid;
		this.setTextureName(modid + ":" + getUnlocalizedName().substring(5 + mod_id.length() + 1));
	}
}