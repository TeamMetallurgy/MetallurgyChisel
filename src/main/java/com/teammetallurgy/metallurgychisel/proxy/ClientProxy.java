package com.teammetallurgy.metallurgychisel.proxy;

import com.teammetallurgy.metallurgychisel.client.render.AllSideBlockRenderer;
import com.teammetallurgy.metallurgychisel.utils.RenderType;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
    @Override
    public void init()
    {
        super.init();

        RenderType.allSideBlockRenderId = RenderingRegistry.getNextAvailableRenderId();

        RenderingRegistry.registerBlockHandler(new AllSideBlockRenderer());
    }
}
