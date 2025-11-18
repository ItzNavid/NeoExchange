package com.badiei.neoexchange;

import com.badiei.neoexchange.blocks.NeoBlocks;
import com.badiei.neoexchange.items.NeoItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;


public class NeoCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, NeoExchange.MOD_ID);

    public static final Supplier<CreativeModeTab> NEO_TAB = CREATIVE_MODE_TAB.register("neo_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(NeoItems.NEO_STONE.get()))
                    .title(Component.translatable("creativetab.neoexchange.neo_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        // Original items
                        output.accept(NeoItems.NEO_STONE);
                        output.accept(NeoBlocks.NEO_PLATE);
                        
                        // The five tier stones in order
                        output.accept(NeoItems.COMMON_STONE);
                        output.accept(NeoItems.UNCOMMON_STONE);
                        output.accept(NeoItems.RARE_STONE);
                        output.accept(NeoItems.EPIC_STONE);
                        output.accept(NeoItems.LEGENDARY_STONE);
                    }).build());

    public static final Supplier<CreativeModeTab> NEO_TAB2 = CREATIVE_MODE_TAB.register("neo_tab2",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(NeoBlocks.NEO_PLATE.get()))
                   // .withTabsBefore(ResourceLocation.fromNamespaceAndPath(NeoExchange.MOD_ID,"neo_tab"))
                    .title(Component.translatable("creativetab.neoexchange.neo_tab2"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(NeoItems.NEO_STONE);
                        output.accept(NeoBlocks.NEO_PLATE);
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }

}
