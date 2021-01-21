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

public class EastG {


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
        l.setX(l.getX() - 1);
        l.getBlock().setType(Material.COBBLESTONE_STAIRS);
        Block b1 = l.getBlock();
        BlockState state1 = b1.getState();
        Stairs stairs1 = (Stairs) state1.getData();
        stairs1.setFacingDirection(BlockFace.EAST);
        stairs1.setInverted(true);
        state1.update(false, false);

        l.setX(l.getX() + 2);
        l.getBlock().setType(Material.COBBLESTONE_STAIRS);
        Block b2 = l.getBlock();
        BlockState state2 = b2.getState();
        Stairs stairs2 = (Stairs) state2.getData();
        stairs2.setFacingDirection(BlockFace.WEST);
        stairs2.setInverted(true);
        state2.update(false, false);
    }
}
