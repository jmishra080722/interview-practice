package org.example.designpattern.creational.abstract_factory;

import org.example.designpattern.creational.abstract_factory.color.Color;
import org.example.designpattern.creational.abstract_factory.shap.Shape;

public class AbstractFactoryDemo {
    public static void main(String[] args) {
        AbstractFactory shapeFactory = FactoryProducer.getFactory(Constant.SHAPE);

        assert shapeFactory != null;
        Shape shape1 = shapeFactory.getShape(Constant.CIRCLE);
        shape1.draw();

        Shape shape2 = shapeFactory.getShape(Constant.RECTANGLE);
        shape2.draw();

        AbstractFactory colorFactory = FactoryProducer.getFactory(Constant.COLOR);
        assert colorFactory != null;
        Color color1 = colorFactory.getColor(Constant.RED);
        color1.fill();
        Color color2 = colorFactory.getColor(Constant.BLUE);
        color2.fill();
    }
}
