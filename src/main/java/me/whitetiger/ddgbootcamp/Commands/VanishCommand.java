/* ---------------------------------------------------------------------------------------------------------------------
Copyright (c) 2020 007Whitetiger (Stijn Te Baerts) -- developer.whitetiger@gmail.com
This file and all other files associated with this file are owned by me (Stijn Te Baerts).
Please create your own code or ask me for permission at the email above
--------------------------------------------------------------------------------------------------------------------- */
package me.whitetiger.ddgbootcamp.Commands;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public abstract class VanishCommand {
    private static List<VanishCommand> commands = new ArrayList<>();

    private String command;
    private String[] aliases;
    private String description;
    private boolean admin;

    public VanishCommand(String command, String[] aliases, String description, boolean admin) {
        this.command = command;
        this.aliases = aliases;
        this.description = description;
        this.admin = admin;
        commands.add(this);
    }

    /**
     * @return command list
     */
    public static List<VanishCommand> getCommands() {
        return commands;
    }

    /**
     * command executor
     * @param player a player
     * @param args command args
     */
    public abstract void onCommand(Player player, String[] args);

    /**
     *
     * @return returns the command name
     */
    public String getCommand() {
        return command;
    }

    /**
     * checks if this is the command
     * @param s the subcommand given by the player
     * @return if the subcommand this command is
     */
    public Boolean isCommand(String s) {
        if (s.equalsIgnoreCase(getCommand())) return true;
        for (String alias : getAliases()) {
            if (s.equalsIgnoreCase(alias)) return true;
        }
        return false;
    }

    /**
     *
     * @return command aliases
     */
    public String[] getAliases() {
        return aliases;
    }

    /**
     *
     * @return the description of the command
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @return returns if it is a admin command
     */
    public boolean isAdmin() {
        return admin;
    }

}
