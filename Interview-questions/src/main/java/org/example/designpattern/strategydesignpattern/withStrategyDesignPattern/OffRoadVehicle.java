package org.example.designpattern.strategydesignpattern.withStrategyDesignPattern;

import org.example.designpattern.strategydesignpattern.withStrategyDesignPattern.strategy.SportsDriveStrategy;

public class OffRoadVehicle extends Vehicle{

    public OffRoadVehicle(SportsDriveStrategy sportsDriveStrategy){
        super(sportsDriveStrategy);
    }
}
