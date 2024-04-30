package problem1;

/**
 * The CookieNotFoundException class represents an exception that is thrown
 * when a cookie is not found in the cookiecatalog, extending the Exception class.
 */
public class CookieNotFoundException extends Exception {

  /**
   * Constructs a new CookieNotFoundException with the specified detail message.
   *
   * @param message the detailed error message.
   */
  public CookieNotFoundException(String message) {
    super(message);
  }
}
