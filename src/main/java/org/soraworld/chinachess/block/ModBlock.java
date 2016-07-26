/*******************************************************************************
 * Created by Himmelt on 2016/7/25.
 * Copyright (c) 2015-2016. Himmelt All rights reserved.
 * https://opensource.org/licenses/MIT
 ******************************************************************************/

package org.soraworld.chinachess.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.soraworld.chinachess.creativetab.ModCreativeTab;
import org.soraworld.chinachess.reference.Reference;

import java.util.List;

public class ModBlock extends Block {
    
    public ModBlock(){
        super(Material.rock);
        this.setCreativeTab(ModCreativeTab.ModTab).setResistance(4.0F).setStepSound(soundTypeStone).setHardness(4.0F);
    }
    
    public ModBlock(String name){
        this();
        this.setBlockName(name).setBlockTextureName(name);
    }

    @Override
    public int damageDropped(int damage)
    {
        return damage;
    }

    @SideOnly(Side.CLIENT)
    @Override
    @SuppressWarnings("unchecked")
    public void getSubBlocks(Item item, CreativeTabs creativeTab, List list)
    {
        list.add(new ItemStack(item, 1, 0));
    }

    @Override
    protected String getTextureName(){
        return Reference.MODID + ":" + super.getTextureName();
    }

//    @Override
//    public String getUnlocalizedName()
//    {
//        return "tile."+ Reference.MODID + ":" + super.getUnlocalizedName().substring(super.getUnlocalizedName().indexOf(".") + 1);
//    }

}
