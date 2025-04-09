package fr.alekesi.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;


public class ScoreboardUtils{
    private static String gameMode = "UHC";
    private static String hostName = "Aucun";
    public static void createScoreboard(Player player) {



            ScoreboardManager manager = Bukkit.getScoreboardManager();
            Scoreboard scoreboard = manager.getNewScoreboard();

            Objective objective = scoreboard.registerNewObjective("wavuhc", "dummy");
            objective.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Wav'" + ChatColor.WHITE + "" + ChatColor.BOLD + "UHC");
            objective.setDisplaySlot(DisplaySlot.SIDEBAR);

            Score blank1 = objective.getScore(" ");
            blank1.setScore(4);

            Score onlinePlayers = objective.getScore(ChatColor.WHITE + "Joueurs " + ChatColor.YELLOW + WavPlayers.getPlayers().size());
            onlinePlayers.setScore(3);

            Score mode = objective.getScore(ChatColor.WHITE +  "Mode " + ChatColor.YELLOW  + gameMode);
            mode.setScore(2);

            Score host = objective.getScore(ChatColor.WHITE +  "Host " + ChatColor.YELLOW + hostName);
            host.setScore(1);

            Score blank2 = objective.getScore("  ");
            blank2.setScore(0);

            Score server = objective.getScore(ChatColor.GOLD +"alekesi" );
            server.setScore(0);

            player.setScoreboard(scoreboard);


        }


    public static void updateScoreboard(Player player) {
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard scoreboard = manager.getNewScoreboard();
//        RoofedPlayers roofedPlayers = new RoofedPlayers();
//        gameSatus = gameManager.getCurrentState().getStatusName();

        Objective objective = scoreboard.registerNewObjective("wavuhc", "dummy");
        objective.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Wav'" + ChatColor.WHITE + "" + ChatColor.BOLD + "UHC");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        Score blank1 = objective.getScore(" ");
        blank1.setScore(4);

        Score onlinePlayers = objective.getScore(ChatColor.WHITE + "Joueurs " + ChatColor.YELLOW + WavPlayers.getPlayers().size());
        onlinePlayers.setScore(3);

        Score mode = objective.getScore(ChatColor.WHITE +  "Mode " + ChatColor.YELLOW  + gameMode);
        mode.setScore(2);

        Score host = objective.getScore(ChatColor.WHITE +  "Host " + ChatColor.YELLOW + hostName);
        host.setScore(1);

        Score blank2 = objective.getScore("  ");
        blank2.setScore(0);

        Score server = objective.getScore(ChatColor.GOLD +"alekesi" );
        server.setScore(0);

        player.setScoreboard(scoreboard);

    }
    public static void removeScoreboard(Player player){
        Scoreboard scoreboard = player.getScoreboard();
        if (scoreboard == null) {
            Bukkit.getLogger().warning("Le scoreboard du joueur " + player.getName() + " est null !");
            return;
        }

        Objective objective = scoreboard.getObjective("wavuhc");
        if (objective != null) {
            objective.unregister();
        }

        ScoreboardManager manager = Bukkit.getScoreboardManager();
        if (manager != null) {
            player.setScoreboard(manager.getNewScoreboard());
        }
    }



}
