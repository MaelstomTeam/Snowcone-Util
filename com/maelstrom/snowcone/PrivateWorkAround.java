package com.maelstrom.snowcone;

import java.util.ArrayList;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.ModContainer;

public class PrivateWorkAround {
	private static int myModLocation = -99;

	public static int ModID() {
		if (myModLocation == -99) {
			ArrayList<ModContainer> mods = new ArrayList<ModContainer>();
			FMLClientHandler.instance().addSpecialModEntries(mods);
			int i = 0;
			for (ModContainer mod : Loader.instance().getModList())
				if (mod.getModId().equalsIgnoreCase("snowconeUtil")) {
					myModLocation = i;
					break;
				}
				else
					i++;
		}
		return myModLocation;
	}
}
