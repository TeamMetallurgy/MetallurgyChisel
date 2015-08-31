package com.teammetallurgy.metallurgychisel.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import com.teammetallurgy.metallurgychisel.block.BlockNormalVariation;

public class ItemBlockNormalVariation extends ItemBlock
{

    public ItemBlockNormalVariation(Block block)
    {
        super(block);
        setMaxDamage(0);
        setHasSubtypes(true);
    }

    @Override
    public int getMetadata(int meta)
    {
        return meta;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        return ((BlockNormalVariation) field_150939_a).getUnlocalizedName(stack);
    }

}
