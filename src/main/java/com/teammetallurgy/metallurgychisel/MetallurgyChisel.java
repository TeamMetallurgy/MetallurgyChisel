package com.teammetallurgy.metallurgychisel;

import com.teammetallurgy.metallurgychisel.utils.Log;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = MetallurgyChisel.MODID, version = MetallurgyChisel.VERSION, dependencies = MetallurgyChisel.DEPS)
public class MetallurgyChisel
{
    public static final String MODID = "metallurgychisel";
    public static final String VERSION = "0.1";
    public static final String DEPS = "after:Metallurgy;after:chisel";

    @Instance(MODID)
    public static MetallurgyChisel instance;

    @EventHandler
    public void preinit(FMLPreInitializationEvent event)
    {
        Log.setLogger(event.getModLog());
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {

    }

    @EventHandler
    public void postinit(FMLPostInitializationEvent event)
    {

    }
}
