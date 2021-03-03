package com.qubemc.premium_gift;

import de.themoep.inventorygui.StaticGuiElement;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.slf4j.Logger;

import de.themoep.inventorygui.InventoryGui;

import java.util.ArrayList;

public final class Main extends JavaPlugin implements Listener {

    // Create an array to store all the Inventory instance (gift packages)
    ArrayList<ItemStack[]> giftPacks = new ArrayList<ItemStack[]>();
    // Arraylist to store exp date and perm group
    ArrayList<String[]> packs = new ArrayList<String[]>();
    Character[] characters = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o'};
    // Set up the buttons on the gui
    // Max package amount allowed: 15
    String[] guiSetup = {
            "  abcde  ",
            "  fghij  ",
            "  klmno  "
    };

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("Premium Gift Enabled");
        this.getConfig().options().copyDefaults(true);
        this.saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("Premium Gift Disabled");
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            switch(cmd.getName()) {
                case "packgift":
                    // Add a maximum package check to prevent error
                    if (this.giftPacks.size() > 14) {
                        sender.sendMessage(this.getConfig().getString("exceedMaxPackCount"));
                        return false;
                    }
                    sender.sendMessage("uploaded your inventory.");
                    Inventory inv = ((Player) sender).getInventory();
                    ItemStack[] invContent = inv.getContents();
                    for (ItemStack a: invContent) {
                        if (a != null) {
                            sender.sendMessage(a.getI18NDisplayName() + ":" + a.getAmount());
                        }
                    }
                    this.giftPacks.add(invContent);
                    return true;
                case "gifts":
                    sender.sendMessage("Opening gift menu...");
                    InventoryGui gui = new InventoryGui(this, (InventoryHolder) sender, "GIFTS", guiSetup);
                    gui.setFiller(new ItemStack(Material.GRAY_STAINED_GLASS, 1)); // fill the empty slots with this
                    for (int i = 0; i < this.giftPacks.size(); i++) {
                        int finalI = i;
                        gui.addElement(new StaticGuiElement(this.characters[i],
                                new ItemStack(Material.DIAMOND_BLOCK),
                                1, // Display a number as the item count
                                click -> {
                                    if (click.getEvent().getWhoClicked().equals(sender)) {
                                        click.getEvent().getWhoClicked().sendMessage(ChatColor.RED + "Here are the items for this package: package " + finalI);
                                        ItemStack[] tempContents = this.giftPacks.get(finalI);
                                        for (ItemStack a: tempContents) {
                                            if (a != null) {
                                                click.getEvent().getWhoClicked().getInventory().addItem(a);
                                            }
                                        }
                                        return true;
                                    }
                                    return true;
                                },
                                "Gift Package " + i,
                                "Limited to VIP",
                                "Expiration: 24h"
                        ));
                    }
                    gui.show((Player) sender);
                    return true;
            }
            return false;
        }
        return false;
    }
}
