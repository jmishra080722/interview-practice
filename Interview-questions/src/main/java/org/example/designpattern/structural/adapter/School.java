package org.example.designpattern.structural.adapter;

import org.example.designpattern.structural.adapter.third_party_library.PilotPen;

public class School {
    public static void main(String[] args) {

        //PilotPen pp = new PilotPen();

        PilotPenAdapter pa = new PilotPenAdapter(new PilotPen());
        Assignment as = new Assignment();
        // as.setP(pp); //This will not work
        as.setP(pa);
        as.writeAssignment("Complete this work during vacation.... ");
    }
}
