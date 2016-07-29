/*******************************************************************************
 * Created by Himmelt on 2016/7/25.
 * Copyright (c) 2015-2016. Himmelt All rights reserved.
 * https://opensource.org/licenses/MIT
 ******************************************************************************/

package org.soraworld.chinachess.registry;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import org.soraworld.chinachess.block.ModBlockBoard;
import org.soraworld.chinachess.block.ModBlockChess;
import org.soraworld.chinachess.client.render.ModRenderChess;
import org.soraworld.chinachess.item.ModItemBlockChess;
import org.soraworld.chinachess.reference.Reference;

@GameRegistry.ObjectHolder(Reference.MODID)
public class ModRegistry {

    public static int modRenderId;

    public static void registerBlocks() {
        int i = 0;
        for(i = 0;i < 11;i++ ){
            GameRegistry.registerBlock(new ModBlockBoard(Reference.Blocks.board + "." + i),
                    Reference.Blocks.board + "." + i);
        }
        for(i = 0;i < 7;i++){
            GameRegistry.registerBlock(new ModBlockChess(Reference.Blocks.chess + "." + i),
                    ModItemBlockChess.class,Reference.Blocks.chess + "." + i);
        }
    }

    public static void registerRenders() {
        modRenderId = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(modRenderId, new ModRenderChess());
    }

}
