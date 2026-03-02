package org.example.designpattern.creational.abstract_factory;

import org.example.designpattern.creational.abstract_factory.color.Color;
import org.example.designpattern.creational.abstract_factory.shap.Circle;
import org.example.designpattern.creational.abstract_factory.shap.Rectangle;
import org.example.designpattern.creational.abstract_factory.shap.Shape;
import org.example.designpattern.creational.abstract_factory.shap.Square;

public class ShapeFactory extends AbstractFactory{

    @Override
    Shape getShape(String shape) {
        if(shape == null || shape.isEmpty()){
            return null;
        }else if(shape.equalsIgnoreCase(Constant.CIRCLE)){
            return new Circle();
        }else if(shape.equalsIgnoreCase(Constant.RECTANGLE)){
            return new Rectangle();
        }
        else if(shape.equalsIgnoreCase(Constant.SQUARE)){
            return new Square();
        }
        return null;
    }


    @Override
    Color getColor(String color) {
        return null;
    }
}
