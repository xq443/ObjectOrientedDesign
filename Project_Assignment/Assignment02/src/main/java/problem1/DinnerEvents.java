package problem1;

/**
 * The DinnerEvents class represents a dinner event, extending the base class Event.
 */
public class DinnerEvents extends Event {
  private Integer numNonVegEntrees;
  private Integer numVegEntrees;

  /** The minimum number of attendees allowed for a dinner event. */
  private static final Integer MIN_DINNER_ATTENDEES = 10;

  /** The maximum number of attendees allowed for a dinner event. */
  private static final Integer MAX_DINNER_ATTENDEES = 50;

  /**
   * Constructs a DinnerEvents object with the specified client name and number of
   * attendees.
   *
   * @param clientName   the name of the client for the dinner event
   * @param numAttendees the number of attendees for the dinner event
   */
  public DinnerEvents(String clientName, Integer numAttendees) {
    super(clientName, numAttendees);
    this.numNonVegEntrees = (int) Math.ceil(0.8 * numAttendees);
    this.numVegEntrees = (int) Math.ceil(0.2 * numAttendees);
  }

  /**
   * Validates the number of attendees for a dinner event.
   *
   * @param numAttendees the number of attendees to validate
   * @throws InvalidNumAttendeesDinnerLessMinException if the number of attendees is less than
   *                                                    the minimum allowed
   * @throws InvalidNumAttendeesDinnerOverMaxException if the number of attendees is more than
   *                                                    the maximum allowed
   */
  public void checkDinnerNumAttendees(int numAttendees)
      throws InvalidNumAttendeesDinnerLessMinException, InvalidNumAttendeesDinnerOverMaxException {
    if (numAttendees < MIN_DINNER_ATTENDEES) {
      throw new InvalidNumAttendeesDinnerLessMinException("Number of attendees for dinner is less than 10.");
    } else if (numAttendees > MAX_DINNER_ATTENDEES) {
      throw new InvalidNumAttendeesDinnerOverMaxException("Number of attendees for dinner is more than 50.");
    }
  }

  /**
   * Returns the number of non-vegetarian entrees for the dinner event.
   * @return the number of non-vegetarian entrees: integer
   */
  public Integer getNumNonVegEntrees() {
    return this.numNonVegEntrees;
  }

  /**
   * Returns the number of vegetarian entrees for the dinner event.
   * @return the number of vegetarian entrees: integer
   */
  public Integer getNumVegEntrees() {
    return this.numVegEntrees;
  }
}
