package problem2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DeliveryTest {
    private Delivery testDelivery;
    private String startLocation;
    private String endLocation;
    private Time startTime;
    private Time endTime;

    @BeforeEach
    void setUp() {
        startLocation = "Warehouse";
        endLocation = "Customer's House";
        startTime = new Time(10, 30, 10);
        endTime = new Time(12, 15, 30);
        testDelivery = new Delivery(startLocation, endLocation, startTime, endTime);
    }

    @Test
    void testGetStartLocation() {
        assertEquals(startLocation, testDelivery.getStartLocation());
    }


    @Test
    void testGetEndLocation() {
        assertEquals(endLocation, testDelivery.getEndLocation());
    }


    @Test
    void testGetStartTime() {
        assertEquals(startTime, testDelivery.getStartTime());
    }


    @Test
    void testGetEndTime() {
        assertEquals(endTime, testDelivery.getEndTime());
    }

    @Test
    void testGetDuration() {
        Time expectedDuration = new Time(1, 45, 20);
        assertEquals(expectedDuration.getHour(), testDelivery.getDuration().getHour());
        assertEquals(expectedDuration.getMinute(),testDelivery.getDuration().getMinute());
        assertEquals(expectedDuration.getSecond(), testDelivery.getDuration().getSecond());
    }

    @Test
    public void testGetDurationPositiveDifference() {
        // Create Delivery instance with positive duration
        Delivery delivery = new Delivery("Start", "End",
            new Time(10, 30, 0), new Time(12, 45, 30));
        Time duration = delivery.getDuration();
        assertEquals(new Time(2, 15, 30), duration);
    }

    @Test
    public void testGetDurationNegativeSecond() {
        // Create Delivery instance with negative seconds difference
        Delivery delivery = new Delivery("Start", "End",
            new Time(10, 30, 45), new Time(12, 45, 30));
        Time duration = delivery.getDuration();
        assertEquals(new Time(2, 14, 45), duration);
    }

    @Test
    public void testGetDurationNegativeMinute() {
        // Create Delivery instance with negative minutes difference
        Delivery delivery = new Delivery("Start", "End",
            new Time(10, 45, 30), new Time(12, 30, 15));
        Time duration = delivery.getDuration();
        assertEquals(new Time(1, 44, 45), duration);
    }

    @Test
    public void testEquals_SameObjects() {
        assertTrue(testDelivery.equals(testDelivery));
    }
    @Test
    void testEquals_NullComparison(){
        assertFalse(testDelivery.equals(null));
    }

    @Test
    void testEquals_DifferentDataType(){
        assertFalse(testDelivery.equals("String"));
    }

    @Test
    void testEquals_DifferentObjectSameFields(){
        Delivery otherDelivery = new Delivery(startLocation, endLocation, startTime, endTime);
        assertTrue(testDelivery.equals(otherDelivery));
    }
    @Test
    void testEquals_DifferentObjectDifferentStartLocation(){
        Delivery otherDelivery = new Delivery("301 Minor Ave N", endLocation, startTime, endTime);
        assertFalse(testDelivery.equals(otherDelivery));
    }
    @Test
    void testEquals_DifferentObjectDifferentEndLocation(){
        Delivery otherDelivery = new Delivery(startLocation, "301 Minor Ave N", startTime, endTime);
        assertFalse(testDelivery.equals(otherDelivery));
    }
    @Test
    void testEquals_DifferentObjectDifferentStartTime(){
        Delivery otherDelivery = new Delivery(startLocation, endLocation, new Time(1,1,1), endTime);
        assertFalse(testDelivery.equals(otherDelivery));
    }
    @Test
    void testEquals_DifferentObjectDifferentEndTime(){
        Delivery otherDelivery = new Delivery(startLocation, endLocation,startTime, new Time(1,1,1));
        assertFalse(testDelivery.equals(otherDelivery));
    }
    @Test
    void testHashCode() {
        int expectedHashCode = Objects.hash(startLocation, endLocation, startTime, endTime);
        assertEquals(expectedHashCode, testDelivery.hashCode());
    }

}
