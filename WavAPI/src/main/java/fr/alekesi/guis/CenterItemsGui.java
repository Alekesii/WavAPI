package fr.alekesi.guis;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class CenterItemsGui {
    public static void addItemToCenter(Inventory inventory, List<ItemStack> itemStack) {
        if (inventory == null || itemStack == null || itemStack.isEmpty()) {
            return;
        }
        int size = inventory.getSize();
        int itemCount = itemStack.size();

        if (itemCount > size) {
            return;
        }

        int startIndex = (size / 2) - (itemCount / 2);

        for (int i = 0; i < itemCount; i++) {
            if (itemStack.get(i) != null) {
                inventory.setItem(startIndex + i, itemStack.get(i));
            }
        }
    }
}
