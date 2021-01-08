package rip.koru.roads.cache;

import org.bukkit.entity.Player;

import java.util.HashMap;

/**
 * Developed by FxMxGRAGFX
 * Project: KoruRoads
 **/

public class CacheManager {

    private static HashMap<Player, HashMap<String, Integer>> cache;

    public CacheManager() {
        cache = new HashMap<Player, HashMap<String, Integer>>();
    }

    public static HashMap<Player, HashMap<String, Integer>> getCache() {
        return cache;
    }
}
