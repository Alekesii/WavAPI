package fr.alekesi.commands;
import fr.alekesi.WavAPI;
import fr.alekesi.guis.HostGui;
import fr.alekesi.manager.HostManager;
import fr.alekesi.manager.NameManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HostCommand implements CommandExecutor {
    private WavAPI plugin;

    public HostCommand(WavAPI plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (args.length == 0) {
                HostGui.createHostGui(player);
                return true;
            }

            if (args.length == 2 && args[0].equalsIgnoreCase("add")) {
                String targetName = args[1];
                Player target = Bukkit.getPlayer(targetName);

                if (target != null && target.isOnline()) {
                    HostManager.setHost(target);
                    player.sendMessage( NameManager.prefixColor + NameManager.messagePrefix + ChatColor.GREEN + targetName + " a été ajouté comme host.");
                } else {
                    player.sendMessage( NameManager.prefixColor + NameManager.messagePrefix + ChatColor.RED + "Le joueur " + targetName + " est introuvable.");
                }
                return true;
            }
        }
        return false;
    }

    }
