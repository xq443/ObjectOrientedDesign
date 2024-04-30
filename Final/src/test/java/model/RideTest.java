package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RideTest {

  private Ride ride;
  private Customer customer;

  @BeforeEach
  void setUp() {
    customer = new Customer("123");
    ride = new Ride(customer, "Start", "Destination",
        5.0, 0, RideType.Standard, 1000,
        2000, 10.0);
  }

  @Test
  void testGetters() {
    assertEquals("123", ride.getCustomer().getCustomerId());
    assertEquals("Start", ride.getStartingLocation());
    assertEquals("Destination", ride.getDesiredLocation());
    assertEquals(5.0, ride.getAnticipatedDistance());
    assertEquals(0, ride.getRequestTime());
    assertEquals(RideType.Standard, ride.getRideType());
    assertEquals(1000, ride.getStartTime());
    assertEquals(2000, ride.getEndTime());
    assertEquals(10.0, ride.getLength());
  }

  @Test
  void testEquals() {
    Ride sameRide = new Ride(customer, "Start", "Destination",
        5.0, 0, RideType.Standard, 1000, 2000, 10.0);

    Ride differentCustomerRide = new Ride(new Customer("1"), "Start", "Destination",
        5.0, 0, RideType.Standard, 1000, 2000, 10.0);

    Ride differentstartingRide = new Ride(customer, "s", "Destination",
        5.0, 0, RideType.Standard, 1000, 2000, 10.0);

    Ride differentendingRide = new Ride(customer, "Start", "D",
        5.0, 0, RideType.Standard, 1000, 2000, 10.0);

    Ride differentAnticipatedDistanceRide = new Ride(customer, "Start", "Destination",
        10.0, 0, RideType.Standard, 1000, 2000, 10.0);

    Ride differentRequestTimeRide = new Ride(customer, "Start", "Destination",
        5.0, 10, RideType.Standard, 1000, 2000, 10.0);

    Ride differentTypeRide = new Ride(customer, "Start", "Destination",
        5.0, 0, RideType.Express, 1000, 2000, 10.0);

    Ride differentstarttimeRide = new Ride(customer, "Start", "Destination",
        5.0, 0, RideType.Standard, 100, 2000, 10.0);

    Ride differentendtimeRide = new Ride(customer, "Start", "Destination",
        5.0, 0, RideType.Standard, 1000, 3000, 10.0);

    Ride differentLengthRide = new Ride(customer, "Start", "Destination",
        5.0, 0, RideType.Standard, 1000, 2000, 100.0);



    assertTrue(ride.equals(ride));
    assertFalse(sameRide.equals(null));
    assertFalse(sameRide.equals(5));
    assertFalse(sameRide.equals(differentCustomerRide));
    assertFalse(sameRide.equals(differentstartingRide));
    assertFalse(sameRide.equals(differentendingRide));
    assertFalse(sameRide.equals(differentAnticipatedDistanceRide));
    assertFalse(sameRide.equals(differentRequestTimeRide));
    assertFalse(sameRide.equals(differentTypeRide));
    assertFalse(sameRide.equals(differentstarttimeRide));
    assertFalse(sameRide.equals(differentendtimeRide));
    assertFalse(sameRide.equals(differentLengthRide));

  }

  @Test
  void testHashCode() {
    int expectedHashCode = Objects.hash(ride.getCustomer(), ride.getStartingLocation(),
        ride.getDesiredLocation(), ride.getAnticipatedDistance(), ride.getRequestTime(),
        ride.getRideType(), ride.getStartTime(), ride.getEndTime(), ride.getLength());

    assertEquals(expectedHashCode, ride.hashCode());
  }


  @Test
  void testToString() {
    String expectedToString = "Ride{" +
        "customer=" + ride.getCustomer() +
        ", startingLocation='" + ride.getStartingLocation() + '\'' +
        ", desiredLocation='" + ride.getDesiredLocation() + '\'' +
        ", anticipatedDistance=" + ride.getAnticipatedDistance() +
        ", requestTime=" + ride.getRequestTime() +
        ", rideType=" + ride.getRideType() +
        ", startTime=" + ride.getStartTime() +
        ", endTime=" + ride.getEndTime() +
        ", length=" + ride.getLength() +
        '}';
    assertEquals(expectedToString, ride.toString());
  }
  @Test
  void testGetPriority_Express() {
    ride = new Ride(customer, "Start", "Destination",
        5.0, 0, RideType.Express, 1000,
        2000, 10.0);
    assertEquals(1, ride.getPriority());
  }

  @Test
  void testGetPriority_Standard() {
    ride = new Ride(customer, "Start", "Destination",
        5.0, 0, RideType.Standard, 1000,
        2000, 10.0);
    assertEquals(2, ride.getPriority());
  }

  @Test
  void testGetPriority_WaitAndSave() {
    ride = new Ride(customer, "Start", "Destination",
        5.0, 0, RideType.WaitAndSave, 1000,
        2000, 10.0);
    assertEquals(3, ride.getPriority());
  }

  @Test
  void testGetPriority_EnvironmentallyConscious() {
    ride = new Ride(customer, "Start", "Destination",
        5.0, 0, RideType.EnvironmentallyConscious, 1000,
        2000, 10.0);
    assertEquals(4, ride.getPriority());
  }

  @Test
  void testEquals_SameLocations() {
    Ride sameRide = new Ride(customer, "Start", "Destination",
        5.0, 0, RideType.Standard, 1000, 2000, 10.0);
    assertEquals(ride, sameRide);
  }

  @Test
  void testEquals_DifferentStartingLocation() {
    Ride differentStartingLocationRide = new Ride(customer, "DifferentStart", "Destination",
        5.0, 0, RideType.Standard, 1000, 2000, 10.0);
    assertNotEquals(ride, differentStartingLocationRide);
  }

  @Test
  void testEquals_DifferentDesiredLocation() {
    Ride differentDesiredLocationRide = new Ride(customer, "Start", "DifferentDestination",
        5.0, 0, RideType.Standard, 1000, 2000, 10.0);
    assertNotEquals(ride, differentDesiredLocationRide);
  }
}
