package org.example.uber.inheritance;

public class Main1 implements A, B{
    @Override
    public void print_msg() {
        System.out.println("Printing msg");
    }

    /*@Override
    public void defaut_print() {
        B.super.defaut_print();
    }*/

    public static void main(String[] args) {
        A a = new Main1();
        a.print_msg();
        B b = new Main1();
        b.print_msg();
        a.defaut_print();
        b.defaut_print_b();
    }
}
