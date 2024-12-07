package org.example.designpattern.strategydesignpattern.withoutStrategyDesignPattern;

public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = new SportsVehicle();
        vehicle.drive();

        vehicle = new OffRoadVehicle();
        vehicle.drive();

        vehicle = new PassengerVehicle();
        vehicle.drive();

        //In this case both SportsVehicle and OffRoadVehicle class have duplicate code.
        // Which will not be the case, when we use Strategy Design Pattern

        //Video Link: https://www.youtube.com/watch?v=u8DttUrXtEw&list=PL6W8uoQQ2c61X_9e6Net0WdYZidm7zooW&index=4
    }
}
