package problem1;

import java.time.LocalDate;

public class Fruit extends PerishableFoodItem{

  public Fruit(String name, Double currPricePerUnit, Integer currAvailableQuantity,
      LocalDate orderDate, LocalDate expirationDate) {
    super(name, currPricePerUnit, currAvailableQuantity, orderDate, expirationDate);
  }
}
