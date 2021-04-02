package ru.fazziclay.openprivatemessages;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public static FileConfiguration pluginConfig;

    @Override
    public void onEnable() {
        getCommand("tell").setExecutor(new ru.fazziclay.openprivatemessages.CommandExecutor());
        getCommand("msg").setExecutor(new ru.fazziclay.openprivatemessages.CommandExecutor());
        getCommand("w").setExecutor(new ru.fazziclay.openprivatemessages.CommandExecutor());

        loadConfig();
    }

    public void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
        Main.pluginConfig = getConfig();
    }
}
