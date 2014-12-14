package com.maelstrom.snowcone.nbt;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

public abstract class PlayerNbt extends EntityNbt {
	
	private EntityPlayer player;
	private NBTTagCompound playernbt;
	
	public PlayerNbt(EntityPlayer ply, String customNBT){
		super(ply, customNBT);
		player = ply;
		playernbt = player.getEntityData();
	}
	
	public EntityPlayer player(){
		return player;
	}
	
	public NBTTagCompound playernbt(){
		return playernbt;
	}

}