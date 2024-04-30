package problem1;

/**
 * The UnsuccessfulBookedDinnerException is an exception thrown when an attempt to book a dinner event is unsuccessful.
 */
public class UnsuccessfulBookedDinnerException extends Exception {

  /**
   * Constructs a new UnsuccessfulBookedDinnerException with the specified detail message.
   * @param message The detail message.
   */
  public UnsuccessfulBookedDinnerException(String message) {
    super(message);
  }
}
