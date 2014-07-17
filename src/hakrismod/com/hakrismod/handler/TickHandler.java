package com.hakrismod.handler;

import com.hakrismod.helper.LogHelper;
import com.hakrismod.tileentity.PolCanEntity;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;

public class TickHandler {
	@SubscribeEvent	
	public void onTick(TickEvent e) {
PolCanEntity.ticker++;


	}
}
