package problem1;

import java.time.LocalDate;
import java.util.Objects;

/**
 * The PerishableFoodItem class is a type of FoodItem.
 * It inherits attributes including name, current price per unit, current
 * available quantity, and maximum allowed quantity from the base class.
 * Additionally, it
 * includes the order date and expiration date of perishable food items.
 * Perishable food items have a constant maximum allowed quantity(100).
 */
public abstract class PerishableFoodItem extends FoodItem {
  protected LocalDate orderDate;
  protected LocalDate expirationDate;
  protected static final Integer MAX_ALLOWED_QUANTITY = 100;

  /**
   * Constructs a new {@code PerishableFoodItem} with the specified details.
   *
   * @param name                the name of the perishable food item
   * @param currPricePerUnit    the current price per unit of the perishable food item
   * @param currAvailableQuantity the current available quantity of the perishable food item
   * @param orderDate           the order date of the perishable food item
   * @param expirationDate      the expiration date of the perishable food item
   */
  public PerishableFoodItem(String name, Double currPricePerUnit, Integer currAvailableQuantity,
      LocalDate orderDate, LocalDate expirationDate) {
    super(name, currPricePerUnit, currAvailableQuantity, MAX_ALLOWED_QUANTITY);
    this.orderDate = orderDate;
    this.expirationDate = expirationDate;
  }

  /**
   * Returns the order date of the perishable food item.
   *
   * @return the order date of the perishable food item as LocalDate
   */
  public LocalDate getOrderDate() {
    return orderDate;
  }

  /**
   * Returns the expiration date of the perishable food item.
   *
   * @return the expiration date of the perishable food item as LocalDate
   */
  public LocalDate getExpirationDate() {
    return expirationDate;
  }
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    PerishableFoodItem that = (PerishableFoodItem) o;
    return Objects.equals(orderDate, that.orderDate) && Objects.equals(
        expirationDate, that.expirationDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), orderDate, expirationDate);
  }

  @Override
  public String toString() {
    return "PerishableFoodItem{" +
        "orderDate=" + orderDate +
        ", expirationDate=" + expirationDate +
        ", name='" + name + '\'' +
        ", currPricePerUnit=" + currPricePerUnit +
        ", currAvailableQuantity=" + currAvailableQuantity +
        ", maxAllowedQuantity=" + maxAllowedQuantity +
        '}';
  }
}
