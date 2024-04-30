package problem1;

/**
 * The Rice class is a type of NonPerishableFoodItem.
 * It inherits attributes including name, current price per unit, current available quantity, and maximum allowed quantity
 * from the base class.
 */
public class Rice extends NonPerishableFoodItem {

  /**
   * Constructs a new {@code Rice} with the specified details.
   *
   * @param name                the name of the rice
   * @param currPricePerUnit    the current price per unit of the rice
   * @param currAvailableQuantity the current available quantity of the rice
   */
  public Rice(String name, Double currPricePerUnit, Integer currAvailableQuantity) {
    super(name, currPricePerUnit, currAvailableQuantity);
  }
}
