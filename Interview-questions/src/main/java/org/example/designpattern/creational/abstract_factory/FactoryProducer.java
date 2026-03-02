package org.example.designpattern.creational.abstract_factory;

public class FactoryProducer {
    public static AbstractFactory getFactory(String choice){
        if(Constant.SHAPE.equalsIgnoreCase(choice)){
            return new ShapeFactory();
        } else if (Constant.COLOR.equalsIgnoreCase(choice)) {
            return new ColorFactory();
        }
        return null;
    }
}
