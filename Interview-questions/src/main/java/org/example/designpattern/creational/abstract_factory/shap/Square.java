package org.example.designpattern.creational.abstract_factory.shap;

public class Square implements Shape{
    @Override
    public void draw() {
        System.out.println("Inside Square:: draw method");
    }
}
