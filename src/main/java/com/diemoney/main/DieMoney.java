package com.diemoney.main;

import com.diemoney.event.ThunderEvent;
import com.diemoney.hud.TextHUD;
import com.diemoney.item.init.TextModItems;
import com.diemoney.spawnpoint.SpawnPoint;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import static com.diemoney.config.Config.generateConfigFile;
import static com.diemoney.config.MoneyLoad.extractDoubleFromTextFile;

@Mod(Reference.MOD_ID)
public class DieMoney {
    public DieMoney() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        SpawnPoint.register();
        TextHUD.register();
        generateConfigFile();
        extractDoubleFromTextFile();
        TextModItems.REGISTRY.register(bus);
        ThunderEvent.register();

        bus.addListener(this::onClientSetup);
    }


    private void setup(final FMLCommonSetupEvent event){

    }
    private void onClientSetup(FMLClientSetupEvent event){

    }

}
