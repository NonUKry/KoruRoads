package rip.koru.roads.manager;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import rip.koru.roads.utils.CC;

import java.util.Arrays;
import java.util.List;

/**
 * Developed by FxMxGRAGFX
 * Project: KoruRoads
 **/

public class RoadsManager {

    public static void startGeneration(Player player, String[] blocks) {
        long initTime = System.currentTimeMillis();
        Bukkit.broadcastMessage(CC.GREEN + "Staring to generating all roads!, Please wait...");
        //Bukkit.broadcastMessage(CC.GREEN + "Please wait 3s to generate all!");
        //try {
        //    Thread.sleep(TimeUnit.SECONDS.toMillis(3));
        //} catch (InterruptedException e) {
        //    e.printStackTrace();
        //}
        // player.getScoreboard().clearSlot(DisplaySlot.SIDEBAR);
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
            Material.HUGE_MUSHROOM_2,
            Material.STEP
    );
}
