package com.badiei.neoexchange.items;

import com.badiei.neoexchange.NeoExchange;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class NeoItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(NeoExchange.MOD_ID);

    // Original Neo Stone - keeping this for now (maybe for testing or crafting material)
    public static final DeferredItem<Item> NEO_STONE = ITEMS.registerItem("neo_stone", Item::new, new Item.Properties());

    // ========== THE FIVE TIER STONES ==========
    
    /**
     * Tier 1: Common Stone
     * Access: EMC 0-256 (basic items)
     * Crafting: 4 Iron + 4 Coal + 1 Redstone
     */
    public static final DeferredItem<Item> COMMON_STONE = ITEMS.registerItem("common_stone", 
        Item::new, 
        new Item.Properties()
            .rarity(Rarity.COMMON)  // White text
            .stacksTo(1)            // Can only carry 1 at a time (like a tool)
    );

    /**
     * Tier 2: Uncommon Stone
     * Access: EMC 257-1,024 (iron-tier items)
     * Crafting: 4 Gold + 4 Redstone Blocks + 1 Common Stone
     */
    static String uncommon = "uncommon_stone";
    public static final DeferredItem<Item> UNCOMMON_STONE = ITEMS.registerItem(uncommon,
        Item::new, 
        new Item.Properties()
            .rarity(Rarity.UNCOMMON)  // Green text
            .stacksTo(1)
                .overrideDescription(Component.translatable("item.neoexchange." + uncommon).getString())
    );
    /**
     * Tier 3: Rare Stone
     * Access: EMC 1,025-4,096 (gold/diamond tier)
     * Crafting: 4 Diamonds + 4 Ender Pearls + 1 Uncommon Stone
     */
    public static final DeferredItem<Item> RARE_STONE = ITEMS.registerItem("rare_stone", 
        Item::new, 
        new Item.Properties()
            .rarity(Rarity.RARE)  // Blue text
            .stacksTo(1)
    );

    /**
     * Tier 4: Epic Stone
     * Access: EMC 4,097-16,384 (high-tier items)
     * Crafting: 4 Netherite Ingots + 1 Nether Star + 1 Rare Stone
     */
    public static final DeferredItem<Item> EPIC_STONE = ITEMS.registerItem("epic_stone", 
        Item::new, 
        new Item.Properties()
            .rarity(Rarity.EPIC)  // Purple text
            .stacksTo(1)
    );

    /**
     * Tier 5: Legendary Stone
     * Access: Unlimited EMC + special features
     * Crafting: 4 Nether Stars + 4 Netherite Blocks + 1 Dragon Egg (returns) + 1 Epic Stone
     */
    public static final DeferredItem<Item> LEGENDARY_STONE = ITEMS.registerItem("legendary_stone", 
        Item::new, 
        new Item.Properties()
            .rarity(Rarity.EPIC)  // Purple text (Minecraft doesn't have orange rarity)
            .stacksTo(1)
            .fireResistant()      // Can't burn in lava - it's legendary!
    );

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
