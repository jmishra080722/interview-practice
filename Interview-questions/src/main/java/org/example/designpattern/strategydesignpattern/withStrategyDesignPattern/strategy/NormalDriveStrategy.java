package org.example.designpattern.strategydesignpattern.withStrategyDesignPattern.strategy;

public class NormalDriveStrategy implements DriveStrategy{


    @Override
    public void drive() {
        System.out.println("Normal drive capability");
    }
}
