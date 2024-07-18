package org.example.uber.inheritance;

public interface A {
    void print_msg();
    default void defaut_print(){
        System.out.println("defaut_print A");
    }
}
