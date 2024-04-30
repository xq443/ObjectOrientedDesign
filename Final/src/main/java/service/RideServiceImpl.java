package service;

import java.util.Comparator;
import java.util.PriorityQueue;
import model.Ride;

/**
 * The RideServiceImpl class provides implementation for managing ride requests
 * and driver assignments.
 */
public class RideServiceImpl implements RideService {
  private static final int MINIMUM_PRIORITY_VALUE = -1;
  private static final int MAXIMUM_PRIORITY_VALUE = 1;
  private static final int MILLIS_IN_SECONDS = 1000;
  private static final double DEFAULT_VALUE = 0.0;

  private PriorityQueue<Ride> rideRequested;
  private PriorityQueue<Ride> activeRides;
  public int availableDrivers;

  /**
   * Constructs a new RideServiceImpl object with the specified number of drivers.
   *
   * @param numberOfDrivers The number of drivers available.
   */
  public RideServiceImpl(int numberOfDrivers) {
    // Initialize the queues
    this.rideRequested = new PriorityQueue<>(new Comparator<Ride>() {
      @Override
      public int compare(Ride ride1, Ride ride2) {
        if (isHigherPriority(ride1, ride2)) {
          return MINIMUM_PRIORITY_VALUE; // ride1 has higher priority
        } else if (isHigherPriority(ride2, ride1)) {
          return MAXIMUM_PRIORITY_VALUE; // ride2 has higher priority
        } else {
          // If neither ride has higher priority, the longer anticipatedDistance has higher priority
          return Double.compare(ride1.getAnticipatedDistance(), ride2.getAnticipatedDistance());
        }
      }
    });

    // sorted by start-time in asc order
    this.activeRides = new PriorityQueue<>(Comparator.comparingLong(Ride::getStartTime));

    this.availableDrivers = numberOfDrivers;
  }

  /**
   * Requests a ride by adding it to the queue of requested rides.
   *
   * @param ride The ride to be requested.
   */
  @Override
  // customers request rides -> Ride object is created, enqueue the object into rideRequested
  public void requestRide(Ride ride) {
    rideRequested.offer(ride);
  }

  /**
   * Assigns rides to available drivers.
   */
  @Override
  // try to assign rides to available drivers
  public void assignRide() {
    while (!rideRequested.isEmpty()) {
      Ride assignedRide = rideRequested.poll();
      activeRides.offer(assignedRide); // enqueue the ride into active Rides
      availableDrivers--;
    }
  }

  /**
   * Updates the availability status of drivers based on completed rides.
   */
  @Override
  // Update the availability status of drivers based on completed rides
  public void updateDrivers() {
    long currentTime = System.currentTimeMillis();
    // Identify completed rides
    for (Ride ride : activeRides) {
      if (ride.getEndTime() <= currentTime) {
        availableDrivers++;
      }
    }
  }

  /**
   * Determines if a ride has higher priority than another ride.
   *
   * @param ride        The first ride to compare.
   * @param anotherRide The second ride to compare.
   * @return True if the first ride has higher priority, false otherwise.
   */
  @Override
  // Determine if a ride has higher priority than another ride
  public boolean isHigherPriority(Ride ride, Ride anotherRide) {
    long newRequestTime = ride.getRequestTime();
    long anotherRequestTime = anotherRide.getRequestTime();

    // Compare the type of rides' priority ordinal: number is lower, priority is higher
    if (ride.getPriority() < anotherRide.getPriority()) {
      return true; // newRide's priority is higher
    } else if (anotherRide.getPriority() < ride.getPriority()) {
      return false; // anotherRideType's priority is higher
    } else { // If type of the rides are the same
      // anotherRide has an earlier request time, hence higher priority
      return newRequestTime < anotherRequestTime;
    }
  }

  /**
   * Calculates the average wait time for rides given the number of drivers.
   *
   * @param numberOfDrivers The number of available drivers.
   * @return The average wait time for rides in seconds.
   */
  @Override
// Calculate the average wait time for rides given the number of drivers
  public double calculateAverageWaitTime(int numberOfDrivers) {
    long totalWaitTime = 0;
    int totalAssignedRides = 0;

    int totalRidesHandled = this.activeRides.size();

    // Edge case: if numOfDrivers >= numOfRides, the wait-time can be regarded as 0
    if (numberOfDrivers >= totalRidesHandled) {
      return DEFAULT_VALUE;
    }

    // copy the activeRides queue
    PriorityQueue<Ride> sortedRides = new PriorityQueue<>(this.activeRides);
    int delta = numberOfDrivers; // for the first delta rides, do not need to wait
    // remove those rides that do not need to wait
    while (delta > 0 && !sortedRides.isEmpty()) {
      sortedRides.poll();
      totalAssignedRides++;
      delta--;
    }

    // Calculate average wait time for the remaining rides
    while (!sortedRides.isEmpty()) {
      Ride ride = sortedRides.poll();
      long waitTime = Math.max(0, ride.getStartTime() - ride.getRequestTime());
      totalWaitTime += waitTime;
      totalAssignedRides++;
    }

    // Calculate average wait time
    double averageWaitTime = (totalAssignedRides > DEFAULT_VALUE ? (double) totalWaitTime / totalAssignedRides : DEFAULT_VALUE);
    return averageWaitTime / MILLIS_IN_SECONDS; // in seconds
  }


  /**
   * Calculates the average number of rides handled per driver given the total number of drivers.
   *
   * @param numberOfDrivers The total number of drivers.
   * @return The average number of rides handled per driver.
   */
  @Override
  // Calculate the average number of rides handled per driver given the total number of drivers
  public double calculateAverageRidesPerDriver(int numberOfDrivers) {
    // Get the total number of rides handled by all drivers
    // active rides -> rides that have been assigned to drivers
    int totalRidesHandled = this.activeRides.size();

    // Calculate average rides per driver
    return numberOfDrivers > DEFAULT_VALUE ?
        (double) totalRidesHandled / numberOfDrivers : DEFAULT_VALUE;
  }

  /**
   * Retrieves the queue of active rides.
   *
   * @return The queue of active rides.
   */
  public PriorityQueue<Ride> getActiveRides() {
    return activeRides;
  }

  public PriorityQueue<Ride> getRideRequested() {
    return rideRequested;
  }
}
