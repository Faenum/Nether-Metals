package com.knoxhack.nethermetals.blocks;





import java.util.Random;

import net.minecraft.block.Block;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;


public class ModBlockOre extends Block {

	private Block drop;
	private int meta;
	private int least_quantity;
	private int most_quantity;

	protected ModBlockOre(String unlocalizedName, Material mat, Block nethernickelOre, int meta, int least_quantity, int most_quantity) {
		super(mat);
		this.drop = nethernickelOre;
		this.meta = meta;
		this.least_quantity = least_quantity;
		this.most_quantity = most_quantity;
		this.setHarvestLevel("pickaxe", 1);
		this.setHardness(4.0f);
		this.setResistance(15.0f);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}

	protected ModBlockOre(String unlocalizedName, Material mat, Block nethernickelOre, int least_quantity, int most_quantity) {
		this(unlocalizedName, mat, nethernickelOre, 0, least_quantity, most_quantity);
	}

	protected ModBlockOre(String unlocalizedName, Material mat, Block drop) {
		this(unlocalizedName, mat, drop, 1, 1);
	}




	@Override
	public int damageDropped(IBlockState blockstate) {
		return this.meta;
	}

	@Override
	public int quantityDropped(IBlockState blockstate, int fortune, Random random) {
		if (this.least_quantity >= this.most_quantity)
			return this.least_quantity;
		return this.least_quantity + random.nextInt(this.most_quantity - this.least_quantity + fortune + 1);
	}
}

