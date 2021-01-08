package rip.koru.roads.cleaning;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import rip.koru.roads.cache.CacheManager;
import rip.koru.roads.generation.SouthG;
import rip.koru.roads.manager.RoadGenerator;
import rip.koru.roads.utils.Utils;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * Developed by FxMxGRAGFX
 * Project: KoruRoads
 **/

public class SouthC {
    private static HashMap<String, Integer> playerCache;
    private static int anchura;

    public static void clean(Player player, Location l, int max) {
        playerCache = CacheManager.getCache().get(player);
        anchura = (playerCache.get("anchura") / 2);
        cleanLine1(l, max);
        cleanLine2(l, max);
    }

    private static void cleanLine1(Location l, int max) {
        l.setZ(-1);
        for(int i = 0; i < anchura; i++) {
            cleanBlock(l, max);
            l.setX(i);
        }
    }
    private static void cleanLine2(Location location, int max) {
        Location l = location;
        l.setZ(-1);
        for(int i = -0; i > -anchura; i--) {
            cleanBlock(l, max);
            l.setX(i);
        }
    }
    private static void cleanBlock(Location l, int max) {
        for(int i = 1; i < max; i++) {
            for(Material m : RoadGenerator.prohibited) {
                if(l.getBlock().getType() == m) {
                    l.getBlock().setType(Material.AIR);
                }
            }
            l.setZ(i);
        }
    }
}
