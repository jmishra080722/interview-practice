package org.example.designPattern.structural.singleton;

public enum EnumSingleton {
    INSTANCE;

    public void testMethod(){
        System.out.println("This is test method of "+this.getClass().getName());
    }
}
