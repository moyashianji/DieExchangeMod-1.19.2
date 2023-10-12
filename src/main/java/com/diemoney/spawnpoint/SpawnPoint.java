package com.diemoney.spawnpoint;

import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.io.FileWriter;
import java.io.IOException;

import static com.diemoney.config.MoneyLoad.Money;
import static com.diemoney.config.MoneySave.onSave;

public class SpawnPoint {
    private static BlockPos deathLocation; // プレイヤーの死亡位置を保存する変数


    @SubscribeEvent
    public static void onLivingDamage(LivingDamageEvent event) {
        LivingEntity entity = event.getEntity();
        Level level = entity.getCommandSenderWorld();

        // ダメージを受けたのがプレイヤーで、ハートが0.5未満の場合
        if (entity instanceof Player) {
            Player player = (Player) entity;
            float health = player.getHealth();

            if (health - event.getAmount() <= 0.5f) {
                // ハートが0.5未満になるダメージを受けた場合
                player.setHealth(0.5f);
                event.setAmount(0.0f); // ダメージを0に設定

                spawnHeartParticles((ServerLevel) level, player);

                Money++;
                onSave();
            }
        }
    }
    private static void spawnHeartParticles(ServerLevel world, Player player) {
        // ハートパーティクルを生成して再生
        for (int i = 0; i < 30; i++) { // 必要な数だけ繰り返す
            double xOffset = player.getX() + (world.getRandom().nextDouble() - 0.5) * 2.0;
            double yOffset = player.getY() + (world.getRandom().nextDouble() - 0.5) * 5.0;
            double zOffset = player.getZ() + (world.getRandom().nextDouble() - 0.5) * 2.0;
            world.sendParticles(ParticleTypes.COMPOSTER, xOffset, yOffset, zOffset, 20, 0.0, 0.0, 0.0, 1.0);
        }
    }

    private static void setRespawnPoint(ServerPlayer player, ResourceKey<net.minecraft.world.level.Level> dimensionKey,
                                 BlockPos pos, float yaw, float pitch) {
        // スポーン地点を設定
        player.setRespawnPosition(dimensionKey, pos, yaw, true, true);
    }
    public static void register() {
        MinecraftForge.EVENT_BUS.register(SpawnPoint.class);
    }
}
