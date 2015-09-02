package com.teammetallurgy.metallurgychisel.block;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

import com.teammetallurgy.metallurgychisel.MetallurgyChisel;
import com.teammetallurgy.metallurgychisel.utils.RenderType;

public class BlockNormalVariation extends Block
{

    HashMap<Integer, IIcon> icons = new HashMap<Integer, IIcon>();
    HashMap<Integer, String> metalNames = new HashMap<Integer, String>();
    String variationName;
    String setName;
    String defaultTexture = MetallurgyChisel.MODID + ":" + "default";

    public BlockNormalVariation(String variationName, String metalSet)
    {
        super(Material.iron);
        setHardness(1.0F);
        setResistance(1.0F);
        this.variationName = variationName;
        setName = metalSet;
        this.setCreativeTab(MetallurgyChisel.CREATIVE_TAB);
    }

    @Override
    public int damageDropped(int meta)
    {
        return meta;
    }

    public void addMetal(int meta, String name)
    {
        metalNames.put(meta, name);
    }

    @Override
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void getSubBlocks(Item item, CreativeTabs tab, List list)
    {
        for (Entry<Integer, String> entry : metalNames.entrySet())
        {
            list.add(new ItemStack(this, 1, entry.getKey()));
        }
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

    @Override
    public void registerBlockIcons(IIconRegister register)
    {
        for (Entry<Integer, String> entry : metalNames.entrySet())
        {
            String variationTexureName = setName.toLowerCase(Locale.US).replace(" ", "_") + "/";
            variationTexureName += entry.getValue().toLowerCase(Locale.US).replace(" ", "_");
            variationTexureName += "_" + variationName.toLowerCase(Locale.US).replace(" ", "_");

            IIcon registeredIcon = register.registerIcon(MetallurgyChisel.MODID + ":" + variationTexureName);

            icons.put(entry.getKey(), registeredIcon);
        }

        blockIcon = register.registerIcon(defaultTexture);
    }

    @Override
    public IIcon getIcon(int side, int meta)
    {
        IIcon metaIcon = icons.get(meta);
        if (metaIcon == null) return blockIcon;

        return metaIcon;
    }

    @Override
    public String getUnlocalizedName()
    {
        String unlocalized = "tile.unknown." + setName.toLowerCase(Locale.US).replace(" ", ".");
        unlocalized += "." + variationName.toLowerCase(Locale.US).replace(" ", ".");
        return unlocalized;
    }

    public String getUnlocalizedName(ItemStack stack)
    {
        if (stack == null || stack.getItem() == null) return getUnlocalizedName();

        int meta = stack.getItemDamage();
        String name = metalNames.get(meta);

        if (name == null) return getUnlocalizedName() + "." + meta;

        String unlocalized = "tile." + MetallurgyChisel.MODID.toLowerCase(Locale.US);
        unlocalized += "." + name.toLowerCase(Locale.US).replace(" ", ".");
        unlocalized += "." + variationName.toLowerCase(Locale.US).replace(" ", ".");

        return unlocalized;
    }

    public String getMetalName(ItemStack stack)
    {
        if (stack == null || stack.getItem() == null) return null;

        int meta = stack.getItemDamage();
        String name = metalNames.get(meta);

        return name;
    }

    public String getVariationName()
    {
        return variationName;
    }
}
