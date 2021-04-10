package ru.fazziclay.openprivatemessages;


import dev.jorel.commandapi.arguments.Argument;
import dev.jorel.commandapi.arguments.CustomArgument;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.TranslatableComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utils {
    public static Argument getPlayerNicknameArgument(String nodeName) {
        return new CustomArgument<Player>(nodeName, Bukkit::getPlayer).overrideSuggestions(sender -> Bukkit.getOnlinePlayers().stream().map(Player::getName).toArray(String[]::new));
    }

    public static String getTimeFormat(String format) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }
}
