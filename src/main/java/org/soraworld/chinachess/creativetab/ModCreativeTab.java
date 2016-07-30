/*******************************************************************************
 * Created by Himmelt on 2016/7/25.
 * Copyright (c) 2015-2016. Himmelt All rights reserved.
 * https://opensource.org/licenses/MIT
 ******************************************************************************/

package org.soraworld.chinachess.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import org.soraworld.chinachess.reference.Reference;
import org.soraworld.chinachess.registry.ModRegistry;

public class ModCreativeTab {

    public static final CreativeTabs ModTab = new CreativeTabs(Reference.MODID) {
        @Override
        public Item getTabIconItem() {
            return Item.getItemFromBlock(ModRegistry.creativeTab);
        }
    };
}
