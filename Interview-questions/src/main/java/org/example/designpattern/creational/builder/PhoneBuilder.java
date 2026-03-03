package org.example.designpattern.creational.builder;

public class PhoneBuilder {

    private String os;
    private int ram;
    private double screenSize;
    private int battery;
    private String processor;

    public PhoneBuilder setOs(String os) {
        this.os = os;
        return this;
    }

    public PhoneBuilder setRam(int ram) {
        this.ram = ram;
        return this;
    }

    public PhoneBuilder setScreenSize(double screenSize) {
        this.screenSize = screenSize;
        return this;
    }

    public PhoneBuilder setBattery(int battery) {
        this.battery = battery;
        return this;
    }

    public PhoneBuilder setProcessor(String processor) {
        this.processor = processor;
        return this;
    }

    public String getOs() {
        return os;
    }

    public int getRam() {
        return ram;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public int getBattery() {
        return battery;
    }

    public String getProcessor() {
        return processor;
    }

    public Phone build(){
        return new Phone(this);
    }
}
