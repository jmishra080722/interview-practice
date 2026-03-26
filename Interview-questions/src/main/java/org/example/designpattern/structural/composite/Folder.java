package org.example.designpattern.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class Folder implements Component{
    private String folderName;
    private List<Component> components = new ArrayList<>();

    public Folder(String folderName){
        this.folderName = folderName;
    }

    public void add(Component component){
        this.components.add(component);
    }

    @Override
    public void showDetails() {
        System.out.println("I am a folder and my name is : "+this.folderName);
        System.out.println("I contains below files: ");
        for(Component c: components){
            c.showDetails();
        }
    }
}
