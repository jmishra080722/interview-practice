package org.example.designpattern.strategydesignpattern.withStrategyDesignPattern;

import org.example.designpattern.strategydesignpattern.withStrategyDesignPattern.strategy.NormalDriveStrategy;

public class GoodsVehicle extends Vehicle{

    public GoodsVehicle(NormalDriveStrategy normalDriveStrategy){
        super(normalDriveStrategy);
    }
}
