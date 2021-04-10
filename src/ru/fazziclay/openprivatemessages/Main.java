package ru.fazziclay.openprivatemessages;

import dev.jorel.commandapi.CommandAPI;
import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.CommandPermission;
import dev.jorel.commandapi.arguments.GreedyStringArgument;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public static FileConfiguration pluginConfig;

    @Override
    public void onLoad() {
        CommandAPI.onLoad(false);
    }

    @Override
    public void onEnable() {
        CommandAPI.onEnable(this);

        for (int i = 0; i < Config.commands.size(); i++) {
            CommandAPI.unregister(Config.commands.get(i), true);

            int finalI = i;
            new CommandAPICommand(Config.commands.get(i))
                    .withArguments(Utils.getPlayerNicknameArgument("targets"), new GreedyStringArgument("message"))
                    .withPermission(CommandPermission.NONE)
                    .executes((sender, args) -> {
                        CommandExecutor.onCommand(sender,Config.commands.get(finalI), args);
                    }).register();
        }

        loadConfig();
    }

    public void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
        Main.pluginConfig = getConfig();
    }
}
