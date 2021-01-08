package rip.koru.roads.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import rip.koru.roads.cache.CacheManager;
import rip.koru.roads.manager.RoadsManager;
import rip.koru.roads.utils.CC;

import java.util.HashMap;

/**
 * Developed by FxMxGRAGFX
 * Project: KoruRoads
 **/

public class RoadCleanCommand extends Command {
    public RoadCleanCommand() {
        super("roadclean");
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(CC.RED + "No console!");
            return false;
        }
        Player player = (Player) sender;
        if(args.length == 2) {
            HashMap<String, Integer> cache = new HashMap<String, Integer>();
            cache.put("anchura", Integer.parseInt(args[0]));
            cache.put("distancia", Integer.parseInt(args[1]));
            CacheManager.getCache().put(player, cache);
            RoadsManager.clean(player);
            return true;
        }
        player.sendMessage(CC.RED + "/roadclean <anchura> <distancia>");
        return false;
    }
}
