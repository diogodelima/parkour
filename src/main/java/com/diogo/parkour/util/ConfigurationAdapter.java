package com.diogo.parkour.util;

import org.bukkit.configuration.ConfigurationSection;

public interface ConfigurationAdapter<T> {

    T adapt(ConfigurationSection section);

}
