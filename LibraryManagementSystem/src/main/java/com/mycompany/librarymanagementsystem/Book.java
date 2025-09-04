package com.mycompany.librarymanagementsystem;

/**
 * Book class that inherits from LibraryItem
 * Demonstrates inheritance by extending the base class
 */
public class Book extends LibraryItem {
    private String isbn;

    public Book(String title, String author, String isbn) {
        super(title, author); // Call to parent constructor
        this.isbn = isbn;
    }

    public String getIsbn() { return isbn; }
}