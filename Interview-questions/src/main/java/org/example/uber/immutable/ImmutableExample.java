package org.example.uber.immutable;

import org.example.uber.inheritance.A;

public class ImmutableExample {
    public static void main(String[] args) {
        Address a = new Address("Kali Mandeer", "Araria");
        Person p = new Person("Jay", 30, a);

        System.out.println("Name : "+p.getName());
        System.out.println("Age: "+p.getAge());
        System.out.println("Address: "+p.getAddress().getStreet()+" "+p.getAddress().getCity());

        //Changing address details
        Address a1 = p.getAddress();
        a1 = new Address("Janta Chowk", "Purnea");
        System.out.println("==============");
        System.out.println("Updated Address: " + a1.getStreet() + ", " + a1.getCity());
        System.out.println("Original Address: " + p.getAddress().getStreet() + ", " + p.getAddress().getCity());


    }
}
