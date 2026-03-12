package org.example.designpattern.structural.bridge;

public class GreenCircle implements DrawAPI{
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing circle [ color: GREEN, Radius: "+radius+" x: "+x+" y: "+y);

    }
}
