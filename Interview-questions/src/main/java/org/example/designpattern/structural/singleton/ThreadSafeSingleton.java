package org.example.designPattern.structural.singleton;

public class ThreadSafeSingleton {
    private static ThreadSafeSingleton threadSafSingletonInstance;

    private ThreadSafeSingleton(){
        System.out.println("Creating ThreadSafeSingleton class object");
    }

    public static  synchronized ThreadSafeSingleton getInstance(){
        if(threadSafSingletonInstance == null){
            threadSafSingletonInstance = new ThreadSafeSingleton();
        }
        return threadSafSingletonInstance;
    }
}
