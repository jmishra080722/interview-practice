package org.example.designpattern.creational.prototype;

import java.util.ArrayList;
import java.util.List;

public class BookStore implements Cloneable {

    private String storeName;
    private List<Book> books = new ArrayList<>();

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void loadBooks(){
        System.out.println("Loading books.....");
        for(int i = 1; i<=10; i++){
            Book b = new Book();
            b.setBookName("Book "+i);
            b.setBookId(i);
            getBooks().add(b);
        }
    }

    // Shallow cloning - copies object but shares references to nested objects
    /*@Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }*/

    // Deep cloning - creates new instances of nested objects
    @Override
    protected BookStore clone() throws CloneNotSupportedException {
        BookStore shop = new BookStore();
        shop.setStoreName(this.storeName); // Copy storeName field
        // Deep clone: create new Book instances instead of sharing references
        for(Book b: this.getBooks()){
            shop.getBooks().add(b.clone()); // Clone each Book object
        }
        return shop;
    }

    @Override
    public String toString() {
        return "BookStore{" +
                "storeName='" + storeName + '\'' +
                ", books=" + books +
                '}';
    }
}
