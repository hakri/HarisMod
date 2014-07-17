package com.hakrismod.render;

import org.lwjgl.opengl.GL11;

import com.hakrismod.model.LavaCanM;
import com.hakrismod.tileentity.TrollCanEntity;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.IItemRenderer;

public class ItemRenderTrollCan implements IItemRenderer {

	TileEntitySpecialRenderer render;
	private TileEntity entity;


public ItemRenderTrollCan(TileEntitySpecialRenderer render, TileEntity entity) {
	this.entity=entity;
	this.render = render;
	
}
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item,
			ItemRendererHelper helper) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		if(type==IItemRenderer.ItemRenderType.ENTITY) {
			GL11.glTranslatef(-0.5F, 0.0F, -0.5F);
			this.render.renderTileEntityAt(new TrollCanEntity(), 0.0D, 0.0D, 0.0D, 0.0F);
		}
		
	}

}
