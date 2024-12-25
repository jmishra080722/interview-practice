package org.example.designpattern.factoryDP;

public class TwoWheeler implements IVehicle{
    @Override
    public String makeVehicle() {
        return "We produce two Wheeler vehicle.";
    }
}
