package com.diogo.parkour.model.parkour;

import com.diogo.parkour.model.checkpoint.CheckPoint;
import com.diogo.parkour.model.checkpoint.impl.CheckPointEndImpl;
import com.diogo.parkour.model.checkpoint.impl.CheckPointStartImpl;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public record Parkour(Set<CheckPoint> checkPoints) {

    public Optional<CheckPoint> getCheckPointStart(){
        return this.checkPoints
                .stream()
                .filter(checkPoint -> checkPoint instanceof CheckPointStartImpl)
                .findFirst();
    }

    public Optional<CheckPoint> getCheckPointEnd(){
        return this.checkPoints
                .stream()
                .filter(checkPoint -> checkPoint instanceof CheckPointEndImpl)
                .findFirst();
    }

    public List<CheckPoint> getCommonCheckPoints(){
        return this.checkPoints
                .stream()
                .filter(checkPoint -> !(checkPoint instanceof CheckPointStartImpl) && !(checkPoint instanceof CheckPointEndImpl))
                .collect(Collectors.toList());
    }

    public void addCheckPoint(CheckPoint checkPoint){
        this.checkPoints.add(checkPoint);
    }

    public void removeCheckPoint(CheckPoint checkPoint){
        this.checkPoints.remove(checkPoint);
    }

}
