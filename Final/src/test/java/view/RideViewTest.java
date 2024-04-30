package view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RideViewTest {

  private RideView rideView;
  private ByteArrayOutputStream outputStream;

  @BeforeEach
  void setUp() {
    rideView = new RideView();
    outputStream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputStream));
  }

  @Test
  void testDisplayAverageWaitTime() {
    rideView.displayAverageWaitTime(10.5);
    assertEquals("Average wait time for a ride: 10.5 s\n", outputStream.toString());
  }

  @Test
  void testDisplayAverageRidesPerDriver() {
    rideView.displayAverageRidesPerDriver(8.2);
    assertEquals("Average number of rides a driver has handled: 8.2\n", outputStream.toString());
  }

  @Test
  public void displayScenarioInfo_DisplaysCorrectInfo() {
    rideView.displayScenarioInfo(1, 2);

    // Verify that the scenario information is displayed correctly
    String expectedInfo = "\nSimulation Scenario Information:\n" +
        "Number of Drivers: 1\n" +
        "Number of Rides: 2\n\n";
    assertEquals(expectedInfo, outputStream.toString());
  }
}
