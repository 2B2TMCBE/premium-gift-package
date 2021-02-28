package com.qubemc.premium_gift;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
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

public final class Main extends JavaPlugin implements Listener {

    // Create an array to store all the Inventory instance (gift packages)
    Inventory[] giftPacks;
    // Set up the buttons on the gui
    String[] guiSetup = {
            "  s i z  ",
            "  ggggg  ",
            "  fpdnl  "
    };

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("Premium Gift Enabled");
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("Premium Gift Disabled");
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent ev) {
        ev.getPlayer().sendMessage("Welcome to test server"); // DEBUG
    }


    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            switch(cmd.getName()) {
                case "packgift":
                    sender.sendMessage("uploaded your inventory.");
                    Inventory inv = ((Player) sender).getInventory();
                    ItemStack[] invContent = inv.getContents();
                    for (ItemStack a: invContent) {
                        if (a != null) {
                            sender.sendMessage(a.getI18NDisplayName() + ":" + a.getAmount());
                        }
                    }
                    return true;
                case "gifts":
                    sender.sendMessage("Opening gift menu...");
            }
            return false;
        }
        return false;
    }
}
