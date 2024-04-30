package problem1;

/**
 * The InvalidNumAttendeesLunchLessMinException is an exception thrown when the number
 * of attendees for a lunch event is less than the allowed minimum.
 */
public class InvalidNumAttendeesLunchLessMinException extends Exception {

  /**
   * Constructs a new InvalidNumAttendeesLunchLessMinException with the specified detail message.
   * @param message The detail message.
   */
  public InvalidNumAttendeesLunchLessMinException(String message) {
    super(message);
  }
}
