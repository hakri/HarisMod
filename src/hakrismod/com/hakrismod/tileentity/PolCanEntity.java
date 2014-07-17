package com.hakrismod.tileentity;

import java.util.Iterator;
import java.util.List;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.ClientTickEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import cofh.api.energy.EnergyStorage;
import cofh.api.energy.ItemEnergyContainer;
import cofh.api.energy.TileEnergyHandler;

import com.hakrismod.*;

public class PolCanEntity extends CombinedSource {
	public PolCanEntity(int ic2tier, int EUcap, int RFcap,
			ForgeDirection direction, TileEntity recevier) {
		super(4, 1, RFcap, direction, recevier, RFcap);
		// TODO Auto-generated constructor stub
	}

public static int ticker;
	@Override
	
public void updateEntity() {
		
if(!this.worldObj.isRemote) {
cssource.updateEntity();
	cssource.addEnergy(1);
}
hakrismodmain.polevel++;
if(ticker >= 1000) {
this.producepollution();
	}
}
	
public void producepollution()  {
	double ranges = 3;
	List  list = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, AxisAlignedBB.getBoundingBox(this.xCoord-ranges, this.yCoord - ranges, this.zCoord- ranges, this.xCoord + ranges, this.yCoord + ranges, this.zCoord + ranges));
    Iterator ilikepie = list.iterator();   
    if(hakrismodmain.polevel >=1000 && ilikepie.hasNext()) {
    	
    	EntityPlayer player = (EntityPlayer) ilikepie.next();
		player.addPotionEffect(new PotionEffect(17,100));
		player.addPotionEffect(new PotionEffect(19,2000));
		player.addPotionEffect(new PotionEffect(15,10000));
	
		ticker = 0;
		hakrismodmain.polevel--;		
	}	
	}
@Override
public int receiveEnergy(ForgeDirection from, int maxReceive, boolean simulate) {

	return 0;
}

@Override
public boolean canConnectEnergy(ForgeDirection from) {

	return true;
}


@Override

public int extractEnergy(ForgeDirection from, int maxExtract, boolean simulate) {

	
from = ForgeDirection.getOrientation(blockMetadata);
	 return lolstorage.extractEnergy(maxExtract,simulate);
}

@Override
public void invalidate(){
	cssource.invalidate();
	super.invalidate();
}
@Override
public void  writeToNBT(NBTTagCompound tag) {
	super.writeToNBT(tag);
	cssource.writeToNBT(tag);
	lolstorage.writeToNBT(tag);
}
@Override
public boolean emitsEnergyTo(TileEntity receiver, ForgeDirection direction) {
	return true;
}
@Override
public int getEnergyStored(ForgeDirection from) {
	// TODO Auto-generated method stub
	return lolstorage.getEnergyStored();
}

@Override
public int getMaxEnergyStored(ForgeDirection from) {
	// TODO Auto-generated method stub
	return lolstorage.getMaxEnergyStored();
}

}


