package problem1;

import java.time.LocalDate;

public class Vegetable extends PerishableFoodItem{

  public Vegetable(String name, Double currPricePerUnit, Integer currAvailableQuantity,
      LocalDate orderDate, LocalDate expirationDate) {
    super(name, currPricePerUnit, currAvailableQuantity, orderDate, expirationDate);
  }
}
