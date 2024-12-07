package org.example.designpattern.strategydesignpattern.withStrategyDesignPattern;

import org.example.designpattern.strategydesignpattern.withStrategyDesignPattern.strategy.NormalDriveStrategy;
import org.example.designpattern.strategydesignpattern.withStrategyDesignPattern.strategy.SportsDriveStrategy;

public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = new SportsVehicle(new SportsDriveStrategy());
        vehicle.drive();

        vehicle = new OffRoadVehicle(new SportsDriveStrategy());
        vehicle.drive();

        vehicle = new GoodsVehicle(new NormalDriveStrategy());
        vehicle.drive();
    }
}
