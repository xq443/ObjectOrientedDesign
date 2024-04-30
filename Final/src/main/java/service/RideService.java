package service;

import model.Ride;
import java.util.PriorityQueue;

/**
 * The RideService interface defines methods for managing ride requests and driver assignments.
 */
public interface RideService {

  /**
   * Requests a ride by adding it to the queue of requested rides.
   *
   * @param ride The ride to be requested.
   */
  void requestRide(Ride ride);

  /**
   * Assigns rides to available drivers.
   */
  void assignRide();

  /**
   * Updates the availability status of drivers based on completed rides.
   */
  void updateDrivers();

  /**
   * Determines if a ride has higher priority than another ride.
   *
   * @param ride        The first ride to compare.
   * @param anotherRide The second ride to compare.
   * @return True if the first ride has higher priority, false otherwise.
   */
  boolean isHigherPriority(Ride ride, Ride anotherRide);

  /**
   * Calculates the average wait time for rides given the number of drivers.
   *
   * @param numberOfDrivers The number of available drivers.
   * @return The average wait time for rides in seconds.
   */
  double calculateAverageWaitTime(int numberOfDrivers);

  /**
   * Calculates the average number of rides handled per driver given the total number of drivers.
   *
   * @param numberOfDrivers The total number of drivers.
   * @return The average number of rides handled per driver.
   */
  double calculateAverageRidesPerDriver(int numberOfDrivers);

  /**
   * Retrieves the queue of active rides.
   *
   * @return The queue of active rides.
   */
  PriorityQueue<Ride> getActiveRides();

  /**
   * Retrieves the queue of requested rides.
   *
   * @return The queue of requested rides.
   */
  PriorityQueue<Ride> getRideRequested();
}
