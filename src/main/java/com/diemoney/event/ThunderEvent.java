package com.diemoney.event;

import com.diemoney.item.init.TextModItems;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.apache.logging.log4j.core.jmx.Server;

import java.util.Objects;

public class ThunderEvent {
    @SubscribeEvent
    public static void onPlayerInteract(PlayerInteractEvent.RightClickItem event) {
        Player player = event.getEntity();

        if (player != null && player.getMainHandItem().getItem() == TextModItems.THUNDER.get()) { // 例: 右クリックでEnderbodyEntityをキル
            System.out.println("aaa");


            Level world = player.level;
            double x = player.getX();
            double y = player.getY();
            double z = player.getZ();

            // 雷を生成して落とす
            LightningBolt lightning = EntityType.LIGHTNING_BOLT.create(world);
            lightning.moveTo(x,y,z);
            world.addFreshEntity(lightning);
                }
            }



    public static void register() {
        MinecraftForge.EVENT_BUS.register(ThunderEvent.class);
    }

}
