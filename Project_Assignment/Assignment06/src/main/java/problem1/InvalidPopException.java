package problem1;

/**
 * Represents an exception thrown when attempting to pop from an empty priority queue.
 */
public class InvalidPopException extends Exception {

  /**
   * Constructs a new InvalidPopException with the specified detail message.
   *
   * @param message The detail message.
   */
  public InvalidPopException(String message) {
    super(message);
  }
}
