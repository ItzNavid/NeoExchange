package com.badiei.neoexchange.items;

import com.badiei.neoexchange.NeoExchange;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class NeoItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(NeoExchange.MOD_ID);

    public static final DeferredItem<Item> NEO_STONE = ITEMS.registerItem("neo_stone", Item::new, new Item.Properties());

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
