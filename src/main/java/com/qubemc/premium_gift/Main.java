package com.qubemc.premium_gift;

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
        System.out.print("test");
    }
}

// fuck off again