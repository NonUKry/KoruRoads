package rip.koru.roads.utils;

import org.bukkit.Location;

/**
 * Developed by FxMxGRAGFX
 * Project: KoruRoads
 **/

public class Utils {

    public static String LocationToReadableString(Location loc) {
        String ret = "";
        ret = "X: " + Integer.toString(loc.getBlockX()) + " Y: " + Integer.toString(loc.getBlockY()) + " Z: " + Integer.toString(loc.getBlockZ());
        return ret;
    }

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public static boolean check(int input) {
        int n = Math.abs(input);
        if (n == 0 || n == 9)
            return true;
        if (n < 9)
            return false;
        return check((int)(n >> 3) - (int)(n & 7));
    }
}
