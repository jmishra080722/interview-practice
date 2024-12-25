package org.example.designpattern.factoryDP;

public class ClientClass {
    public static void main(String[] args) {
        IVehicle vehicle = VehicleFactory.getVehicle("two-wheeler");
        System.out.println(vehicle != null? vehicle.makeVehicle():"Please Enter valid vehicle type");

        IVehicle vehicle1 = VehicleFactory.getVehicle("Four-Wheeler");
        System.out.println(vehicle1 != null? vehicle1.makeVehicle():"Please Enter valid vehicle type");

    }
}
