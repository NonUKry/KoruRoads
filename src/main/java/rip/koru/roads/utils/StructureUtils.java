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

    public static void placeBedrock(Location bedrock) {
        bedrock.setY(bedrock.getY() - 1);
        bedrock.getBlock().setType(Material.BEDROCK);
        bedrock.setY(bedrock.getY() - 1);
        bedrock.getBlock().setType(Material.BEDROCK);
        bedrock.setY(bedrock.getY() - 1);
        bedrock.getBlock().setType(Material.BEDROCK);
        bedrock.setY(bedrock.getY() - 1);
        bedrock.getBlock().setType(Material.BEDROCK);
        bedrock.setY(bedrock.getY() - 1);
        bedrock.getBlock().setType(Material.BEDROCK);
    }
}
