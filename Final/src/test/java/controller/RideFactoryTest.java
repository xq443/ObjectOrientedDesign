package controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import model.Ride;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RideFactoryTest {

  private RideFactory rideFactory;

  @BeforeEach
  void setUp() {
    rideFactory = new RideFactory();
  }

  @Test
  void testCreateRide() {
    Ride ride = RideFactory.createRide();
    assertNotNull(ride);

    // Validate ride attributes
    assertNotNull(ride.getCustomer());
    assertNotNull(ride.getStartingLocation());
    assertNotNull(ride.getDesiredLocation());
    assertNotNull(ride.getAnticipatedDistance());
    assertNotNull(ride.getRequestTime());
    assertNotNull(ride.getRideType());
    assertNotNull(ride.getStartTime());
    assertNotNull(ride.getEndTime());
    assertNotNull(ride.getLength());
  }
}
