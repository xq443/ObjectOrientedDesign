package problem1;

/**
 * The InvalidNumAttendeesDinnerLessMinException is an exception thrown when the number
 * of attendees for a dinner event is less than the allowed minimum.
 */
public class InvalidNumAttendeesDinnerLessMinException extends Exception{

  /**
   * Constructs a new InvalidNumAttendeesDinnerLessMinException with the specified detail message.
   * @param message The detail message.
   */
  public InvalidNumAttendeesDinnerLessMinException(String message) {
    super(message);
  }
}
