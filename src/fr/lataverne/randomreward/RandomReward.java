package fr.lataverne.randomreward;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class RandomReward extends JavaPlugin {

    private static RandomReward instance;

    private RandomBuilder randomBuilder;

    @Override
    public void onEnable() {
        instance = this;

        CommandManager commandManager = new CommandManager();
        try {
            Objects.requireNonNull(this.getCommand("randomreward")).setExecutor(commandManager);
        } catch (NullPointerException ex) {
            Bukkit.getConsoleSender().sendMessage("Error !!!!");
            this.setEnabled(false);
        }

        randomBuilder = new RandomBuilder();
        Bukkit.getConsoleSender().sendMessage("Plugin RandomReward activé");
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("Plugin RandomReward désactivé");
    }

    public static RandomReward getInstance() {
        return instance;
    }

    public RandomBuilder getRandomBuilder() {
        return randomBuilder;
    }
}
