package com.diogo.parkour.model.parkour.service;

import com.diogo.parkour.model.parkour.Parkour;
import com.diogo.parkour.model.parkour.repository.ParkourRepository;
import com.diogo.parkour.model.parkour.repository.ParkourRepositoryImpl;

import java.util.HashSet;

public class ParkourServiceImpl implements ParkourService{

    private final ParkourRepository repository = new ParkourRepositoryImpl();

    @Override
    public void update(Parkour parkour) {
        repository.insertOrUpdate(parkour);
    }

    @Override
    public Parkour get() {
        Parkour parkour = repository.find();
        return parkour == null ? new Parkour(new HashSet<>()) : parkour;
    }

}
