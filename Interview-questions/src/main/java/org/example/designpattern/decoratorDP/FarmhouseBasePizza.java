package org.example.designpattern.decoratorDP;

public class FarmhouseBasePizza implements BasePizza{
    @Override
    public String getDescription() {
        return "This is FarmhousePizza, which is a base pizza";
    }

    @Override
    public double getPrice() {
        return 10.00;
    }
}
