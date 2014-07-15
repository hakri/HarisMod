package com.hakrismod.client;

import com.hakrismod.CommonProxy;
import com.hakrismod.render.RenderTrollCan;
import com.hakrismod.tileentity.TrollCanEntity;

import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy 
{
@Override
public void RenderStuff() {

    ClientRegistry.bindTileEntitySpecialRenderer(TrollCanEntity.class, new RenderTrollCan());
}

}
