package com.hakrismod.render;

import org.lwjgl.opengl.GL11;

import com.hakrismod.LavaCanM;
import com.hakrismod.hakrismodmain;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderTrollCan extends TileEntitySpecialRenderer {
public final LavaCanM model = new LavaCanM();
public static final ResourceLocation blocks = new ResourceLocation(hakrismodmain.modid +":"+ "textures/model/trollcan.png");
	@Override
	public void renderTileEntityAt(TileEntity p_147500_1_, double x,
	double y, double z, float p_147500_8_) {
GL11.glPushMatrix();
GL11.glTranslatef((float)x+0.5F, (float)y + 1.5F, (float)z + 0.5F);
this.bindTexture(blocks);
GL11.glPushMatrix();
GL11.glRotatef(180, 0F, 0F, 1.0F);
this.model.RenderLol(0.0625F);
GL11.glPopMatrix();
GL11.glPopMatrix();
	
		
		
		
		
	}

}
