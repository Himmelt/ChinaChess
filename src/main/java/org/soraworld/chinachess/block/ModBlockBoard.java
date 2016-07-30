/*******************************************************************************
 * Created by Himmelt on 2016/7/25.
 * Copyright (c) 2015-2016. Himmelt All rights reserved.
 * https://opensource.org/licenses/MIT
 ******************************************************************************/

package org.soraworld.chinachess.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import org.soraworld.chinachess.registry.ModRegistry;

public class ModBlockBoard extends ModBlock {

    private IIcon topIcon;

    protected ModBlockBoard(){
        this.setLightLevel(1.0F).setLightOpacity(0);
    }

    public ModBlockBoard(String Name){
        this();
        this.setBlockName(Name).setBlockTextureName(Name);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public int getRenderType() {
        return ModRegistry.renderBoardId;
    }

    /* opaque 是否为非透明方块 --- 是 */
    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    // Returns which pass should this block be rendered on. 0 for solids and 1 for alpha
    @SideOnly(Side.CLIENT)
    @Override
    public int getRenderBlockPass() {
        return 1;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister register)
    {
        blockIcon = register.registerIcon(this.getTextureName().replaceAll("[0-9]{1,2}","0"));
        topIcon = register.registerIcon(this.getTextureName());
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int side,int meta){
        return side == 1 ? topIcon : blockIcon;
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemStack) {
        int direction = MathHelper.floor_double((double) (entity.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
        world.setBlockMetadataWithNotify(x, y, z, direction, 2);
    }

    /* render side block */
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess blockAccess, int x, int y, int z, int side) {
        return !(blockAccess.getBlock(x, y, z) instanceof ModBlockBoard);
    }

}
