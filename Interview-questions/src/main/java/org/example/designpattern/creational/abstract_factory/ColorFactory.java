package org.example.designpattern.creational.abstract_factory;

import org.example.designpattern.creational.abstract_factory.color.Blue;
import org.example.designpattern.creational.abstract_factory.color.Color;
import org.example.designpattern.creational.abstract_factory.color.Green;
import org.example.designpattern.creational.abstract_factory.color.Red;
import org.example.designpattern.creational.abstract_factory.shap.Shape;

public class   ColorFactory extends AbstractFactory{
    @Override
    Color getColor(String color) {
        Color colorObj = null;
        if(color == null || color.isEmpty()){
            return  colorObj;
        } else if (color.equalsIgnoreCase(Constant.RED)) {
            colorObj =  new Red();
        }
        else if (color.equalsIgnoreCase(Constant.BLUE)) {
            colorObj = new Blue();
        }
        else if (color.equalsIgnoreCase(Constant.GREEN)) {
            colorObj = new Green();
        }
        return colorObj;
    }

    @Override
    Shape getShape(String shape) {
        return null;
    }
}
