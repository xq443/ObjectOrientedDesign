package problem2;

/**
 * The RecipientUnableMatchException is an exception thrown when attempting to pick up a mail item from a locker,
 * but the recipient specified does not match the recipient of the stored mail item.
 */
public class RecipientUnableMatchException extends Exception {

  /**
   * Constructs a new RecipientUnableMatchException with the specified detail message.
   * @param message The detail message.
   */
  public RecipientUnableMatchException(String message) {
    super(message);
  }
}
