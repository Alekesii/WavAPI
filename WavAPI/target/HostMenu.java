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

public class HostMenu {

    public static void addItemToCenter(Inventory inventory, List<ItemStack> itemStack) {
        if (inventory == null || itemStack == null || itemStack.isEmpty()) {
            throw new IllegalArgumentException("Inventaire ou liste d'items null/vide !");
        }

        int size = inventory.getSize();
        int itemCount = itemStack.size();

        if (itemCount > size) {
            throw new IllegalArgumentException("Trop d'éléments pour cet inventaire");
        }

        int startIndex = (size / 2) - (itemCount / 2);

        for (int i = 0; i < itemCount; i++) {
            if (itemStack.get(i) != null) {
                inventory.setItem(startIndex + i, itemStack.get(i));
            }
        }
    }

    public void openHostMenu(Player player) {
        Inventory hostMenu = Bukkit.createInventory(null, 45, "Liste des Hosts");

        // ⚠️ Initialiser `skullMetaList` avant de l'utiliser
        List<ItemStack> skullMetaList = new ArrayList<>();

        for (String hostName : HostManager.getHosts()) {
            ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
            SkullMeta meta = (SkullMeta) skull.getItemMeta();
            meta.setDisplayName(ChatColor.YELLOW + hostName);
            meta.setOwner(hostName); // ✅ Corrigé pour définir le bon joueur
            skull.setItemMeta(meta);
            skullMetaList.add(skull);
        }

        // Ajoute les crânes au centre du menu
        addItemToCenter(hostMenu, skullMetaList);

        // Bouton "Ajouter un host"
        ItemStack addHost = new ItemStack(Material.NAME_TAG);
        ItemMeta addMeta = addHost.getItemMeta();
        addMeta.setDisplayName(ChatColor.GREEN + "Ajouter un host");
        addHost.setItemMeta(addMeta);
        hostMenu.setItem(44, addHost);

        // Ajout du verre teinté orange aux positions spécifiques
        ItemStack orangeGlass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 1);
        List<Integer> positions = Arrays.asList(0, 1, 9, 7, 8, 17, 27, 36, 37, 43, 35);
        for (int position : positions) {
            hostMenu.setItem(position, orangeGlass);
        }

        // Ouvre le menu pour le joueur
        player.openInventory(hostMenu);
    }
}
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

public class HostMenu {

    public static void addItemToCenter(Inventory inventory, List<ItemStack> itemStack) {
        if (inventory == null || itemStack == null || itemStack.isEmpty()) {
            throw new IllegalArgumentException("Inventaire ou liste d'items null/vide !");
        }

        int size = inventory.getSize();
        int itemCount = itemStack.size();

        if (itemCount > size) {
            throw new IllegalArgumentException("Trop d'éléments pour cet inventaire");
        }

        int startIndex = (size / 2) - (itemCount / 2);

        for (int i = 0; i < itemCount; i++) {
            if (itemStack.get(i) != null) {
                inventory.setItem(startIndex + i, itemStack.get(i));
            }
        }
    }

    public void openHostMenu(Player player) {
        Inventory hostMenu = Bukkit.createInventory(null, 45, "Liste des Hosts");

        // ⚠️ Initialiser `skullMetaList` avant de l'utiliser
        List<ItemStack> skullMetaList = new ArrayList<>();

        for (String hostName : HostManager.getHosts()) {
            ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
            SkullMeta meta = (SkullMeta) skull.getItemMeta();
            meta.setDisplayName(ChatColor.YELLOW + hostName);
            meta.setOwner(hostName); // ✅ Corrigé pour définir le bon joueur
            skull.setItemMeta(meta);
            skullMetaList.add(skull);
        }

        // Ajoute les crânes au centre du menu
        addItemToCenter(hostMenu, skullMetaList);

        // Bouton "Ajouter un host"
        ItemStack addHost = new ItemStack(Material.NAME_TAG);
        ItemMeta addMeta = addHost.getItemMeta();
        addMeta.setDisplayName(ChatColor.GREEN + "Ajouter un host");
        addHost.setItemMeta(addMeta);
        hostMenu.setItem(44, addHost);

        // Ajout du verre teinté orange aux positions spécifiques
        ItemStack orangeGlass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 1);
        List<Integer> positions = Arrays.asList(0, 1, 9, 7, 8, 17, 27, 36, 37, 43, 35);
        for (int position : positions) {
            hostMenu.setItem(position, orangeGlass);
        }

        // Ouvre le menu pour le joueur
        player.openInventory(hostMenu);
    }
}
