/* ---------------------------------------------------------------------------------------------------------------------
Copyright (c) 2020 007Whitetiger (Stijn Te Baerts) -- developer.whitetiger@gmail.com
This file and all other files associated with this file are owned by me (Stijn Te Baerts).
Please create your own code or ask me for permission at the email above
--------------------------------------------------------------------------------------------------------------------- */
package me.whitetiger.ddgbootcamp.Commands;

import me.whitetiger.ddgbootcamp.Constants;
import me.whitetiger.ddgbootcamp.DDGVanish;
import me.whitetiger.ddgbootcamp.VanishManager;
import org.bukkit.entity.Player;

public class AdminHide extends VanishCommand {

    public DDGVanish plugin = DDGVanish.getInstance();
    public VanishManager vanishManager = plugin.getVanishManager();

    public AdminHide() {
        super("hide", new String[0], "A way to hide all vanished players for admins", true);
    }

    @Override
    public void onCommand(Player player, String[] args) {
        // hide all vanished players
        vanishManager.getVanishedPlayers().forEach(vanishedPlayer -> {
            if (player == vanishedPlayer) return;
            player.hidePlayer(plugin, vanishedPlayer);
        });
        vanishManager.addHidden(player);
        // send message
        player.sendMessage(Constants.getAdminHidden());
    }
}
