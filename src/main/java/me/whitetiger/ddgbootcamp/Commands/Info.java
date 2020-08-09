/* ---------------------------------------------------------------------------------------------------------------------
Copyright (c) 2020 007Whitetiger (Stijn Te Baerts) -- developer.whitetiger@gmail.com
This file and all other files associated with this file are owned by me (Stijn Te Baerts).
Please create your own code or ask me for permission at the email above
--------------------------------------------------------------------------------------------------------------------- */
package me.whitetiger.ddgbootcamp.Commands;

import me.whitetiger.ddgbootcamp.DDGVanish;
import org.bukkit.entity.Player;

public class Info extends VanishCommand {
    public Info() {
        super("info", new String[0], "info command", false);
    }

    @Override
    public void onCommand(Player player, String[] args) {
        player.sendMessage("§6Made by: §9007_Whitetiger");
        player.sendMessage("§6For more info:");
        player.sendMessage("https://github.com/007Whitetiger");
        player.sendMessage("Github repo:");
        player.sendMessage("https://github.com");
        player.sendMessage("Version: " + DDGVanish.getInstance().version);
    }
}
