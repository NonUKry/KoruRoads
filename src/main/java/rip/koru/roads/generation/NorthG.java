package rip.koru.roads.generation;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.material.Stairs;

/**
 * Developed by FxMxGRAGFX
 * Project: KoruRoads
 **/

public class NorthG {


    public static void adapt(Location l, Material block) {

    }

    private static void buildPilar(Location l) {
        l.setY(l.getY() + 1);
        l.getBlock().setType(Material.COBBLESTONE);
        l.setY(l.getY() + 1);
        l.getBlock().setType(Material.COBBLESTONE);
        l.setY(l.getY() + 1);
        l.getBlock().setType(Material.COBBLESTONE);
        l.setY(l.getY() + 1);
        l.getBlock().setType(Material.COBBLESTONE);
        l.setY(l.getY() + 1);
        l.getBlock().setType(Material.COBBLESTONE);
        l.setZ(l.getZ() - 1);
        l.getBlock().setType(Material.COBBLESTONE_STAIRS);
        Block b1 = l.getBlock();
        BlockState state1 = b1.getState();
        Stairs stairs1 = (Stairs) state1.getData();
        stairs1.setFacingDirection(BlockFace.SOUTH);
        stairs1.setInverted(true);
        state1.update(false, false);

        l.setZ(l.getZ() + 2);
        l.getBlock().setType(Material.COBBLESTONE_STAIRS);
        Block b2 = l.getBlock();
        BlockState state2 = b2.getState();
        Stairs stairs2 = (Stairs) state2.getData();
        stairs2.setFacingDirection(BlockFace.NORTH);
        stairs2.setInverted(true);
        state2.update(false, false);
    }

    public static void placeSlab(Location l) {
        l.setY(l.getY() - 1);
        l.setZ(l.getZ() + 2);
        l.getBlock().setType(Material.STEP);
    }

    public static void breackUp(Location l) {
        l.setY(l.getY() + 1);
        while (l.getBlock().getType() != Material.AIR) {
            l.getBlock().setType(Material.AIR);
            l.setY(l.getY() + 1);
        }
    }

    public static void buildStair(Location l, Material block) {
        //Hacia S
        l.setZ(l.getZ() + 1);
        breackUp(l);
        l.getBlock().setType(block);
        l.setZ(l.getZ() + 1);
        breackUp(l);
        l.getBlock().setType(block);
        l.setZ(l.getZ() + 1);
        l.getBlock().setType(block);
        l.setZ(l.getZ() + 1);
        l.getBlock().setType(block);
        l.setZ(l.getZ() + 1);
        l.getBlock().setType(block);
        l.setZ(l.getZ() + 1);
        l.getBlock().setType(block);
        l.setZ(l.getZ() + 1);
        l.getBlock().setType(block);
        l.setZ(l.getZ() + 1);
        l.getBlock().setType(block);
        l.setZ(l.getZ() + 1);
        l.getBlock().setType(block);
        l.setZ(l.getZ() + 1);
        l.getBlock().setType(block);
        l.setZ(l.getZ() + 1);
        l.getBlock().setType(block);
        l.setZ(l.getZ() + 1);
        l.getBlock().setType(block);
        l.setY(l.getY() + 1);
        l.getBlock().setType(block);
        l.setZ(l.getZ() - 1);
        l.getBlock().setType(block);
        l.setZ(l.getZ() - 1);
        l.getBlock().setType(block);
        l.setZ(l.getZ() - 1);
        l.getBlock().setType(block);
        l.setZ(l.getZ() - 1);
        l.getBlock().setType(block);
        l.setZ(l.getZ() - 1);
        l.getBlock().setType(block);
        l.setZ(l.getZ() - 1);
        l.getBlock().setType(block);
        l.setZ(l.getZ() - 1);
        l.getBlock().setType(block);
        l.setZ(l.getZ() - 1);
        l.getBlock().setType(block);
        l.setZ(l.getZ() - 1);
        l.getBlock().setType(block);
        l.setY(l.getY() + 1);
        l.setZ(l.getZ() + 2);
        l.getBlock().setType(block);
        l.setZ(l.getZ() + 1);
        l.getBlock().setType(block);
        l.setZ(l.getZ() + 1);
        l.getBlock().setType(block);
        l.setZ(l.getZ() + 1);
        l.getBlock().setType(block);
        l.setZ(l.getZ() + 1);
        l.getBlock().setType(block);
        l.setZ(l.getZ() + 1);
        l.getBlock().setType(block);
        l.setZ(l.getZ() + 1);
        l.getBlock().setType(block);
        l.setZ(l.getZ() + 1);
        l.getBlock().setType(block);
        l.setY(l.getY() + 1);
        l.getBlock().setType(block);
        l.setZ(l.getZ() - 1);
        l.getBlock().setType(block);
        l.setZ(l.getZ() - 1);
        l.getBlock().setType(block);
        l.setZ(l.getZ() - 1);
        l.getBlock().setType(block);
        l.setZ(l.getZ() - 1);
        l.getBlock().setType(block);
        l.setZ(l.getZ() - 1);
        l.getBlock().setType(block);
        l.setY(l.getY() + 1);
        l.setZ(l.getZ() + 2);
        l.getBlock().setType(block);
        l.setZ(l.getZ() + 1);
        l.getBlock().setType(block);
        l.setZ(l.getZ() + 1);
        l.getBlock().setType(block);
        l.setZ(l.getZ() + 1);
        l.getBlock().setType(block);
        l.setY(l.getY() + 1);
        l.getBlock().setType(block);
        l.setZ(l.getZ() - 1);
        l.getBlock().setType(block);

    }
}
