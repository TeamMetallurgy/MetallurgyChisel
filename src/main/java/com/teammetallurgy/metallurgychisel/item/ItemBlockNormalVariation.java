package com.teammetallurgy.metallurgychisel.item;

import java.util.Locale;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

import com.teammetallurgy.metallurgychisel.MetallurgyChisel;
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

    @Override
    public String getItemStackDisplayName(ItemStack stack)
    {

        if (stack == null || stack.getItem() == null) return super.getItemStackDisplayName(stack);

        String fullUnlocalizedName = getUnlocalizedName(stack);

        if (StatCollector.canTranslate(fullUnlocalizedName)) return (StatCollector.translateToLocal(fullUnlocalizedName) + ".name").trim();

        BlockNormalVariation variantBlock = (BlockNormalVariation) Block.getBlockFromItem(stack.getItem());

        String unlocalizedVariant = "variation." + MetallurgyChisel.MODID.toLowerCase(Locale.US);
        unlocalizedVariant += "." + variantBlock.getVariationName().toLowerCase(Locale.US).replace(" ", ".");

        String unlocalizedMetalName = "metal." + MetallurgyChisel.MODID.toLowerCase(Locale.US);
        unlocalizedMetalName += "." + variantBlock.getMetalName(stack).toLowerCase(Locale.US).replace(" ", ".");

        if (!StatCollector.canTranslate(unlocalizedVariant) || !StatCollector.canTranslate(unlocalizedMetalName)) return super.getItemStackDisplayName(stack);

        String metalName = StatCollector.translateToLocal(unlocalizedMetalName).trim();

        return StatCollector.translateToLocalFormatted(unlocalizedVariant, metalName).trim();

    }
}
