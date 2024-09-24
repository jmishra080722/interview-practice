package org.example.uber.enm;

public class PlanetTest {
    public static void main(String[] args) {
        for (Planet p : Planet.values()) {
            System.out.printf("Surface gravity on %s is %f m/s^2%n", p, p.surfaceGravity());
        }
    }
}
