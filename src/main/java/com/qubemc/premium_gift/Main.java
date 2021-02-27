package com.qubemc.premium_gift;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("Premium Gift Enabled");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("Premium Gift Disabled");
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent ev) {
        ev.getPlayer().sendMessage("Welcome to test server");
    }


    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            switch(cmd.getName()) {
                case "test":
                    sender.sendMessage("test command");
                    return true;
            }
            return false;
        }
        return false;
    }
}
