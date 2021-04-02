package ru.fazziclay.openprivatemessages;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        getCommand("tell").setExecutor(new ru.fazziclay.openprivatemessages.CommandExecutor());
        getCommand("msg").setExecutor(new ru.fazziclay.openprivatemessages.CommandExecutor());
        getCommand("w").setExecutor(new ru.fazziclay.openprivatemessages.CommandExecutor());
    }
}
