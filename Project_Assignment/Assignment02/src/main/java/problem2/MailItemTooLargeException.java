package problem2;

/**
 * The MailItemTooLargeException is an exception thrown when attempting to add a mail item to a locker
 * where the mail item exceeds the dimensions of the locker.
 */
public class MailItemTooLargeException extends Exception {

  /**
   * Constructs a new MailItemTooLargeException with the specified detail message.
   * @param message The detail message.
   */
  public MailItemTooLargeException(String message) {
    super(message);
  }
}
