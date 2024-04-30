package problem1;

/**
 * The InvalidNumAttendeesLunchOverMaxException is an exception thrown when the number
 * of attendees for a lunch event exceeds the allowed maximum.
 */
public class InvalidNumAttendeesLunchOverMaxException extends Exception {

  /**
   * Constructs a new InvalidNumAttendeesLunchOverMaxException with the specified detail message.
   * @param message The detail message.
   */
  public InvalidNumAttendeesLunchOverMaxException(String message) {
    super(message);
  }
}
