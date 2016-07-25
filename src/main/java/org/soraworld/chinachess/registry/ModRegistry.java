/*******************************************************************************
 * Created by Himmelt on 2016/7/25.
 * Copyright (c) 2015-2016. Himmelt All rights reserved.
 * https://opensource.org/licenses/MIT
 ******************************************************************************/

package org.soraworld.chinachess.registry;

import cpw.mods.fml.common.registry.GameRegistry;
import org.soraworld.chinachess.blocks.ModBlock;
import org.soraworld.chinachess.blocks.ModBlockBoard;
import org.soraworld.chinachess.reference.Reference;

@GameRegistry.ObjectHolder(Reference.MODID)
public class ModRegistry {

    public static void registerBlocks() {
        GameRegistry.registerBlock(new ModBlockBoard(Reference.Blocks.board), Reference.Blocks.board);
    }
}
