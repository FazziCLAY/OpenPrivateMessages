package ru.fazziclay.openprivatemessages;

import java.util.List;

public class Config {
    public static List<String> commands = Main.pluginConfig.getStringList("commands");

    public static String playerNotFoundPattern = Main.pluginConfig.getString("playerNotFound.Pattern");
    public static Boolean playerNotFoundIsTranslatable = Main.pluginConfig.getBoolean("playerNotFound.IsTranslatable");
    public static String timeFormat     = Main.pluginConfig.getString("timeFormat");

    public static String recipientMessagePattern        = Main.pluginConfig.getString( "recipientMessage.Pattern");
    public static Boolean recipientMessageHoverEnable   = Main.pluginConfig.getBoolean("recipientMessage.Hover.Enable");
    public static String  recipientMessageHoverText     = Main.pluginConfig.getString( "recipientMessage.Hover.Text");
    public static Boolean recipientMessageClickEnable   = Main.pluginConfig.getBoolean("recipientMessage.Click.Enable");
    public static String  recipientMessageClickText     = Main.pluginConfig.getString( "recipientMessage.Click.Text");

    public static String senderMessagePattern       = Main.pluginConfig.getString( "senderMessage.Pattern");
    public static Boolean senderMessageHoverEnable  = Main.pluginConfig.getBoolean("senderMessage.Hover.Enable");
    public static String  senderMessageHoverText    = Main.pluginConfig.getString( "senderMessage.Hover.Text");
    public static Boolean senderMessageClickEnable  = Main.pluginConfig.getBoolean("senderMessage.Click.Enable");
    public static String  senderMessageClickText    = Main.pluginConfig.getString( "senderMessage.Click.Text");

}
