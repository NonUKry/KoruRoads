package rip.koru.roads;

import org.bukkit.command.CommandMap;
import org.bukkit.plugin.java.JavaPlugin;
import rip.koru.roads.cache.CacheManager;
import rip.koru.roads.commands.RoadCleanCommand;
import rip.koru.roads.commands.RoadGenCommand;
import rip.koru.roads.utils.CC;

import java.lang.reflect.Field;

/**
 * Developed by FxMxGRAGFX
 * Project: KoruRoads
 **/

public class KoruRoads extends JavaPlugin {

    public static KoruRoads getInstance() { return KoruRoads.getPlugin(KoruRoads.class); }

    @Override
    public void onEnable() {
        new CacheManager();
        try {
            Field field = getServer().getClass().getDeclaredField("commandMap");
            field.setAccessible(true);
            CommandMap map = (CommandMap)field.get(getServer());
            map.register("roads", new RoadCleanCommand());
            map.register("roads", new RoadGenCommand());
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        getServer().getConsoleSender().sendMessage(CC.WHITE + "[KoruRoads] Developed by FxMxGRAGFX has been enabled!");
    }
}
