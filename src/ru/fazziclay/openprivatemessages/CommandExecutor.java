package ru.fazziclay.openprivatemessages;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class CommandExecutor implements org.bukkit.command.CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        String playerNick;
        String message;

        try {
            playerNick = args[0];
            message = args[1];

            for (int i = 2; i < args.length; i++) {
                message = message + " " + args[i];
            }
        } catch (Exception e) {
            sender.sendMessage(Config.commandUsing
                    .replace("&", "§")
                    .replace("$command", command.getName())
            );
            return true;
        }

        Player player = Bukkit.getPlayer(playerNick);
        if (player == null) {
            sender.sendMessage(Config.playerNotFound
                    .replace("&", "§")
            );
            return true;
        }

        // message to recipient
        TextComponent textComponentRecipient = new TextComponent(Config.recipientMessagePattern
                .replace("&", "§")
                .replace("$recipient_nickname", playerNick)
                .replace("$sender_nickname", sender.getName())
                .replace("$message", message)
        );
        if (Config.recipientMessageClickEnable) {
            textComponentRecipient.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, Config.recipientMessageClickText
                    .replace("&", "§")
                    .replace("$command", command.getName())
                    .replace("$sender_nickname", sender.getName())
            ));
        }
        if (Config.recipientMessageHoverEnable) {
            textComponentRecipient.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(
                    Config.recipientMessageHoverText
                            .replace("&", "§")
                            .replace("$sender_nickname", sender.getName())
                            .replace("$recipient_nickname", player.getName())
                            .replace("$message", message)
            ).create()
            ));
        }
        player.spigot().sendMessage(textComponentRecipient);


        // message to sender
        TextComponent textComponentSender = new TextComponent(Config.senderMessagePattern
                .replace("&", "§")
                .replace("$recipient_nickname", playerNick)
                .replace("$sender_nickname", sender.getName())
                .replace("$message", message)
        );
        if (Config.senderMessageClickEnable) {
            textComponentSender.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, Config.senderMessageClickText
                    .replace("&", "§")
                    .replace("$command", command.getName())
                    .replace("$sender_nickname", sender.getName())
            ));
        }
        if (Config.senderMessageHoverEnable) {
            textComponentSender.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(
                    Config.senderMessageHoverText
                            .replace("&", "§")
                            .replace("$sender_nickname", sender.getName())
                            .replace("$recipient_nickname", player.getName())
                            .replace("$message", message)
            ).create()
            ));
        }
        sender.spigot().sendMessage(textComponentSender);
        return true;
    }
}
