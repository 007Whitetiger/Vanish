package me.whitetiger.ddgbootcamp;

import me.whitetiger.ddgbootcamp.Commands.CommandHandler;
import me.whitetiger.ddgbootcamp.Listeners.JoinLeaveListener;
import me.whitetiger.ddgbootcamp.Utils.BroadCastUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public final class DDGVanish extends JavaPlugin {

    public static DDGVanish Instance;
    public VanishManager vanishManager;
    public PluginManager pluginManager;
    public String version = "V0.1";

    @Override
    public void onEnable() {
        saveDefaultConfig();
        // adds all variables
        Instance = this;
        this.vanishManager = new VanishManager();
        this.pluginManager = Bukkit.getPluginManager();

        new Constants();

        registerEvents();

        // register main command
        getCommand("vanish").setExecutor(new CommandHandler());

    }

    @Override
    public void onDisable() {
        for (Player p : vanishManager.getVanishedPlayers()) {
            // disable vanish
            vanishManager.show(p);

            // add to currently vanished
            List<String> vanishedPlayers = getConfig().getStringList("vanished");
            vanishedPlayers.add(p.getUniqueId().toString());
            getConfig().set("vanished", vanishedPlayers);
        }
        saveConfig();
    }

    /**
     * Registers events
     */
    public void registerEvents() {
        pluginManager.registerEvents(new JoinLeaveListener(), this);
    }

    /**
     *
     * @return the current plugin
     */
    public static DDGVanish getInstance() {
        return Instance;
    }

    /**
     *
     * @return the current vanishManager
     */
    public VanishManager getVanishManager() {
        return vanishManager;
    }}
