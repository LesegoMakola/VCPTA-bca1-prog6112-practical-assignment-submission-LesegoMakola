import java.util.Scanner;
//Import the Scanner class for user input
// Main class that serves as the entry point of the application
public class Main {
    public static void main(String[] args) {
        // Create a Series instance to manage series operations
        Series seriesManager = new Series();
        // Create a Scanner object to read user input from the console
        Scanner menuScanner = new Scanner(System.in);
        // Main application loop - continues until user chooses to exit
        while (true) {
            // Display the main menu options
            System.out.println("TV SERIES MANAGEMENT APPLICATION");
            System.out.println("********************************");
            System.out.println("1. Capture a new series");
            System.out.println("2. Search series");
            System.out.println("3. Update series");
            System.out.println("4. Delete series");
            System.out.println("5. Display series report");
            System.out.println("6. Exit application");
            System.out.print("Enter your choice (1-6): ");
            // Read user's menu choice
            String choice = menuScanner.nextLine();
            // Process user's choice using a switch statement
            switch (choice) {
                case "1":
                    seriesManager.captureSeries();// Add a new series
                    break;
                case "2":
                    seriesManager.searchSeries();// Search existing series
                    break;
                case "3":
                    seriesManager.updateSeries();// Update series details
                    break;
                case "4":
                    seriesManager.deleteSeries();// Delete a series
                    break;
                case "5":
                    seriesManager.seriesReport();// Display all series
                    break;
                case "6":
                    seriesManager.exitSeriesApplication();// Exit the program
                    break;
                default:
                    // Handle invalid menu choices
                    System.out.println("Invalid choice. Please select 1-6.");
            }
            
            System.out.println(); // Add a blank line for readability
        }
    }
}