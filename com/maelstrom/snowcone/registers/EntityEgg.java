package com.maelstrom.snowcone.registers;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityList.EntityEggInfo;
import cpw.mods.fml.common.registry.EntityRegistry;

public class EntityEgg {
	
	private static int startEntityId = 0;

	public static void registerEntityAndEgg(Class<? extends Entity> entity,
			int primaryColor, int secondaryColor, String entityName,
			Object mod, int trackingRange, int updateFrequency,
			boolean sendsVelocityUpdates) {
		int id = getUniqueEntityId();
		EntityRegistry.registerModEntity(entity, entityName, id, mod,
				trackingRange, updateFrequency, sendsVelocityUpdates);
		EntityList.IDtoClassMapping.put(id, entity);
		EntityList.entityEggs.put(id, new EntityEggInfo(id, primaryColor,
				secondaryColor));
	}

	public static int getUniqueEntityId() {
		do startEntityId++;
		while (EntityList.getStringFromID(startEntityId) != null);
		return startEntityId;
	}
	
}
