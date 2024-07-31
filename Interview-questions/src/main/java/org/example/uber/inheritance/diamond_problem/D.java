package org.example.uber.inheritance.diamond_problem;

public class D implements C, B {

    public static void main(String[] args) {
        System.out.println("Hello....");
        D d = new D();
        d.method();
        B b = new D();
        b.method();
        C c = new D();
        c.method();
    }

    //If we implements more than one interface having same default method than we need to provide our own implementation
    @Override
    public void method() {
        C.super.method();
        //Or
        B.super.method();
        // Complete new implementation
    }
}
