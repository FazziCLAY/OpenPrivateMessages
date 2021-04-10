package ru.fazziclay.openprivatemessages;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.*;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class CommandExecutor {
    public static void onCommand(CommandSender sender, String command, Object[] args) {
        // Args
        Player target;
        String message;

        // Time
        String time = Utils.getTimeFormat(Config.timeFormat);

        try {
            target = (Player) args[0];
            message = (String) args[1];

        } catch (Exception e) {
            if (Config.playerNotFoundIsTranslatable) {
                TranslatableComponent a = new TranslatableComponent(Config.playerNotFoundPattern);
                a.setColor(ChatColor.RED);
                sender.spigot().sendMessage(a);
                return;
            }
            sender.sendMessage(Config.playerNotFoundPattern);
            return;
        }

        // message to recipient
        TextComponent textComponentRecipient = new TextComponent(Config.recipientMessagePattern
                .replace("&", "§")
                .replace("$recipient_nickname", target.getName())
                .replace("$sender_nickname", sender.getName())
                .replace("$message", message)
                .replace("$time", time)
        );
        if (Config.recipientMessageClickEnable) {
            textComponentRecipient.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, Config.recipientMessageClickText
                    .replace("&", "§")
                    .replace("$command", command)
                    .replace("$sender_nickname", sender.getName())
                    .replace("$time", time)
            ));
        }
        if (Config.recipientMessageHoverEnable) {
            textComponentRecipient.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(
                    Config.recipientMessageHoverText
                            .replace("&", "§")
                            .replace("$sender_nickname", sender.getName())
                            .replace("$recipient_nickname", target.getName())
                            .replace("$message", message)
                            .replace("$time", time)
            ).create()
            ));
        }
        target.spigot().sendMessage(textComponentRecipient);


        // message to sender
        TextComponent textComponentSender = new TextComponent(Config.senderMessagePattern
                .replace("&", "§")
                .replace("$recipient_nickname", target.getName())
                .replace("$sender_nickname", sender.getName())
                .replace("$message", message)
                .replace("$time", time)
        );
        if (Config.senderMessageClickEnable) {
            textComponentSender.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, Config.senderMessageClickText
                    .replace("&", "§")
                    .replace("$command", command)
                    .replace("$recipient_nickname", target.getName())
                    .replace("$time", time)
            ));
        }
        if (Config.senderMessageHoverEnable) {
            textComponentSender.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(
                    Config.senderMessageHoverText
                            .replace("&", "§")
                            .replace("$sender_nickname", sender.getName())
                            .replace("$recipient_nickname", target.getName())
                            .replace("$message", message)
                            .replace("$time", time)
            ).create()
            ));
        }
        sender.spigot().sendMessage(textComponentSender);
    }
}
