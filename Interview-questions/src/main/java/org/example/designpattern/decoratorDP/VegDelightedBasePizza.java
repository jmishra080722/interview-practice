package org.example.designpattern.decoratorDP;

public class VegDelightedBasePizza implements BasePizza{
    @Override
    public String getDescription() {
        return "This is VegDelightedBasePizza, which is a base pizza";
    }

    @Override
    public double getPrice() {
        return 15.00;
    }
}
