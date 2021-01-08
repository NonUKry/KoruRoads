package rip.koru.roads.utils;

import org.bukkit.Location;
import org.bukkit.Material;

/**
 * Developed by FxMxGRAGFX
 * Project: KoruRoads
 **/

public class StructureUtils {

    public static void breackUp(Location l) {
        while (l.getBlock().getType() != Material.AIR) {
            l.getBlock().setType(Material.AIR);
            l.setY(l.getY() + 1);
        }
    }
}
