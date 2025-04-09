package fr.alekesi;

import fr.alekesi.commands.HostCommand;
import fr.alekesi.commands.ScoreboardCommand;
import fr.alekesi.events.*;
import fr.alekesi.manager.Register;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public final class WavAPI extends JavaPlugin {
    public static WavAPI instance;
    private final Map<Player, String> waitingForHostName = new HashMap<>(); // Pour suivre les joueurs qui doivent entrer un nom de host

    @Override
    public void onEnable() {
        instance = this;
        System.out.println("WavAPI is ON");

        Register.registerEvents(this, new PlayerJoinListener());
        Register.registerEvents(this, new PlayerQuitListener());
        Register.registerEvents(this, new FoodEvent());
        Register.registerEvents(this, new PlayerChatListener(instance));
        Register.registerEvents(this, new InventoryClickListener(instance));

        Register.registerCommands(this, "scoreboard", new ScoreboardCommand());
        Register.registerCommands(this, "host", new HostCommand(instance));

        // Génération des barrières dans le monde
        World world = Bukkit.getWorld("world");
        if (world == null) {
            getLogger().warning("Le monde 'world' n'a pas été trouvé !");
            return;
        }

        placeBarrierBlocks(world);
    }

    private void placeBarrierBlocks(World world) {
        int halfSize = 50 / 2;
        int centerX = 0, centerZ = 0;
        Material barrier = Material.BARRIER;

        // Placer les barrières dans un carré
        for (int x = -halfSize; x <= halfSize; x++) {
            for (int z = -halfSize; z <= halfSize; z++) {
                world.getBlockAt(x, 149, z).setType(barrier);
            }
        }
        for (int x = centerX - halfSize; x <= centerX + halfSize; x++) {
            for (int height = 1; height <= 3; height++) {
                world.getBlockAt(x, 149 + height, centerZ - halfSize).setType(barrier);
                world.getBlockAt(x, 149 + height, centerZ + halfSize).setType(barrier);
            }
        }

        for (int z = centerZ - halfSize; z <= centerZ + halfSize; z++) {
            for (int height = 1; height <= 3; height++) {
                world.getBlockAt(centerX - halfSize, 149 + height, z).setType(barrier);
                world.getBlockAt(centerX + halfSize, 149 + height, z).setType(barrier);
            }
        }
    }

    public Map<Player, String> getWaitingForHostName() {
        return waitingForHostName;
    }

    @Override
    public void onDisable() {
        System.out.println("WavAPI is OFF");
    }
}
