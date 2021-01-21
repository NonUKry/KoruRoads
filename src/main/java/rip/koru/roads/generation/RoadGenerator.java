package rip.koru.roads.generation;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import rip.koru.roads.KoruRoads;
import rip.koru.roads.cache.CacheManager;
import rip.koru.roads.utils.CC;
import rip.koru.roads.utils.StructureUtils;
import rip.koru.roads.utils.Utils;

import java.text.DecimalFormat;
import java.util.HashMap;

/**
 * Developed by FxMxGRAGFX
 * Project: KoruRoads
 **/

public class RoadGenerator extends BukkitRunnable {

    private final Player player;
    private final String[] blocks;
    private final Location pLocation;
    HashMap<String, Integer> playerCache;
    int distance;
    int width;
    int height;

    public RoadGenerator(Player player, String[] blocks) {
        this.player = player;
        this.blocks = blocks;
        this.pLocation = player.getLocation();
        playerCache = CacheManager.getCache().get(player);
        distance = (playerCache.get("distance") - 1);
        width = (playerCache.get("width") + 1);
        height = (playerCache.get("height") + 1);
    }

    @Override
    public void run() {
        new GenerateNorth().runTaskTimer(KoruRoads.getInstance(), 0L, 3L);
        new GenerateSouth().runTaskTimer(KoruRoads.getInstance(), 0L, 3L);
        new GenerateEast().runTaskTimer(KoruRoads.getInstance(), 0L, 3L);
        new GenerateWest().runTaskTimer(KoruRoads.getInstance(), 0L, 3L);
    }

    private class GenerateNorth extends BukkitRunnable {
        int z = -0;

        @Override
        public void run() {
            for (int x = 0; x < width; x++) {
                Material selected = getMaterial();
                Location lS = StructureUtils.topBlock(player, 0, 0);
                Location h1 = StructureUtils.topBlock(player, x, z);
                //Abajo
                if (h1.getY() < (lS.getY() - height)) {
                    h1.setY((lS.getY() - height));
                    Location sH1 = h1;
                    h1.setY(h1.getY() + 1);
                    StructureUtils.breackUp(h1);
                    sH1.getBlock().setType(selected);
                }
                //Arroba
                Location h2 = StructureUtils.topBlock(player, x, z);
                if (h2.getY() > (lS.getY() + height)) {
                    h2.setY(lS.getY() + height);
                    Location sH2 = h2;
                    h2.setY(h2.getY() + 1);
                    StructureUtils.breackUp(h2);
                    sH2.getBlock().setType(selected);
                }
                //Adaptacion enfrente
                Location lA = StructureUtils.topBlock(player, x, z);
                lA.setZ(lA.getZ() - 1);
                lA.setY(lA.getY() + 1);
                if (lA.getBlock().getType() != Material.AIR) {
                    lA.setY(lA.getY() + 1);
                    StructureUtils.breackUp(lA);
                    Location lA2 = StructureUtils.topBlock(player, x, z);
                    lA2.setZ(lA2.getZ() - 2);
                    lA2.setY(lA2.getY() + 2);
                    StructureUtils.breackUp(lA2);
                }
                //Adaptacion atras
                Location lA4 = StructureUtils.topBlock(player, x, z);
                lA4.setZ(lA4.getZ() + 1);
                lA4.setY(lA4.getY() + 1);
                if (lA4.getBlock().getType() != Material.AIR) {
                    lA4.setY(lA4.getY() + 1);
                    StructureUtils.breackUp(lA4);
                    Location lA2 = StructureUtils.topBlock(player, x, z);
                    lA2.setZ(lA2.getZ() + 2);
                    lA2.setY(lA2.getY() + 2);
                    StructureUtils.breackUp(lA2);
                }
                //Slabs enfrente
                Location l1 = StructureUtils.topBlock(player, x, z);
                Location sL1 = l1;
                l1.setZ(l1.getZ() - 1);
                l1.setY(l1.getY() + 1);
                if (l1.getBlock().getType() != Material.AIR) {
                    sL1.setZ(sL1.getZ() + 2);
                    if (sL1.getBlock().getType() != Material.AIR) {
                        sL1.setZ(sL1.getZ() - 1);
                        sL1.getBlock().setType(selected);
                    } else {
                        sL1.setZ(sL1.getZ() - 1);
                        sL1.getBlock().setType(Material.STEP);
                        sL1.getBlock().setData((byte) 0);
                    }
                }
                //Slabs atras
                Location l2 = StructureUtils.topBlock(player, x, z);
                Location sL2 = l2;
                l2.setZ(l2.getZ() + 1);
                l2.setY(l2.getY() + 1);
                if (l2.getBlock().getType() != Material.AIR && l2.getBlock().getType() != Material.STEP) {
                    sL2.setZ(sL2.getZ() - 2);
                    if (sL2.getBlock().getType() != Material.AIR) {
                        sL2.setZ(sL2.getZ() + 1);
                        sL2.getBlock().setType(selected);
                    } else {
                        sL2.setZ(sL2.getZ() + 1);
                        sL2.getBlock().setType(Material.STEP);
                        sL2.getBlock().setData((byte) 0);
                    }
                }
                //Remplazar por bloques finales
                Location l3 = StructureUtils.topBlock(player, x, z);
                if (l3.getBlock().getType() != Material.STEP) {
                    l3.getBlock().setType(selected);
                }
                //Bedrock
                Location lB = StructureUtils.topBlock(player, x, z);
                lB.setY(lB.getY() - 1);
                lB.getBlock().setType(Material.BEDROCK);
                lB.setY(lB.getY() - 1);
                lB.getBlock().setType(Material.BEDROCK);
                lB.setY(lB.getY() - 1);
                lB.getBlock().setType(Material.BEDROCK);
                lB.setY(lB.getY() - 1);
                lB.getBlock().setType(Material.BEDROCK);
                lB.setY(lB.getY() - 1);
                lB.getBlock().setType(Material.BEDROCK);
            }
            for (int x = -0; x > -width; x--) {
                Material selected = getMaterial();
                Location lS = StructureUtils.topBlock(player, 0, 0);
                Location h1 = StructureUtils.topBlock(player, x, z);
                //Abajo
                if (h1.getY() < (lS.getY() - height)) {
                    h1.setY((lS.getY() - height));
                    Location sH1 = h1;
                    h1.setY(h1.getY() + 1);
                    StructureUtils.breackUp(h1);
                    sH1.getBlock().setType(selected);
                }
                //Arroba
                Location h2 = StructureUtils.topBlock(player, x, z);
                if (h2.getY() > (lS.getY() + height)) {
                    h2.setY(lS.getY() + height);
                    Location sH2 = h2;
                    h2.setY(h2.getY() + 1);
                    StructureUtils.breackUp(h2);
                    sH2.getBlock().setType(selected);
                }
                //Adaptacion enfrente
                Location lA = StructureUtils.topBlock(player, x, z);
                lA.setZ(lA.getZ() - 1);
                lA.setY(lA.getY() + 1);
                if (lA.getBlock().getType() != Material.AIR) {
                    lA.setY(lA.getY() + 1);
                    StructureUtils.breackUp(lA);
                    Location lA2 = StructureUtils.topBlock(player, x, z);
                    lA2.setZ(lA2.getZ() - 2);
                    lA2.setY(lA2.getY() + 2);
                    StructureUtils.breackUp(lA2);
                }
                //Adaptacion atras
                Location lA4 = StructureUtils.topBlock(player, x, z);
                lA4.setZ(lA4.getZ() + 1);
                lA4.setY(lA4.getY() + 1);
                if (lA4.getBlock().getType() != Material.AIR) {
                    lA4.setY(lA4.getY() + 1);
                    StructureUtils.breackUp(lA4);
                    Location lA2 = StructureUtils.topBlock(player, x, z);
                    lA2.setZ(lA2.getZ() + 2);
                    lA2.setY(lA2.getY() + 2);
                    StructureUtils.breackUp(lA2);
                }
                //Slabs enfrente
                Location l1 = StructureUtils.topBlock(player, x, z);
                Location sL1 = l1;
                l1.setZ(l1.getZ() - 1);
                l1.setY(l1.getY() + 1);
                if (l1.getBlock().getType() != Material.AIR) {
                    sL1.setZ(sL1.getZ() + 2);
                    if (sL1.getBlock().getType() != Material.AIR) {
                        sL1.setZ(sL1.getZ() - 1);
                        sL1.getBlock().setType(selected);
                    } else {
                        sL1.setZ(sL1.getZ() - 1);
                        sL1.getBlock().setType(Material.STEP);
                        sL1.getBlock().setData((byte) 0);
                    }
                }
                //Slabs atras
                Location l2 = StructureUtils.topBlock(player, x, z);
                Location sL2 = l2;
                l2.setZ(l2.getZ() + 1);
                l2.setY(l2.getY() + 1);
                if (l2.getBlock().getType() != Material.AIR && l2.getBlock().getType() != Material.STEP) {
                    sL2.setZ(sL2.getZ() - 2);
                    if (sL2.getBlock().getType() != Material.AIR) {
                        sL2.setZ(sL2.getZ() + 1);
                        sL2.getBlock().setType(selected);
                    } else {
                        sL2.setZ(sL2.getZ() + 1);
                        sL2.getBlock().setType(Material.STEP);
                        sL2.getBlock().setData((byte) 0);
                    }
                }
                //Remplazar por bloques finales
                Location l3 = StructureUtils.topBlock(player, x, z);
                if (l3.getBlock().getType() != Material.STEP) {
                    l3.getBlock().setType(selected);
                }
                //Bedrock
                Location lB = StructureUtils.topBlock(player, x, z);
                lB.setY(lB.getY() - 1);
                lB.getBlock().setType(Material.BEDROCK);
                lB.setY(lB.getY() - 1);
                lB.getBlock().setType(Material.BEDROCK);
                lB.setY(lB.getY() - 1);
                lB.getBlock().setType(Material.BEDROCK);
                lB.setY(lB.getY() - 1);
                lB.getBlock().setType(Material.BEDROCK);
                lB.setY(lB.getY() - 1);
                lB.getBlock().setType(Material.BEDROCK);
            }
            z = z - 1;
            if (z < -distance) {
                cancel();
            }
        }
    }

    private class GenerateSouth extends BukkitRunnable {
        int z = 0;

        @Override
        public void run() {
            for (int x = 0; x < width; x++) {
                Material selected = getMaterial();
                Location lS = StructureUtils.topBlock(player, 0, 0);
                Location h1 = StructureUtils.topBlock(player, x, z);
                //Abajo
                if (h1.getY() < (lS.getY() - height)) {
                    h1.setY((lS.getY() - height));
                    Location sH1 = h1;
                    h1.setY(h1.getY() + 1);
                    StructureUtils.breackUp(h1);
                    sH1.getBlock().setType(selected);
                }
                //Arroba
                Location h2 = StructureUtils.topBlock(player, x, z);
                if (h2.getY() > (lS.getY() + height)) {
                    h2.setY(lS.getY() + height);
                    Location sH2 = h2;
                    h2.setY(h2.getY() + 1);
                    StructureUtils.breackUp(h2);
                    sH2.getBlock().setType(selected);
                }
                //Adaptacion enfrente
                Location lA = StructureUtils.topBlock(player, x, z);
                lA.setZ(lA.getZ() + 1);
                lA.setY(lA.getY() + 1);
                if (lA.getBlock().getType() != Material.AIR) {
                    lA.setY(lA.getY() + 1);
                    StructureUtils.breackUp(lA);
                    Location lA2 = StructureUtils.topBlock(player, x, z);
                    lA2.setZ(lA2.getZ() + 2);
                    lA2.setY(lA2.getY() + 2);
                    StructureUtils.breackUp(lA2);
                }
                //Adaptacion atras
                Location lA4 = StructureUtils.topBlock(player, x, z);
                lA4.setZ(lA4.getZ() - 1);
                lA4.setY(lA4.getY() + 1);
                if (lA4.getBlock().getType() != Material.AIR) {
                    lA4.setY(lA4.getY() + 1);
                    StructureUtils.breackUp(lA4);
                    Location lA2 = StructureUtils.topBlock(player, x, z);
                    lA2.setZ(lA2.getZ() - 2);
                    lA2.setY(lA2.getY() + 2);
                    StructureUtils.breackUp(lA2);
                }
                //Slabs enfrente
                Location l1 = StructureUtils.topBlock(player, x, z);
                Location sL1 = l1;
                l1.setZ(l1.getZ() + 1);
                l1.setY(l1.getY() + 1);
                if (l1.getBlock().getType() != Material.AIR) {
                    sL1.setZ(sL1.getZ() - 2);
                    if (sL1.getBlock().getType() != Material.AIR) {
                        sL1.setZ(sL1.getZ() + 1);
                        sL1.getBlock().setType(selected);
                    } else {
                        sL1.setZ(sL1.getZ() + 1);
                        sL1.getBlock().setType(Material.STEP);
                        sL1.getBlock().setData((byte) 0);
                    }
                }
                //Slabs atras
                Location l2 = StructureUtils.topBlock(player, x, z);
                Location sL2 = l2;
                l2.setZ(l2.getZ() - 1);
                l2.setY(l2.getY() + 1);
                if (l2.getBlock().getType() != Material.AIR && l2.getBlock().getType() != Material.STEP) {
                    sL2.setZ(sL2.getZ() + 2);
                    if (sL2.getBlock().getType() != Material.AIR) {
                        sL2.setZ(sL2.getZ() - 1);
                        sL2.getBlock().setType(selected);
                    } else {
                        sL2.setZ(sL2.getZ() - 1);
                        sL2.getBlock().setType(Material.STEP);
                        sL2.getBlock().setData((byte) 0);
                    }
                }
                //Remplazar por bloques finales
                Location l3 = StructureUtils.topBlock(player, x, z);
                if (l3.getBlock().getType() != Material.STEP) {
                    l3.getBlock().setType(selected);
                }
                //Bedrock
                Location lB = StructureUtils.topBlock(player, x, z);
                lB.setY(lB.getY() - 1);
                lB.getBlock().setType(Material.BEDROCK);
                lB.setY(lB.getY() - 1);
                lB.getBlock().setType(Material.BEDROCK);
                lB.setY(lB.getY() - 1);
                lB.getBlock().setType(Material.BEDROCK);
                lB.setY(lB.getY() - 1);
                lB.getBlock().setType(Material.BEDROCK);
                lB.setY(lB.getY() - 1);
                lB.getBlock().setType(Material.BEDROCK);
            }
            for (int x = -0; x > -width; x--) {
                Material selected = getMaterial();
                Location lS = StructureUtils.topBlock(player, 0, 0);
                Location h1 = StructureUtils.topBlock(player, x, z);
                //Abajo
                if (h1.getY() < (lS.getY() - height)) {
                    h1.setY((lS.getY() - height));
                    Location sH1 = h1;
                    h1.setY(h1.getY() + 1);
                    StructureUtils.breackUp(h1);
                    sH1.getBlock().setType(selected);
                }
                //Arroba
                Location h2 = StructureUtils.topBlock(player, x, z);
                if (h2.getY() > (lS.getY() + height)) {
                    h2.setY(lS.getY() + height);
                    Location sH2 = h2;
                    h2.setY(h2.getY() + 1);
                    StructureUtils.breackUp(h2);
                    sH2.getBlock().setType(selected);
                }
                //Adaptacion enfrente
                Location lA = StructureUtils.topBlock(player, x, z);
                lA.setZ(lA.getZ() + 1);
                lA.setY(lA.getY() + 1);
                if (lA.getBlock().getType() != Material.AIR) {
                    lA.setY(lA.getY() + 1);
                    StructureUtils.breackUp(lA);
                    Location lA2 = StructureUtils.topBlock(player, x, z);
                    lA2.setZ(lA2.getZ() + 2);
                    lA2.setY(lA2.getY() + 2);
                    StructureUtils.breackUp(lA2);
                }
                //Adaptacion atras
                Location lA4 = StructureUtils.topBlock(player, x, z);
                lA4.setZ(lA4.getZ() - 1);
                lA4.setY(lA4.getY() + 1);
                if (lA4.getBlock().getType() != Material.AIR) {
                    lA4.setY(lA4.getY() + 1);
                    StructureUtils.breackUp(lA4);
                    Location lA2 = StructureUtils.topBlock(player, x, z);
                    lA2.setZ(lA2.getZ() - 2);
                    lA2.setY(lA2.getY() + 2);
                    StructureUtils.breackUp(lA2);
                }
                //Slabs enfrente
                Location l1 = StructureUtils.topBlock(player, x, z);
                Location sL1 = l1;
                l1.setZ(l1.getZ() + 1);
                l1.setY(l1.getY() + 1);
                if (l1.getBlock().getType() != Material.AIR) {
                    sL1.setZ(sL1.getZ() - 2);
                    if (sL1.getBlock().getType() != Material.AIR) {
                        sL1.setZ(sL1.getZ() + 1);
                        sL1.getBlock().setType(selected);
                    } else {
                        sL1.setZ(sL1.getZ() + 1);
                        sL1.getBlock().setType(Material.STEP);
                        sL1.getBlock().setData((byte) 0);
                    }
                }
                //Slabs atras
                Location l2 = StructureUtils.topBlock(player, x, z);
                Location sL2 = l2;
                l2.setZ(l2.getZ() - 1);
                l2.setY(l2.getY() + 1);
                if (l2.getBlock().getType() != Material.AIR && l2.getBlock().getType() != Material.STEP) {
                    sL2.setZ(sL2.getZ() + 2);
                    if (sL2.getBlock().getType() != Material.AIR) {
                        sL2.setZ(sL2.getZ() - 1);
                        sL2.getBlock().setType(selected);
                    } else {
                        sL2.setZ(sL2.getZ() - 1);
                        sL2.getBlock().setType(Material.STEP);
                        sL2.getBlock().setData((byte) 0);
                    }
                }
                //Remplazar por bloques finales
                Location l3 = StructureUtils.topBlock(player, x, z);
                if (l3.getBlock().getType() != Material.STEP) {
                    l3.getBlock().setType(selected);
                }
                //Bedrock
                Location lB = StructureUtils.topBlock(player, x, z);
                lB.setY(lB.getY() - 1);
                lB.getBlock().setType(Material.BEDROCK);
                lB.setY(lB.getY() - 1);
                lB.getBlock().setType(Material.BEDROCK);
                lB.setY(lB.getY() - 1);
                lB.getBlock().setType(Material.BEDROCK);
                lB.setY(lB.getY() - 1);
                lB.getBlock().setType(Material.BEDROCK);
                lB.setY(lB.getY() - 1);
                lB.getBlock().setType(Material.BEDROCK);
            }
            z = z + 1;
            if (z > distance) {
                cancel();
            }
        }
    }
    private class GenerateEast extends BukkitRunnable {
        int x = 0;

        @Override
        public void run() {
            for (int z = 0; z < width; z++) {
                Material selected = getMaterial();
                Location lS = StructureUtils.topBlock(player, 0, 0);
                Location h1 = StructureUtils.topBlock(player, x, z);
                //Abajo
                if (h1.getY() < (lS.getY() - height)) {
                    h1.setY((lS.getY() - height));
                    Location sH1 = h1;
                    h1.setY(h1.getY() + 1);
                    StructureUtils.breackUp(h1);
                    sH1.getBlock().setType(selected);
                }
                //Arroba
                Location h2 = StructureUtils.topBlock(player, x, z);
                if (h2.getY() > (lS.getY() + height)) {
                    h2.setY(lS.getY() + height);
                    Location sH2 = h2;
                    h2.setY(h2.getY() + 1);
                    StructureUtils.breackUp(h2);
                    sH2.getBlock().setType(selected);
                }
                //Adaptacion enfrente
                Location lA = StructureUtils.topBlock(player, x, z);
                lA.setX(lA.getX() + 1);
                lA.setY(lA.getY() + 1);
                if (lA.getBlock().getType() != Material.AIR) {
                    lA.setY(lA.getY() + 1);
                    StructureUtils.breackUp(lA);
                    Location lA2 = StructureUtils.topBlock(player, x, z);
                    lA2.setX(lA2.getX() + 2);
                    lA2.setY(lA2.getY() + 2);
                    StructureUtils.breackUp(lA2);
                }
                //Adaptacion atras
                Location lA4 = StructureUtils.topBlock(player, x, z);
                lA4.setX(lA4.getX() - 1);
                lA4.setY(lA4.getY() + 1);
                if (lA4.getBlock().getType() != Material.AIR) {
                    lA4.setY(lA4.getY() + 1);
                    StructureUtils.breackUp(lA4);
                    Location lA2 = StructureUtils.topBlock(player, x, z);
                    lA2.setX(lA2.getX() - 2);
                    lA2.setY(lA2.getY() + 2);
                    StructureUtils.breackUp(lA2);
                }
                //Slabs enfrente
                Location l1 = StructureUtils.topBlock(player, x, z);
                Location sL1 = l1;
                l1.setX(l1.getX() + 1);
                l1.setY(l1.getY() + 1);
                if (l1.getBlock().getType() != Material.AIR) {
                    sL1.setX(sL1.getX() - 2);
                    if (sL1.getBlock().getType() != Material.AIR) {
                        sL1.setX(sL1.getX() + 1);
                        sL1.getBlock().setType(selected);
                    } else {
                        sL1.setX(sL1.getX() + 1);
                        sL1.getBlock().setType(Material.STEP);
                        sL1.getBlock().setData((byte) 0);
                    }
                }
                //Slabs atras
                Location l2 = StructureUtils.topBlock(player, x, z);
                Location sL2 = l2;
                l2.setX(l2.getX() - 1);
                l2.setY(l2.getY() + 1);
                if (l2.getBlock().getType() != Material.AIR && l2.getBlock().getType() != Material.STEP) {
                    sL2.setX(sL2.getX() + 2);
                    if (sL2.getBlock().getType() != Material.AIR) {
                        sL2.setX(sL2.getX() - 1);
                        sL2.getBlock().setType(selected);
                    } else {
                        sL2.setX(sL2.getX() - 1);
                        sL2.getBlock().setType(Material.STEP);
                        sL2.getBlock().setData((byte) 0);
                    }
                }
                //Remplazar por bloques finales
                Location l3 = StructureUtils.topBlock(player, x, z);
                if (l3.getBlock().getType() != Material.STEP) {
                    l3.getBlock().setType(selected);
                }
                //Bedrock
                Location lB = StructureUtils.topBlock(player, x, z);
                lB.setY(lB.getY() - 1);
                lB.getBlock().setType(Material.BEDROCK);
                lB.setY(lB.getY() - 1);
                lB.getBlock().setType(Material.BEDROCK);
                lB.setY(lB.getY() - 1);
                lB.getBlock().setType(Material.BEDROCK);
                lB.setY(lB.getY() - 1);
                lB.getBlock().setType(Material.BEDROCK);
                lB.setY(lB.getY() - 1);
                lB.getBlock().setType(Material.BEDROCK);
            }
            for (int z = -0; z > -width; z--) {
                Material selected = getMaterial();
                Location lS = StructureUtils.topBlock(player, 0, 0);
                Location h1 = StructureUtils.topBlock(player, x, z);
                //Abajo
                if (h1.getY() < (lS.getY() - height)) {
                    h1.setY((lS.getY() - height));
                    Location sH1 = h1;
                    h1.setY(h1.getY() + 1);
                    StructureUtils.breackUp(h1);
                    sH1.getBlock().setType(selected);
                }
                //Arroba
                Location h2 = StructureUtils.topBlock(player, x, z);
                if (h2.getY() > (lS.getY() + height)) {
                    h2.setY(lS.getY() + height);
                    Location sH2 = h2;
                    h2.setY(h2.getY() + 1);
                    StructureUtils.breackUp(h2);
                    sH2.getBlock().setType(selected);
                }
                //Adaptacion enfrente
                Location lA = StructureUtils.topBlock(player, x, z);
                lA.setX(lA.getX() + 1);
                lA.setY(lA.getY() + 1);
                if (lA.getBlock().getType() != Material.AIR) {
                    lA.setY(lA.getY() + 1);
                    StructureUtils.breackUp(lA);
                    Location lA2 = StructureUtils.topBlock(player, x, z);
                    lA2.setX(lA2.getX() + 2);
                    lA2.setY(lA2.getY() + 2);
                    StructureUtils.breackUp(lA2);
                }
                //Adaptacion atras
                Location lA4 = StructureUtils.topBlock(player, x, z);
                lA4.setX(lA4.getX() - 1);
                lA4.setY(lA4.getY() + 1);
                if (lA4.getBlock().getType() != Material.AIR) {
                    lA4.setY(lA4.getY() + 1);
                    StructureUtils.breackUp(lA4);
                    Location lA2 = StructureUtils.topBlock(player, x, z);
                    lA2.setX(lA2.getX() - 2);
                    lA2.setY(lA2.getY() + 2);
                    StructureUtils.breackUp(lA2);
                }
                //Slabs enfrente
                Location l1 = StructureUtils.topBlock(player, x, z);
                Location sL1 = l1;
                l1.setX(l1.getX() + 1);
                l1.setY(l1.getY() + 1);
                if (l1.getBlock().getType() != Material.AIR) {
                    sL1.setX(sL1.getX() - 2);
                    if (sL1.getBlock().getType() != Material.AIR) {
                        sL1.setX(sL1.getX() + 1);
                        sL1.getBlock().setType(selected);
                    } else {
                        sL1.setX(sL1.getX() + 1);
                        sL1.getBlock().setType(Material.STEP);
                        sL1.getBlock().setData((byte) 0);
                    }
                }
                //Slabs atras
                Location l2 = StructureUtils.topBlock(player, x, z);
                Location sL2 = l2;
                l2.setX(l2.getX() - 1);
                l2.setY(l2.getY() + 1);
                if (l2.getBlock().getType() != Material.AIR && l2.getBlock().getType() != Material.STEP) {
                    sL2.setX(sL2.getX() + 2);
                    if (sL2.getBlock().getType() != Material.AIR) {
                        sL2.setX(sL2.getX() - 1);
                        sL2.getBlock().setType(selected);
                    } else {
                        sL2.setX(sL2.getX() - 1);
                        sL2.getBlock().setType(Material.STEP);
                        sL2.getBlock().setData((byte) 0);
                    }
                }
                //Remplazar por bloques finales
                Location l3 = StructureUtils.topBlock(player, x, z);
                if (l3.getBlock().getType() != Material.STEP) {
                    l3.getBlock().setType(selected);
                }
                //Bedrock
                Location lB = StructureUtils.topBlock(player, x, z);
                lB.setY(lB.getY() - 1);
                lB.getBlock().setType(Material.BEDROCK);
                lB.setY(lB.getY() - 1);
                lB.getBlock().setType(Material.BEDROCK);
                lB.setY(lB.getY() - 1);
                lB.getBlock().setType(Material.BEDROCK);
                lB.setY(lB.getY() - 1);
                lB.getBlock().setType(Material.BEDROCK);
                lB.setY(lB.getY() - 1);
                lB.getBlock().setType(Material.BEDROCK);
            }
            x = x + 1;
            if (x > distance) {
                cancel();
            }
        }
    }

    private class GenerateWest extends BukkitRunnable {
        int x = -0;
        int f = 0;
        double value;

        @Override
        public void run() {
            for (int z = 0; z < width; z++) {
                Material selected = getMaterial();
                Location lS = StructureUtils.topBlock(player, 0, 0);
                Location h1 = StructureUtils.topBlock(player, x, z);
                //Abajo
                if (h1.getY() < (lS.getY() - height)) {
                    h1.setY((lS.getY() - height));
                    Location sH1 = h1;
                    h1.setY(h1.getY() + 1);
                    StructureUtils.breackUp(h1);
                    sH1.getBlock().setType(selected);
                }
                //Arroba
                Location h2 = StructureUtils.topBlock(player, x, z);
                if (h2.getY() > (lS.getY() + height)) {
                    h2.setY(lS.getY() + height);
                    Location sH2 = h2;
                    h2.setY(h2.getY() + 1);
                    StructureUtils.breackUp(h2);
                    sH2.getBlock().setType(selected);
                }
                //Adaptacion enfrente
                Location lA = StructureUtils.topBlock(player, x, z);
                lA.setX(lA.getX() - 1);
                lA.setY(lA.getY() + 1);
                if (lA.getBlock().getType() != Material.AIR) {
                    lA.setY(lA.getY() + 1);
                    StructureUtils.breackUp(lA);
                    Location lA2 = StructureUtils.topBlock(player, x, z);
                    lA2.setX(lA2.getX() - 2);
                    lA2.setY(lA2.getY() + 2);
                    StructureUtils.breackUp(lA2);
                }
                //Adaptacion atras
                Location lA4 = StructureUtils.topBlock(player, x, z);
                lA4.setX(lA4.getX() + 1);
                lA4.setY(lA4.getY() + 1);
                if (lA4.getBlock().getType() != Material.AIR) {
                    lA4.setY(lA4.getY() + 1);
                    StructureUtils.breackUp(lA4);
                    Location lA2 = StructureUtils.topBlock(player, x, z);
                    lA2.setX(lA2.getX() + 2);
                    lA2.setY(lA2.getY() + 2);
                    StructureUtils.breackUp(lA2);
                }
                //Slabs enfrente
                Location l1 = StructureUtils.topBlock(player, x, z);
                Location sL1 = l1;
                l1.setX(l1.getX() - 1);
                l1.setY(l1.getY() + 1);
                if (l1.getBlock().getType() != Material.AIR) {
                    sL1.setX(sL1.getX() + 2);
                    if (sL1.getBlock().getType() != Material.AIR) {
                        sL1.setX(sL1.getX() - 1);
                        sL1.getBlock().setType(selected);
                    } else {
                        sL1.setX(sL1.getX() - 1);
                        sL1.getBlock().setType(Material.STEP);
                        sL1.getBlock().setData((byte) 0);
                    }
                }
                //Slabs atras
                Location l2 = StructureUtils.topBlock(player, x, z);
                Location sL2 = l2;
                l2.setX(l2.getX() + 1);
                l2.setY(l2.getY() + 1);
                if (l2.getBlock().getType() != Material.AIR && l2.getBlock().getType() != Material.STEP) {
                    sL2.setX(sL2.getX() - 2);
                    if (sL2.getBlock().getType() != Material.AIR) {
                        sL2.setX(sL2.getX() + 1);
                        sL2.getBlock().setType(selected);
                    } else {
                        sL2.setX(sL2.getX() + 1);
                        sL2.getBlock().setType(Material.STEP);
                        sL2.getBlock().setData((byte) 0);
                    }
                }
                //Remplazar por bloques finales
                Location l3 = StructureUtils.topBlock(player, x, z);
                if (l3.getBlock().getType() != Material.STEP) {
                    l3.getBlock().setType(selected);
                }
                //Bedrock
                Location lB = StructureUtils.topBlock(player, x, z);
                lB.setY(lB.getY() - 1);
                lB.getBlock().setType(Material.BEDROCK);
                lB.setY(lB.getY() - 1);
                lB.getBlock().setType(Material.BEDROCK);
                lB.setY(lB.getY() - 1);
                lB.getBlock().setType(Material.BEDROCK);
                lB.setY(lB.getY() - 1);
                lB.getBlock().setType(Material.BEDROCK);
                lB.setY(lB.getY() - 1);
                lB.getBlock().setType(Material.BEDROCK);
            }
            for (int z = -0; z > -width; z--) {
                Material selected = getMaterial();
                Location lS = StructureUtils.topBlock(player, 0, 0);
                Location h1 = StructureUtils.topBlock(player, x, z);
                //Abajo
                if (h1.getY() < (lS.getY() - height)) {
                    h1.setY((lS.getY() - height));
                    Location sH1 = h1;
                    h1.setY(h1.getY() + 1);
                    StructureUtils.breackUp(h1);
                    sH1.getBlock().setType(selected);
                }
                //Arroba
                Location h2 = StructureUtils.topBlock(player, x, z);
                if (h2.getY() > (lS.getY() + height)) {
                    h2.setY(lS.getY() + height);
                    Location sH2 = h2;
                    h2.setY(h2.getY() + 1);
                    StructureUtils.breackUp(h2);
                    sH2.getBlock().setType(selected);
                }
                //Adaptacion enfrente
                Location lA = StructureUtils.topBlock(player, x, z);
                lA.setX(lA.getX() - 1);
                lA.setY(lA.getY() + 1);
                if (lA.getBlock().getType() != Material.AIR) {
                    lA.setY(lA.getY() + 1);
                    StructureUtils.breackUp(lA);
                    Location lA2 = StructureUtils.topBlock(player, x, z);
                    lA2.setX(lA2.getX() - 2);
                    lA2.setY(lA2.getY() + 2);
                    StructureUtils.breackUp(lA2);
                }
                //Adaptacion atras
                Location lA4 = StructureUtils.topBlock(player, x, z);
                lA4.setX(lA4.getX() + 1);
                lA4.setY(lA4.getY() + 1);
                if (lA4.getBlock().getType() != Material.AIR) {
                    lA4.setY(lA4.getY() + 1);
                    StructureUtils.breackUp(lA4);
                    Location lA2 = StructureUtils.topBlock(player, x, z);
                    lA2.setX(lA2.getX() + 2);
                    lA2.setY(lA2.getY() + 2);
                    StructureUtils.breackUp(lA2);
                }
                //Slabs enfrente
                Location l1 = StructureUtils.topBlock(player, x, z);
                Location sL1 = l1;
                l1.setX(l1.getX() - 1);
                l1.setY(l1.getY() + 1);
                if (l1.getBlock().getType() != Material.AIR) {
                    sL1.setX(sL1.getX() + 2);
                    if (sL1.getBlock().getType() != Material.AIR) {
                        sL1.setX(sL1.getX() - 1);
                        sL1.getBlock().setType(selected);
                    } else {
                        sL1.setX(sL1.getX() - 1);
                        sL1.getBlock().setType(Material.STEP);
                        sL1.getBlock().setData((byte) 0);
                    }
                }
                //Slabs atras
                Location l2 = StructureUtils.topBlock(player, x, z);
                Location sL2 = l2;
                l2.setX(l2.getX() + 1);
                l2.setY(l2.getY() + 1);
                if (l2.getBlock().getType() != Material.AIR && l2.getBlock().getType() != Material.STEP) {
                    sL2.setX(sL2.getX() - 2);
                    if (sL2.getBlock().getType() != Material.AIR) {
                        sL2.setX(sL2.getX() + 1);
                        sL2.getBlock().setType(selected);
                    } else {
                        sL2.setX(sL2.getX() + 1);
                        sL2.getBlock().setType(Material.STEP);
                        sL2.getBlock().setData((byte) 0);
                    }
                }
                //Remplazar por bloques finales
                Location l3 = StructureUtils.topBlock(player, x, z);
                if (l3.getBlock().getType() != Material.STEP) {
                    l3.getBlock().setType(selected);
                }
                //Bedrock
                Location lB = StructureUtils.topBlock(player, x, z);
                lB.setY(lB.getY() - 1);
                lB.getBlock().setType(Material.BEDROCK);
                lB.setY(lB.getY() - 1);
                lB.getBlock().setType(Material.BEDROCK);
                lB.setY(lB.getY() - 1);
                lB.getBlock().setType(Material.BEDROCK);
                lB.setY(lB.getY() - 1);
                lB.getBlock().setType(Material.BEDROCK);
                lB.setY(lB.getY() - 1);
                lB.getBlock().setType(Material.BEDROCK);
            }
            x = x - 1;
            value = Math.abs(((double)x * 100.00D / (double) distance));
            if(value > 100D && value != 100D) {
                f++;
            } else {
                String v = new DecimalFormat("##.##").format((value));
                Bukkit.broadcastMessage(CC.GREEN + "Generating all roads (" + v + "%)");
            }
            if(f == 1) {
                Bukkit.broadcastMessage(CC.GREEN + "Successfully generated all roads!");
            }
            if(x < -distance) {
                cancel();
            }
        }
    }

    private Material getMaterial() {
        HashMap<Integer, Material> mats = new HashMap<Integer, Material>();
        for (String s : blocks) {
            Material type = Material.getMaterial(Integer.parseInt(s));
            mats.put(mats.size() + 1, type);
        }
        return mats.get(Utils.getRandomNumber(1, mats.size() + 1));
    }
}
