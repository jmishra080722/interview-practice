package org.example.designpattern.structural.adapter.third_party_library;

public class PilotPen {

    //This has no relationship with Pen interface but
    //This class will have every thing a pen should have.
    // So we will not create an Implementation of Pen Interface,
    // instead  we will use this using an Adapter for pen
    public void mark(String str){
        System.out.println(str);
    }
}
