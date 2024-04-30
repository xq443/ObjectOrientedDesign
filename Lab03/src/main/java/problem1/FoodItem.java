package problem1;

import java.util.Objects;

/**
 * The FoodItem class represents a food class with essential properties
 * including name, current price per unit, current available quantity, and maximum allowed quantity.
 * This class serves as an abstract base class for specific types of food items.
 *
 * @author Cathy
 */
public abstract class FoodItem {

  protected String name;
  protected Double currPricePerUnit;
  protected Integer currAvailableQuantity;
  protected Integer maxAllowedQuantity;

  /**
   * Constructs a new {@code FoodItem} with the specified details.
   *
   * @param name                the name of the food item
   * @param currPricePerUnit    the current price per unit of the food item
   * @param currAvailableQuantity the current available quantity of the food item
   * @param maxAllowedQuantity  the maximum allowed quantity of the food item
   */
  public FoodItem(String name, Double currPricePerUnit, Integer currAvailableQuantity,
      Integer maxAllowedQuantity) {
    this.name = name;
    this.currPricePerUnit = currPricePerUnit;
    this.currAvailableQuantity = currAvailableQuantity;
    this.maxAllowedQuantity = maxAllowedQuantity;
  }

  /**
   * the name of the food item.
   * @return the name of the food item: String
   */
  public String getName() {
    return name;
  }

  /**
   * the current price per unit of the food item.
   * @return the current price per unit of the food item as Double
   */
  public Double getCurrPricePerUnit() {
    return currPricePerUnit;
  }

  /**
   * the current available quantity of the food item.
   * @return the current available quantity of the food item as Integer
   */
  public Integer getCurrAvailableQuantity() {
    return currAvailableQuantity;
  }

  /**
   * the maximum allowed quantity of the food item.
   * @return the maximum allowed quantity of the food item as Integer
   */
  public Integer getMaxAllowedQuantity() {
    return maxAllowedQuantity;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FoodItem foodItem = (FoodItem) o;
    return Objects.equals(name, foodItem.name) && Objects.equals(currPricePerUnit,
        foodItem.currPricePerUnit) && Objects.equals(currAvailableQuantity,
        foodItem.currAvailableQuantity) && Objects.equals(maxAllowedQuantity,
        foodItem.maxAllowedQuantity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, currPricePerUnit, currAvailableQuantity, maxAllowedQuantity);
  }

  @Override
  public String toString() {
    return "FoodItem{" +
        "name='" + name + '\'' +
        ", currPricePerUnit=" + currPricePerUnit +
        ", currAvailableQuantity=" + currAvailableQuantity +
        ", maxAllowedQuantity=" + maxAllowedQuantity +
        '}';
  }
}
