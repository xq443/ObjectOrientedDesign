package problem2;

import java.util.Objects;

/**
 * The Time class represents a time in hours, minutes, and seconds.
 * It provides methods for creating and manipulating time objects.
 */
public class Time {
    private int hour;
    private int minute;
    private int second;

    /**
     * Constructs a Time object with the specified hour, minute, and second.
     *
     * @param hour   The hour component of the time (0-23).
     * @param minute The minute component of the time (0-59).
     * @param second The second component of the time (0-59).
     * @throws IllegalArgumentException If the provided time values are invalid.
     */
    public Time(int hour, int minute, int second) {
        if (!isValidTime(hour, minute, second)) {
            throw new IllegalArgumentException("Invalid time values");
        }
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    /**
     * Checks if the provided time values are valid.
     *
     * @param hour   The hour component of the time.
     * @param minute The minute component of the time.
     * @param second The second component of the time.
     * @return {@code true} if the time values are valid, {@code false} otherwise.
     */
    boolean isValidTime(int hour, int minute, int second) {
        return hour >= 0 && hour <= 23 && minute >= 0 && minute <= 59 && second >= 0 && second <= 59;
    }

    /**
     * Gets the hour component of the time.
     *
     * @return The hour component.
     */
    public int getHour() {
        return hour;
    }

    /**
     * Gets the minute component of the time.
     *
     * @return The minute component.
     */
    public int getMinute() {
        return minute;
    }

    /**
     * Gets the second component of the time.
     *
     * @return The second component.
     */
    public int getSecond() {
        return second;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param o The reference object with which to compare.
     * @return {@code true} if this object is the same as the obj argument;
     * {@code false} otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Time time = (Time) o;
        return hour == time.hour && minute == time.minute && second == time.second;
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return A hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(hour, minute, second);
    }
}
