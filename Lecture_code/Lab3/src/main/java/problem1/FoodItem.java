package problem1;

import java.util.Objects;

public abstract class FoodItem {

  protected String name;
  protected Double currPricePerUnit;
  protected Integer currAvailableQuantity;
  protected Integer maxAllowedQuantity;

  public FoodItem(String name, Double currPricePerUnit, Integer currAvailableQuantity,
      Integer maxAllowedQuantity) {
    this.name = name;
    this.currPricePerUnit = currPricePerUnit;
    this.currAvailableQuantity = currAvailableQuantity;
    this.maxAllowedQuantity = maxAllowedQuantity;
  }

  public String getName() {
    return name;
  }

  public Double getCurrPricePerUnit() {
    return currPricePerUnit;
  }

  public Integer getCurrAvailableQuantity() {
    return currAvailableQuantity;
  }

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
