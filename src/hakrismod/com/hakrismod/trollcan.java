package com.hakrismod;

import com.hakrismod.tileentity.TrollCanEntity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class trollcan extends BlockContainer {
public IIcon trollcon;

	public trollcan() {
		super(Material.iron);
		this.setBlockName("trollcan");
		this.setHardness(9.0F);
		this.setResistance(8.0F);
		this.setCreativeTab(hakrismodmain.BlockTab);
		
		this.setBlockBounds(1F/16F * 3F, 0F, 1F/16F*3F, 1F-1F/16F*3F, 1F-1F/16F*3F, 1F-1F/16F*3F);
	
	}
	@Override

public void  registerBlockIcons(IIconRegister iconregister) {
	
	this.blockIcon = iconregister.registerIcon("hakrismod:trollcanlol"); 
}

@Override
public boolean isOpaqueCube() {
	return false;
	
}
@Override
public boolean renderAsNormalBlock() {
	return false;
}
@Override
public int getRenderType() {
	return -1;
}

@Override
public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
	// TODO Auto-generated method stub
	return new TrollCanEntity();
}
}
