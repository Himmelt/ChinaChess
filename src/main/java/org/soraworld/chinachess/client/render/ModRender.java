/*******************************************************************************
 * Created by Himmelt on 2016/7/25.
 * Copyright (c) 2015-2016. Himmelt All rights reserved.
 * https://opensource.org/licenses/MIT
 ******************************************************************************/

package org.soraworld.chinachess.client.render;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;
import org.soraworld.chinachess.registry.ModRegistry;

public class ModRender implements ISimpleBlockRenderingHandler {

    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {

    }

    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        renderer.setRenderBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        if (world.getBlockMetadata(x, y, z) >= 4 && world.getBlockMetadata(x, y, z) <= 7)
            renderer.uvRotateTop = 3;
        if (world.getBlockMetadata(x, y, z) >= 8 && world.getBlockMetadata(x, y, z) <= 11)
            renderer.uvRotateTop = 2;
        if (world.getBlockMetadata(x, y, z) >= 0 && world.getBlockMetadata(x, y, z) <= 3)
            renderer.uvRotateTop = 1;
        renderer.renderStandardBlock(block, x, y, z);
        // Must reset the rotation or it will mess up all rotating blocks around
        renderer.uvRotateTop = 0;
        return true;
    }

    @Override
    public boolean shouldRender3DInInventory(int modelId) {
        return false;
    }

    @Override
    public int getRenderId() {
        return ModRegistry.modRenderId;
    }

}
