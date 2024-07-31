package org.example.uber.singleton;

public class SingletonExampleThreadSafe {
    private static SingletonExampleThreadSafe instance;

    private SingletonExampleThreadSafe(){}

    public static synchronized SingletonExampleThreadSafe getInstance(){
        if(instance == null){
            instance = new SingletonExampleThreadSafe();
        }
        return instance;
    }
}
