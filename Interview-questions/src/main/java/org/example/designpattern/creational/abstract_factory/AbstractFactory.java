package org.example.designpattern.creational.abstract_factory;

import org.example.designpattern.creational.abstract_factory.color.Color;
import org.example.designpattern.creational.abstract_factory.shap.Shape;

public abstract class AbstractFactory {
    abstract Color getColor(String color);
    abstract Shape getShape(String shape);
}
