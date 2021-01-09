package rip.koru.roads.utils;

import org.bukkit.Location;
import org.bukkit.Material;

/**
 * Developed by FxMxGRAGFX
 * Project: KoruRoads
 **/

public class Adapter {
    
    public static void adapt(Location l, RoadDirection direction) {
        if(direction == RoadDirection.NORHT) {
            north(l);
        }
        if(direction == RoadDirection.SOUTH) {
            south(l);
        }
        if(direction == RoadDirection.WHEST) {
            west(l);
        }
        if(direction == RoadDirection.EAST) {
            east(l);
        }
    }

    /*
     * Todo lo relacionado con el norte
     */

    //Metodo main del norte
    private static void north(Location l) {
        //Reducción de Z
        //Adaptar teniendo en mente que debe de estar invertido
        north1(l);
        north2(l);
    }

    private static void south(Location l) {
        //Reducción de Z
        //Adaptar teniendo en mente que debe de estar invertido
        south1(l);
        south2(l);
    }

    private static void east(Location l) {
        //Reducción de Z
        //Adaptar teniendo en mente que debe de estar invertido
        east1(l);
        east2(l);
    }

    private static void west(Location l) {
        //Reducción de Z
        //Adaptar teniendo en mente que debe de estar invertido
        west1(l);
        west2(l);
    }

    //Adaptar a altura especifica
    private static void north1(Location l) {
        l.setZ(l.getZ() - 1);
        l.setY(l.getY() + 2);
        while(l.getBlock().getType() != Material.AIR) {
            StructureUtils.breackUp(l);
            l.setY(l.getY() + 1);
        }
    }

    //Adaptar para las lozas
    private static void north2(Location l) {
        l.setY(l.getY() + 1);
        l.setZ(l.getZ() - 2);
        if(l.getBlock().getType() != Material.AIR) {
            l.setZ(l.getZ() + 1);
            l.getBlock().setType(Material.AIR);
        }
    }


    //Adaptar a altura especifica
    private static void south1(Location l) {
        l.setZ(l.getZ() + 1);
        l.setY(l.getY() + 2);
        while(l.getBlock().getType() != Material.AIR) {
            StructureUtils.breackUp(l);
            l.setY(l.getY() + 1);
        }
    }

    //Adaptar para las lozas
    private static void south2(Location l) {
        l.setY(l.getY() + 1);
        l.setZ(l.getZ() + 2);
        if(l.getBlock().getType() != Material.AIR) {
            l.setZ(l.getZ() - 1);
            l.getBlock().setType(Material.AIR);
        }
    }

    //Adaptar a altura especifica
    private static void west1(Location l) {
        l.setX(l.getX() - 1);
        l.setY(l.getY() + 2);
        while(l.getBlock().getType() != Material.AIR) {
            StructureUtils.breackUp(l);
            l.setY(l.getY() + 1);
        }
    }

    //Adaptar para las lozas
    private static void west2(Location l) {
        l.setY(l.getY() + 1);
        l.setX(l.getX() - 2);
        if(l.getBlock().getType() != Material.AIR) {
            l.setZ(l.getZ() + 1);
            l.getBlock().setType(Material.AIR);
        }
    }

    //Adaptar a altura especifica
    private static void east1(Location l) {
        l.setX(l.getX() + 1);
        l.setY(l.getY() + 2);
        while(l.getBlock().getType() != Material.AIR) {
            StructureUtils.breackUp(l);
            l.setY(l.getY() + 1);
        }
    }

    //Adaptar para las lozas
    private static void east2(Location l) {
        l.setY(l.getY() + 1);
        l.setX(l.getX() + 2);
        if(l.getBlock().getType() != Material.AIR) {
            l.setZ(l.getZ() + 1);
            l.getBlock().setType(Material.AIR);
        }
    }
}
