package org.example.designpattern.creational.builder;

public class Shop {

    public static void main(String[] args) {
        //Here we have to pass all the fields.
        /*Phone phone = new Phone("Android", 4, 6.0, 4000, "QualComm");
        System.out.println(phone);*/

        //Here we do not need to pass all the fields. If we want we can pass.
        Phone phone1 = new PhoneBuilder().setOs("iOS").setRam(6).build();
        System.out.println(phone1);
    }
}
