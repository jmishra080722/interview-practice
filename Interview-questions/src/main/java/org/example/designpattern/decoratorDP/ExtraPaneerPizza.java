package org.example.designpattern.decoratorDP;

public class ExtraPaneerPizza implements BasePizza{

    BasePizza basePizza;

    public ExtraPaneerPizza(BasePizza basePizza){
        this.basePizza = basePizza;
    }

    @Override
    public String getDescription() {
        return "This is a ExtraPaneerPizza. This will add extra Paneer to base pizza. You have to pay 5.00 rupees extra.";
    }

    @Override
    public double getPrice() {
        return basePizza.getPrice() + 5;
    }
}
