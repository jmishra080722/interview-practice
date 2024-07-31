package org.example.uber.copy;

import org.example.uber.inheritance.A;

public class DeepCopyExample {
    public static void main(String[] args) throws CloneNotSupportedException {
        Address2 a = new Address2("Araria", "Bihar");
        Person2 p = new Person2("Jay", a);

        Person2 p2 = (Person2) p.clone();
        System.out.println(p.getAddress().getCity());
        System.out.println(p2.getAddress().getCity());

        p2.getAddress().setCity("Purnea");

        System.out.println(p.getAddress().getCity());
        System.out.println(p2.getAddress().getCity());
    }
}
