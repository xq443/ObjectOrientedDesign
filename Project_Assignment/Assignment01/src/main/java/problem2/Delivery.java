package problem2;

import java.util.Objects;

/**
 * The Delivery class represents a delivery service between two locations
 * with specified start and end times.
 */
public class Delivery {
    private String startLocation;
    private String endLocation;
    private Time startTime;
    private Time endTime;

    /**
     * Constructs a Delivery object with the specified start and end locations,
     * start time, and end time.
     *
     * @param startLocation The starting location of the delivery.
     * @param endLocation   The destination location of the delivery.
     * @param startTime     The start time of the delivery.
     * @param endTime       The end time of the delivery.
     */
    public Delivery(String startLocation, String endLocation, Time startTime, Time endTime) {
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /**
     * Calculates and returns the duration of the delivery.
     *
     * @return The duration of the delivery as a Time object.
     */
    public Time getDuration() {
        int durationHour = endTime.getHour() - startTime.getHour();
        int durationMinute = endTime.getMinute() - startTime.getMinute();
        int durationSecond = endTime.getSecond() - startTime.getSecond();

        // Handle negative values by adjusting
        if (durationSecond < 0) {
            durationSecond += 60;
            durationMinute--;
        }
        if (durationMinute < 0) {
            durationMinute += 60;
            durationHour--;
        }

        return new Time(durationHour, durationMinute, durationSecond);
    }

    /**
     * Gets the starting location of the delivery.
     *
     * @return The starting location as a String.
     */
    public String getStartLocation() {
        return startLocation;
    }

    /**
     * Gets the destination location of the delivery.
     *
     * @return The destination location as a String.
     */
    public String getEndLocation() {
        return endLocation;
    }

    /**
     * Gets the start time of the delivery.
     *
     * @return The start time as a Time object.
     */
    public Time getStartTime() {
        return startTime;
    }

    /**
     * Gets the end time of the delivery.
     *
     * @return The end time as a Time object.
     */
    public Time getEndTime() {
        return endTime;
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
        Delivery delivery = (Delivery) o;
        return Objects.equals(startLocation, delivery.startLocation)
            && Objects.equals(endLocation, delivery.endLocation)
            && Objects.equals(startTime, delivery.startTime)
            && Objects.equals(endTime, delivery.endTime);
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return A hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(startLocation, endLocation, startTime, endTime);
    }
}
