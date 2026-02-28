package org.example.designPattern.structural.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class SerializableSingleton implements Serializable {
    private static final long serialVersionUID = 1L;

    private static final SerializableSingleton INSTANCE = new SerializableSingleton();
    // private constructor
    private SerializableSingleton() {
        // optionally guard against reflection here
        // if (INSTANCE != null) {
        //     throw new IllegalStateException("Instance already created");
        // }
    }

    public static SerializableSingleton getInstance(){
        return INSTANCE;
    }

    public void doSomething() {
        System.out.println("Doing something in SerializableSingleton");
    }

    /**
     * This method is called after deserialization.
     * Returning the existing INSTANCE ensures we do not create a new object.
     */
    private Object readResolve() throws ObjectStreamException {
        return INSTANCE;
    }
}
