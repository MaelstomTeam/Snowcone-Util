package com.maelstrom.snowcone.extendables;

import com.maelstrom.arcaneMechina.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public abstract class ExtendableItem extends Item {
	
	private String mod_id;
	
	public ExtendableItem(String name, String modid){
		super();
		setUnlocalizedName(modid+"."+name);
		mod_id = modid;
//		this.setTextureName(Reference.MOD_ID + ":" + name);
	}
	
	@SideOnly(Side.CLIENT)
    protected String getIconString(){
        return this.getUnlocalizedName().substring(5 + mod_id.length() + 1);
    }

    public abstract void registerIcons(IIconRegister iicon);
//    public abstract IIcon getIcon(ItemStack stack, int pass);
}