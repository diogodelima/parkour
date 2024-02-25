package com.diogo.parkour.model.checkpoint.impl;

import com.diogo.parkour.model.checkpoint.CheckPoint;
import org.bukkit.Location;

public class CheckPointImpl extends CheckPoint {

    public CheckPointImpl(Location location) {
        super(location);
    }

    @Override
    public String getMessage() {
        return "§aYou've reached a checkpoint";
    }

}
