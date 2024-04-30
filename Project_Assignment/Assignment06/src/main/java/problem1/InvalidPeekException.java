package problem1;

/**
 * Represents an exception thrown when attempting to peek from an empty priority queue.
 */
public class InvalidPeekException extends Exception {

  /**
   * Constructs a new InvalidPeekException with the specified detail message.
   *
   * @param message The detail message.
   */
  public InvalidPeekException(String message) {
    super(message);
  }
}
