package org.example.uber.copy;

import org.example.uber.inheritance.diamond_problem.A;

/*
* Characteristics of Shallow Copy
        Primitive Fields: The values are copied directly.
        Reference Fields: Only the reference is copied, so both the original and the copy share the same object.
*/
public class ShallowCopyExample {
    public static void main(String[] args) throws CloneNotSupportedException {
        Address a1 = new Address("Araria", "Bihar");
        Person p1 = new Person("Jay", a1);

        Person p2 = p1.clone();
        System.out.println(p1.getAddress().getCity());
        System.out.println(p2.getAddress().getCity());

        p2.getAddress().setCity("Purnea");
        System.out.println(p1.getAddress().getCity());
        System.out.println(p2.getAddress().getCity());
    }
}
