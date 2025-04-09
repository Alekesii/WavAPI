package fr.alekesi.commands;

import fr.alekesi.utils.ScoreboardUtils;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ScoreboardCommand implements CommandExecutor {

        @Override
        public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                ScoreboardUtils.createScoreboard(player);
                player.sendMessage("Scoreboard affiché !");
                return true;
            } else {
                sender.sendMessage("Cette commande peut uniquement être utilisée par un joueur.");
                return false;
        }
    }
}
