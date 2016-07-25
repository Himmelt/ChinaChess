/*******************************************************************************
 * Created by Himmelt on 2016/7/25.
 * Copyright (c) 2015-2016. Himmelt All rights reserved.
 * https://opensource.org/licenses/MIT
 ******************************************************************************/

package org.soraworld.chinachess.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import org.soraworld.chinachess.creativetab.ModCreativeTab;
import org.soraworld.chinachess.reference.Reference;

import java.util.List;

public class ModBlock extends Block {

    @SideOnly(Side.CLIENT)
    private IIcon[] icons;
    
    public ModBlock(){
        super(Material.rock);
        this.setCreativeTab(ModCreativeTab.ModTab).setResistance(4.0F).setStepSound(soundTypeStone).setHardness(4.0F);
    }
    
    public ModBlock(String name){
        this();
        this.setBlockName(name).setBlockTextureName(name);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int side, int meta)
    {
        return this.icons[0];
    }

    @Override
    public int damageDropped(int damage)
    {
        return damage;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void getSubBlocks(Item item, CreativeTabs creativeTab, List list)
    {
        list.add(new ItemStack(item, 1, 0));
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        this.icons = new IIcon[1];
        this.icons[0] = iconRegister.registerIcon(this.getTextureName());
    }

    @Override
    public String getTextureName(){
        return Reference.MODID + ":" + super.getTextureName();
    }

    @Override
    public String getUnlocalizedName()
    {
        return "tile."+ Reference.MODID + ":" + super.getUnlocalizedName().substring(super.getUnlocalizedName().indexOf(".") + 1);
    }
}
