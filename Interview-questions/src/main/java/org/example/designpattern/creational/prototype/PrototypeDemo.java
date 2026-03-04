package org.example.designpattern.creational.prototype;

public class PrototypeDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        BookStore bs = new BookStore();
        bs.setStoreName("Student");
        bs.loadBooks();

        BookStore bs1 =  bs.clone();
        /*//Below line will remove book form both object if we use sallow cloning.
         Commented clone method from BookStore class
        bs.getBooks().remove(2);*/

        //This will remove only from first object as we updated clone method in the BookStore class
        bs.getBooks().remove(2);
        bs1.setStoreName("A1");

        System.out.println(bs);
        System.out.println(bs1);
    }
}
