/* ---------------------------------------------------------------------------------------------------------------------
Copyright (c) 2020 007Whitetiger (Stijn Te Baerts) -- developer.whitetiger@gmail.com
This file and all other files associated with this file are owned by me (Stijn Te Baerts).
Please create your own code or ask me for permission at the email above
--------------------------------------------------------------------------------------------------------------------- */
package me.whitetiger.ddgbootcamp.Commands;

import org.bukkit.entity.Player;

public class Help extends VanishCommand{
    public Help() {
        super("help", new String[0], "Help Command", false);
    }

    @Override
    public void onCommand(Player player, String[] args) {
        player.sendMessage("--------§6help§f--------");
        VanishCommand.getCommands().forEach(vanishCommand -> player.sendMessage("§6/vanish " + vanishCommand.getCommand() + ": §f" + vanishCommand.getDescription()));
    }
}
