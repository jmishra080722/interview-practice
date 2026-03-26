package org.example.designpattern.structural.composite;

public class File implements Component{

    private String fileName;

    public File(String fileName){
        this.fileName = fileName;
    }
    @Override
    public void showDetails() {
        System.out.println("I am a file and my name is : "+this.fileName);
    }
}
