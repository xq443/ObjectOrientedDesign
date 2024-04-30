package problem2;

/**
 * The NoMailItemMatchException is an exception thrown when attempting to pick up a mail item from a locker,
 * but no matching mail item is found.
 */
public class NoMailItemMatchException extends Exception {

  /**
   * Constructs a new NoMailItemMatchException with the specified detail message.
   * @param message The detail message.
   */
  public NoMailItemMatchException(String message) {
    super(message);
  }
}
