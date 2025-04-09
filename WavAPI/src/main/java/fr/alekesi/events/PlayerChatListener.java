package fr.alekesi.events;

import fr.alekesi.WavAPI;
import fr.alekesi.manager.HostManager;
import fr.alekesi.manager.NameManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChatListener implements Listener {
    private WavAPI plugin;

    public PlayerChatListener(WavAPI plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();

        if (!plugin.getWaitingForHostName().isEmpty()) {
            event.setCancelled(true);

            String hostName = event.getMessage();
            Player target = Bukkit.getPlayerExact(hostName);
            if (target != null && target.isOnline()) {
                if(!HostManager.getSecondHosts().isEmpty()){
                    HostManager.setCoHost(target);
                } else {
                    HostManager.setHost(target);

                }
                player.sendMessage(NameManager.prefixColor + NameManager.messagePrefix + ChatColor.GREEN + target.getName() + " a été ajouté comme host.");
            } else {
                player.sendMessage(NameManager.prefixColor + NameManager.messagePrefix + ChatColor.RED + "Le joueur " + hostName + " est introuvable.");
            }

            plugin.getWaitingForHostName().remove(player);
        }
    }

}