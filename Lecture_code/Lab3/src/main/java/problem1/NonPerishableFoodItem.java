package problem1;

public abstract class NonPerishableFoodItem extends FoodItem {

  protected static final Integer MAX_ALLOWED_QUANTITY = 250;

  public NonPerishableFoodItem(String name, Double currPricePerUnit, Integer currAvailableQuantity) {
    super(name, currPricePerUnit, currAvailableQuantity, MAX_ALLOWED_QUANTITY);
  }
}
