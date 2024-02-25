package com.diogo.parkour;

import com.diogo.parkour.command.ParkourCommand;
import com.diogo.parkour.model.parkour.service.ParkourService;
import com.diogo.parkour.model.parkour.service.ParkourServiceImpl;
import com.diogo.parkour.util.Configuration;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public class ParkourPlugin extends JavaPlugin {

    public static ParkourPlugin getInstance(){
        return getPlugin(ParkourPlugin.class);
    }

    private Configuration parkour;

    private ParkourService parkourService;

    @Override
    public void onEnable() {

        parkour = new Configuration("parkour.yml", this);
        parkour.saveFile();

        parkourService = new ParkourServiceImpl();

        getCommand("parkour").setExecutor(new ParkourCommand());
    }

}
