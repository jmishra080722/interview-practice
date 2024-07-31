package org.example.uber.singleton;

public class SingletonExampleEager {

    private static final SingletonExampleEager singSingletonExample = new SingletonExampleEager();

    private SingletonExampleEager(){
    }

    public static SingletonExampleEager getObjOfSingletonExample(){
        return singSingletonExample;
    }
}
