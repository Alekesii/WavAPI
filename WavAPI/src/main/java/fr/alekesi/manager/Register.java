package fr.alekesi.manager;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Register {
    public static void registerEvents(JavaPlugin plugin, Listener... listeners) {
        for (Listener listener : listeners) {
            plugin.getServer().getPluginManager().registerEvents(listener, plugin);
        }
    }

    public static void registerCommands(JavaPlugin plugin, String commandName, CommandExecutor commandExecutor) {
        plugin.getCommand(commandName).setExecutor(commandExecutor);
    }
}
