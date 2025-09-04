import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

public class SeriesTest {
    private Series series;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    
    @BeforeEach
    public void setUp() {
        series = new Series();
        System.setOut(new PrintStream(outputStream));
    }
    
    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
    }
    
    @Test
    public void TestSearchSeries() {
        // Add a series first
        String input = "S001\nTest Series\n12\n24\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        series.captureSeries();
        
        // Reset output
        outputStream.reset();
        
        // Search for the series
        String searchInput = "S001\n";
        System.setIn(new ByteArrayInputStream(searchInput.getBytes()));
        series.searchSeries();
        
        String output = outputStream.toString();
        assertTrue(output.contains("Series ID: S001"));
        assertTrue(output.contains("Test Series"));
        assertTrue(output.contains("12"));
        assertTrue(output.contains("24"));
    }
    
    @Test
    public void TestSearchSeries_SeriesNotFound() {
        String input = "S999\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        series.searchSeries();
        
        String output = outputStream.toString();
        assertTrue(output.contains("not found"));
    }
    
    @Test
    public void TestUpdateSeries() {
        // Add a series first
        String addInput = "S002\nOriginal Name\n14\n10\n";
        System.setIn(new ByteArrayInputStream(addInput.getBytes()));
        series.captureSeries();
        
        // Reset output
        outputStream.reset();
        
        // Update the series
        String updateInput = "S002\nUpdated Name\n16\n20\n";
        System.setIn(new ByteArrayInputStream(updateInput.getBytes()));
        series.updateSeries();
        
        String output = outputStream.toString();
        assertTrue(output.contains("Series updated successfully"));
        
        // Verify the update
        outputStream.reset();
        String searchInput = "S002\n";
        System.setIn(new ByteArrayInputStream(searchInput.getBytes()));
        series.searchSeries();
        
        output = outputStream.toString();
        assertTrue(output.contains("Updated Name"));
        assertTrue(output.contains("16"));
        assertTrue(output.contains("20"));
    }
    
    @Test
    public void TestDeleteSeries() {
        // Add a series first
        String addInput = "S003\nTo Delete\n10\n5\n";
        System.setIn(new ByteArrayInputStream(addInput.getBytes()));
        series.captureSeries();
        
        // Reset output
        outputStream.reset();
        
        // Delete the series
        String deleteInput = "S003\nYES\n";
        System.setIn(new ByteArrayInputStream(deleteInput.getBytes()));
        series.deleteSeries();
        
        String output = outputStream.toString();
        assertTrue(output.contains("Series deleted successfully"));
        
        // Verify deletion
        outputStream.reset();
        String searchInput = "S003\n";
        System.setIn(new ByteArrayInputStream(searchInput.getBytes()));
        series.searchSeries();
        
        output = outputStream.toString();
        assertTrue(output.contains("not found"));
    }
    
    @Test
    public void TestDeleteSeries_SeriesNotFound() {
        String deleteInput = "S999\n";
        System.setIn(new ByteArrayInputStream(deleteInput.getBytes()));
        series.deleteSeries();
        
        String output = outputStream.toString();
        assertTrue(output.contains("not found"));
    }
    
    @Test
    public void TestSeriesAgeRestriction_AgeValid() {
        // Test valid age input
        String input = "S004\nTest Series\n12\n10\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        series.captureSeries();
        
        String output = outputStream.toString();
        assertTrue(output.contains("successfully saved"));
    }
    
    @Test
    public void TestSeriesAgeRestriction_SeriesAgeInValid() {
        // Test invalid age input (non-number)
        String input = "S005\nTest Series\nabc\n10\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        series.captureSeries();
        
        String output = outputStream.toString();
        assertTrue(output.contains("Only numbers are allowed"));
        
        // Reset output
        outputStream.reset();
        
        // Test invalid age input (out of range)
        String input2 = "S006\nTest Series\n20\n10\n";
        System.setIn(new ByteArrayInputStream(input2.getBytes()));
        series.captureSeries();
        
        output = outputStream.toString();
        assertTrue(output.contains("between 2 and 18"));
    }
}