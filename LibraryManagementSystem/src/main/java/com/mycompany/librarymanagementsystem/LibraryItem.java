package com.mycompany.librarymanagementsystem;

/**
 * Base class for all library items
 * Demonstrates information hiding with private fields and public getters/setters
 */
public class LibraryItem {
    // Private fields for information hiding
    private String title;
    private String author;
    private boolean checkedOut;

    // Constructor to initialize items
    public LibraryItem(String title, String author) {
        this.title = title;
        this.author = author;
        this.checkedOut = false;
    }

    // Getters and setters for encapsulated fields
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isCheckedOut() { return checkedOut; }
    public void setCheckedOut(boolean checkedOut) { this.checkedOut = checkedOut; }
}