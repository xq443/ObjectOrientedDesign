package problem1;

import java.time.LocalDate;

public class Meat extends PerishableFoodItem{

  public Meat(String name, Double currPricePerUnit, Integer currAvailableQuantity,
      LocalDate orderDate, LocalDate expirationDate) {
    super(name, currPricePerUnit, currAvailableQuantity, orderDate, expirationDate);
  }
}
