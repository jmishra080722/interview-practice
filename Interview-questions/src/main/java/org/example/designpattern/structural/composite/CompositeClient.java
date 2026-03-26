package org.example.designpattern.structural.composite;

public class CompositeClient {
    public static void main(String[] args) {
        File file1 = new File("file1.txt");
        File file2 = new File("file2.txt");

        Folder folder = new Folder("root");
        folder.add(file1);
        folder.add(file2);

        folder.showDetails();
    }
}
