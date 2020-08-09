/* ---------------------------------------------------------------------------------------------------------------------
Copyright (c) 2020 007Whitetiger (Stijn Te Baerts) -- developer.whitetiger@gmail.com
This file and all other files associated with this file are owned by me (Stijn Te Baerts).
Please create your own code or ask me for permission at the email above
--------------------------------------------------------------------------------------------------------------------- */
package me.whitetiger.ddgbootcamp.Utils;

import org.bukkit.entity.Player;

public class PermissionUtil {
    /**
     *
     * @param p the player
     * @return if player has admin permissions
     */
    public static Boolean isAdmin(Player p) {
        return p.hasPermission("DDGVanish.admin") || p.isOp();
    }

    /**
     *
     * @param p the player
     * @return if player can vanish
     */
    public static Boolean canVanish(Player p) {
        return p.hasPermission("DDGVanish.vanish");
    }
}
