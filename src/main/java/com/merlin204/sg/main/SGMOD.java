package com.merlin204.sg.main;


import com.merlin204.sg.entity.SGEntities;

import com.merlin204.sg.events.ForgeModEvents;

import com.merlin204.sg.item.SGItems;
import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;


@Mod(SGMOD.MOD_ID)
public class SGMOD {

    public static final String MOD_ID = "super_golem";
    public static final Logger LOGGER = LogUtils.getLogger();



    public SGMOD(FMLJavaModLoadingContext context) {
        IEventBus bus = context.getModEventBus();
        bus.addListener(this::client);
        SGEntities.ENTITIES.register(bus);
        SGItems.ITEMS.register(bus);
        SGItems.SUPER_GOLEM_TAB.register(bus);



    }



    private void client(final FMLClientSetupEvent event) {
        MinecraftForge.EVENT_BUS.register(new ForgeModEvents());
    };




}
