package fr.lataverne.randomreward;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class CommandManager implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (sender instanceof ConsoleCommandSender || sender instanceof Player && sender.hasPermission("rr.give")) {
            if (args.length < 2) {
                sender.sendMessage("Mauvaise utilisation !");
                return true;
            }

            if (args[0].equalsIgnoreCase("give")) {
                Player player = Bukkit.getPlayer(args[1]);
                if (player == null) {
                    sender.sendMessage("Player introuvable !");
                    return true;
                }

                this.giveCommand(player);
                return true;
            }

            return true;
        }

        return false;
    }

    private void giveCommand(Player player) {
        RandomBuilder rb = RandomReward.getInstance().getRandomBuilder();

        Reward reward = rb.getRandomReward();

        String command = reward.isCustomItem
                ? "ir give " + player.getDisplayName() + " " + reward.nomItem
                : "give " + player.getDisplayName() + " " + reward.nomItem;

        ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
        Bukkit.dispatchCommand(console, command);
    }
}
