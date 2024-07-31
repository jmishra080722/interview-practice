package org.example.uber.singleton;

public class SingletonExampleDoubleCheck {
    private static SingletonExampleDoubleCheck instance;

    private SingletonExampleDoubleCheck(){}

    public static SingletonExampleDoubleCheck getInstance(){
        if (instance == null){
            synchronized (SingletonExampleDoubleCheck.class){
                if(instance == null){
                    instance = new SingletonExampleDoubleCheck();
                }
            }
        }
        return instance;
    }
}
