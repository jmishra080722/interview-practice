package org.example.designPattern.structural.singleton;

public class StaticInnerClassSingleton {

    private StaticInnerClassSingleton(){
        System.out.println("Creating StaticInnerClassSingleton class Instance!");
    }
    private static class Holder{
        private static final StaticInnerClassSingleton INSTANCE = new StaticInnerClassSingleton();
    }

    public static StaticInnerClassSingleton getInstance(){
        return Holder.INSTANCE;
    }
}
