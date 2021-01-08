package rip.koru.roads.cleaning;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import rip.koru.roads.cache.CacheManager;
import rip.koru.roads.manager.RoadGenerator;
import rip.koru.roads.utils.Utils;

import java.util.HashMap;

/**
 * Developed by FxMxGRAGFX
 * Project: KoruRoads
 **/

public class WestC {

    private static HashMap<String, Integer> playerCache;
    private static int anchura;

    public static void clean(Player player, Location l, int max) {
        playerCache = CacheManager.getCache().get(player);
        anchura = (playerCache.get("anchura") / 2);
        cleanLine1(l, max);
        cleanLine2(l, max);
    }
    private static void cleanLine1(Location l, int max) {
        l.setX(-1);
        for(int i = 0; i < anchura; i++) {
            cleanBlock(l, max);
            l.setZ(i);
        }
    }
    private static void cleanLine2(Location location, int max) {
        Location l = location;
        l.setX(-1);
        for(int i = -0; i > -anchura; i--) {
            cleanBlock(l, max);
            l.setZ(i);
        }
    }
    private static void cleanBlock(Location l, int max) {
        for(int i = -1; i > -max; i--) {
            for(Material m : RoadGenerator.prohibited) {
                if(l.getBlock().getType() == m) {
                    l.getBlock().setType(Material.AIR);
                }
            }
            l.setX(i);
        }
    }
}
