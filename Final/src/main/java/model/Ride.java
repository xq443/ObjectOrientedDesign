package model;

import java.util.Objects;

/**
 * The Ride class represents a ride requested by a customer.
 */
public class Ride {
  // Define constants for priority levels
  public static final int PRIORITY_EXPRESS = 1;
  public static final int PRIORITY_STANDARD = 2;
  public static final int PRIORITY_WAIT_AND_SAVE = 3;
  public static final int PRIORITY_ENVIRONMENTALLY_CONSCIOUS = 4;

  private Customer customer;
  private String startingLocation;
  private String desiredLocation;
  private double anticipatedDistance;
  private long requestTime;
  private RideType rideType;
  private long startTime;
  private long endTime;
  private double length;

  /**
   * Constructs a new Ride with the specified parameters.
   *
   * @param customer           the customer who requested the ride
   * @param startingLocation   the starting location of the ride
   * @param desiredLocation    the desired destination of the ride
   * @param anticipatedDistance the anticipated distance of the ride
   * @param requestTime        the time when the ride was requested
   * @param rideType           the type of the ride
   * @param startTime          the time when the ride started
   * @param endTime            the time when the ride ended
   * @param length             the length of the ride
   */
  public Ride(Customer customer, String startingLocation, String desiredLocation,
      double anticipatedDistance, long requestTime, RideType rideType, long startTime, long endTime,
      double length) {
    this.customer = customer;
    this.startingLocation = startingLocation;
    this.desiredLocation = desiredLocation;
    this.anticipatedDistance = anticipatedDistance;
    this.requestTime = requestTime;
    this.rideType = rideType;
    this.startTime = startTime;
    this.endTime = endTime;
    this.length = length;
  }

  // Getters for ride properties

  /**
   * Returns the customer who requested the ride.
   *
   * @return the customer who requested the ride
   */
  public Customer getCustomer() {
    return customer;
  }

  /**
   * Returns the starting location of the ride.
   *
   * @return the starting location of the ride
   */
  public String getStartingLocation() {
    return startingLocation;
  }

  /**
   * Returns the desired destination of the ride.
   *
   * @return the desired destination of the ride
   */
  public String getDesiredLocation() {
    return desiredLocation;
  }

  /**
   * Returns the anticipated distance of the ride.
   *
   * @return the anticipated distance of the ride
   */
  public double getAnticipatedDistance() {
    return anticipatedDistance;
  }

  /**
   * Returns the time when the ride was requested.
   *
   * @return the time when the ride was requested
   */
  public long getRequestTime() {
    return requestTime;
  }

  /**
   * Returns the type of the ride.
   *
   * @return the type of the ride
   */
  public RideType getRideType() {
    return rideType;
  }

  /**
   * Returns the time when the ride started.
   *
   * @return the time when the ride started
   */
  public long getStartTime() {
    return startTime;
  }

  /**
   * Returns the time when the ride ended.
   *
   * @return the time when the ride ended
   */
  public long getEndTime() {
    return endTime;
  }

  /**
   * Returns the length of the ride.
   *
   * @return the length of the ride
   */
  public double getLength() {
    return length;
  }

  /**
   * Returns the priority of the ride based on its type.
   *
   * @return the priority of the ride
   */
  public int getPriority() {
    // Switch expression using the defined constants
    return switch (rideType) {
      case Express -> PRIORITY_EXPRESS;
      case Standard -> PRIORITY_STANDARD;
      case WaitAndSave -> PRIORITY_WAIT_AND_SAVE;
      case EnvironmentallyConscious -> PRIORITY_ENVIRONMENTALLY_CONSCIOUS;
    };
  }

  /**
   * Indicates whether some other object is "equal to" this one.
   *
   * @param o the reference object with which to compare
   * @return true if this object is the same as the obj argument; false otherwise
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Ride ride = (Ride) o;
    return Double.compare(ride.anticipatedDistance, anticipatedDistance) == 0
        && requestTime == ride.requestTime && startTime == ride.startTime && endTime == ride.endTime
        && Double.compare(ride.length, length) == 0 && Objects.equals(customer, ride.customer) && Objects.equals(
        startingLocation, ride.startingLocation) && Objects.equals(desiredLocation,
        ride.desiredLocation) && rideType == ride.rideType;
  }

  /**
   * Returns a hash code value for the Ride.
   *
   * @return a hash code value for this Ride
   */
  @Override
  public int hashCode() {
    return Objects.hash(customer, startingLocation, desiredLocation, anticipatedDistance,
        requestTime, rideType, startTime, endTime, length);
  }

  /**
   * Returns a string representation of the Ride.
   *
   * @return a string representation of the Ride
   */
  @Override
  public String toString() {
    return "Ride{" +
        "customer=" + customer +
        ", startingLocation='" + startingLocation + '\'' +
        ", desiredLocation='" + desiredLocation + '\'' +
        ", anticipatedDistance=" + anticipatedDistance +
        ", requestTime=" + requestTime +
        ", rideType=" + rideType +
        ", startTime=" + startTime +
        ", endTime=" + endTime +
        ", length=" + length +
        '}';
  }
}
