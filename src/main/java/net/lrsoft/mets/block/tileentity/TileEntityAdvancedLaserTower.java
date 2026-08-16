package net.lrsoft.mets.block.tileentity;

import java.util.List;

import net.lrsoft.mets.block.tileentity.OilRig.TileEntityGUIMachine;
import net.lrsoft.mets.manager.ConfigManager;
import net.lrsoft.mets.manager.SoundManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;

public class TileEntityAdvancedLaserTower extends TileEntityGUIMachine {
    private static double attackConsume = ConfigManager.AdvancedLaserTowerCost;
    private Vec3d shootOffset = new Vec3d(0.5d, 1.0d, 0.5d);
    private static int maxEnergy = 500000, tier = 3;
    private static int maxLockTarget = 5;
    
    private int scanRange = 30;
    
    private int updateInterval = 25, currentInterval = 0;
    
    public TileEntityAdvancedLaserTower() {
        super(maxEnergy, tier);
    }
    
    @Override
    protected void updateEntityServer() {
        super.updateEntityServer();
        updateTileEntity();
    }

    private void updateTileEntity() {
        boolean shouldActive = false;
        if (this.energy.canUseEnergy(attackConsume)) {
            shouldActive = true;
            
            currentInterval++;
            if (currentInterval >= updateInterval) {
                Vec3d currentPos = new Vec3d(this.pos.getX(), pos.getY(), pos.getZ());
                currentPos = currentPos.add(shootOffset);

                AxisAlignedBB bb = new AxisAlignedBB(
                        currentPos.x - scanRange, currentPos.y - scanRange, currentPos.z - scanRange, 
                        currentPos.x + scanRange, currentPos.y + scanRange, currentPos.z + scanRange);

                List<Entity> list = this.world.getEntitiesInAABBexcluding(null, bb, TileEntiyLaserTower.ALIVE_MOB_SELECTOR);
                if (!list.isEmpty() && this.energy.useEnergy(attackConsume)) {
                    int currentSize = list.size();
                    int maxSize = currentSize >= maxLockTarget ? maxLockTarget : currentSize;
                    
                    // TODO: 激光塔功能需要重新实现 - EntityGunBullet 已被移除
                    // 原代码使用 EntityGunBullet 发射子弹攻击多个目标
                    // 建议: 使用自定义激光实体或 EntityPlasmaBullet
                    
                    for (int index = 0; index < maxSize; index++) {
                        Entity mob = list.get(index);
                        // 激光攻击逻辑需要重新实现
                    }
                    
                    world.playSound((EntityPlayer)null, currentPos.x, currentPos.y, currentPos.z, 
                            SoundManager.lighter_place, SoundCategory.AMBIENT, 0.6f, 0.8F);
                }
                
                currentInterval = 0;
            }
        } else {
            currentInterval = 0;
        }
        setActive(shouldActive);
    }
    
    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound tag) {
        super.writeToNBT(tag);
        tag.setInteger("shootInterval", currentInterval);
        return tag;
    }
    
    @Override
    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);
        currentInterval = tag.getInteger("shootInterval");
    }
}
