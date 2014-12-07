package com.maelstrom.snowcone.extendables;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.Item;

public abstract class ExtendableItem extends Item {
	
	private String mod_id;
	
	public ExtendableItem(String name, String modid){
		super();
		setUnlocalizedName(modid+"."+name);
		mod_id = modid;
	}
	
	@SideOnly(Side.CLIENT)
    protected String getIconString(){
        return this.getUnlocalizedName().substring(5 + mod_id.length() + 1);
    }
}