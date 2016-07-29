/*******************************************************************************
 * Created by Himmelt on 2016/7/29.
 * Copyright (c) 2015-2016. Himmelt All rights reserved.
 * https://opensource.org/licenses/MIT
 ******************************************************************************/

package org.soraworld.chinachess.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import org.soraworld.chinachess.reference.Reference;

public class ModItemBlockChess extends ModItemBlock {
    public ModItemBlockChess(Block block) {
        super(block);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
        return super.getUnlocalizedName() + "." + Reference.Blocks.factions[itemStack.getItemDamage()];
    }

}
