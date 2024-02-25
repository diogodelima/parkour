package com.diogo.parkour.model.checkpoint.impl;

import com.diogo.parkour.model.checkpoint.CheckPoint;
import org.bukkit.Location;

public class CheckPointEndImpl extends CheckPoint {

    public CheckPointEndImpl(Location location) {
        super(location);
    }

    @Override
    public String getMessage() {
        return "§aYou've finished parkour!";
    }

}
