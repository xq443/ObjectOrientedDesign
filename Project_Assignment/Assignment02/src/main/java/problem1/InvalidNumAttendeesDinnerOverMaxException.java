package problem1;

/**
 * The InvalidNumAttendeesDinnerOverMaxException is an exception thrown when the number
 * of attendees for a dinner event exceeds the allowed maximum.
 */
public class InvalidNumAttendeesDinnerOverMaxException extends Exception {

  /**
   * Constructs a new InvalidNumAttendeesDinnerOverMaxException with the specified detail message.
   * @param message The detail message.
   */
  public InvalidNumAttendeesDinnerOverMaxException(String message) {
    super(message);
  }
}
