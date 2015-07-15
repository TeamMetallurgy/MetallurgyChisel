package com.teammetallurgy.metallurgychisel;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

import com.cricketcraft.chisel.api.carving.CarvingUtils;
import com.teammetallurgy.metallurgy.api.IMetalSet;
import com.teammetallurgy.metallurgy.api.MetallurgyApi;

public class MetallurgyChiselBlocks
{

    public static void init()
    {
        String[] setNames = MetallurgyApi.getSetNames();
        for (String setName : setNames)
        {
            IMetalSet metalSet = MetallurgyApi.getMetalSet(setName);
            String[] metalNames = metalSet.getMetalNames();

            Block defaultBrick = metalSet.getDefaultBricks();
            for (String metalName : metalNames)
            {

                ItemStack brick = metalSet.getBrick(metalName);

                String groupName = metalName.toLowerCase() + "_brick";

                CarvingUtils.chisel.addVariation(groupName, defaultBrick, brick.getItemDamage(), 100);
                // CarvingUtils.chisel.addVariation(groupName, variation);

            }

        }

    }
}
