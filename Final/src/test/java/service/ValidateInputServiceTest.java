package service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import exception.InvalidInputException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ValidateInputServiceTest {

  private ValidateInputService validateInputService;

  @BeforeEach
  void setUp() {
    validateInputService = new ValidateInputService();
  }

  @Test
  void testValidateNumberOfDrivers_ValidInput() throws InvalidInputException {
    String[] input = {"5"};
    int numDrivers = ValidateInputService.validateNumberOfDrivers(input);
    assertEquals(5, numDrivers);
  }

  @Test
  void testValidateNumberOfDrivers_NullInput() {
    assertThrows(IllegalArgumentException.class, () -> {
      ValidateInputService.validateNumberOfDrivers(null);
    });
  }

  @Test
  void testValidateNumberOfDrivers_EmptyInput() {
    assertThrows(IllegalArgumentException.class, () -> {
      ValidateInputService.validateNumberOfDrivers(new String[]{});
    });
  }

  @Test
  void testValidateNumberOfDrivers_NonNumericInput() {
    String[] input = {"abc"};
    assertThrows(InvalidInputException.class, () -> {
      ValidateInputService.validateNumberOfDrivers(input);
    });
  }

  @Test
  void testValidateNumberOfDrivers_NegativeInput() {
    String[] input = {"-5"};
    assertThrows(InvalidInputException.class, () -> {
      ValidateInputService.validateNumberOfDrivers(input);
    });
  }

  @Test
  void testValidateNumberOfDrivers_ZeroInput() {
    String[] input = {"0"};
    assertThrows(InvalidInputException.class, () -> {
      ValidateInputService.validateNumberOfDrivers(input);
    });
  }
}
