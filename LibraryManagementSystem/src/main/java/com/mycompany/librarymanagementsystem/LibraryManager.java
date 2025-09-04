package com.mycompany.librarymanagementsystem;

/**
 * Manages library operations using arrays
 * Contains methods for checking items in/out and generating reports
 */
public class LibraryManager {
    private LibraryItem[] items; // Array for storing library items
    private int itemCount;

    public LibraryManager(int capacity) {
        items = new LibraryItem[capacity]; // Fixed-size array
        itemCount = 0;
    }

    public void addItem(LibraryItem item) {
        if (itemCount < items.length) {
            items[itemCount++] = item;
        }
    }

    // Check out item using loop and array access
    public boolean checkOutItem(String title) {
        for (int i = 0; i < itemCount; i++) {
            if (items[i].getTitle().equalsIgnoreCase(title) && !items[i].isCheckedOut()) {
                items[i].setCheckedOut(true);
                return true;
            }
        }
        return false;
    }

    // Check in item using loop and array access
    public boolean checkInItem(String title) {
        for (int i = 0; i < itemCount; i++) {
            if (items[i].getTitle().equalsIgnoreCase(title) && items[i].isCheckedOut()) {
                items[i].setCheckedOut(false);
                return true;
            }
        }
        return false;
    }

    // Generate report using console output
    public void generateReport() {
        System.out.println("\nLibrary Status Report");
        System.out.println("=====================");
        for (int i = 0; i < itemCount; i++) {
            LibraryItem item = items[i];
            String status = item.isCheckedOut() ? "Checked Out" : "Available";
            String type = item instanceof Book ? "Book" : "Journal";
            
            System.out.printf("Title: %-20s Author: %-15s Type: %-8s Status: %s%n",
                item.getTitle(),
                item.getAuthor(),
                type,
                status
            );
        }
    }
}