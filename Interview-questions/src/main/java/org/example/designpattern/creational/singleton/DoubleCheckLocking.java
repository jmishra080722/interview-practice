package org.example.designPattern.structural.singleton;

public class DoubleCheckLocking {
    private static volatile DoubleCheckLocking instance;

    private DoubleCheckLocking(){
        System.out.println("Creating DoubleCheckLocking class object");
    }

    public static synchronized DoubleCheckLocking getInstance(){
        if(instance == null){
            synchronized (DoubleCheckLocking.class){
                if(instance == null){
                    instance = new DoubleCheckLocking();
                }
            }
        }
        return instance;
    }
}
