package com.mycompany.librarymanagementsystem;

/**
 * Journal class that inherits from LibraryItem
 * Demonstrates inheritance by extending the base class
 */
public class Journal extends LibraryItem {
    private int issueNumber;

    public Journal(String title, String author, int issueNumber) {
        super(title, author); // Call to parent constructor
        this.issueNumber = issueNumber;
    }

    public int getIssueNumber() { return issueNumber; }
}