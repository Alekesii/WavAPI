package fr.alekesi.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class TabModifier {

    public static void modifyTabName(Player player, String prefix, String suffix) {

            if (player == null) return;

            Scoreboard scoreboard = player.getScoreboard();
            if (scoreboard == null || scoreboard == Bukkit.getScoreboardManager().getMainScoreboard()) {
                scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
                player.setScoreboard(scoreboard);
            }

            String teamName = "tab_" + player.getName();
            if (teamName.length() > 16) teamName = teamName.substring(0, 16);

            Team team = scoreboard.getTeam(teamName);
            if (team == null) {
                team = scoreboard.registerNewTeam(teamName);
            }

            team.setPrefix(prefix);
            team.setSuffix(suffix);
            team.addEntry(player.getName());
        }

}
