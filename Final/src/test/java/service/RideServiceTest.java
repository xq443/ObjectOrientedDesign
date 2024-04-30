package service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Comparator;
import java.util.PriorityQueue;
import model.Ride;
import model.RideType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RideServiceTest {

  private RideServiceImpl rideService;

  @BeforeEach
  void setUp() {
    int numOfDriver = 5;
    rideService = new RideServiceImpl(numOfDriver);
  }

  @Test
  void testRequestRide() {
    rideService.requestRide(new Ride(null, null, null, 0, 0, RideType.Standard, 0, 0, 0));
    PriorityQueue<Ride> rideRequested = rideService.getRideRequested();
    assertEquals(1, rideRequested.size());
  }

  //  @Test
//  void testAssignRide() {
//    rideController.requestRide();
//    rideController.assignRide();
//    PriorityQueue<Ride> activeRides = rideController.getActiveRides();
//    assertEquals(1, activeRides.size());
//  }
  @Test
  void testIsHigherPriority() {
    RideType highPriorityType = RideType.Express;
    RideType lowPriorityType = RideType.Standard;

    Ride highPriorityRide = new Ride(null, null, null, 0, 0, highPriorityType, 0, 0, 0);
    Ride lowPriorityRide = new Ride(null, null, null, 0, 0, lowPriorityType, 0, 0, 0);

    // Test when highPriorityRide has higher type priority
    assertTrue(rideService.isHigherPriority(highPriorityRide, lowPriorityRide));

    // Test when lowPriorityRide has higher type priority
    assertFalse(rideService.isHigherPriority(lowPriorityRide, highPriorityRide));

    // Test when both rides have the same type but highPriorityRide has longer anticipated distance
    highPriorityRide = new Ride(null, null, null, 10, 0, lowPriorityType, 0, 0, 0);
    lowPriorityRide = new Ride(null, null, null, 10, 100, lowPriorityType, 0, 0, 0);
    assertTrue(rideService.isHigherPriority(highPriorityRide, lowPriorityRide));

    // Test when both rides have the same type and anticipated distance
    assertFalse(rideService.isHigherPriority(lowPriorityRide, highPriorityRide));
  }

  @Test
  void testRidePriorityQueueSorting() {
    // Creating some sample rides with different priorities and request times
    Ride highPriorityRide = new Ride(null, null, null, 0, 0, RideType.Express, 0, 0, 0);
    Ride mediumPriorityRide = new Ride(null, null, null, 0, 0, RideType.Standard, 0, 0, 0);
    Ride lowPriorityRide = new Ride(null, null, null, 0, 0, RideType.WaitAndSave, 0, 0, 0);

    // Creating a priority queue with the provided comparator
    PriorityQueue<Ride> rideQueue = new PriorityQueue<>(new Comparator<Ride>() {
      @Override
      public int compare(Ride ride1, Ride ride2) {
        if (rideService.isHigherPriority(ride1, ride2)) {
          return -1; // ride1 has higher priority
        } else if (rideService.isHigherPriority(ride2, ride1)) {
          return 1; // ride2 has higher priority
        } else {
          // If neither ride has higher priority, compare the request time
          return Long.compare(ride1.getRequestTime(), ride2.getRequestTime());
        }
      }
    });

    // Adding rides to the priority queue
    rideQueue.add(highPriorityRide);
    rideQueue.add(mediumPriorityRide);
    rideQueue.add(lowPriorityRide);

    // Polling rides from the priority queue to verify the sorting order
    Ride polledRide = rideQueue.poll();
    assertEquals(highPriorityRide, polledRide);

    polledRide = rideQueue.poll();
    assertEquals(mediumPriorityRide, polledRide);

    polledRide = rideQueue.poll();
    assertEquals(lowPriorityRide, polledRide);
  }

  // Test case for getActiveRides() method
  @Test
  void testGetActiveRides() {
    // Add some active rides to the activeRides queue
    rideService.getActiveRides().add(new Ride(null, null, null, 0, 0, RideType.Standard, 0, 0, 0));
    rideService.getActiveRides().add(new Ride(null, null, null, 0, 0, RideType.Express, 0, 0, 0));

    PriorityQueue<Ride> activeRides = rideService.getActiveRides();
    assertEquals(2, activeRides.size());
  }

  @Test
  void testRideRequestedComparator() {
    // Create some sample rides with different priorities and request times
    Ride highPriorityRide = new Ride(null, null, null, 100, 0, RideType.Express, 1000, 0, 0);
    Ride mediumPriorityRide = new Ride(null, null, null, 10, 0, RideType.Standard, 2000, 0, 0);
    Ride lowPriorityRide = new Ride(null, null, null, 0, 0, RideType.WaitAndSave, 3000, 0, 0);

    // Create the comparator instance
    Comparator<? super Ride> rideComparator = rideService.getRideRequested().comparator();

    // Test the comparison between rides
    assertEquals(-1, rideComparator.compare(highPriorityRide, lowPriorityRide)); // highPriorityRide should come before lowPriorityRide
    assertEquals(1, rideComparator.compare(lowPriorityRide, highPriorityRide)); // lowPriorityRide should come after highPriorityRide
    assertEquals(0, rideComparator.compare(highPriorityRide, highPriorityRide)); // Two identical rides should have the same order
  }


  @Test
  void testCalculateAverageRidesPerDriver() {
    // Add some sample rides to the controller's active and complete rides queues
    rideService.getActiveRides().add(new Ride(null, null, null, 0, 0, RideType.Standard, 1000, 1500, 0));
    rideService.getActiveRides().add(new Ride(null, null, null, 0, 0, RideType.Standard, 2000, 2500, 0));
    // Calculate average rides per driver
    double averageRidesPerDriver = rideService.calculateAverageRidesPerDriver(5); // Assuming 5 drivers

    // Assert that the calculated average rides per driver matches the expected value
    assertEquals(0.4, averageRidesPerDriver); // Expected average rides per driver: (2) / 5 = 0.4
  }

  @Test
  void testCalculateAverageWaitTime() {
    // Add some sample rides to the controller's active and complete rides queues
    rideService.getActiveRides().add(new Ride(null, null, null, 0, 0, RideType.Standard, 1000, 1500, 0));
    rideService.getActiveRides().add(new Ride(null, null, null, 0, 0, RideType.Standard, 2000, 2500, 0));
    // Calculate average wait time
    double averageWaitTime = rideService.calculateAverageWaitTime(1);
    double averageWaitTime1 = rideService.calculateAverageWaitTime(5);

    // Assert that the calculated average wait time matches the expected value
    assertEquals(1.0, averageWaitTime); // Expected average wait time: (0 + 500 + 1000 + 1500) / 4 = 1000
    assertEquals(0.0, averageWaitTime1); // num of drivers are more than num of rides
  }
}
