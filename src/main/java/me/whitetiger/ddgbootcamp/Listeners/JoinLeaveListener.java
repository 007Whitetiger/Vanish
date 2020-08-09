/* ---------------------------------------------------------------------------------------------------------------------
Copyright (c) 2020 007Whitetiger (Stijn Te Baerts) -- developer.whitetiger@gmail.com
This file and all other files associated with this file are owned by me (Stijn Te Baerts).
Please create your own code or ask me for permission at the email above
--------------------------------------------------------------------------------------------------------------------- */
package me.whitetiger.ddgbootcamp.Listeners;

import me.whitetiger.ddgbootcamp.Constants;
import me.whitetiger.ddgbootcamp.DDGVanish;
import me.whitetiger.ddgbootcamp.Utils.BroadCastUtils;
import me.whitetiger.ddgbootcamp.Utils.PermissionUtil;
import me.whitetiger.ddgbootcamp.VanishManager;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.List;

public class JoinLeaveListener implements Listener {

    public DDGVanish plugin = DDGVanish.getInstance();
    public VanishManager vanishManager = plugin.getVanishManager();
    public FileConfiguration config = plugin.getConfig();

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        // hide all vanished players if the player is not an admin
        if (!PermissionUtil.isAdmin(p)) {
            for (Player vanished : vanishManager.getVanishedPlayers()) {
                p.hidePlayer(plugin, vanished);
            }
        }
        // checks if the person was vanished
        List<String> offlineVanished = config.getStringList("vanished");
        if (PermissionUtil.canVanish(p) && offlineVanished.contains(p.getUniqueId().toString())) {
            // set join message to nothing
            e.setJoinMessage("");
            // vanish player
            vanishManager.vanish(p);
            // send message
            p.sendMessage(Constants.getVanishMessage());
            BroadCastUtils.broadCastToAdmins(Constants.getJoinedVanished().replaceAll("%player%", p.getName()));

            // remove from currently vanished
            offlineVanished.remove(p.getUniqueId().toString());
            plugin.getConfig().set("vanished", offlineVanished);
        }
    }
    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        // makes everyone see able on leave
        if (!vanishManager.playerIsVanished(p)) {
            for (Player vanished : vanishManager.getVanishedPlayers()) {
                if (p != vanished && !p.canSee(vanished)) p.showPlayer(plugin, vanished);
            }
        }
        // if player is vanished add him to vanish storage
        if (vanishManager.playerIsVanished(p)) {
            // set quit message to nothing
            e.setQuitMessage("");
            // show the player
            vanishManager.show(p);
            // send message
            BroadCastUtils.broadCastToAdmins(Constants.getLeftVanished().replaceAll("%player%", p.getName()));

            // add to currently vanished
            List<String> vanishedPlayers = plugin.getConfig().getStringList("vanished");
            vanishedPlayers.add(p.getUniqueId().toString());
            config.set("vanished", vanishedPlayers);
        }
    }

}
