package fr.lataverne.randomreward;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class RandomReward extends JavaPlugin {

    private static RandomReward instance;

    private RandomBuilder randomBuilder;

    @Override
    public void onEnable() {

        File file = new File(getDataFolder(), "filename.txt");
        if (!file.exists()) {// saves it to your plugin's data folder if it doesn't exist already
            file.getParentFile().mkdirs();
            try {
                System.out.println("cration du fichier !! ");
                file.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }else
            System.out.println("le fichier existe ! ");

        instance = this;

        CommandManager commandManager = new CommandManager();
        try {
            Objects.requireNonNull(this.getCommand("randomreward")).setExecutor(commandManager);
        } catch (NullPointerException ex) {
            Bukkit.getConsoleSender().sendMessage("Error !!!!");
            this.setEnabled(false);
        }

        randomBuilder = new RandomBuilder(file);
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

    public ArrayList<String> getList() {
        return  randomBuilder.getList();
    }

}
