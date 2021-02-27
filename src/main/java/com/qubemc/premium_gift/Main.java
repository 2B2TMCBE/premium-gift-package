package com.qubemc.premium_gift;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
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

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            switch(cmd.getName()) {
                case "test":
                    sender.sendMessage("fuck off test");
                    sender.sendMessage("Please test this code STAT");
                    // ok Im commiting
            }
        }
    }
}
