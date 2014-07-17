package com.hakrismod.client;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

import com.hakrismod.CommonProxy;
import com.hakrismod.hakrismodmain;
import com.hakrismod.render.ItemRenderTrollCan;
import com.hakrismod.render.RenderTrollCan;
import com.hakrismod.tileentity.TrollCanEntity;

import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy 
{
@Override
public void RenderStuff() {
	TileEntitySpecialRenderer render = new RenderTrollCan();

    ClientRegistry.bindTileEntitySpecialRenderer(TrollCanEntity.class,render);


}
@Override
public void rendershit() {
	TileEntitySpecialRenderer render = new RenderTrollCan();

	MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(hakrismodmain.trollcan), new ItemRenderTrollCan(render, new TrollCanEntity()));
}
}