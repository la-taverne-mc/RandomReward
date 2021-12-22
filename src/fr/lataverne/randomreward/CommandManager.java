package fr.lataverne.randomreward;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class CommandManager implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (sender instanceof ConsoleCommandSender || sender instanceof Player && sender.hasPermission("rr.give")) {
            if (args.length < 1) {
                sender.sendMessage("Mauvaise utilisation !");
                return true;
            }

            if(args[0].equalsIgnoreCase("list"))
                this.listItems(sender);

            if (args[0].equalsIgnoreCase("give")) {
                Player player = Bukkit.getPlayer(args[1]);
                if (player == null) {

                    sender.sendMessage("Player introuvable !");
                    return true;
                }
                if(args.length==3)
                    for (int i=0; i<Integer.parseInt(args[2]);i++)
                        this.giveCommand(player);
                else
                    this.giveCommand(player);

                return true;
            }

            return true;
        }

        return false;
    }

    private void listItems(CommandSender sender) {
        ArrayList<String> list = RandomReward.getInstance().getList();
        sender.sendMessage(ChatColor.AQUA + "================== RandomReward ==================");
        for(String string : list){
            sender.sendMessage(ChatColor.LIGHT_PURPLE + string);
        }
        sender.sendMessage(ChatColor.AQUA + "================== RandomReward ==================");
    }

    private void giveCommand(Player player) {
        RandomBuilder rb = RandomReward.getInstance().getRandomBuilder();

        Reward reward = rb.getRandomReward();
        System.out.println("ir give " + player.getDisplayName() + " " + reward.nomItem);
        String command = reward.isCustomItem
                ? "ir give " + player.getDisplayName() + " " + reward.nomItem
                : "give " + player.getDisplayName() + " " + reward.nomItem;

        ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
        Bukkit.dispatchCommand(console, command);
    }

}
