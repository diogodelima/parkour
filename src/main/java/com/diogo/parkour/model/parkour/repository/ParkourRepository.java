package com.diogo.parkour.model.parkour.repository;

import com.diogo.parkour.model.parkour.Parkour;

public interface ParkourRepository {

    void insertOrUpdate(Parkour parkour);

    Parkour find();

}
