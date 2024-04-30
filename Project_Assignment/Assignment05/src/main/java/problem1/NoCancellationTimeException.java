package problem1;

/**
 * NoCancellationTimeException is an exception class that represents the situation where a cancellation time
 * is required but not provided or is invalid.
 */
public class NoCancellationTimeException extends Exception {

  /**
   * Constructs a new NoCancellationTimeException with the specified detail message.
   *
   * @param message the detail message (which is saved for later retrieval by the getMessage() method)
   */
  public NoCancellationTimeException(String message) {
    super(message);
  }
}
