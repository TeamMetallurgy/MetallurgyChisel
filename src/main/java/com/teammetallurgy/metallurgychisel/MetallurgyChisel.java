package com.teammetallurgy.metallurgychisel;

import net.minecraft.creativetab.CreativeTabs;

import com.teammetallurgy.metallurgychisel.proxy.IProxy;
import com.teammetallurgy.metallurgychisel.utils.Log;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = MetallurgyChisel.MODID, version = MetallurgyChisel.VERSION, dependencies = MetallurgyChisel.DEPS)
public class MetallurgyChisel
{
    public static final String MODID = "metallurgychisel";
    public static final String VERSION = "%version%";
    public static final String DEPS = "required-after:Metallurgy;required-after:chisel";

    @Instance(MODID)
    public static MetallurgyChisel instance;

    @SidedProxy(modId = MetallurgyChisel.MODID, clientSide = "com.teammetallurgy.metallurgychisel.proxy.ClientProxy", serverSide = "com.teammetallurgy.metallurgychisel.proxy.CommonProxy")
    public static IProxy proxy;

    public static CreativeTabs CREATIVE_TAB;

    @EventHandler
    public void preinit(FMLPreInitializationEvent event)
    {
        Log.setLogger(event.getModLog());
        CREATIVE_TAB = new MetallurgyChiselTab();
        MetallurgyChiselItems.init();
        MetallurgyChiselBlocks.init();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init();
    }

    @EventHandler
    public void postinit(FMLPostInitializationEvent event)
    {

    }
}
