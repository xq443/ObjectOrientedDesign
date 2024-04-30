package problem1;

/**
 * The LunchEvents class represents a lunch event, extending the base class Event.
 */
public class LunchEvents extends Event {
  private Integer numSandwiches;

  /** The minimum number of attendees allowed for a lunch event. */
  private static final Integer MIN_LUNCH_ATTENDEES = 15;

  /** The maximum number of attendees allowed for a lunch event. */
  private static final Integer MAX_LUNCH_ATTENDEES = 90;

  /**
   * Constructs a LunchEvents object with the specified client name and number of attendees.
   *
   * @param clientName   the name of the client for the lunch event
   * @param numAttendees the number of attendees for the lunch event
   */
  public LunchEvents(String clientName, Integer numAttendees) {
    super(clientName, numAttendees);
    this.numSandwiches = (int) Math.ceil(1.05 * numAttendees);
  }

  /**
   * Validates the number of attendees for a lunch event.
   *
   * @param numAttendees the number of attendees to validate
   * @throws InvalidNumAttendeesLunchLessMinException if the number of attendees is less than
   *                                                    the minimum allowed
   * @throws InvalidNumAttendeesLunchOverMaxException if the number of attendees is more than
   *                                                    the maximum allowed
   */
  public void checkLunchNumAttendees(int numAttendees)
      throws InvalidNumAttendeesLunchLessMinException, InvalidNumAttendeesLunchOverMaxException {
    if (numAttendees < MIN_LUNCH_ATTENDEES) {
      throw new InvalidNumAttendeesLunchLessMinException("Number of attendees for lunch is less than 15.");
    } else if (numAttendees > MAX_LUNCH_ATTENDEES) {
      throw new InvalidNumAttendeesLunchOverMaxException("Number of attendees for lunch is more than 90.");
    }
  }

  /**
   * Returns the number of sandwiches to be provided for the lunch event.
   *
   * @return the number of sandwiches: Integer
   */
  public Integer getNumSandwiches() {
    return this.numSandwiches;
  }
}
