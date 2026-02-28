package org.example.designPattern.structural.singleton;

public class LazyInitializeSingleton {
    private static LazyInitializeSingleton lazyInitializeSingleton;

    private LazyInitializeSingleton(){
        System.out.println("Creating LazyInitializeSingleton class object");
    }

    public static LazyInitializeSingleton getInstance(){
        if(lazyInitializeSingleton == null){
            lazyInitializeSingleton = new LazyInitializeSingleton();
        }
        return lazyInitializeSingleton;
    }
}
