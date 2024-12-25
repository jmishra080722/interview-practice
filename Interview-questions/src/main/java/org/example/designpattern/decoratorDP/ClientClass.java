package org.example.designpattern.decoratorDP;

public class ClientClass {
    public static void main(String[] args) {
        BasePizza farmHouse = new FarmhouseBasePizza();
        System.out.println(farmHouse.getDescription());
        System.out.println(farmHouse.getPrice()+"\n");

        System.out.println("Add extra cheese to farmhouse pizza");
        BasePizza extraCheeseFarmHouse = new ExtraCheesePizza(farmHouse);
        System.out.println(extraCheeseFarmHouse.getDescription());
        System.out.println(extraCheeseFarmHouse.getPrice()+"\n");

        System.out.println("Add extra Paneer to VegDelight pizza");
        BasePizza vegDelight = new VegDelightedBasePizza();
        BasePizza extraPaneerVegDelight = new ExtraPaneerPizza(vegDelight);
        System.out.println(extraPaneerVegDelight.getDescription());
        System.out.println(extraPaneerVegDelight.getPrice()+"\n");

        BasePizza farmHouse1 = new FarmhouseBasePizza();
        System.out.println("Add extra paneer and cheese to Farmhouse pizza");
        BasePizza specialPizza = new ExtraCheesePizza(new ExtraPaneerPizza(farmHouse1));
        System.out.println(specialPizza.getDescription());
        System.out.println(specialPizza.getPrice());

    }
}
