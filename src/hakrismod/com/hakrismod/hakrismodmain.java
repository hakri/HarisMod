package com.hakrismod;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

import com.hakrismod.tileentity.TrollCanEntity;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
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
	

	public static Block trollcan = new trollcan();
	
	@EventHandler
	public void preinit(FMLPreInitializationEvent z) {
		GameRegistry.registerBlock(trollcan, "trollcan");
		GameRegistry.registerTileEntity(TrollCanEntity.class, "trollcan");
		proxy.RenderStuff();
	}
public void init(FMLInitializationEvent e) {
	
	
}
}
