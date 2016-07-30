/*******************************************************************************
 * Created by Himmelt on 2016/7/25.
 * Copyright (c) 2015-2016. Himmelt All rights reserved.
 * https://opensource.org/licenses/MIT
 ******************************************************************************/

package org.soraworld.chinachess.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import org.soraworld.chinachess.creativetab.ModCreativeTab;
import org.soraworld.chinachess.reference.Reference;

public class ModBlock extends Block {

    protected ModBlock(){
        super(Material.rock);
        this.setCreativeTab(ModCreativeTab.ModTab).setResistance(4.0F).setStepSound(soundTypeStone).setHardness(4.0F);
    }
    
    public ModBlock(String name){
        this();
        this.setBlockName(name).setBlockTextureName(name);
    }

    @Override
    protected String getTextureName(){
        return Reference.MODID + ":" + super.getTextureName();
    }

    @Override
    public int damageDropped(int damage)
    {
        return damage;
    }

}
