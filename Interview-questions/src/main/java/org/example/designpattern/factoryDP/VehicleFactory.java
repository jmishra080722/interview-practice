package org.example.designpattern.factoryDP;

public class VehicleFactory {

    public static IVehicle getVehicle(String vehicleType ){
        switch (vehicleType.toLowerCase()) {
            case "two-wheeler":
                return new TwoWheeler();
            case "four-wheeler":
                return new FourWheeler();
            default:
                return null;
        }
    }
}
