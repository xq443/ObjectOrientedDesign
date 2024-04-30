package problem1;

/**
 * The NonPerishableFoodItem class is a type of FoodItem.
 * It inherits attributes including name,
 * current price per unit, current available quantity, and maximum allowed quantity
 * from the base class.
 * Non-perishable food items have a constant maximum allowed quantity(250).
 */
public abstract class NonPerishableFoodItem extends FoodItem {

  protected static final Integer MAX_ALLOWED_QUANTITY = 250;

  /**
   * Constructs a new {@code NonPerishableFoodItem} with the specified details.
   *
   * @param name                the name of the non-perishable food item
   * @param currPricePerUnit    the current price per unit of the non-perishable food item
   * @param currAvailableQuantity the current available quantity of the non-perishable food item
   */
  public NonPerishableFoodItem(String name, Double currPricePerUnit, Integer currAvailableQuantity) {
    super(name, currPricePerUnit, currAvailableQuantity, MAX_ALLOWED_QUANTITY);
  }
}