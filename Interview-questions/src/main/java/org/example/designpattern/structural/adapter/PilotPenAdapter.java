package org.example.designpattern.structural.adapter;

import org.example.designpattern.structural.adapter.third_party_library.PilotPen;

public class PilotPenAdapter implements Pen{

    private final PilotPen pilotPen;

    public PilotPenAdapter(PilotPen pilotPen) {
        this.pilotPen = pilotPen;
    }

    @Override
    public void write(String str) {
        pilotPen.mark(str);
    }
}
