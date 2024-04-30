package exceptions.bankingSystem;

public class OverTheAllowedMaxException extends Exception {

  public OverTheAllowedMaxException(String message) {
    super(message);
  }
}
