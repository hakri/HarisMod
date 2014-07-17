package com.hakrismod.render;

import org.lwjgl.opengl.GL11;

import com.hakrismod.hakrismodmain;
import com.hakrismod.model.LavaCanM;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;


public class RenderTrollCan extends TileEntitySpecialRenderer{
	public final LavaCanM model;
	ResourceLocation textures = (new ResourceLocation(hakrismodmain.modid + ":" + "textures/model/trollcan.png")); 
public RenderTrollCan() {
	this.model = new LavaCanM();
	
}
	@Override
	public void renderTileEntityAt(TileEntity te, double x,
			double y, double z, float size) {
		GL11.glPushMatrix();
		 GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
		 this.bindTexture(textures);
		GL11.glPushMatrix();
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		this.model.RenderLol(0.0625F);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
		 
		
	}

}
