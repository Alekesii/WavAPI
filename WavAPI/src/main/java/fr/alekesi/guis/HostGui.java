package fr.alekesi.guis;

import fr.alekesi.manager.HostManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HostGui {


    public static void createHostGui(Player player){
        Inventory hostMenu = Bukkit.createInventory(null, 45, "Liste des Hosts");

        List<ItemStack> skullMetaList = new ArrayList<>();

        for (String hostName : HostManager.getSecondHosts()){
            ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
            SkullMeta meta = (SkullMeta) skull.getItemMeta();
            meta.setDisplayName(ChatColor.YELLOW + hostName);
            meta.setOwner(hostName);
            skull.setItemMeta(meta);
            skullMetaList.add(skull);
            CenterItemsGui.addItemToCenter(hostMenu, skullMetaList);
        }


        ItemStack addHost = new ItemStack(Material.NAME_TAG);
        ItemStack removeHost = new ItemStack(Material.NAME_TAG);
        ItemMeta addMeta = addHost.getItemMeta();
        ItemMeta removeMeta = removeHost.getItemMeta();
        removeMeta.setDisplayName(ChatColor.RED + "Retirer un host");
        addMeta.setDisplayName(ChatColor.GREEN + "Ajouter un host");
        addHost.setItemMeta(addMeta);
        removeHost.setItemMeta(removeMeta);
        hostMenu.setItem(44, addHost);
        hostMenu.setItem(44, addHost);


        ItemStack orangeGlass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 1);
        List<Integer> positions = Arrays.asList(0, 1, 9, 7, 8, 17, 27, 36, 37, 43, 35);
        for (int position : positions) {
            hostMenu.setItem(position, orangeGlass);
        }

        player.openInventory(hostMenu);
    }
}
