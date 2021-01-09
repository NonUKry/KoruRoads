package rip.koru.roads.cleaning;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import rip.koru.roads.cache.CacheManager;
import rip.koru.roads.manager.RoadsManager;
import rip.koru.roads.utils.CC;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * Developed by FxMxGRAGFX
 * Project: KoruRoads
 **/

public class NorthC {

    public static void start(Player player) {
        long initTime = System.currentTimeMillis();
        Bukkit.broadcastMessage(CC.GREEN + "Starting the road NORTH cleaning!");
        HashMap<String, Integer> playerCache = CacheManager.getCache().get(player);
        int width = playerCache.get("width");
        int distance = (playerCache.get("distance") / 2);
        double value = 0;
        //Aumento de Y
        for(int y = 0; y < 250; y++) {
            //Aumento de Z
            for (int z = -1; z > distance; z--) {
                //Aumento de X
                for (int x = 0; x < width; x++) {
                    Location block = new Location(player.getWorld(), x, y, z);
                    //Verificacion de bloques basura
                    for(Material m : RoadsManager.prohibited) {
                        if(block.getBlock().getType() == m) {
                            block.getBlock().setType(Material.AIR);
                        }
                    }
                }
                //Reduccion de X
                for (int x = -0; x > -width; x--) {
                    Location block = new Location(player.getWorld(), x, y, z);
                    //Verificacion de bloques basura
                    for(Material m : RoadsManager.prohibited) {
                        if(block.getBlock().getType() == m) {
                            block.getBlock().setType(Material.AIR);
                        }
                    }
                }
            }
            value = Math.abs(((double)y * 100.00D / 250.00D));
            Bukkit.broadcastMessage(CC.GREEN + "Cleaning the road NORTH (" + new DecimalFormat("##.##").format((value)) + "%)");
        }
        if(value != 100.00D) {
            Bukkit.broadcastMessage(CC.GREEN + "Cleaning the road NORTH (100%)");
        }
        Bukkit.broadcastMessage(CC.GREEN + "The NORTH road has been successfully cleared in " + (double) TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - initTime) + " secconds!");
    }
}
