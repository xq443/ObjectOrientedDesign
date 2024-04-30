package problem1;

/**
 * The UnsuccessfulBookedLunchException is an exception thrown when an attempt to book a lunch event is unsuccessful.
 */
public class UnsuccessfulBookedLunchException extends Exception {

  /**
   * Constructs a new UnsuccessfulBookedLunchException with the specified detail message.
   * @param message The detail message.
   */
  public UnsuccessfulBookedLunchException(String message) {
    super(message);
  }
}
