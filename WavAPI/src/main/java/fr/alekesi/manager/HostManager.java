package fr.alekesi.manager;

import fr.alekesi.utils.ScoreboardUtils;
import fr.alekesi.utils.TabModifier;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.*;

public class HostManager {
    private static final HashMap<UUID, ERanks> playerRanks = new HashMap<>();
    private static final Set<String> secondHosts = new HashSet<>();
    public static Player host = null;

    public static Set<String> getSecondHosts() {
        return new HashSet<>(secondHosts);
    }

    public static ERanks getRank(Player player) {
        return playerRanks.getOrDefault(player.getUniqueId(), ERanks.MEMBER);
    }

    public static String getHostsList() {
        if (secondHosts.isEmpty() && host == null ) {
            return NameManager.prefixColor +  NameManager.messagePrefix + ChatColor.RED + "Aucun host pour l’instant.";
        } else if (secondHosts.isEmpty()) {
            return NameManager.prefixColor  + NameManager.messagePrefix + ChatColor.GREEN + "Hôte : "  + host.getDisplayName() + " Co-Hôtes: " + ChatColor.RED + "Aucun" ;
        } else if (host == null) {
            return NameManager.prefixColor +  NameManager.messagePrefix + ChatColor.RED + "Aucun host pour l’instant.";
        }
        return ChatColor.GREEN + "Hôte : "  + host + " Co-Hôtes: " + ChatColor.YELLOW + String.join(", ", secondHosts);
    }

    public static void setHost(Player player) {
        if (getRank(player) != ERanks.HOST ||  getRank(player) != ERanks.SECONDHOST ) {
            playerRanks.put(player.getUniqueId(), ERanks.HOST);
            host = player;
            TabModifier.modifyTabName(player,  ChatColor.GOLD +"", " §7⚡");

        }
    }
    public static void setCoHost(Player player) {
        if (getRank(player) != ERanks.HOST ||  getRank(player) != ERanks.SECONDHOST ) {
            playerRanks.put(player.getUniqueId(), ERanks.SECONDHOST);
            secondHosts.add(player.getName());
            TabModifier.modifyTabName(player, ChatColor.YELLOW + "", " §7⚡");
            for(Player player0 : Bukkit.getOnlinePlayers()){
                ScoreboardUtils.removeScoreboard(player0);
                ScoreboardUtils.updateScoreboard(player0);
            }
        }
    }


    public static boolean removeHost(Player player) {
        if (getRank(player) == ERanks.HOST) {
            playerRanks.put(player.getUniqueId(), ERanks.MEMBER);
            secondHosts.remove(player.getName());
            return true;
        }
        return false;
    }
}
