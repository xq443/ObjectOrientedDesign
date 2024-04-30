package controller;

import model.Customer;
import model.Ride;
import model.RideType;

import java.util.Random;

/**
 * The RideFactory class generates random Ride objects for simulation purposes.
 */
public class RideFactory {
  private static final int MAX_CUSTOMER_ID = 100;
  private static final int MAX_LOCATIONS = 10;
  private static final double MAX_RIDE_DISTANCE = 10.0;
  private static final double AVERAGE_SPEED = 60.0;
  private static final long MILLIS_IN_HOUR = 3600000L;
  private static final int MILLIS_IN_SECONDS = 1000;
  private static final int DELAY_IN_SECONDS = 30;
  private static final double DEFAULT_SPEED = 60.0;

  /**
   * Creates a random Ride object with randomly generated attributes.
   *
   * @return A randomly generated Ride object.
   */
  public static Ride createRide() {
    Random random = new Random();

    // Generating a random customer id
    String customerId = String.valueOf(random.nextInt(MAX_CUSTOMER_ID));

    // Generating random starting and desired locations
    String startingLocation = "Location_" + random.nextInt(MAX_LOCATIONS);
    String desiredLocation = "Location_" + random.nextInt(MAX_LOCATIONS);

    // Generating random ride distance
    double anticipatedRideDistance = random.nextDouble() * MAX_RIDE_DISTANCE;

    // Calculate ride duration based on anticipated ride distance and average speed
    long rideDuration = (long) ((anticipatedRideDistance / AVERAGE_SPEED) * MILLIS_IN_HOUR);

    // Generating random ride type
    RideType rideType = RideType.values()[random.nextInt(RideType.values().length)];

    // Generating random timestamps for ride request and ride start time
    long rideRequestedTime = System.currentTimeMillis();

    // Adding delay of half minutes to accelerate the test operation speed
    long rideStartTime = rideRequestedTime + random.nextInt(DELAY_IN_SECONDS * MILLIS_IN_SECONDS);
    long rideEndTime = rideStartTime + rideDuration;

    // Calculating ride length
    double length = DEFAULT_SPEED * rideDuration;

    // Creating the random ride object
    return new Ride(new Customer(customerId), startingLocation, desiredLocation,
        anticipatedRideDistance, rideRequestedTime, rideType, rideStartTime,
        rideEndTime, length);
  }
}
