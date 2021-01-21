package rip.koru.roads.utils;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import rip.koru.roads.cache.CacheManager;

import java.util.HashMap;

/**
 * Developed by FxMxGRAGFX
 * Project: KoruRoads
 **/

public class Adapter {
    
    public static void adapt(Location l, Material block, RoadDirection direction, Player player) {
        if(direction == RoadDirection.WEST) {
            west(l, block, player);
        }
    }

    private static void west(Location l, Material block, Player player) {
        HashMap<String, Integer> playerCache = CacheManager.getCache().get(player);
        int height = playerCache.get("height");
        int value = (int) (player.getLocation().getY() + height);
        l.setX(l.getX() + 1);
        l.setY(l.getY() + 1);
        if(l.getBlock().getType() != Material.AIR) {
            StructureUtils.breackUp(l);
            l.setX(l.getX() - 1);
            StructureUtils.breackUp(l);
        }
    }
}
