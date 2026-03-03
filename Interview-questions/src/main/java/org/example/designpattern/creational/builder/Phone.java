package org.example.designpattern.creational.builder;

public class Phone {

    private final String os;
    private final int ram;
    private final double screenSize;
    private final int battery;
    private final String processor;

    /*public Phone(String os, int ram, double screenSize, int battery, String processor) {
        this.os = os;
        this.ram = ram;
        this.screenSize = screenSize;
        this.battery = battery;
        this.processor = processor;
    }*/

    public Phone(PhoneBuilder phoneBuilder){
        this.os = phoneBuilder.getOs();
        this.ram = phoneBuilder.getRam();
        this.screenSize = phoneBuilder.getScreenSize();
        this.battery = phoneBuilder.getBattery();
        this.processor = phoneBuilder.getProcessor();
    }

    @Override
    public String toString() {
        return "Phone{" +
                "os='" + os + '\'' +
                ", ram=" + ram +
                ", screenSize=" + screenSize +
                ", battery=" + battery +
                ", processor='" + processor + '\'' +
                '}';
    }
}
