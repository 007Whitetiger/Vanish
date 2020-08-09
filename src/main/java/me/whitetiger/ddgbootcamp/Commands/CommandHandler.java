/* ---------------------------------------------------------------------------------------------------------------------
Copyright (c) 2020 007Whitetiger (Stijn Te Baerts) -- developer.whitetiger@gmail.com
This file and all other files associated with this file are owned by me (Stijn Te Baerts).
Please create your own code or ask me for permission at the email above
--------------------------------------------------------------------------------------------------------------------- */
package me.whitetiger.ddgbootcamp.Commands;

import me.whitetiger.ddgbootcamp.Constants;
import me.whitetiger.ddgbootcamp.DDGVanish;
import me.whitetiger.ddgbootcamp.Utils.PermissionUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHandler implements CommandExecutor {
    public DDGVanish plugin = DDGVanish.getInstance();

    public CommandHandler() {
        new Vanish();
        new AdminShow();
        new AdminHide();
        new Info();
        new Help();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // check if sender is a player
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(args.length < 1) {
                player.sendMessage(String.format(Constants.getNoSubCommandError(), label));
                return true;
            }

            // loop through all commands in the VanishCommand command list
            for(VanishCommand vanishCommand : VanishCommand.getCommands()) {
                if(vanishCommand.isCommand(args[0])) {
                    // permission check and execute command
                    if(vanishCommand.isAdmin()) {
                        if (PermissionUtil.isAdmin(player)) {
                            vanishCommand.onCommand(player, args);
                        } else {
                            player.sendMessage(Constants.getPermsError());
                        }
                    } else if(!vanishCommand.isAdmin() && PermissionUtil.canVanish(player)) {
                        vanishCommand.onCommand(player, args);
                    } else {
                        player.sendMessage(Constants.getPermsError());
                    }
                    return true;
                }
            }
            // help message if it's not a valid subcommand
            player.sendMessage("--------§6help§f--------");
            VanishCommand.getCommands().forEach(vanishCommand -> player.sendMessage("§6/vanish " + vanishCommand.getCommand() + ": §f" + vanishCommand.getDescription()));

        } else {
            sender.sendMessage(Constants.getNotaplayer());
        }
        return true;

    }
}
