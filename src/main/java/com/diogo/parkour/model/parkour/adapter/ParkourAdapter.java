package com.diogo.parkour.model.parkour.adapter;

import com.diogo.parkour.model.checkpoint.CheckPoint;
import com.diogo.parkour.model.checkpoint.impl.CheckPointImpl;
import com.diogo.parkour.model.checkpoint.impl.CheckPointStartImpl;
import com.diogo.parkour.model.parkour.Parkour;
import com.diogo.parkour.util.ConfigurationAdapter;
import com.diogo.parkour.util.Serializer;
import org.bukkit.configuration.ConfigurationSection;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ParkourAdapter implements ConfigurationAdapter<Parkour> {

    @Override
    public Parkour adapt(ConfigurationSection section) {

        Set<CheckPoint> checkPoints = section.contains("checkpoints") ? section.getStringList("checkpoints")
                .stream()
                .map(str -> new CheckPointImpl(Serializer.locationDeserializer(str)))
                .collect(Collectors.toSet()) : new HashSet<>();

        if (section.contains("start")) {
            CheckPoint start = new CheckPointStartImpl(Serializer.locationDeserializer(section.getString("start")));
            checkPoints.add(start);
        }

        if (section.contains("end")) {
            CheckPoint end = new CheckPointStartImpl(Serializer.locationDeserializer(section.getString("end")));
            checkPoints.add(end);
        }

        return new Parkour(checkPoints);
    }

}
