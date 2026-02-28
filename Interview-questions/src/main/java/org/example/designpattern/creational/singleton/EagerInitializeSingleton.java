package org.example.designPattern.structural.singleton;

public class EagerInitializeSingleton {
    private static final EagerInitializeSingleton eagerInitializedSingleton = new EagerInitializeSingleton();
    private EagerInitializeSingleton(){
        System.out.println("Intializing EagerInitializeSingleton class object!");
    }

    public static EagerInitializeSingleton getInstance(){
        return eagerInitializedSingleton;
    }
}
