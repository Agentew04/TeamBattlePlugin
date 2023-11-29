package com.rodrigoappelt.teambattleplugin;

import com.rodrigoappelt.teambattleplugin.listeners.ChestListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class TeamBattlePlugin extends JavaPlugin {

    public final Logger logger = getServer().getLogger();

    @Override
    public void onEnable() {
        // Plugin startup logic
        logger.info("Comecando");
        getServer().getPluginManager().registerEvents(new ChestListener(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
