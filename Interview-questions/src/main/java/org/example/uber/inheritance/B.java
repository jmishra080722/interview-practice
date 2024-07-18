package org.example.uber.inheritance;

public interface B {
    void print_msg();
    default void defaut_print_b(){
        System.out.println("defaut_print B");
    }
}
