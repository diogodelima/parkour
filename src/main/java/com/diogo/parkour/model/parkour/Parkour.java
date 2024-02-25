package com.diogo.parkour.model.parkour;

import com.diogo.parkour.model.checkpoint.CheckPoint;
import lombok.AllArgsConstructor;

import java.util.Set;

@AllArgsConstructor
public class Parkour {

    private final Set<CheckPoint> checkPoints;

}
