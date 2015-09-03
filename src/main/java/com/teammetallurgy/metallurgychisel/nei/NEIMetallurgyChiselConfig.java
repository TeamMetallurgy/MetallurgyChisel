package com.teammetallurgy.metallurgychisel.nei;

import net.minecraft.item.ItemStack;
import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;

import com.teammetallurgy.metallurgychisel.MetallurgyChiselItems;

public class NEIMetallurgyChiselConfig implements IConfigureNEI
{

    @Override
    public void loadConfig()
    {
        API.hideItem(new ItemStack(MetallurgyChiselItems.TAB_ITEM));
    }

    @Override
    public String getName()
    {
        return "Metallurgy Chisel NEI";
    }

    @Override
    public String getVersion()
    {
        return "0.1.0";
    }

}
