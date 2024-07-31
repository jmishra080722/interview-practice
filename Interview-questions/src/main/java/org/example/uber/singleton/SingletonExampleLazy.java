package org.example.uber.singleton;

public class SingletonExampleLazy {
    private static SingletonExampleLazy singletonExampleLazy;

    private SingletonExampleLazy(){};

    public static SingletonExampleLazy getSingletonExampleLazy() {
        if(singletonExampleLazy == null){
            singletonExampleLazy = new SingletonExampleLazy();
        }
        return singletonExampleLazy;
    }
}
