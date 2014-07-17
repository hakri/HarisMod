package com.hakrismod.tileentity;

import java.util.List;

import com.google.common.collect.Lists;

import ic2.api.energy.prefab.BasicSource;
import cofh.api.energy.EnergyStorage;
import cofh.api.energy.IEnergyHandler;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class CombinedSource extends TileEntity implements IEnergyHandler{
	protected EnergyStorage  lolstorage;
	public BasicSource cssource;
	public List<ForgeDirection> validinputs = Lists.newArrayList(ForgeDirection.UP,ForgeDirection.DOWN,ForgeDirection.EAST,ForgeDirection.WEST,ForgeDirection.NORTH,ForgeDirection.SOUTH);
	public CombinedSource(int ic2tier, int EUcap, int RFcap,ForgeDirection direction, TileEntity recevier,double amount) {
		super();
		this.lolstorage = new EnergyStorage(RFcap);
		this.cssource = new BasicSource(this,RFcap/4,ic2tier);
		this.cssource.setCapacity(EUcap);
		this.lolstorage.setCapacity(EUcap*4);
		this.cssource.emitsEnergyTo(recevier, direction);
		this.cssource.addEnergy(amount);
	}
	@Override
	public boolean canConnectEnergy(ForgeDirection from) {
		
		return true;
	}
	@Override
	public int receiveEnergy(ForgeDirection from, int maxReceive,
			boolean simulate) {	
		return 0;
	}
	@Override
	public int extractEnergy(ForgeDirection from, int maxExtract,
			boolean simulate) {	
		return lolstorage.extractEnergy(maxExtract, simulate);
	}
	@Override
	public int getEnergyStored(ForgeDirection from) {
		
		return lolstorage.getEnergyStored();
	}
	@Override
	public int getMaxEnergyStored(ForgeDirection from) {
		return lolstorage.getMaxEnergyStored();
	}
@Override	
public void updateEntity() {
	cssource.updateEntity();
	if(!worldObj.isRemote) {	
	lolstorage.setEnergyStored((int)this.lolstorage.getEnergyStored() +(int)this.cssource.getOfferedEnergy()/4);
	}
}
@Override
public void invalidate(){
	cssource.invalidate();
	super.invalidate();
}
@Override
public void onChunkUnload(){
	super.onChunkUnload();
	cssource.onChunkUnload();
}
@Override
public void  readFromNBT(NBTTagCompound tag) {
	super.readFromNBT(tag);
	cssource.readFromNBT(tag);
	lolstorage.readFromNBT(tag);	
}
@Override
public void  writeToNBT(NBTTagCompound tag) {
	super.writeToNBT(tag);
	cssource.writeToNBT(tag);
	lolstorage.writeToNBT(tag);
}
public boolean emitsEnergyTo(TileEntity receiver, ForgeDirection direction) {
	return true;
}
}