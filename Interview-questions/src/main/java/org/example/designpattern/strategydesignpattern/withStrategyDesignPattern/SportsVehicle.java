package org.example.designpattern.strategydesignpattern.withStrategyDesignPattern;

import org.example.designpattern.strategydesignpattern.withStrategyDesignPattern.strategy.DriveStrategy;
import org.example.designpattern.strategydesignpattern.withStrategyDesignPattern.strategy.SportsDriveStrategy;

public class SportsVehicle extends Vehicle{


    public SportsVehicle(SportsDriveStrategy sportsDriveStrategy) {
        super(sportsDriveStrategy);
    }
}
