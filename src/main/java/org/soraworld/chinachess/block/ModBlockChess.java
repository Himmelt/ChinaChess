/*******************************************************************************
 * Created by Himmelt on 2016/7/25.
 * Copyright (c) 2015-2016. Himmelt All rights reserved.
 * https://opensource.org/licenses/MIT
 ******************************************************************************/

package org.soraworld.chinachess.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ModBlockChess extends ModBlock {

    protected ModBlockChess(String textureName){
        this.setLightLevel(1.0F)
                .setLightOpacity(0)
                .setResistance(5.0F)
                .setStepSound(soundTypeStone)
                .setHardness(5.0F)
                .setBlockTextureName(textureName);
    }

    /**
     * Returns which pass should this block be rendered on. 0 for solids and 1 for alpha
     */
    @SideOnly(Side.CLIENT)
    @Override
    public int getRenderBlockPass()
    {
        return 1;
    }

}
