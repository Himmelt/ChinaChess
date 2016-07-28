/*******************************************************************************
 * Created by Himmelt on 2016/7/25.
 * Copyright (c) 2015-2016. Himmelt All rights reserved.
 * https://opensource.org/licenses/MIT
 ******************************************************************************/

package org.soraworld.chinachess.client.render;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;
import org.soraworld.chinachess.registry.ModRegistry;

@SideOnly(Side.CLIENT)
public class ModRender implements ISimpleBlockRenderingHandler {

    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
        renderer.setRenderBoundsFromBlock(block);
        renderer.renderBlockAsItem(block,0,1.0F);
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        renderer.setRenderBoundsFromBlock(block);
        int meta = world.getBlockMetadata(x, y, z);
        if(meta == 1) renderer.uvRotateTop = 1;
        if(meta == 3) renderer.uvRotateTop = 2;
        if(meta == 2) renderer.uvRotateTop = 3;
        renderer.renderStandardBlock(block, x, y, z);
        // Must reset the rotation or it will mess up all rotating blocks around
        renderer.uvRotateTop = 0;
        return true;
    }

    @Override
    public boolean shouldRender3DInInventory(int modelId) {
        return true;
    }

    @Override
    public int getRenderId() {
        return ModRegistry.modRenderId;
    }

}
