package com.teammetallurgy.metallurgychisel;

import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;

public class MetallurgyChiselItems
{
    public static Item TAB_ITEM;

    public static void init()
    {
        TAB_ITEM = new Item().setTextureName("metallurgychisel:tartarite_chisel").setUnlocalizedName("metallurgychisel.tab.item");

        GameRegistry.registerItem(TAB_ITEM, "tabitem");

    }
}
