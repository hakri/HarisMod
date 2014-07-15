package com.hakrismod;

import cofh.api.energy.TileEnergyHandler;

import com.hakrismod.tileentity.PolCanEntity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class PolCan extends BlockContainer {
private IIcon side;
private IIcon top;
private IIcon Bottom;
private IIcon left;
private IIcon right;
private IIcon back;
private IIcon front;
public static int pollutionlevel = 100;


	public PolCan() {
		super(Material.rock);
		this.setCreativeTab(hakrismodmain.BlockTab);
		this.setBlockName("PollutionBlock");
		// TODO Auto-generated constructor stub
		  
	}


	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		// TODO Auto-generated method stub
		return new PolCanEntity();
	}

	@Override
	public void onBlockAdded(World world, int x, int y, int z)
    {
      world.getBlock(x, y, z);
       
   
      
      
    }
	 private void func_149930_e(World p_149930_1_, int p_149930_2_, int p_149930_3_, int p_149930_4_)
	    {
	        if (!p_149930_1_.isRemote)
	        {
	            Block block = p_149930_1_.getBlock(p_149930_2_, p_149930_3_, p_149930_4_ - 1);
	            Block block1 = p_149930_1_.getBlock(p_149930_2_, p_149930_3_, p_149930_4_ + 1);
	            Block block2 = p_149930_1_.getBlock(p_149930_2_ - 1, p_149930_3_, p_149930_4_);
	            Block block3 = p_149930_1_.getBlock(p_149930_2_ + 1, p_149930_3_, p_149930_4_);
	            byte b0 = 3;

	            if (block.func_149730_j() && !block1.func_149730_j())
	            {
	                b0 = 3;
	            }

	            if (block1.func_149730_j() && !block.func_149730_j())
	            {
	                b0 = 2;
	            }

	            if (block2.func_149730_j() && !block3.func_149730_j())
	            {
	                b0 = 5;
	            }

	            if (block3.func_149730_j() && !block2.func_149730_j())
	            {
	                b0 = 4;
	            }

	            p_149930_1_.setBlockMetadataWithNotify(p_149930_2_, p_149930_3_, p_149930_4_, b0, 2);
	        }
	    }

	  public boolean renderAsNormalBlock()
	    {
	        return false;
	    }
  public boolean isOpaqueCube() {
	  return false;
  }
  @Override
  
  @SideOnly(Side.CLIENT)
  public IIcon getIcon(int side, int meta)
  {
      return side == 1 ? this.top : (side == 0 ? this.top : (side != meta ? this.side : this.front));
  }
  @Override
  public void registerBlockIcons(IIconRegister ilikeicons) {
	  side = ilikeicons.registerIcon("hakrismod:side");
	  top = ilikeicons.registerIcon("hakrismod:top");
	  front = ilikeicons.registerIcon("hakrismod:front");
	  
	  
  }
  @Override
  public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase living, ItemStack itemstack)
  {
      super.onBlockPlacedBy(world, x, y, z, living, itemstack);
      PolCanEntity.ticker=0;
  
  
  


    
  }
  
}
