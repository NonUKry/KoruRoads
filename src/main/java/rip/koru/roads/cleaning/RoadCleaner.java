package rip.koru.roads.cleaning;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import rip.koru.roads.KoruRoads;
import rip.koru.roads.cache.CacheManager;
import rip.koru.roads.manager.RoadsManager;
import rip.koru.roads.utils.CC;

import java.text.DecimalFormat;
import java.util.HashMap;

/**
 * Developed by FxMxGRAGFX
 * Project: KoruRoads
 **/

public class RoadCleaner extends BukkitRunnable {

    private final Player player;
    private String[] blocks;
    HashMap<String, Integer> playerCache;
    int distance;
    int width;
    double value;

    public RoadCleaner(Player player) {
        this.player = player;
        playerCache = CacheManager.getCache().get(player);
        distance = (playerCache.get("distance") - 1);
        width = (playerCache.get("width") + 3);
    }

    @Override
    public void run() {
        new NorthCleaner(0).runTaskTimer(KoruRoads.getInstance(),0L, 2L);
        new SouthCleaner(0).runTaskTimer(KoruRoads.getInstance(),0L, 2L);
        new WestCleaner(0).runTaskTimer(KoruRoads.getInstance(),0L, 2L);
        new EastCleaner(0).runTaskTimer(KoruRoads.getInstance(),0L, 2L);
    }

    private class NorthCleaner extends BukkitRunnable {
        private int z;
        public NorthCleaner(int z) {
            this.z = z;
        }

        @Override
        public void run() {
            for(int y = 0; y < 250; y++) {
                for (int x = 0; x < width; x++) {
                    Location location = new Location(player.getWorld(), x,y,z);
                    for(Material m : RoadsManager.prohibited) {
                        if(location.getBlock().getType() == m) {
                            location.getBlock().setType(Material.AIR);
                        }
                    }
                }
                for (int x = -0; x > -width; x--) {
                    Location location = new Location(player.getWorld(), x,y,z);
                    for(Material m : RoadsManager.prohibited) {
                        if (location.getBlock().getType() == m) {
                            location.getBlock().setType(Material.AIR);
                        }
                    }
                }
            }
            z = z - 1;
            if(z < -distance) {
                cancel();
            }
        }
    }

    private class SouthCleaner extends BukkitRunnable {
        private int z;
        public SouthCleaner(int z) {
            this.z = z;
        }

        @Override
        public void run() {
            for(int y = 0; y < 250; y++) {
                for (int x = 0; x < width; x++) {
                    Location location = new Location(player.getWorld(), x,y,z);
                    for(Material m : RoadsManager.prohibited) {
                        if(location.getBlock().getType() == m) {
                            location.getBlock().setType(Material.AIR);
                        }
                    }
                }
                for (int x = -0; x > -width; x--) {
                    Location location = new Location(player.getWorld(), x,y,z);
                    for(Material m : RoadsManager.prohibited) {
                        if (location.getBlock().getType() == m) {
                            location.getBlock().setType(Material.AIR);
                        }
                    }
                }
            }
            z = z + 1;
            if(z > distance) {
                cancel();
            }
        }
    }

    private class EastCleaner extends BukkitRunnable {
        private int x;
        public EastCleaner(int x) {
            this.x = x;
        }

        @Override
        public void run() {
            for(int y = 0; y < 250; y++) {
                for (int z = 0; z < width; z++) {
                    Location location = new Location(player.getWorld(), x,y,z);
                    for(Material m : RoadsManager.prohibited) {
                        if(location.getBlock().getType() == m) {
                            location.getBlock().setType(Material.AIR);
                        }
                    }
                }
                for (int z = -0; z > -width; z--) {
                    Location location = new Location(player.getWorld(), x,y,z);
                    for(Material m : RoadsManager.prohibited) {
                        if (location.getBlock().getType() == m) {
                            location.getBlock().setType(Material.AIR);
                        }
                    }
                }
            }
            x = x + 1;
            if(x > distance) {
                cancel();
            }
        }
    }

    private class WestCleaner extends BukkitRunnable {
        private int x;
        int f = 0;
        public WestCleaner(int x) {
            this.x = x;
        }

        @Override
        public void run() {
            for(int y = 0; y < 250; y++) {
                for (int z = 0; z < width; z++) {
                    Location location = new Location(player.getWorld(), x,y,z);
                    for(Material m : RoadsManager.prohibited) {
                        if(location.getBlock().getType() == m) {
                            location.getBlock().setType(Material.AIR);
                        }
                    }
                }
                for (int z = -0; z > -width; z--) {
                    Location location = new Location(player.getWorld(), x,y,z);
                    for(Material m : RoadsManager.prohibited) {
                        if (location.getBlock().getType() == m) {
                            location.getBlock().setType(Material.AIR);
                        }
                    }
                }
            }
            x = x - 1;
            value = Math.abs(((double)x * 100.00D / (double) distance));
            if(value > 100D && value != 100D) {
                f++;
            } else {
                String v = new DecimalFormat("##.##").format((value));
                Bukkit.broadcastMessage(CC.GREEN + "Cleaning all roads (" + v + "%)");
            }
            if(f == 1) {
                Bukkit.broadcastMessage(CC.GREEN + "Successfully cleaned all roads!");
            }
            if(x < -distance) {
                cancel();
            }
        }
    }
}
