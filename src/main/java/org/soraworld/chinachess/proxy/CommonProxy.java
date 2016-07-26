/*******************************************************************************
 * Created by Himmelt on 2016/7/25.
 * Copyright (c) 2015-2016. Himmelt All rights reserved.
 * https://opensource.org/licenses/MIT
 ******************************************************************************/

package org.soraworld.chinachess.proxy;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import org.soraworld.chinachess.registry.ModRegistry;

public abstract class CommonProxy implements IProxy {

    public void preInit(FMLPreInitializationEvent event) {
        ModRegistry.registerBlocks();
        ModRegistry.registerRenders();
    }

    public void Init(FMLInitializationEvent event) {

    }

    public void postInit(FMLPostInitializationEvent event) {

    }

}
