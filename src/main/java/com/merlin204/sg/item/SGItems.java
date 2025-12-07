package com.merlin204.sg.item;

import com.merlin204.avalon.item.MerlinSuperGG;
import com.merlin204.avalon.main.AvalonMOD;
import com.merlin204.sg.main.SGMOD;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SGItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SGMOD.MOD_ID);

    public static final RegistryObject<Item> GOLEM_HEART = ITEMS.register("golem_heart", () ->
            new GolemHeartItem(Tiers.IRON,10,-3,new Item.Properties()));

    public static final DeferredRegister<CreativeModeTab> SUPER_GOLEM_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SGMOD.MOD_ID);
    public static final RegistryObject<CreativeModeTab> DEFAULT_TAB = SUPER_GOLEM_TAB.register("super_golem_items",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.super_golem.items"))
                    .icon(() -> new ItemStack(GOLEM_HEART.get()))
                    .displayItems((parameters, tabData) ->{
                        tabData.accept(GOLEM_HEART.get());




                    }).build());

}
