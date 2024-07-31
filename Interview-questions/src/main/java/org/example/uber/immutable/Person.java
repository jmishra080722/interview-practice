package org.example.uber.immutable;

import org.example.uber.copy.Address2;
import org.example.uber.copy.Person2;

public final class Person {

    private final String name;
    private final int age;
    private final Address address;

    Person(String name, int age, Address address){
        this.name = name;
        this.age = age;
        this.address = new Address(address.getStreet(), address.getCity());
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        return new Address(address.getStreet(), address.getCity());
    }
}
