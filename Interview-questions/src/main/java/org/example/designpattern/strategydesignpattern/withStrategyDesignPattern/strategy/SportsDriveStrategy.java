package org.example.designpattern.strategydesignpattern.withStrategyDesignPattern.strategy;

public class SportsDriveStrategy implements DriveStrategy{


    @Override
    public void drive() {
        System.out.println("Sports drive capability");
    }
}
