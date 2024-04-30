package problem3;

import java.util.Objects;

/**
 * Amount Class represents a monetary amount with dollars and cents.
 */
public class Amount {

  private int dollars;
  private int cents;

  /**
   * Constructs a new Amount with the specified dollars and cents.
   *
   * @param dollars The dollar amount (non-negative integer).
   * @param cents   The cent amount (between 0 and 99, inclusive).
   */
  public Amount(int dollars, int cents) {
    this.dollars = dollars;
    this.cents = cents;
  }

  /**
   * Gets the dollar amount.
   *
   * @return The dollar amount.
   */
  public int getDollars() {
    return dollars;
  }

  /**
   * Gets the cent amount.
   *
   * @return The cent amount.
   */
  public int getCents() {
    return cents;
  }
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Amount amount = (Amount) o;
    return dollars == amount.dollars && cents == amount.cents;
  }

  /**
   * Generates a hash code for this Amount.
   *
   * @return The hash code.
   */
  @Override
  public int hashCode() {
    return Objects.hash(dollars, cents);
  }
}
