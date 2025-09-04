package com.mycompany.librarymanagementsystem;

import java.util.Scanner;

/**
 * Console application with menu-driven interface
 * Main entry point for the Library Management System
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibraryManager manager = new LibraryManager(10);
        
        // Initialize with some sample data
        manager.addItem(new Book("1984", "George Orwell", "978-0451524935"));
        manager.addItem(new Book("To Kill a Mockingbird", "Harper Lee", "978-0061120084"));
        manager.addItem(new Journal("Science Today", "Dr. Smith", 42));
        manager.addItem(new Journal("Nature Review", "Dr. Johnson", 15));
        
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Check Out Item");
            System.out.println("2. Check In Item");
            System.out.println("3. Generate Report");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    System.out.print("Enter item title to check out: ");
                    String checkoutTitle = scanner.nextLine();
                    if (manager.checkOutItem(checkoutTitle)) {
                        System.out.println("Item checked out successfully!");
                    } else {
                        System.out.println("Item not available or not found");
                    }
                    break;
                    
                case 2:
                    System.out.print("Enter item title to check in: ");
                    String checkinTitle = scanner.nextLine();
                    if (manager.checkInItem(checkinTitle)) {
                        System.out.println("Item checked in successfully!");
                    } else {
                        System.out.println("Item not found or not checked out");
                    }
                    break;
                    
                case 3:
                    manager.generateReport();
                    break;
                    
                case 4:
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}