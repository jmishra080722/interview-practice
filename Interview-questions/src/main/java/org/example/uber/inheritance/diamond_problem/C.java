package org.example.uber.inheritance.diamond_problem;

public interface C extends A{

    @Override
    default void method(){
        System.out.println("Method from interface C");
    }
}
