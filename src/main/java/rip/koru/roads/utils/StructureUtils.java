package rip.koru.roads.utils;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

/**
 * Developed by FxMxGRAGFX
 * Project: KoruRoads
 **/

public class StructureUtils {

    public static void breackUp(Location l) {
        while (l.getBlock().getY() != 250D) {
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

    public static Location topBlock(Player player, int x, int z) {
        Location location = new Location(player.getWorld(), x, 100, z);
        World world = player.getWorld();
        Block toReplace = player.getWorld().getHighestBlockAt(location);
        Block blockBelow = world.getBlockAt(new Location(world, toReplace.getX(), toReplace.getY() - 1, toReplace.getZ()));
        return blockBelow.getLocation();
    }
}
