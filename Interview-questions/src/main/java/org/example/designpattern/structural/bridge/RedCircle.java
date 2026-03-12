package org.example.designpattern.structural.bridge;

public class RedCircle implements DrawAPI{
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing circle [ color: RED, Radius: "+radius+" x: "+x+" y: "+y);
    }
}
