package problem1;

/**
 * The Pasta class represents a type of NonPerishableFoodItem.
 * It inherits attributes including
 * name, current price per unit, current available quantity, and maximum allowed quantity
 * from the base class.
 */
public class Pasta extends NonPerishableFoodItem {

  /**
   * Constructs a new {@code Pasta} with the specified details.
   *
   * @param name                the name of the pasta
   * @param currPricePerUnit    the current price per unit of the pasta
   * @param currAvailableQuantity the current available quantity of the pasta
   */
  public Pasta(String name, Double currPricePerUnit, Integer currAvailableQuantity) {
    super(name, currPricePerUnit, currAvailableQuantity);
  }
}
