/* ---------------------------------------------------------------------------------------------------------------------
Copyright (c) 2020 007Whitetiger (Stijn Te Baerts) -- developer.whitetiger@gmail.com
This file and all other files associated with this file are owned by me (Stijn Te Baerts).
Please create your own code or ask me for permission at the email above
--------------------------------------------------------------------------------------------------------------------- */
package me.whitetiger.ddgbootcamp;

import org.bukkit.configuration.file.FileConfiguration;

public class Settings {

    public static boolean canJoinVanished;

    /**
     * gets all settings
     */
    public Settings() {
        DDGVanish plugin = DDGVanish.getInstance();
        FileConfiguration file = plugin.getConfig();
        canJoinVanished = file.getBoolean("leaveVanished");
    }

}
