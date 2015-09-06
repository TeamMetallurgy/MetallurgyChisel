package com.teammetallurgy.metallurgychisel;

import java.util.Locale;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

import com.cricketcraft.chisel.api.carving.CarvingUtils;
import com.teammetallurgy.metallurgy.api.IMetalSet;
import com.teammetallurgy.metallurgy.api.MetallurgyApi;
import com.teammetallurgy.metallurgychisel.block.BlockNormalVariation;
import com.teammetallurgy.metallurgychisel.block.BlockTransparentVariation;
import com.teammetallurgy.metallurgychisel.item.ItemBlockNormalVariation;

import cpw.mods.fml.common.registry.GameRegistry;

public class MetallurgyChiselBlocks
{

    private static final String[] variationNormalList = { "Bar Storage", "Blank Plate", "Circle Plate", "Horizontal Pipes", "Horizontal Plate", "Large Bricks", "Ornate", "Plate", "Quarter Plate",
            "Rune", "Small Bricks", "Spiral", "Vertical Pipes", "Vertical Plate", "Warning" };
    private static final String[] variationTransparentList = { "Frame", "Frame Crossed", "Grate", "Mesh", "Window" };

    public static void init()
    {
        createBlocks(variationNormalList, false);
        createBlocks(variationTransparentList, true);
    }

    private static void createBlocks(String[] variationList, boolean transparent)
    {

        String[] setNames = MetallurgyApi.getSetNames();
        for (String setName : setNames)
        {
            if (setName.equalsIgnoreCase("utility") || setName.equalsIgnoreCase("vanilla")) continue;

            IMetalSet metalSet = MetallurgyApi.getMetalSet(setName);
            String[] metalNames = metalSet.getMetalNames();

            Block defaultBlock = metalSet.getDefaultBlock();

            boolean firstRun = true;

            for (String variation : variationList)
            {
                BlockNormalVariation variationBlock;

                if (transparent) variationBlock = new BlockTransparentVariation(variation, setName);
                else variationBlock = new BlockNormalVariation(variation, setName);

                String blockName = setName.toLowerCase(Locale.US).replace(" ", "_") + "_";
                blockName += variation.toLowerCase(Locale.US).replace(" ", "_");

                GameRegistry.registerBlock(variationBlock, ItemBlockNormalVariation.class, blockName);

                for (String metalName : metalNames)
                {

                    ItemStack storageBlock = metalSet.getBlock(metalName);
                    if (storageBlock == null)
                    {
                        continue;
                    }

                    variationBlock.addMetal(storageBlock.getItemDamage(), metalName);

                    String groupName = metalName.toLowerCase(Locale.US).trim().replace(" ", "_") + "_block";

                    if (firstRun) CarvingUtils.chisel.addVariation(groupName, defaultBlock, storageBlock.getItemDamage(), 100);

                    CarvingUtils.chisel.addVariation(groupName, variationBlock, storageBlock.getItemDamage(), 101 + storageBlock.getItemDamage());

                }

                firstRun = false;
            }

        }

    }
}
