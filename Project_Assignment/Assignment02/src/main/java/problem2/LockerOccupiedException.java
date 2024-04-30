package problem2;

/**
 * The LockerOccupiedException is an exception thrown when attempting to add mail to an occupied locker.
 */
public class LockerOccupiedException extends Exception {

  /**
   * Constructs a new LockerOccupiedException with the specified detail message.
   * @param message The detail message.
   */
  public LockerOccupiedException(String message) {
    super(message);
  }
}
