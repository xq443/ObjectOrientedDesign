package service;

import exception.InvalidInputException;
import java.util.regex.Pattern;

/**
 * The ValidateInputService class provides methods to validate user input.
 */
public class ValidateInputService {
  private static final String POSITIVE_INTEGER_REGEX = "^[1-9]\\d*$";
  private static final String ERROR_NO_DRIVERS_PROVIDED = "Numbers must be provided.";
  private static final String ERROR_INVALID_POSITIVE_INTEGER = "Number of drivers must be "
      + "a positive integer.";
  private static final String ERROR_INVALID_NUMBER_FORMAT = "Invalid number of drivers. "
      + "Please provide a valid integer.";

  /**
   * Validates the provided input and returns the number of drivers.
   *
   * @param input The input string array containing the number of drivers.
   * @return The number of drivers.
   * @throws InvalidInputException if the input is invalid.
   */
  public static int validateNumberOfDrivers(String[] input) throws InvalidInputException {
    if (input == null || input.length == 0) {
      throw new IllegalArgumentException(ERROR_NO_DRIVERS_PROVIDED);
    }

    try {
      int numDrivers = Integer.parseInt(input[0]);
      if (!Pattern.matches(POSITIVE_INTEGER_REGEX, input[0])) {
        throw new InvalidInputException(ERROR_INVALID_POSITIVE_INTEGER);
      }
      return numDrivers;
    } catch (NumberFormatException e) {
      throw new InvalidInputException(ERROR_INVALID_NUMBER_FORMAT);
    }
  }
}
