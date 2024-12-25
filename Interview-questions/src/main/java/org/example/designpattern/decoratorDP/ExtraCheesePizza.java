package org.example.designpattern.decoratorDP;

public class ExtraCheesePizza implements BasePizza{
    BasePizza basePizza;

    public ExtraCheesePizza(BasePizza basePizza){
        this.basePizza = basePizza;
    }
    @Override
    public String getDescription() {
        return "This is a ExtraCheesePizza. This will add extra cheese to base pizza. You have to pay 3.00 rupees extra.";
    }

    @Override
    public double getPrice() {
        return basePizza.getPrice() + 3.00;
    }
}
