package ru.fazziclay.openprivatemessages;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Entity;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class CommandExecutor implements org.bukkit.command.CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        Bukkit.getLogger().info("args: " + Arrays.toString(args));

        String playerNick;
        String message;

        try {
            playerNick = args[0];
            message = args[1];

            for (int i = 2; i < args.length; i++) {
                message = message + " " + args[i];
            }
        } catch (Exception e) {
            sender.sendMessage("Используйте /"+command.getName()+" <player> <message>");
            return true;
        }

        Player player = Bukkit.getPlayer(playerNick);
        if (player == null) {
            sender.sendMessage("Error: player==null");
            return true;
        }

        TextComponent textComponent = new TextComponent(message);
        textComponent.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, ("/" + command.getName() + " ") ));

        player.spigot().sendMessage(textComponent);


        Bukkit.getLogger().info("playerNick="+playerNick+"; message="+message);

        return true;
    }
}
