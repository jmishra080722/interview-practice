package org.example.uber.copy;

public class Address2 implements Cloneable{

    String city;
    String state;

    public Address2(String city, String state) {
        this.city = city;
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public Address2 clone() throws CloneNotSupportedException{
        return (Address2) super.clone();
    }
}
