package rip.koru.roads.utils;

import net.md_5.bungee.api.ChatColor;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Developed by FxMxGRAGFX
 * Project: LazzeInstaller
 **/

public class CC {

    public static ChatColor BLUE = ChatColor.BLUE;
    public static ChatColor AQUA = ChatColor.AQUA;
    public static ChatColor YELLOW = ChatColor.YELLOW;
    public static ChatColor RED = ChatColor.RED;
    public static ChatColor GRAY = ChatColor.GRAY;
    public static ChatColor GOLD = ChatColor.GOLD;
    public static ChatColor GREEN = ChatColor.GREEN;
    public static ChatColor WHITE = ChatColor.WHITE;
    public static ChatColor BLACK = ChatColor.BLACK;
    public static ChatColor BOLD = ChatColor.BOLD;
    public static ChatColor ITALIC = ChatColor.ITALIC;
    public static ChatColor UNDER_LINE = ChatColor.UNDERLINE;
    public static ChatColor STRIKE_THROUGH = ChatColor.STRIKETHROUGH;
    public static ChatColor RESET = ChatColor.RESET;
    public static ChatColor MAGIC = ChatColor.MAGIC;
    public static ChatColor DARK_BLUE = ChatColor.DARK_BLUE;
    public static ChatColor DARK_AQUA = ChatColor.DARK_AQUA;
    public static ChatColor DARK_GRAY = ChatColor.DARK_GRAY;
    public static ChatColor DARK_GREEN = ChatColor.DARK_GREEN;
    public static ChatColor DARK_PURPLE = ChatColor.DARK_PURPLE;
    public static ChatColor DARK_RED = ChatColor.DARK_RED;
    public static ChatColor PINK = ChatColor.LIGHT_PURPLE;
    public static String MENU_BAR = ChatColor.STRIKETHROUGH + "------------------------";
    public static String CHAT_BAR = ChatColor.STRIKETHROUGH + "------------------------------------------------";
    public static String SB_BAR = ChatColor.STRIKETHROUGH + "----------------------";

    public static String translate(String input) {
        return ChatColor.translateAlternateColorCodes('&', input);
    }

    public static List<String> translate(List<String> input) {
        return input.stream().map(CC::translate).collect(Collectors.toList());
    }
}
