package view;

/**
 * The RideView class provides methods for displaying ride simulation information.
 */
public class RideView {

  /**
   * Displays the average wait time for a ride.
   *
   * @param averageWaitTime The average wait time for a ride in seconds.
   */
  public void displayAverageWaitTime(double averageWaitTime) {
    System.out.println("Average wait time for a ride: " + averageWaitTime + " s");
  }

  /**
   * Displays the average number of rides a driver has handled.
   *
   * @param averageRidesPerDriver The average number of rides per driver.
   */
  public void displayAverageRidesPerDriver(double averageRidesPerDriver) {
    System.out.println("Average number of rides a driver has handled: " + averageRidesPerDriver);
  }

  /**
   * Displays the scenario information for the simulation.
   *
   * @param numberOfDrivers The number of drivers participating in the simulation.
   * @param numberOfRides The number of rides in the simulation.
   */
  public void displayScenarioInfo(int numberOfDrivers, int numberOfRides) {
    System.out.println("\nSimulation Scenario Information:");
    System.out.println("Number of Drivers: " + numberOfDrivers);
    System.out.println("Number of Rides: " + numberOfRides);
    System.out.println();
  }
}
