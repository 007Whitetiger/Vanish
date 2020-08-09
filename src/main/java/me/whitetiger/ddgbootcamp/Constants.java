/* ---------------------------------------------------------------------------------------------------------------------
Copyright (c) 2020 007Whitetiger (Stijn Te Baerts) -- developer.whitetiger@gmail.com
This file and all other files associated with this file are owned by me (Stijn Te Baerts).
Please create your own code or ask me for permission at the email above
--------------------------------------------------------------------------------------------------------------------- */
package me.whitetiger.ddgbootcamp;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.file.FileConfiguration;

public class Constants {

    private final FileConfiguration file;

    // prefix
    public static String prefix;

    // vanish messages
    public static String vanishMessage;
    public static String showMessage;

    // admin messages
    public static String broadCastVanish;
    public static String broadCastShow;
    public static String joinedVanished;
    public static String leftVanished;
    public static String adminShown;
    public static String adminHidden;

    // Error messages
    public static String permsError;
    public static String notaplayer;
    public static String noSubCommandError;

    public Constants() {
        DDGVanish plugin = DDGVanish.getInstance();
        file = plugin.getConfig();

        // prefix
        prefix = color(file.getString("vanishPrefix"));

        // vanish messages
        vanishMessage = getConfigMessage("vanishEnable");
        showMessage = getConfigMessage("vanishDisable");

        // admin messages
        broadCastVanish = getConfigMessage("adminVanished");
        broadCastShow = getConfigMessage("adminShow");
        joinedVanished = getConfigMessage("adminJoinedVanished");
        leftVanished = getConfigMessage("adminLeftVanished");
        adminHidden = getConfigMessage("adminHidden");
        adminShown = getConfigMessage("adminShown");

        // Error messages
        permsError = getConfigMessage("errorNoPermissions");
        notaplayer = getConfigMessage("errorNotaPlayer");
        noSubCommandError = getConfigMessage("errorNoSubCommand");

    }

    public static String getPrefix() {
        return prefix + " " + ChatColor.RESET;
    }

    public static String getShowMessage() {
        return showMessage;
    }

    public static String getVanishMessage() {
        return vanishMessage;
    }

    public static String getBroadCastShow() {
        return broadCastShow;
    }

    public static String getBroadCastVanish() {
        return broadCastVanish;
    }

    public static String getJoinedVanished() {
        return joinedVanished;
    }

    public static String getLeftVanished() {
        return leftVanished;
    }

    public static String getAdminShown() {
        return adminShown;
    }

    public static String getAdminHidden() {
        return adminHidden;
    }

    public static String getPermsError() {
        return permsError;
    }

    public static String getNotaplayer() {
        return notaplayer;
    }

    public static String getNoSubCommandError() {
        return noSubCommandError;
    }

    private String getConfigMessage(String s) {
        return getPrefix() + color(file.getString(s));
    }

    private String color(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }
}
