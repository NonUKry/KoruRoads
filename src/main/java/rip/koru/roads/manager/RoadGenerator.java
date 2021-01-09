package rip.koru.roads.manager;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import rip.koru.roads.cache.CacheManager;
import rip.koru.roads.generation.EastG;
import rip.koru.roads.generation.NorthG;
import rip.koru.roads.generation.SouthG;
import rip.koru.roads.generation.WestG;
import rip.koru.roads.utils.CC;

import java.text.DecimalFormat;
import java.util.HashMap;
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
        }
        Bukkit.broadcastMessage("All roads have been cleaned in " + TimeUnit.MILLISECONDS.toSeconds((System.currentTimeMillis() - initTime)) + " seconds!");
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
        Bukkit.broadcastMessage("All roads generated in " + (double) TimeUnit.MILLISECONDS.toSeconds((System.currentTimeMillis() - m1)) + " seconds! (" + max + " blocks)");
    }



    public static Location topBlock(Player player, int x, int z) {
        Location location = new Location(player.getWorld(), x, 100, z);
        World world = player.getWorld();
        Block toReplace = player.getWorld().getHighestBlockAt(location);
        Block blockBelow = world.getBlockAt(new Location(world, toReplace.getX(), toReplace.getY() - 1, toReplace.getZ()));
        return blockBelow.getLocation();
    }
}
