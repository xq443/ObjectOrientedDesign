package problem2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TimeTest {
    private Time testTime;
    private int expectedHour;
    private int expectedMinute;
    private int expectedSecond;

    @BeforeEach
    void setUp() {
        testTime = new Time(1, 20, 10);
        expectedHour = 1;
        expectedMinute = 20;
        expectedSecond = 10;
    }

    @Test
    void getHour() {
        assertEquals(expectedHour, testTime.getHour());
    }

    @Test
    void getMinute() {
        assertEquals(expectedMinute, testTime.getMinute());
    }

    @Test
    void getSecond() {
        assertEquals(expectedSecond, testTime.getSecond());
    }

    @Test
    void testInvalidHourGreater() {

        int invalidHour = 100;
        try {
            new Time(invalidHour, expectedMinute, expectedSecond);
        } catch (IllegalArgumentException exception) {
            assertEquals("Invalid time values", exception.getMessage());
        }
    }
    @Test
    void testInvalidHourLess() {

        int invalidHour = -1;
        try {
            new Time(invalidHour, expectedMinute, expectedSecond);
        } catch (IllegalArgumentException exception) {
            assertEquals("Invalid time values", exception.getMessage());
        }
    }

    @Test
    void testInvalidMinuteGreater() {

        int invalidMinute = 100;
        try {
            new Time(expectedHour, invalidMinute, expectedSecond);
        } catch (IllegalArgumentException exception) {
            // Verify the exception message
            assertEquals("Invalid time values", exception.getMessage());
        }
    }
    @Test
    void testInvalidMinLess() {

        int invalidHour = -10;
        try {
            new Time(invalidHour, expectedMinute, expectedSecond);
        } catch (IllegalArgumentException exception) {
            // Verify the exception message
            assertEquals("Invalid time values", exception.getMessage());
        }
    }

    @Test
    void testInvalidSecondGreater() {
        int invalidSecond = 100;
        try {
            new Time(expectedHour, expectedMinute, invalidSecond);
        } catch (IllegalArgumentException exception) {
            // Verify the exception message
            assertEquals("Invalid time values", exception.getMessage());
        }
    }
    @Test
    void testInvalidSecondLess() {
        int invalidSecond = -1;
        try {
            new Time(expectedHour, expectedMinute, invalidSecond);
        } catch (IllegalArgumentException exception) {
            // Verify the exception message
            assertEquals("Invalid time values", exception.getMessage());
        }
    }
    @Test
    void testInvalidSecondMinLess() {
        int invalidSecond = -1, invalidMin = -1;
        try {
            new Time(expectedHour, invalidMin, invalidSecond);
        } catch (IllegalArgumentException exception) {
            // Verify the exception message
            assertEquals("Invalid time values", exception.getMessage());
        }
    }
    @Test
    void testInvalidSecondHourLess() {
        int invalidSecond = -1, invalidHour = -1;
        try {
            new Time(invalidHour, expectedMinute, invalidSecond);
        } catch (IllegalArgumentException exception) {
            // Verify the exception message
            assertEquals("Invalid time values", exception.getMessage());
        }
    }
    @Test
    void testInvalidHourMinLess() {
        int invalidSecond = -1, invalidHour = -1;
        try {
            new Time(invalidHour, expectedMinute, invalidSecond);
        } catch (IllegalArgumentException exception) {
            // Verify the exception message
            assertEquals("Invalid time values", exception.getMessage());
        }
    }

    @Test
    void testEquals_SameObjects() {
        assertTrue(testTime.equals(testTime));
    }
    @Test
    void testEquals_NullComparison(){
        assertFalse(testTime.equals(null));
    }

    @Test
    void testEquals_DifferentDataType(){
        assertFalse(testTime.equals("String"));
    }

    @Test
    void testEquals_DifferentObjectSameFields(){
        Time otherTime = new Time(expectedHour,expectedMinute, expectedSecond);
        assertTrue(testTime.equals(otherTime));
    }
    @Test
    void testEquals_DifferentObjectDifferentHour(){
        Time otherTime = new Time(2,expectedMinute, expectedSecond);
        assertFalse(testTime.equals(otherTime));
    }
    @Test
    void testEquals_DifferentObjectDifferentMin(){
        Time otherTime = new Time(expectedHour,1, expectedSecond);
        assertFalse(testTime.equals(otherTime));
    }
    @Test
    void testEquals_DifferentObjectDifferentSec(){
        Time otherTime = new Time(expectedHour,expectedMinute, 1);
        assertFalse(testTime.equals(otherTime));
    }
    @Test
    void testHashCode() {
        int expectedHashCode = Objects.hash(expectedHour, expectedMinute, expectedSecond);
        assertEquals(expectedHashCode, testTime.hashCode());
    }
}