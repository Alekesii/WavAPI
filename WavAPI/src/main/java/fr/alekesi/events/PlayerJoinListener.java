package fr.alekesi.events;
import fr.alekesi.utils.WavPlayers;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import fr.alekesi.utils.ScoreboardUtils;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener{
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        ScoreboardUtils.createScoreboard(player);
        event.setJoinMessage("[" + ChatColor.GREEN +  "+" + ChatColor.WHITE + "] " + player.getDisplayName() );
        Location loc = new Location(player.getWorld(), 0 ,151 ,0, 0, 0);
        player.setGameMode(GameMode.ADVENTURE);
        player.teleport(loc);
        WavPlayers.addPlayer(player);
        for(Player player0 : Bukkit.getOnlinePlayers()){
            ScoreboardUtils.removeScoreboard(player0);
            ScoreboardUtils.updateScoreboard(player0);
        }

    }
}
