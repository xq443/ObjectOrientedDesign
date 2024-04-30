package problem1;

/**
 * NoProcessingTimeException is an exception class that represents the situation where a processing time
 * is required but not provided or is invalid.
 */
public class NoProcessingTimeException extends Exception {

  /**
   * Constructs a new NoProcessingTimeException with the specified detail message.
   *
   * @param message the detail message (which is saved for later retrieval by the getMessage() method)
   */
  public NoProcessingTimeException(String message) {
    super(message);
  }
}
