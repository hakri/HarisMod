package com.hakrismod.tileentity;

import java.util.Iterator;
import java.util.List;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

import com.hakrismod.*;

public class PolCanEntity extends TileEntity {
	
	
	
 double distance = 10;
 //creating array for potion effects
public static int ticker;
	

public PolCanEntity()  {
	double ranges = 3;
	
	
	if(ticker >= 23 ) {
 
 int pollutionlevel = 1000;
 EntityPlayer player;

	List  list = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, AxisAlignedBB.getBoundingBox(xCoord-ranges, yCoord - ranges, zCoord- ranges, xCoord + ranges, yCoord + ranges, zCoord + ranges));
    Iterator ilikepie = list.iterator();
    
    
    while(pollutionlevel >=100 && ilikepie.hasNext() && list.size()!= 0) {
    	
    	player = (EntityPlayer)ilikepie.next();
		player.addPotionEffect(new PotionEffect(17,100));
	
		ticker = 0;
		pollutionlevel --;
		LogHelper.info(pollutionlevel);
		
		
	}
		
	
	}


	
}
}

