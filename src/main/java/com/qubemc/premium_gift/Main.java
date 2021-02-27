package com.qubemc.premium_gift;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.slf4j.Logger;

public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("Premium Gift Enabled");
        getServer().getPluginManager().registerEvents(this,this);
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
