package com.diogo.parkour.model.parkour.repository;

import com.diogo.parkour.ParkourPlugin;
import com.diogo.parkour.model.parkour.Parkour;
import com.diogo.parkour.model.parkour.adapter.ParkourAdapter;
import com.diogo.parkour.util.Configuration;
import com.diogo.parkour.util.Serializer;

import java.util.stream.Collectors;

public class ParkourRepositoryImpl implements ParkourRepository {

    private final Configuration config = ParkourPlugin.getInstance().getParkour();
    private final ParkourAdapter adapter = new ParkourAdapter();

    @Override
    public void insertOrUpdate(Parkour parkour) {

        parkour.getCheckPointStart().ifPresent(checkPoint -> config.getConfig().set("start", Serializer.locationSerializer(checkPoint.getLocation())));
        parkour.getCheckPointEnd().ifPresent(checkPoint -> config.getConfig().set("end", Serializer.locationSerializer(checkPoint.getLocation())));

        if (!parkour.getCommonCheckPoints().isEmpty()) {

            config.getConfig().set("checkpoints", parkour.getCommonCheckPoints()
                    .stream()
                    .map(checkPoint -> Serializer.locationSerializer(checkPoint.getLocation()))
                    .collect(Collectors.toList()));

        }

        config.saveConfig();
    }

    @Override
    public Parkour find() {
        return this.adapter.adapt(config.getConfig().getConfigurationSection(""));
    }

}
