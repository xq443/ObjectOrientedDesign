package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RiceTest {
  private Rice testRice;
  private String expectedName;
  private Double expectedPrice;
  private Integer expectedQuantity;

  @BeforeEach
  void setUp() {
    testRice = new Rice("Jasmine Rice", 3.45, 128);
    expectedName = "Jasmine Rice";
    expectedPrice = 3.45;
    expectedQuantity = 128;
  }

  @Test
  void getName() {
    assertEquals(expectedName, testRice.getName());
  }

  @Test
  void getCurrPricePerUnit() {
    assertEquals(expectedPrice, testRice.getCurrPricePerUnit());
  }

  @Test
  void getCurrAvailableQuantity() {
    assertEquals(expectedQuantity, testRice.getCurrAvailableQuantity());
  }

  @Test
  void getMaxAllowedQuantity() {
    assertEquals(Rice.MAX_ALLOWED_QUANTITY, testRice.getMaxAllowedQuantity());
  }

  @Test
  void testEquals_SameObjects() {
    assertTrue(testRice.equals(testRice));
  }

  @Test
  void testEquals_NullObjects() {
    assertFalse(testRice.equals(null));
  }
  @Test
  void testEquals_DifferentDataType() {
    assertFalse(testRice.equals("String"));
  }
  @Test
  void testEquals_DifferentName() {
    Rice otherRice = new Rice("Grain Rice", 3.45, 128);
    assertFalse(testRice.equals(otherRice));
  }
  @Test
  void testEquals_DifferentRice() {
    Rice otherRice = new Rice("Jasmine Rice", 3.75, 128);
    assertFalse(testRice.equals(otherRice));
  }
  @Test
  void testEquals_DifferentQuantity() {
    Rice otherRice = new Rice("Jasmine Rice", 3.45, 200);
    assertFalse(testRice.equals(otherRice));
  }
  @Test
  void testEquals_DifferentObjectSameFields() {
    Rice otherRice = new Rice("Jasmine Rice", 3.45, 128);
    assertTrue(testRice.equals(otherRice));
  }



  @Test
  void testHashCode() {
    int expectedHashCode = Objects.hash(testRice.getName(), testRice.getCurrPricePerUnit(), testRice.getCurrAvailableQuantity(), testRice.getMaxAllowedQuantity());
    assertEquals(expectedHashCode, testRice.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "FoodItem{" +
        "name='" + testRice.getName() + '\'' +
        ", currPricePerUnit=" + testRice.getCurrPricePerUnit() +
        ", currAvailableQuantity=" + testRice.getCurrAvailableQuantity() +
        ", maxAllowedQuantity=" + testRice.getMaxAllowedQuantity() +
        '}';
    assertEquals(expectedString, testRice.toString());
  }
}