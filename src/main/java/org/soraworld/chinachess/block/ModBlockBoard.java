/*******************************************************************************
 * Created by Himmelt on 2016/7/25.
 * Copyright (c) 2015-2016. Himmelt All rights reserved.
 * https://opensource.org/licenses/MIT
 ******************************************************************************/

package org.soraworld.chinachess.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

public class ModBlockBoard extends ModBlock {

    private static final int subBlocks = 11;

    @SideOnly(Side.CLIENT)
    private IIcon[] icons = new IIcon[subBlocks];

    protected ModBlockBoard(){
        this.setLightLevel(1.0F).setLightOpacity(0);
    }

    public ModBlockBoard(String Name){
        this();
        this.setBlockName(Name).setBlockTextureName(Name);
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        for (int i = 0; i < subBlocks; ++i){
            icons[i] = iconRegister.registerIcon(this.getTextureName() + "." + i);
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    @SuppressWarnings("unchecked")
    public void getSubBlocks(Item item, CreativeTabs creativeTab, List list)
    {
        for (int i = 0; i < subBlocks; ++i)
        {
            list.add(new ItemStack(item, 1, i));
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int side, int meta)
    {
        return side == 1 ? icons[meta] : icons[0];
    }
}
