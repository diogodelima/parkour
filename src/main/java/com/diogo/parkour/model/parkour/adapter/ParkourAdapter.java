package com.diogo.parkour.model.parkour.adapter;

import com.diogo.parkour.model.checkpoint.CheckPoint;
import com.diogo.parkour.model.checkpoint.impl.CheckPointImpl;
import com.diogo.parkour.model.checkpoint.impl.CheckPointStartImpl;
import com.diogo.parkour.model.parkour.Parkour;
import com.diogo.parkour.util.ConfigurationAdapter;
import com.diogo.parkour.util.Serializer;
import org.bukkit.configuration.ConfigurationSection;

import java.util.Set;
import java.util.stream.Collectors;

public class ParkourAdapter implements ConfigurationAdapter<Parkour> {

    @Override
    public Parkour adapt(ConfigurationSection section) {

        CheckPoint start = new CheckPointStartImpl(Serializer.locationDeserializer(section.getString("start")));
        CheckPoint end = new CheckPointStartImpl(Serializer.locationDeserializer(section.getString("end")));
        Set<CheckPoint> checkPoints = section.getStringList("checkpoints")
                .stream()
                .map(str -> new CheckPointImpl(Serializer.locationDeserializer(str)))
                .collect(Collectors.toSet());
        checkPoints.add(start);
        checkPoints.add(end);

        return new Parkour(checkPoints);
    }

}
