/*******************************************************************************
 * Created by Himmelt on 2016/7/25.
 * Copyright (c) 2015-2016. Himmelt All rights reserved.
 * https://opensource.org/licenses/MIT
 ******************************************************************************/

package org.soraworld.chinachess.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import org.soraworld.chinachess.reference.Reference;
import org.soraworld.chinachess.registry.ModRegistry;

import java.util.List;

public class ModBlockChess extends ModBlock {

//    @SideOnly(Side.CLIENT)
    protected IIcon[] icons = new IIcon[2];

    protected ModBlockChess(){
        this.setLightOpacity(0).setResistance(0.4F).setHardness(0.4F);
    }

    public ModBlockChess(String Name){
        this();
        this.setBlockName(Name).setBlockTextureName(Name);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public int getRenderType() {
        return ModRegistry.renderChessId;
    }

    /* opaque 是否为非透明方块 --- 是 */
    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    // Returns which pass should this block be rendered on. 0 for solids and 1 for alpha
    @SideOnly(Side.CLIENT)
    @Override
    public int getRenderBlockPass()
    {
        return 1;
    }

    @Override
    public int damageDropped(int damage)
    {
        return (damage & 8) >> 3;// 1 0 0 0
    }

    @SideOnly(Side.CLIENT)
    @Override
    @SuppressWarnings("unchecked")
    public void getSubBlocks(Item item, CreativeTabs creativeTab, List list){
        list.add(new ItemStack(item,1,0));
        list.add(new ItemStack(item,1,1));
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int side,int meta){
        return icons[meta >> 3];
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister register)
    {
        icons[0] = register.registerIcon(this.getTextureName() + "." + Reference.Blocks.factions[0]);
        icons[1] = register.registerIcon(this.getTextureName() + "." + Reference.Blocks.factions[1]);
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemStack) {
        int direction = MathHelper.floor_double((double) (entity.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
        int meta = (itemStack.getItemDamage() << 3) + direction;
        world.setBlockMetadataWithNotify(x, y, z, meta, 2);
    }
}
