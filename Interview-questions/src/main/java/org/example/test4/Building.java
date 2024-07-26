package org.example.test4;

public class Building {
    Building(){
        System.out.println("Building");
    }
    Building(String name){
        this();
        System.out.println("Building: String constructor "+name);
    }

}
