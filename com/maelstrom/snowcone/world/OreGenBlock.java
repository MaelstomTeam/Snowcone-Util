package com.maelstrom.snowcone.world;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class OreGenBlock {
	
	public final int vainSize;
	public final int vainsPerChunk;
	public final int maxY, minY;
	public final Block block;
	public final int meta;
	
	public OreGenBlock(int vain, int vainsPerChunk, int minY, int maxY, Block block, int meta){
		vainSize = vain;
		this.minY = minY;
		this.maxY = maxY;
		this.block = block;
		this.meta = meta;
		this.vainsPerChunk = vainsPerChunk;
	}
	
	public void generateOre(World world, Random random, int x, int z) {
		for(int i = 0; i < vainsPerChunk; i++){
			int xCoord = x + random.nextInt(16);
			int yCoord = minY + random.nextInt(maxY - minY);
			int zCoord = z + random.nextInt(16);
			new WorldGenMinable(block, meta, vainSize, Blocks.stone).generate(world, random, xCoord, yCoord, zCoord);
		}
	}
}