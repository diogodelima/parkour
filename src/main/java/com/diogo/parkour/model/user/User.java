package com.diogo.parkour.model.user;

import com.diogo.parkour.model.checkpoint.CheckPoint;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Objects;

@AllArgsConstructor
@Data
public class User {

    private final String nickname;
    private CheckPoint currentCheckPoint;

    public boolean hasCheckPoint(){
        return this.currentCheckPoint != null;
    }

    public Player getPlayer(){
        return Bukkit.getPlayerExact(this.nickname);
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.nickname);
    }

    @Override
    public boolean equals(Object o){

        if (this == o)
            return true;

        if (!(o instanceof User user))
            return false;

        return this.nickname.equals(user.nickname);
    }

}
