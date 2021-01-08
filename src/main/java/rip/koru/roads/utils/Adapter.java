package rip.koru.roads.utils;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

/**
 * Developed by FxMxGRAGFX
 * Project: KoruRoads
 **/

public class Adapter {
    
    public static void adapt(Player player, RoadDirection direction) {
        if(direction == RoadDirection.NORHT) {
            north(player);
        }
    }

    /*
     * Todo lo relacionado con el norte
     */

    //Metodo main del norte
    private static void north(Player player) {
        //Reducción de Z
        //Adaptar teniendo en mente que debe de estar invertido
        north1(player);
        north2(player);
    }

    //Adaptar a altura especifica
    private static void north1(Player player) {
        Location l = player.getLocation();
        l.setZ(l.getZ() - 1);
        l.setY(l.getY() + 2);
        while(l.getBlock().getType() != Material.AIR) {
            StructureUtils.breackUp(l);
            l.setY(l.getY() + 1);
        }
    }

    //Rellenar espacios vacios
    private static void north2(Player player) {
        Location l = player.getLocation();
        l.setZ(l.getZ() - 2);
        l.setY(l.getY() + 1);
        if(l.getBlock().getType() != Material.AIR) {
            l.setY(l.getY() - 1);
            l.setZ(l.getZ() - 1);
            l.getBlock().setType(Material.COBBLESTONE);
        }
    }
}
