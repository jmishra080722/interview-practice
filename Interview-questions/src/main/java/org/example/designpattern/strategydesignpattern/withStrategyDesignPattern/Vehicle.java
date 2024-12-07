package org.example.designpattern.strategydesignpattern.withStrategyDesignPattern;

import org.example.designpattern.strategydesignpattern.withStrategyDesignPattern.strategy.DriveStrategy;

public class Vehicle {

    public DriveStrategy driveStrategy;

    //Constructor injection
    public Vehicle(DriveStrategy driveStrategy){
        this.driveStrategy = driveStrategy;
    }

    public void drive(){
        driveStrategy.drive();
    }
}
