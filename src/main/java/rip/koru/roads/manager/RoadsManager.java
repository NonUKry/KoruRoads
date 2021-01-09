package rip.koru.roads.manager;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import rip.koru.roads.cleaning.EastC;
import rip.koru.roads.cleaning.NorthC;
import rip.koru.roads.cleaning.SouthC;
import rip.koru.roads.cleaning.WestC;
import rip.koru.roads.utils.CC;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Developed by FxMxGRAGFX
 * Project: KoruRoads
 **/

public class RoadsManager {
    
    public static void startClean(Player player) {
        long initTime = System.currentTimeMillis();
        Bukkit.broadcastMessage(CC.GREEN + "Staring to cleaning all roads!, Please wait...");
        EastC.start(player);
        WestC.start(player);
        SouthC.start(player);
        NorthC.start(player);
        Bukkit.broadcastMessage(CC.GREEN + "All roads has been cleaned successfully in " + TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - initTime) + " secconds!");
    }

    public void generate(Player player) {
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
}
