package org.example.designPattern.structural.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) throws Exception {

        /*EagerInitializeSingleton eis1 = EagerInitializeSingleton.getInstance();
        EagerInitializeSingleton eis2 = EagerInitializeSingleton.getInstance();
        System.out.println(eis1.hashCode()+" : "+eis2.hashCode());*/


        /*LazyInitializeSingleton lis1 = LazyInitializeSingleton.getInstance();
        LazyInitializeSingleton lis2 = LazyInitializeSingleton.getInstance();
        System.out.println(lis1.hashCode()+" : "+lis2.hashCode());*/

        /*ThreadSafeSingleton tss1 = ThreadSafeSingleton.getInstance();
        ThreadSafeSingleton tss2 = ThreadSafeSingleton.getInstance();
        System.out.println(tss1.hashCode()+" : "+ tss2.hashCode());*/


        /*DoubleCheckLocking dcl1 = DoubleCheckLocking.getInstance();
        DoubleCheckLocking dcl2 = DoubleCheckLocking.getInstance();
        System.out.println(dcl1.hashCode()+" : "+ dcl2.hashCode());*/

        /*StaticInnerClassSingleton sis1 = StaticInnerClassSingleton.getInstance();
        StaticInnerClassSingleton sis2 = StaticInnerClassSingleton.getInstance();
        System.out.println(sis1.hashCode()+ " : "+sis2.hashCode());*/

        /*EnumSingleton es1 = EnumSingleton.INSTANCE;
        EnumSingleton es2 = EnumSingleton.INSTANCE;
        System.out.println(es1.hashCode()+" : "+es2.hashCode());*/



        SerializableSingleton instance1 = SerializableSingleton.getInstance();
        // Serialize to a file
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("singleton.ser"))) {
            oos.writeObject(instance1);
        }

        // Deserialize from the file
        SerializableSingleton instance2;
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("singleton.ser"))) {
            instance2 = (SerializableSingleton) ois.readObject();
        }

        // Both references should point to the same object
        System.out.println("instance1 hashCode: " + instance1.hashCode());
        System.out.println("instance2 hashCode: " + instance2.hashCode());
        System.out.println("Same instance? " + (instance1 == instance2));
    }
}
