/*******************************************************************************
 * Created by Himmelt on 2016/7/25.
 * Copyright (c) 2015-2016. Himmelt All rights reserved.
 * https://opensource.org/licenses/MIT
 ******************************************************************************/

package org.soraworld.chinachess.registry;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import org.soraworld.chinachess.block.ModBlockBoard;
import org.soraworld.chinachess.block.ModBlockChess;
import org.soraworld.chinachess.client.render.ModRenderBoard;
import org.soraworld.chinachess.client.render.ModRenderChess;
import org.soraworld.chinachess.item.ModItemBlockChess;
import org.soraworld.chinachess.reference.Reference;

@GameRegistry.ObjectHolder(Reference.MODID)
public class ModRegistry {

    // 渲染器 ID
    public static int renderBoardId;
    public static int renderChessId;

    // 创造物品栏方块图标
    public static ModBlockChess creativeTab = new ModBlockChess(Reference.Blocks.chess + ".0");

    // 注册方块
    public static void registerBlocks() {
        int i;
        // 注册棋盘
        for(i = 0;i < 11;i++ ){
            GameRegistry.registerBlock(new ModBlockBoard(Reference.Blocks.board + "." + i),Reference.Blocks.board + "." + i);
        }
        // 注册第一棋子
        GameRegistry.registerBlock(creativeTab,ModItemBlockChess.class,Reference.Blocks.chess + ".0");
        // 注册棋子
        for(i = 1;i < 7;i++){
            GameRegistry.registerBlock(new ModBlockChess(Reference.Blocks.chess + "." + i),ModItemBlockChess.class,Reference.Blocks.chess + "." + i);
        }
    }

    // 注册合成表
    public static void registerRecipes() {

    }

    //注册渲染器
    @SideOnly(Side.CLIENT)
    public static void registerRenders() {
        renderBoardId = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(renderBoardId, new ModRenderBoard());
        renderChessId = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(renderChessId, new ModRenderChess());
    }

}
