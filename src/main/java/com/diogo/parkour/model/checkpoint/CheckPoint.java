package com.diogo.parkour.model.checkpoint;

import com.diogo.parkour.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.bukkit.Location;

import java.util.Objects;

@AllArgsConstructor
@Data
public abstract class CheckPoint {

    private final Location location;

    public abstract String getMessage();

    public void process(User user){

        user.setCurrentCheckPoint(this);
        user.getPlayer().sendMessage(getMessage());

    }

    @Override
    public int hashCode(){
        return Objects.hash(this.location);
    }

    @Override
    public boolean equals(Object o){

        if (this == o)
            return true;

        if (!(o instanceof CheckPoint checkPoint))
            return false;

        return this.location.equals(checkPoint.location);
    }

}
