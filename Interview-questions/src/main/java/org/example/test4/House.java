package org.example.test4;

import java.util.TreeSet;

public class House extends Building{
    House(){
        System.out.println("House");
    }
    House(String name){
        this();
        System.out.println("house: String constructor "+name);
    }

    public static void main(String[] args) {
        //new House("Test");
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("tree");
        treeSet.add("def");
        treeSet.add("tree");
        treeSet.add("treedeftree");
        for(String temp: treeSet){
            System.out.println(temp);
        }
    }
}
