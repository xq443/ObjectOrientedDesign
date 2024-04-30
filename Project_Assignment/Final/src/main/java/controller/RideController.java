package controller;

import model.Ride;
import service.RideServiceImpl;
import view.RideView;

/**
 * The RideController class coordinates the simulation of ride requests and driver assignments.
 * Also, it connects with the VIEW to display the required output
 */
public class RideController {
  private static final Integer CASE_1 = 25;
  private static final Integer CASE_2 = 100;
  private static final Integer CASE_3 = 250;

  private static final int[] rides = {CASE_1, CASE_2, CASE_3};
  RideView rideView = new RideView();

  /**
   * Simulates ride requests and driver assignments for different scenarios.
   *
   * @param numberOfDrivers The number of available drivers.
   */
  public void simulate(int numberOfDrivers) {
    for (int numberOfRides : rides) {
      RideServiceImpl rideService = new RideServiceImpl(numberOfDrivers);
      rideView.displayScenarioInfo(numberOfDrivers, numberOfRides);
      simulateHelper(rideService, numberOfRides, numberOfDrivers);
    }
  }

  /**
   * Helper method for simulating ride requests and driver assignments.
   *
   * @param rideService  The RideService instance to handle ride requests and assignments.
   * @param numberOfRides The number of rides to simulate.
   * @param numOfDrivers The number of available drivers.
   */
  private void simulateHelper(RideServiceImpl rideService, int numberOfRides, int numOfDrivers) {
    for (int i = 0; i < numberOfRides; i++) {
      Ride ride = RideFactory.createRide();
      rideService.requestRide(ride);
      while (!rideService.getRideRequested().isEmpty()) {
        rideService.updateDrivers();
        // if there are drivers available, assign ride
        if (rideService.availableDrivers > 0) {
          rideService.assignRide();
        }
      }
    }
    double averageWaitTime = rideService.calculateAverageWaitTime(numOfDrivers);
    double averageRidesPerDriver = rideService.calculateAverageRidesPerDriver(numOfDrivers);
    rideView.displayAverageWaitTime(averageWaitTime);
    rideView.displayAverageRidesPerDriver(averageRidesPerDriver);
  }
}
