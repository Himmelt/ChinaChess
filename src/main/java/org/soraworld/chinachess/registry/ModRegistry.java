/*******************************************************************************
 * Created by Himmelt on 2016/7/25.
 * Copyright (c) 2015-2016. Himmelt All rights reserved.
 * https://opensource.org/licenses/MIT
 ******************************************************************************/

package org.soraworld.chinachess.registry;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.BlockColored;
import net.minecraft.block.material.Material;
import org.soraworld.chinachess.block.ModBlockBoard;
import org.soraworld.chinachess.item.ModItemBlock;
import org.soraworld.chinachess.reference.Reference;

@GameRegistry.ObjectHolder(Reference.MODID)
public class ModRegistry {

    public static void registerBlocks() {
        GameRegistry.registerBlock(new ModBlockBoard(Reference.Blocks.board), ModItemBlock.class, Reference.Blocks.board);
    }
}
