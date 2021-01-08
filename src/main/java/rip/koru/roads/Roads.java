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

public class Roads extends JavaPlugin {

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
        getServer().getConsoleSender().sendMessage(CC.WHITE + "Roads by FxMxGRAGFX Enabled!");
    }
}
