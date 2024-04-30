package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PerishableFoodItemTest {

  private Meat testMeat;
  private Fruit testFruit;
  private Vegetable testVegetable;
  private LocalDate expectedOrderDate;
  private LocalDate expectedExpirationDate;

  @BeforeEach
  void setUp() {
    testMeat = new Meat("Chicken breast", 3.45, 95,
        LocalDate.of(2024, 1, 15), LocalDate.of(2024, 2, 1));
    testFruit = new Fruit("Anjou pears", 2.99, 80,
        LocalDate.of(2023, 12, 27), LocalDate.now());
    testVegetable = new Vegetable("Iceberg lettuce", 2.45, 25,
        LocalDate.of(2024, 1, 10), LocalDate.now());
    expectedOrderDate = LocalDate.of(2023, 12, 27);
    expectedExpirationDate = LocalDate.now();
  }

  @Test
  void getOrderDate() {
    assertEquals(expectedOrderDate, testFruit.getOrderDate());
  }

  @Test
  void getExpirationDate() {
    assertEquals(expectedExpirationDate, testVegetable.getExpirationDate());
  }

  @Test
  void testEquals_SameObject() {
    assertTrue(testVegetable.equals(testVegetable));
  }

  @Test
  void testEquals_NullObject(){
    assertFalse(testVegetable.equals(null));
  }

  @Test
  void testEquals_DifferentDataTypes(){
    assertFalse(testFruit.equals("String"));
  }

  @Test
  void testEquals_DifferentName(){
    Meat otherMeat = new Meat("Pork chops", 3.45, 95,
        LocalDate.of(2024, 1, 15), LocalDate.of(2024, 2, 1));
    assertFalse(testMeat.equals(otherMeat));
  }

  @Test
  void testEquals_DifferentPrice(){
    Meat otherMeat = new Meat("Chicken breast", 4.45, 95,
        LocalDate.of(2024, 1, 15), LocalDate.of(2024, 2, 1));
    assertFalse(testMeat.equals(otherMeat));
  }

  @Test
  void testEquals_DifferentQuantity(){
    Meat otherMeat = new Meat("Chicken breast", 3.45, 85,
        LocalDate.of(2024, 1, 15), LocalDate.of(2024, 2, 1));
    assertFalse(testMeat.equals(otherMeat));
  }

  @Test
  void testEquals_DifferentOrderDate(){
    Meat otherMeat = new Meat("Chicken breast", 3.45, 95,
        LocalDate.of(2023, 12, 15), LocalDate.of(2024, 2, 1));
    assertFalse(testMeat.equals(otherMeat));
  }

  @Test
  void testEquals_DifferentExpirationDate(){
    Meat otherMeat = new Meat("Chicken breast", 3.45, 95,
        LocalDate.of(2024, 1, 15), LocalDate.of(2024, 2, 15));
    assertFalse(testMeat.equals(otherMeat));
  }

  @Test
  void testEquals_DifferentObjectSameValue(){
    Meat otherMeat = new Meat("Chicken breast", 3.45, 95,
        LocalDate.of(2024, 1, 15), LocalDate.of(2024, 2, 1));
    assertTrue(testMeat.equals(otherMeat));
  }

  @Test
  void testHashCode() {
    int expectedHashCode = Objects.hash(Objects.hash(testMeat.getName(), testMeat.getCurrPricePerUnit(),
        testMeat.getCurrAvailableQuantity(), testMeat.getMaxAllowedQuantity()),
        testMeat.getOrderDate(), testMeat.getExpirationDate());
    assertEquals(expectedHashCode, testMeat.hashCode());
  }


  @Test
  void testToString() {
    String expectedString = "PerishableFoodItem{" +
          "orderDate=" + testMeat.getOrderDate() +
          ", expirationDate=" + testMeat.getExpirationDate() +
          ", name='" + testMeat.getName() + '\'' +
          ", currPricePerUnit=" + testMeat.getCurrPricePerUnit() +
          ", currAvailableQuantity=" + testMeat.getCurrAvailableQuantity() +
          ", maxAllowedQuantity=" + testMeat.getMaxAllowedQuantity() +
          '}';
    assertEquals(expectedString, testMeat.toString());
  }
}