package rip.koru.roads.manager;

import org.bukkit.entity.Player;

/**
 * Developed by FxMxGRAGFX
 * Project: KoruRoads
 **/

public class RoadsManager {
    
    public static void clean(Player player) {
        RoadGenerator.startClean(player);
    }

    public void generate(Player player) {
    }

}
