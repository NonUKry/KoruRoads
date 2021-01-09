package rip.koru.roads.commands;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import rip.koru.roads.generation.NorthG;
import rip.koru.roads.manager.RoadGenerator;
import rip.koru.roads.utils.CC;

/**
 * Developed by FxMxGRAGFX
 * Project: KoruRoads
 **/

public class RoadGenCommand extends Command {
    public RoadGenCommand() {
        super("roadgen");
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(CC.RED + "No console!");
            return false;
        }
        Player player = (Player) sender;
        if(args[0].equalsIgnoreCase("test")) {
            String[] blocks = args[2].split(",");
            NorthG.generate(player, Integer.parseInt(args[1]), blocks);
            return false;
        }
        if(args.length == 1) {
            String[] blocks = args[0].split(",");
            RoadGenerator.startGeneration(player, blocks);
            return true;
        } else {
            player.sendMessage(CC.RED + "/roadgen <bloque,bloques>");
            return false;
        }
    }
}
