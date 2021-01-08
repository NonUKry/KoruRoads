package rip.koru.roads.generation;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;
import org.bukkit.material.Stairs;
import rip.koru.roads.manager.RoadGenerator;
import rip.koru.roads.utils.Utils;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * Developed by FxMxGRAGFX
 * Project: KoruRoads
 **/

public class SouthG {

    public static void generate(Player player, int max, String[] blocks) {
        int y = 100;
        long m1 = System.currentTimeMillis();
        for (int z = 0; z < max; z++) {
            for (int x = 0; x < 5; x++) {
                Location blockTop = RoadGenerator.topBlock(player, x, z);
                HashMap<Integer, Material> mats = new HashMap<Integer, Material>();
                for(String s : blocks) {
                    Material type = Material.getMaterial(Integer.parseInt(s));
                    mats.put(mats.size() + 1, type);
                }
                blockTop.getBlock().setType(mats.get(Utils.getRandomNumber(1, mats.size() + 1)));
                buildBedrock(blockTop);

            }
            for (int x = -0; x > -5; x--) {
                Location blockTop = RoadGenerator.topBlock(player, x, z);
                HashMap<Integer, Material> mats = new HashMap<Integer, Material>();
                for(String s : blocks) {
                    Material type = Material.getMaterial(Integer.parseInt(s));
                    mats.put(mats.size() + 1, type);
                }
                blockTop.getBlock().setType(mats.get(Utils.getRandomNumber(1, mats.size() + 1)));
                buildBedrock(blockTop);
            }
            double porcentaje = Math.abs(((double)z * 100.0 / (double)max)) ;
            Bukkit.broadcastMessage("Generating the road SOUTH: " + new DecimalFormat("##.##").format((porcentaje)) + "%");
        }
        Bukkit.broadcastMessage("Road SOUTH generated successfully in " + (double) TimeUnit.MILLISECONDS.toSeconds((System.currentTimeMillis() - m1)) + " seconds!");
    }

    public static void breakWall(Location l) {
        Location ll = l;
        l.setZ(l.getZ() + 1);
        ll.setZ(ll.getZ() + 1);
        ll.setY(ll.getY() + 2);
        while (ll.getBlock().getType() != Material.AIR) {
            ll.getBlock().setType(Material.AIR);
            ll.setY(ll.getY() + 1);
            System.out.println(Utils.LocationToReadableString(ll));
        }
    }

    public static void buildSlabs(Location l) {
        //Solo si es jugador
        l.setY(l.getY() - 1);
        l.setZ(l.getZ() - 1);
        if(l.getBlock().getType() == Material.COBBLESTONE) {
            l.setZ(l.getZ() - 2);
            if(l.getBlock().getType() != Material.COBBLESTONE) {
                l.setZ(l.getZ() + 1);
                l.getBlock().setType(Material.STEP);
            } else {
                l.setZ(l.getZ() + 1);
                l.getBlock().setType(Material.COBBLESTONE);
            }
        }
    }

    private static void buildBedrock(Location bedrock) {
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
}
