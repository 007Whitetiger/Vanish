/* ---------------------------------------------------------------------------------------------------------------------
Copyright (c) 2020 007Whitetiger (Stijn Te Baerts) -- developer.whitetiger@gmail.com
This file and all other files associated with this file are owned by me (Stijn Te Baerts).
Please create your own code or ask me for permission at the email above
--------------------------------------------------------------------------------------------------------------------- */
package me.whitetiger.ddgbootcamp.Commands;

import me.whitetiger.ddgbootcamp.Constants;
import me.whitetiger.ddgbootcamp.DDGVanish;
import me.whitetiger.ddgbootcamp.Utils.BroadCastUtils;
import me.whitetiger.ddgbootcamp.Utils.PermissionUtil;
import me.whitetiger.ddgbootcamp.VanishManager;
import org.bukkit.Server;
import org.bukkit.entity.Player;

public class Vanish extends VanishCommand {

    public DDGVanish plugin = DDGVanish.getInstance();
    public VanishManager vanishManager = plugin.getVanishManager();

    public Vanish() {
        super("vanish", new String[]{"on", "v"}, "Main vanish command", true);
    }

    @Override
    public void onCommand(Player player, String[] args) {
        // checks if already vanished
       if (vanishManager.playerIsVanished(player)) {
           // disable vanish
           vanishManager.show(player);
           // send messages
           player.sendMessage(Constants.getShowMessage());
           BroadCastUtils.broadCastToAdmins(Constants.getBroadCastShow().replaceAll("%player%", player.getName()));
       } else {
           // enable vanish
           vanishManager.vanish(player);
           // send messages
           player.sendMessage(Constants.getVanishMessage());
           BroadCastUtils.broadCastToAdmins(Constants.getBroadCastVanish().replaceAll("%player%", player.getName()));
       }
    }
}
