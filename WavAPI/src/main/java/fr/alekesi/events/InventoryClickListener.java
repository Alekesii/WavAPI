package fr.alekesi.events;

import fr.alekesi.WavAPI;
import fr.alekesi.manager.HostManager;
import fr.alekesi.manager.NameManager;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

public class InventoryClickListener implements Listener {
    private WavAPI plugin;

    public InventoryClickListener(WavAPI plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();
        for (Map.Entry<Player, String> hosterMap : plugin.getWaitingForHostName().entrySet()){
            if(event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW +hosterMap.getValue())){
                player.sendMessage("reussi");
            }

        }

        if (event.getInventory().getName().equals("Liste des Hosts")) {
            event.setCancelled(true);

            ItemStack clickedItem = event.getCurrentItem();
            if (clickedItem == null || clickedItem.getType() == Material.AIR) return;

            if (clickedItem.getType() == Material.NAME_TAG && clickedItem.getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Ajouter un host")) {
                player.closeInventory();
                plugin.getWaitingForHostName().put(player, "true");
                player.sendMessage(NameManager.prefixColor + NameManager.messagePrefix +ChatColor.YELLOW + "Entrez le nom du joueur à ajouter comme host.\n" + HostManager.getHostsList());
            }
        }
    }
}

