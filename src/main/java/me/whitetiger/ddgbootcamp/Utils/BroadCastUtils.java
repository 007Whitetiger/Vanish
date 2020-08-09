/* ---------------------------------------------------------------------------------------------------------------------
Copyright (c) 2020 007Whitetiger (Stijn Te Baerts) -- developer.whitetiger@gmail.com
This file and all other files associated with this file are owned by me (Stijn Te Baerts).
Please create your own code or ask me for permission at the email above
--------------------------------------------------------------------------------------------------------------------- */
package me.whitetiger.ddgbootcamp.Utils;

import me.whitetiger.ddgbootcamp.Commands.Vanish;
import me.whitetiger.ddgbootcamp.DDGVanish;
import me.whitetiger.ddgbootcamp.VanishManager;

public class BroadCastUtils {
    public static DDGVanish plugin = DDGVanish.getInstance();
    public static VanishManager vanishManager = plugin.getVanishManager();

    /**
     * sends a message to all admins online
     * @param message the message for admins
     */
    public static void broadCastToAdmins(String message) {
        /*
        gets all players
        checks if admin
        sends message if admin
         */
        plugin.getServer().getOnlinePlayers().forEach(player -> {
            if (PermissionUtil.isAdmin(player)) {
                player.sendMessage(message);
            }
        });
    }
}
