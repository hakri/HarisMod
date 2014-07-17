package com.hakrismod;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

import com.hakrismod.block.PolCan;
import com.hakrismod.block.trollcan;
import com.hakrismod.handler.TickHandler;
import com.hakrismod.tileentity.CombinedSource;
import com.hakrismod.tileentity.PolCanEntity;
import com.hakrismod.tileentity.TrollCanEntity;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;



@Mod(modid = hakrismodmain.modid , version = hakrismodmain.version)
public class hakrismodmain {
	
public static final String modid = "hakrismod";
	public  static final String version = "1.0";
	@SidedProxy(clientSide= "com.hakrismod.client.ClientProxy", serverSide="com.hakrismod.CommonProxy")
	public static  CommonProxy proxy;
	public static CreativeTabs BlockTab = new CreativeTabs("TrollTab") {

		@Override
		public Item getTabIconItem() {
			// TODO Auto-generated method stub
			return Items.blaze_rod;
		}
		
	};
	
//blocks
	public static Block trollcan = new trollcan();
	public static Block PolCan = new PolCan();
	public static int polevel;


	
	@EventHandler
public void preinit(FMLPreInitializationEvent z) {
GameRegistry.registerBlock(trollcan, "trollcan");
GameRegistry.registerTileEntity(TrollCanEntity.class, "trollcan");
GameRegistry.registerBlock(PolCan, "polcan");
GameRegistry.registerTileEntity(PolCanEntity.class, "PolCan");
GameRegistry.registerTileEntity(CombinedSource.class,"cominedsource");
proxy.RenderStuff();
proxy.rendershit();
 FMLCommonHandler.instance().bus().register(new TickHandler());
			
	
	}
public void init(FMLInitializationEvent e) {
	
	proxy.rendershit();
}
}
