import java.util.ArrayList;
import java.util.Scanner;
// Import required Java utilities
// Series class that handles all TV series management operations
public class Series {
    // ArrayList to store all series data
    private ArrayList<SeriesModel> seriesList = new ArrayList<>();
    // Scanner object for reading user input
    private Scanner scanner = new Scanner(System.in);
    // Method to capture and add a new series to the collection
    public void captureSeries() {
        // Create a new SeriesModel object to store series data
        SeriesModel series = new SeriesModel();
        System.out.println("CAPTURE A NEW SERIES");
        System.out.println("********************");
        // Get series ID from user
        System.out.print("Enter the series ID: ");
        series.seriesId = scanner.nextLine();
        // Get series name from user
        System.out.print("Enter the series name: ");
        series.seriesName = scanner.nextLine();

        // Validate age restriction
        while (true) {
            System.out.print("Enter the age restriction (2-18): ");
            String ageInput = scanner.nextLine();
            try {
                // Convert input to integer and validate range
                int age = Integer.parseInt(ageInput);
                if (age >= 2 && age <= 18) {
                    series.seriesAge = ageInput;
                    break;
                } else {
                    System.out.println("Invalid age restriction. Please enter a value between 2 and 18.");
                }
            } catch (NumberFormatException e) {
                 // Handle non-numeric input
                System.out.println("Invalid input. Only numbers are allowed for age restriction.");
            }
        }
        // Get number of episodes from user
        System.out.print("Enter the number of episodes: ");
        series.seriesNumberOfEpisodes = scanner.nextLine();
        // Add the new series to the collection
        seriesList.add(series);
        System.out.println("Series details have been successfully saved!");
    }
    // Method to search for a series by ID
    public void searchSeries() {
        System.out.println("SEARCH SERIES");
        System.out.println("*************");
        System.out.print("Enter the series ID to search: ");
        String searchId = scanner.nextLine();
        // Flag to track if series was found
        boolean found = false;
        // Iterate through all series to find matching ID
        for (SeriesModel series : seriesList) {
            if (series.seriesId.equals(searchId)) {
                // Display series details if found
                System.out.println("Series ID: " + series.seriesId);
                System.out.println("Series Name: " + series.seriesName);
                System.out.println("Age Restriction: " + series.seriesAge);
                System.out.println("Number of Episodes: " + series.seriesNumberOfEpisodes);
                found = true;
                break;
            }
        }
        // Display message if series not found
        if (!found) {
            System.out.println("Series with ID " + searchId + " not found.");
        }
    }
    // Method to update an existing series' details
    public void updateSeries() {
        System.out.println("UPDATE SERIES");
        System.out.println("*************");
        System.out.print("Enter the series ID to update: ");
        String updateId = scanner.nextLine();
        // Flag to track if series was found
        boolean found = false;
        // Iterate through series to find matching ID
        for (SeriesModel series : seriesList) {
            if (series.seriesId.equals(updateId)) {
                // Update series name (if provided)
                System.out.print("Enter new series name (current: " + series.seriesName + "): ");
                String newName = scanner.nextLine();
                if (!newName.isEmpty()) {
                    series.seriesName = newName;
                }

                // Validate and update age restriction
                while (true) {
                    System.out.print("Enter new age restriction (current: " + series.seriesAge + "): ");
                    String newAge = scanner.nextLine();
                    if (newAge.isEmpty()) {
                        break;// Keep current value if empty input
                    }
                    try {
                        int ageValue = Integer.parseInt(newAge);
                        if (ageValue >= 2 && ageValue <= 18) {
                            series.seriesAge = newAge;
                            break;
                        } else {
                            System.out.println("Invalid age. Must be between 2 and 18.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Only numbers are allowed.");
                    }
                }
                // Update number of episodes (if provided)
                System.out.print("Enter new number of episodes (current: " + series.seriesNumberOfEpisodes + "): ");
                String newEpisodes = scanner.nextLine();
                if (!newEpisodes.isEmpty()) {
                    series.seriesNumberOfEpisodes = newEpisodes;
                }

                System.out.println("Series updated successfully!");
                found = true;
                break;
            }
        }
        // Display message if series not found
        if (!found) {
            System.out.println("Series with ID " + updateId + " not found.");
        }
    }
    // Method to delete a series from the collection
    public void deleteSeries() {
        System.out.println("DELETE SERIES");
        System.out.println("*************");
        System.out.print("Enter the series ID to delete: ");
        String deleteId = scanner.nextLine();
        // Flag to track if series was found
        boolean found = false;
        // Iterate through series to find matching ID
        for (int i = 0; i < seriesList.size(); i++) {
            if (seriesList.get(i).seriesId.equals(deleteId)) {
                // Confirm deletion with user
                System.out.print("Are you sure you want to delete this series? (YES/NO): ");
                String confirmation = scanner.nextLine();
                if (confirmation.equalsIgnoreCase("YES")) {
                    seriesList.remove(i);
                    System.out.println("Series deleted successfully!");
                } else {
                    System.out.println("Deletion cancelled.");
                }
                found = true;
                break;
            }
        }
        // Display message if series not found
        if (!found) {
            System.out.println("Series with ID " + deleteId + " not found.");
        }
    }
     // Method to display all series in the collection
    public void seriesReport() {
        System.out.println("SERIES REPORT");
        System.out.println("*************");
        if (seriesList.isEmpty()) {
            System.out.println("No series available.");
            return;
        }
        // Iterate through and display all series
        for (SeriesModel series : seriesList) {
            System.out.println("Series ID: " + series.seriesId);
            System.out.println("Series Name: " + series.seriesName);
            System.out.println("Age Restriction: " + series.seriesAge);
            System.out.println("Number of Episodes: " + series.seriesNumberOfEpisodes);
            System.out.println("---------------------------------");
        }
    }
    // Method to cleanly exit the application
    public void exitSeriesApplication() {
        System.out.println("Exiting application...");
        scanner.close();// Close scanner to prevent resource leak
        System.exit(0);// Terminate application
    }
}