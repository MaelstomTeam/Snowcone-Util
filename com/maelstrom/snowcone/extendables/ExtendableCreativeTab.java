package com.maelstrom.snowcone.extendables;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public abstract class ExtendableCreativeTab extends CreativeTabs {
	
	private ItemStack icon = null;

	public ExtendableCreativeTab(String lablel, ItemStack tabIcon) {
		super(lablel);
		icon = tabIcon;
	}

	@Override
	public Item getTabIconItem() {
		return null;
	}
	
    public ItemStack getIconItemStack(){
    	if(icon !=null)
    		return icon;
    	else
    		return super.getIconItemStack();
    }
    
    @SideOnly(Side.CLIENT)
    public String getTranslatedTabLabel(){
		return "itemGroup." + this.getTabLabel() + ".name";
    }
    
}
