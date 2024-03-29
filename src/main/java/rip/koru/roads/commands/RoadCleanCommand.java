package rip.koru.roads.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import rip.koru.roads.cache.CacheManager;
import rip.koru.roads.cleaning.RoadCleaner;
import rip.koru.roads.utils.CC;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Developed by FxMxGRAGFX
 * Project: KoruRoads
 **/

public class RoadCleanCommand extends Command {
    public RoadCleanCommand() {
        super("roadclean");
        super.setAliases(Arrays.asList("roadclear"));
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(CC.RED + "[KoruRoads] No console!");
            return false;
        }
        Player player = (Player) sender;
        if(!player.hasPermission("koruroads.clean")) {
            player.sendMessage(CC.translate("&7[&cKoruRoads&7] &4You no have permissions to use this!"));
            return false;
        }
        if(args.length == 3) {
            HashMap<String, Integer> cache = new HashMap<String, Integer>();
            cache.put("width", Integer.parseInt(args[0]));
            cache.put("height", Integer.parseInt(args[1]));
            cache.put("distance", Integer.parseInt(args[2]));
            CacheManager.getCache().put(player, cache);
            Bukkit.broadcastMessage(CC.GREEN + "Staring to generating all roads!, Please wait...");
            new RoadCleaner(player).run();
            return true;
        }
        player.sendMessage(CC.RED + "/roadclean <width> <height> <distance>");
        return false;
    }
}
