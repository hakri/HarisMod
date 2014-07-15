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
import cofh.api.energy.TileEnergyHandler;

import com.hakrismod.*;

public class PolCanEntity extends TileEnergyHandler {
	
	

public static int ticker;
	@Override
	
public void updateEntity() {
		
if(!this.worldObj.isRemote) {

storage.setEnergyStored(storage.getEnergyStored() + 10);
		
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
		LogHelper.info(hakrismodmain.polevel);
		
		
	}
    
		
	
	}
@Override
public int extractEnergy(ForgeDirection from, int maxExtract, boolean simulate) {

	return storage.extractEnergy(maxExtract, simulate);
	
}
@Override
public int receiveEnergy(ForgeDirection from, int maxReceive, boolean simulate) {

	return 0;
}

@Override
public boolean canConnectEnergy(ForgeDirection from) {

	return true;
}
}

