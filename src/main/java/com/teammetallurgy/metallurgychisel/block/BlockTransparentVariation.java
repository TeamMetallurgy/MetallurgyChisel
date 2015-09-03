package com.teammetallurgy.metallurgychisel.block;

import net.minecraft.world.IBlockAccess;

import com.teammetallurgy.metallurgychisel.utils.RenderType;

public class BlockTransparentVariation extends BlockNormalVariation
{

    public BlockTransparentVariation(String variationName, String metalSet)
    {
        super(variationName, metalSet);
    }

    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
    public boolean isNormalCube()
    {
        return false;
    }

    @Override
    public int getRenderType()
    {
        return RenderType.allSideBlockRenderId;
    }

    @Override
    public boolean shouldSideBeRendered(IBlockAccess world, int x, int y, int z, int side)
    {
        return true;
    }

}
