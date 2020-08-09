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

public class AdminShow extends VanishCommand {
    public DDGVanish plugin = DDGVanish.getInstance();
    public VanishManager vanishManager = plugin.getVanishManager();

    public AdminShow() {
        super("show", new String[0], "A way to show all vanished players for admins", true);
    }

    @Override
    public void onCommand(Player player, String[] args) {
        // show all vanished players
        vanishManager.getVanishedPlayers().forEach(vanishedPlayer -> {
            if (player == vanishedPlayer) return;
            player.showPlayer(plugin, vanishedPlayer);
        });
        vanishManager.removeHidden(player);
        player.sendMessage(Constants.getAdminShown());
    }
}
