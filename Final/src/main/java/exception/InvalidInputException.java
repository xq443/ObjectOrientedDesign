package exception;

/**
 * The InvalidInputException class represents an exception that is thrown when input validation fails.
 * It extends the Exception class.
 */
public class InvalidInputException extends Exception {

  /**
   * Constructs a new InvalidInputException with the specified detail message.
   *
   * @param message the detail message (which is saved for later retrieval by the Throwable.getMessage() method)
   */
  public InvalidInputException(String message) {
    super(message);
  }
}
