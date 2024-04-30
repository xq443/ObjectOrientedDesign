package problem1;

import java.util.Objects;

/**
 * The Event class represents an event with the client's name and the number of attendees.
 *
 * @author Cathy
 */
public class Event {
  private String clientName;
  private Integer numAttendees;

  /**
   * Constructs an Event object with the specified client name and number of attendees.
   *
   * @param clientName   the name of the client for the event
   * @param numAttendees the number of attendees for the event
   */
  public Event(String clientName, Integer numAttendees) {
    this.clientName = clientName;
    this.numAttendees = numAttendees;
  }

  /**
   * Returns the client name for the event.
   * @return the client name: String
   */
  public String getClientName() {
    return this.clientName;
  }

  /**
   * Returns the number of attendees for the event.
   * @return the number of attendees:Integer
   */
  public Integer getNumAttendees() {
    return this.numAttendees;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Event event = (Event) o;
    return Objects.equals(clientName, event.clientName) && Objects.equals(
        numAttendees, event.numAttendees);
  }

  @Override
  public int hashCode() {
    return Objects.hash(clientName, numAttendees);
  }

  @Override
  public String toString() {
    return "Event{" +
        "clientName='" + clientName + '\'' +
        ", numAttendees=" + numAttendees +
        '}';
  }
}
