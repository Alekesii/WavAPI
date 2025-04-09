package fr.alekesi.utils;

import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class WavPlayers {
    private static final Set<Player> players = new HashSet<>();
    public static void addPlayer(Player player) {
        players.add(player);
    }
    public static Player getFirstPlayer(Set<Player> players) {
        if (players != null && !players.isEmpty()) {
            Iterator<Player> iterator = players.iterator();
            return iterator.hasNext() ? iterator.next() : null;
        }
        return null;
    }

    public static void removePlayer(Player player) {
        players.remove(player);
    }

    public static void clearPlayers() {
        players.clear();
    }

    public static Set<Player> getPlayers() {
        return players;
    }

    public static boolean isInGame(Player player) {
        return players.contains(player);
    }

    // Ajoute une méthode pour obtenir le nombre de joueurs
    public static int getPlayerCount() {
        return players.size();
    }
}
