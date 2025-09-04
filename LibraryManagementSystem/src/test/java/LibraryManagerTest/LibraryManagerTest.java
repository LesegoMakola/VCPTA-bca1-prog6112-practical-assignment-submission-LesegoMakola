package LibraryManagerTest;

import com.mycompany.librarymanagementsystem.Book;
import com.mycompany.librarymanagementsystem.LibraryManager;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for LibraryManager class
 * Tests the core functionality of the library management system
 */
public class LibraryManagerTest {
    
    @Test
    public void testCheckOutAvailableItem() {
        LibraryManager manager = new LibraryManager(5);
        manager.addItem(new Book("Test Book", "Author", "ISBN123"));
        assertTrue("Should be able to check out available item", 
                   manager.checkOutItem("Test Book"));
    }
    
    @Test
    public void testCheckOutAlreadyCheckedOutItem() {
        LibraryManager manager = new LibraryManager(5);
        manager.addItem(new Book("Test Book", "Author", "ISBN123"));
        manager.checkOutItem("Test Book");
        assertFalse("Should not be able to check out already checked out item", 
                    manager.checkOutItem("Test Book"));
    }
    
    @Test
    public void testCheckInItem() {
        LibraryManager manager = new LibraryManager(5);
        manager.addItem(new Book("Test Book", "Author", "ISBN123"));
        manager.checkOutItem("Test Book");
        assertTrue("Should be able to check in checked out item", 
                   manager.checkInItem("Test Book"));
    }
    
    @Test
    public void testCheckInItemNotCheckedOut() {
        LibraryManager manager = new LibraryManager(5);
        manager.addItem(new Book("Test Book", "Author", "ISBN123"));
        assertFalse("Should not be able to check in item that wasn't checked out", 
                    manager.checkInItem("Test Book"));
    }
    
    @Test
    public void testCheckOutNonExistentItem() {
        LibraryManager manager = new LibraryManager(5);
        manager.addItem(new Book("Test Book", "Author", "ISBN123"));
        assertFalse("Should not be able to check out non-existent item", 
                    manager.checkOutItem("Non Existent Book"));
    }
    
    @Test
    public void testAddItemsToFullLibrary() {
        LibraryManager manager = new LibraryManager(2);
        manager.addItem(new Book("Book 1", "Author 1", "ISBN1"));
        manager.addItem(new Book("Book 2", "Author 2", "ISBN2"));
        manager.addItem(new Book("Book 3", "Author 3", "ISBN3")); // This should not be added
        
        // Should be able to check out first two books
        assertTrue("Should be able to check in checked out item", manager.checkOutItem("Book 1"));
        assertTrue("Should be able to check in checked out item", manager.checkOutItem("Book 2"));
        
        // Should not be able to check out the third book
        assertFalse("Should not be able to check out non-existent item", manager.checkOutItem("Book 3"));
    }

    private void assertFalse(String should_not_be_able_to_check_out_nonexiste, boolean checkOutItem) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void assertTrue(String should_be_able_to_check_in_checked_out_it, boolean checkOutItem) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}