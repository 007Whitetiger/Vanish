/* ---------------------------------------------------------------------------------------------------------------------
Copyright (c) 2020 007Whitetiger (Stijn Te Baerts) -- developer.whitetiger@gmail.com
This file and all other files associated with this file are owned by me (Stijn Te Baerts).
Please create your own code or ask me for permission at the email above
--------------------------------------------------------------------------------------------------------------------- */
package me.whitetiger.ddgbootcamp;

import me.whitetiger.ddgbootcamp.Utils.PermissionUtil;
import org.bukkit.Server;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class VanishManager {
    public List<Player> vanishedPlayers = new ArrayList<>();
    public List<Player> hidden = new ArrayList<>();
    public DDGVanish plugin = DDGVanish.getInstance();
    public Server server = plugin.getServer();

    /**
     * add player to vanish list
     * @param p the player to be vanished
     */
    public void addVanish(Player p) {
        vanishedPlayers.add(p);
    }

    /**
     *
     * @return all the vanished players
     */
    public List<Player> getVanishedPlayers() {
        return vanishedPlayers;
    }

    /**
     *
     * @param p the player to check
     * @return returns if the player is vanished
     */
    public Boolean playerIsVanished(Player p) {
        return vanishedPlayers.contains(p);
    }

    /**
     * Add player to hidden list
     * @param p the player to be added
     */
    public void addHidden(Player p) {
        hidden.add(p);
    }

    /**
     * remove player from hidden list
     * @param p the player to be removed
     */
    public void removeHidden(Player p) {
        hidden.remove(p);
    }

    /**
     * checks if the player is hidden
     * @param p the player to be checked
     * @return true if the player is hidden
     */
    public Boolean isHidden(Player p) {
        return hidden.contains(p);
    }

    /**
     * vanishes the player
     * @param p the player to be vanished
     */

    public void vanish(Player p) {
        addVanish(p);

        // online players loop
        for (Player toBeHidden : server.getOnlinePlayers()) {
            if (toBeHidden == p) continue;
            // if admin don't hide
            if (!PermissionUtil.isAdmin(toBeHidden) || isHidden(toBeHidden)) {
                toBeHidden.hidePlayer(plugin, p);
            }
        }
    }

    /**
     * shows the player again
     * @param p the player to be shown
     */
    public void show(Player p) {
        vanishedPlayers.remove(p);
        // shows the player again
        for (Player other : server.getOnlinePlayers()) {
            if (other == p) continue;
            other.showPlayer(plugin, p);
        }
    }
}