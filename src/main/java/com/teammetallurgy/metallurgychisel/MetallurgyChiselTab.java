package com.teammetallurgy.metallurgychisel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class MetallurgyChiselTab extends CreativeTabs
{

    public MetallurgyChiselTab()
    {
        super("metallurgychisel.tab");
    }

    @Override
    public Item getTabIconItem()
    {
        return MetallurgyChiselItems.TAB_ITEM;
    }

}
