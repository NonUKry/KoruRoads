package rip.koru.roads.utils;

import org.bukkit.Location;

/**
 * Developed by FxMxGRAGFX
 * Project: KoruRoads
 **/

public class Utils {

    public static String LocationToReadableString(Location loc) {
        String ret = "";
        ret = "X: " + loc.getBlockX() + " Y: " + loc.getBlockY() + " Z: " + loc.getBlockZ();
        return ret;
    }

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public static boolean check(int input) {
        int n = Math.abs(input);
        if (n == 0 || n == 5)
            return true;
        if (n < 5)
            return false;
        return check((n >> 3) - (n & 7));
    }
}
