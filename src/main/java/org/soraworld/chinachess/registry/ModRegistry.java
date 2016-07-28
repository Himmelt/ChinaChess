/*******************************************************************************
 * Created by Himmelt on 2016/7/25.
 * Copyright (c) 2015-2016. Himmelt All rights reserved.
 * https://opensource.org/licenses/MIT
 ******************************************************************************/

package org.soraworld.chinachess.registry;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import org.soraworld.chinachess.block.ModBlockBoard;
import org.soraworld.chinachess.client.render.ModRender;
import org.soraworld.chinachess.item.ModItemBlock;
import org.soraworld.chinachess.reference.Reference;

@GameRegistry.ObjectHolder(Reference.MODID)
public class ModRegistry {

    public static int modRenderId;

    public static void registerBlocks() {
        GameRegistry.registerBlock(new ModBlockBoard(Reference.Blocks.board), Reference.Blocks.board);
    }

    public static void registerRenders() {
        modRenderId = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(modRenderId, new ModRender());
    }
}
