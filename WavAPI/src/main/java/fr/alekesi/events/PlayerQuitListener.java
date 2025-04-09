package fr.alekesi.events;

import fr.alekesi.utils.ScoreboardUtils;
import fr.alekesi.utils.WavPlayers;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event){
        Player player = event.getPlayer();
        event.setQuitMessage("[" + ChatColor.RED +  "-" + ChatColor.WHITE + "] " + player.getDisplayName());
        Bukkit.getServer().broadcastMessage(Bukkit.getOnlinePlayers().size() +"");
        WavPlayers.removePlayer(player);
        for(Player player0 : Bukkit.getOnlinePlayers()){
            ScoreboardUtils.removeScoreboard(player0);
            ScoreboardUtils.updateScoreboard(player0);
        }
    }
}
