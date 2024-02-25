package com.diogo.parkour.model.checkpoint.impl;

import com.diogo.parkour.model.checkpoint.CheckPoint;
import org.bukkit.Location;

public class CheckPointStartImpl extends CheckPoint {

    public CheckPointStartImpl(Location location) {
        super(location);
    }

    @Override
    public String getMessage() {
        return "§aYou've started parkour!";
    }

}
