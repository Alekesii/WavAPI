package fr.alekesi.events;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class FoodEvent implements Listener {
    @EventHandler
    public void OnPlayerLooseFood(FoodLevelChangeEvent event){
        Entity player = event.getEntity();
        event.setCancelled(true);
    }
}
