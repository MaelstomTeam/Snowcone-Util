package com.maelstrom.snowcone.nbt;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

public abstract class EntityNbt {
	
	private Entity entity;
	private String tag_name;
	private NBTTagCompound entitynbt;
	private NBTTagCompound customNbt;
	
	/**
	 * 	@author hybolic
	 *	@param ent Entity
	 *	@param customNBT custom name for the nbt group
	 */
	public EntityNbt(Entity ent, String customNBT){
		entity = ent;
		tag_name = customNBT;
		entitynbt = entity.getEntityData();
		if(entitynbt.getCompoundTag(customNBT) == null){
			customNbt = new NBTTagCompound();
			entitynbt.setTag(customNBT, customNbt);
		}
		else
			customNbt = entity().getEntityData().getCompoundTag(customNBT);
	}
	
	public Entity entity(){
		return entity;
	}
	
	protected NBTTagCompound customNbt(){
		return customNbt;
	}
	
	public String tag_name(){
		return tag_name;
	}
	
	public boolean getBoolean(String name){
		return customNbt.getBoolean(name);
	}
	
	public String getString(String name){
		return customNbt.getString(name);
	}
	
	public int getInteger(String name){
		return customNbt.getInteger(name);
	}
	
	public int[] getIntArray(String name){
		return customNbt.getIntArray(name);
	}
	
	public short getShort(String name){
		return customNbt.getShort(name);
	}
	
	public long getLong(String name){
		return customNbt.getLong(name);
	}
	
	public byte getByte(String name){
		return customNbt.getByte(name);
	}
	
	public float getFloat(String name){
		return customNbt.getFloat(name);
	}
	
	public double getDouble(String name){
		return customNbt.getDouble(name);
	}
	
	public byte[] getByteArray(String name){
		return customNbt.getByteArray(name);
	}
	


	public void setBoolean(String string, boolean b) {
		customNbt().setBoolean(string, b);
		entity().getEntityData().setTag(tag_name(), customNbt());
	}
	
	/*usually be smart to add this to the part that changes the nbt data*/
	public abstract void Update();

}