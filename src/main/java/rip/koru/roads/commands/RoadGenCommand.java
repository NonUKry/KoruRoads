package rip.koru.roads.commands;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import rip.koru.roads.cache.CacheManager;
import rip.koru.roads.generation.RoadGenerator;
import rip.koru.roads.manager.RoadsManager;
import rip.koru.roads.utils.CC;

import java.util.HashMap;

/**
 * Developed by FxMxGRAGFX
 * Project: KoruRoads
 **/

public class RoadGenCommand extends Command {
    public RoadGenCommand() {
        super("roadgen");
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(CC.RED + "No console!");
            return false;
        }
        Player player = (Player) sender;
        if(args[0].equalsIgnoreCase("test")) {
            HashMap<String, Integer> cache = new HashMap<String, Integer>();
            cache.put("width", Integer.parseInt("10"));
            cache.put("height", Integer.parseInt("5"));
            cache.put("distance", Integer.parseInt(args[1]));
            CacheManager.getCache().put(player, cache);
            String[] blocks = args[2].split(",");
            RoadsManager.startGeneration(player, blocks);
            return false;
        }
        if(!player.hasPermission("koruroads.gen")) {
            player.sendMessage(CC.translate("&7[&cKoruRoads&7] &4You no have permissions to use this!"));
            return false;
        }
        if(!CacheManager.getCache().containsKey(player)) {
            player.sendMessage(CC.RED + "Please first clear! /roadclean <width> <height> <distance>");
            return false;
        }
        if(args.length == 1) {
            String[] blocks = args[0].split(",");
            Bukkit.broadcastMessage(CC.GREEN + "Starting all roads generation!");
            new RoadGenerator(player, blocks).run();
            return true;
        } else {
            player.sendMessage(CC.RED + "/roadgen <blockID,blocksID>");
            return false;
        }
    }
}
