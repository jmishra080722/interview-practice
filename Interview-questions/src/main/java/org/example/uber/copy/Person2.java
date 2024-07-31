package org.example.uber.copy;

public class Person2 implements Cloneable{

    String name;
    Address2 address2;

    public Person2(String name, Address2 address2) {
        this.name = name;
        this.address2 = address2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address2 getAddress() {
        return address2;
    }

    public void setAddress(Address2 address2) {
        this.address2 = address2;
    }

    @Override
    public Person2 clone() throws CloneNotSupportedException {
            Person2 clone = (Person2) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            clone.address2 = (Address2) address2.clone();
            return clone;
    }
}
