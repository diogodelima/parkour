package com.diogo.parkour.command;

import com.diogo.parkour.ParkourPlugin;
import com.diogo.parkour.model.checkpoint.impl.CheckPointEndImpl;
import com.diogo.parkour.model.checkpoint.impl.CheckPointImpl;
import com.diogo.parkour.model.checkpoint.impl.CheckPointStartImpl;
import com.diogo.parkour.model.parkour.Parkour;
import com.diogo.parkour.model.parkour.service.ParkourService;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ParkourCommand implements CommandExecutor {

    private final ParkourService parkourService = ParkourPlugin.getInstance().getParkourService();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (!(sender instanceof Player player))
            return false;

        Parkour parkour = parkourService.get();

        if (args.length != 2 || !args[0].equalsIgnoreCase("checkpoint")){
            player.sendMessage("§cType '/parkour checkpoint <common/start/end>'");
            return false;
        }

        if (player.getLocation().getBlock().getType() != Material.GOLD_PLATE){
            player.sendMessage("§cYou need to stand on a gold pressure plate.");
            return false;
        }

        switch (args[1].toLowerCase()){
            case "common":
                parkour.addCheckPoint(new CheckPointImpl(player.getLocation()));
                break;
            case "start":
                parkour.getCheckPointStart().ifPresent(parkour::removeCheckPoint);
                parkour.addCheckPoint(new CheckPointStartImpl(player.getLocation()));
                break;
            case "end":
                parkour.getCheckPointEnd().ifPresent(parkour::removeCheckPoint);
                parkour.addCheckPoint(new CheckPointEndImpl(player.getLocation()));
                break;
            default:
                player.sendMessage("§cType '/parkour checkpoint <common/start/end>'");
                return false;
        }

        player.sendMessage("§aCheckpoint successfully added.");
        parkourService.update(parkour);
        return true;
    }
}
