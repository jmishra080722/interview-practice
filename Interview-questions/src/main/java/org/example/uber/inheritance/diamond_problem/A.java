package org.example.uber.inheritance.diamond_problem;

public interface A {
    default void method(){
        System.out.println("Method from interface A");
    }
}
