package rip.koru.roads.manager;

import com.boydti.fawe.wrappers.LocationMaskedPlayerWrapper;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;
import org.bukkit.material.Stairs;
import rip.koru.roads.cache.CacheManager;
import rip.koru.roads.cleaning.EastC;
import rip.koru.roads.cleaning.NorthC;
import rip.koru.roads.cleaning.SouthC;
import rip.koru.roads.cleaning.WestC;
import rip.koru.roads.generation.EastG;
import rip.koru.roads.generation.NorthG;
import rip.koru.roads.generation.SouthG;
import rip.koru.roads.generation.WestG;
import rip.koru.roads.utils.CC;
import rip.koru.roads.utils.Utils;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Developed by FxMxGRAGFX
 * Project: KoruRoads
 **/

public class RoadGenerator {

    public static void startClean(Player player) {
        long initTime = System.currentTimeMillis();
        HashMap<String, Integer> playerCache = CacheManager.getCache().get(player);
        int max = playerCache.get("distancia");
        Location l = player.getLocation();
        Bukkit.broadcastMessage("Starting to clean all roads!");
        for(int i = 0; i < 250; i++) {
            double porcentaje = Math.abs(((double)i * 100.0 / (double)250)) ;
            Bukkit.broadcastMessage("Cleaning all roads: " + new DecimalFormat("##.##").format((porcentaje)) + "%");
            l.setY(i);
            SouthC.clean(player, l, max);
            NorthC.clean(player, l, max);
            WestC.clean(player, l, max);
            EastC.clean(player, l, max);
        }
        Bukkit.broadcastMessage(String.valueOf("All roads have been cleaned in " + TimeUnit.MILLISECONDS.toSeconds((System.currentTimeMillis() - initTime)) + " seconds!"));
    }

    public static void startGeneration(Player player, String[] blocks) {
        long m1 = System.currentTimeMillis();
        HashMap<String, Integer> playerCache = CacheManager.getCache().get(player);
        if(!CacheManager.getCache().containsKey(player)) {
            player.sendMessage(CC.RED + "Please first clear! /roadclear <anchura> <distancia>");
            return;
        }
        int max = playerCache.get("distancia");
        EastG.generate(player, max, blocks);
        NorthG.generate(player, max, blocks);
        SouthG.generate(player, max, blocks);
        WestG.generate(player, max, blocks);
        Bukkit.broadcastMessage(String.valueOf("All roads generated in " + (double)TimeUnit.MILLISECONDS.toSeconds((System.currentTimeMillis() - m1)) + " seconds! (" + max + " blocks)"));
    }

    public static List<Material> prohibited = Arrays.asList(
            Material.LEAVES,
            Material.LEAVES_2,
            Material.DEAD_BUSH,
            Material.LONG_GRASS,
            Material.YELLOW_FLOWER,
            Material.RED_ROSE,
            Material.BROWN_MUSHROOM,
            Material.RED_MUSHROOM,
            Material.WOOD,
            Material.LOG,
            Material.LOG_2,
            Material.CACTUS,
            Material.SUGAR_CANE,
            Material.SUGAR_CANE_BLOCK,
            Material.DOUBLE_PLANT,
            Material.IRON_FENCE,
            Material.FENCE,
            Material.FENCE_GATE,
            Material.SAPLING,
            Material.SNOW_BLOCK,
            Material.SNOW,
            Material.WATER_LILY,
            Material.VINE,
            Material.HUGE_MUSHROOM_1,
            Material.HUGE_MUSHROOM_2
    );

    public static Location topBlock(Player player, int x, int z) {
        Location location = new Location(player.getWorld(), x, 100, z);
        World world = player.getWorld();
        Block toReplace = player.getWorld().getHighestBlockAt(location);
        Block blockBelow = world.getBlockAt(new Location(world, toReplace.getX(), toReplace.getY() - 1, toReplace.getZ()));
        return blockBelow.getLocation();
    }
}
