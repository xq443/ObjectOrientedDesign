package problem1;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CookieTest {

  private Cookie testCookie;
  private String[] expectedIngredients;
  private String expectedName;
  private Double expectedQuantity;
  private Double expectedCalories;
  private Double expectedSugar;
  private Double expectedFat;
  private Double expectedProtein;
  private Double expectedFiber;
  private Boolean expectedContainsNuts;
  private Boolean expectedContainsDairy;
  private Boolean expectedGlutenFree;

  @BeforeEach
  void setUp() {
    expectedName = "Chocolate Chip Cookie";
    expectedIngredients = new String[]{"flour", "sugar", "butter", "chocolate chips"};
    expectedQuantity = 1.0;
    expectedCalories = 200.0;
    expectedSugar = 20.0;
    expectedFat = 10.0;
    expectedProtein = 5.0;
    expectedFiber = 2.0;
    expectedContainsNuts = true;
    expectedContainsDairy = true;
    expectedGlutenFree = false;

    testCookie = new Cookie(expectedName, expectedIngredients, expectedQuantity,
        expectedCalories, expectedSugar, expectedFat, expectedProtein, expectedFiber,
        expectedContainsNuts, expectedContainsDairy, expectedGlutenFree);
  }

  @Test
  void testGetName() {
    assertEquals(expectedName, testCookie.getName());
  }

  @Test
  void testGetIngredients() {
    assertArrayEquals(expectedIngredients, testCookie.getIngredients());
  }

  @Test
  void testGetQuantityPerServing() {
    assertEquals(expectedQuantity, testCookie.getQuantityPerServing());
  }

  @Test
  void testGetCaloriesPerServing() {
    assertEquals(expectedCalories, testCookie.getCaloriesPerServing());
  }

  @Test
  void testGetSugarPerServing() {
    assertEquals(expectedSugar, testCookie.getSugarPerServing());
  }

  @Test
  void testGetFatPerServing() {
    assertEquals(expectedFat, testCookie.getFatPerServing());
  }

  @Test
  void testGetProteinPerServing() {
    assertEquals(expectedProtein, testCookie.getProteinPerServing());
  }

  @Test
  void testGetFiberPerServing() {
    assertEquals(expectedFiber, testCookie.getFiberPerServing());
  }

  @Test
  void testGetContainsNuts() {
    assertEquals(expectedContainsNuts, testCookie.getContainsNuts());
  }

  @Test
  void testGetContainsDairy() {
    assertEquals(expectedContainsDairy, testCookie.getContainsDairy());
  }

  @Test
  void testGetGlutenFree() {
    assertEquals(expectedGlutenFree, testCookie.getGlutenFree());
  }
  @Test
  void testChangeName() {
    String newName = "Oatmeal Raisin Cookie";
    Cookie newCookie = new Cookie(newName, expectedIngredients, expectedQuantity,
        expectedCalories, expectedSugar, expectedFat, expectedProtein, expectedFiber,
        expectedContainsNuts, expectedContainsDairy, expectedGlutenFree);
    assertNotEquals(newCookie, testCookie);
  }

  @Test
  void testChangeIngredients() {
    String[] newIngredients = {"oats", "raisins", "butter", "sugar"};
    Cookie newCookie = new Cookie(expectedName, newIngredients, expectedQuantity,
        expectedCalories, expectedSugar, expectedFat, expectedProtein, expectedFiber,
        expectedContainsNuts, expectedContainsDairy, expectedGlutenFree);
    assertNotEquals(newCookie, testCookie);
  }

  @Test
  void testChangeQuantity() {
    Double newQuantity = 0.5;
    Cookie newCookie = new Cookie(expectedName, expectedIngredients, newQuantity,
        expectedCalories, expectedSugar, expectedFat, expectedProtein, expectedFiber,
        expectedContainsNuts, expectedContainsDairy, expectedGlutenFree);
    assertNotEquals(newCookie, testCookie);
  }

  @Test
  void testChangeCalories() {
    Double newCalories = 150.0;
    Cookie newCookie = new Cookie(expectedName, expectedIngredients, expectedQuantity,
        newCalories, expectedSugar, expectedFat, expectedProtein, expectedFiber,
        expectedContainsNuts, expectedContainsDairy, expectedGlutenFree);
    assertNotEquals(newCookie, testCookie);
  }

  @Test
  void testChangeSugar() {
    Double newSugar = 15.0;
    Cookie newCookie = new Cookie(expectedName, expectedIngredients, expectedQuantity,
        expectedCalories, newSugar, expectedFat, expectedProtein, expectedFiber,
        expectedContainsNuts, expectedContainsDairy, expectedGlutenFree);
    assertNotEquals(newCookie, testCookie);
  }

  @Test
  void testChangeFat() {
    Double newFat = 8.0;
    Cookie newCookie = new Cookie(expectedName, expectedIngredients, expectedQuantity,
        expectedCalories, expectedSugar, newFat, expectedProtein, expectedFiber,
        expectedContainsNuts, expectedContainsDairy, expectedGlutenFree);
    assertNotEquals(newCookie, testCookie);
  }

  @Test
  void testChangeProtein() {
    Double newProtein = 6.0;
    Cookie newCookie = new Cookie(expectedName, expectedIngredients, expectedQuantity,
        expectedCalories, expectedSugar, expectedFat, newProtein, expectedFiber,
        expectedContainsNuts, expectedContainsDairy, expectedGlutenFree);
    assertNotEquals(newCookie, testCookie);
  }

  @Test
  void testChangeFiber() {
    Double newFiber = 3.0;
    Cookie newCookie = new Cookie(expectedName, expectedIngredients, expectedQuantity,
        expectedCalories, expectedSugar, expectedFat, expectedProtein, newFiber,
        expectedContainsNuts, expectedContainsDairy, expectedGlutenFree);
    assertNotEquals(newCookie, testCookie);
  }

  @Test
  void testChangeContainsNuts() {
    Boolean newContainsNuts = false;
    Cookie newCookie = new Cookie(expectedName, expectedIngredients, expectedQuantity,
        expectedCalories, expectedSugar, expectedFat, expectedProtein, expectedFiber,
        newContainsNuts, expectedContainsDairy, expectedGlutenFree);
    assertNotEquals(newCookie, testCookie);
  }

  @Test
  void testChangeContainsDairy() {
    Boolean newContainsDairy = false;
    Cookie newCookie = new Cookie(expectedName, expectedIngredients, expectedQuantity,
        expectedCalories, expectedSugar, expectedFat, expectedProtein, expectedFiber,
        expectedContainsNuts, newContainsDairy, expectedGlutenFree);
    assertNotEquals(newCookie, testCookie);
  }

  @Test
  void testChangeGlutenFree() {
    Boolean newGlutenFree = true;
    Cookie newCookie = new Cookie(expectedName, expectedIngredients, expectedQuantity,
        expectedCalories, expectedSugar, expectedFat, expectedProtein, expectedFiber,
        expectedContainsNuts, expectedContainsDairy, newGlutenFree);
    assertNotEquals(newCookie, testCookie);
  }

  @Test
  void testEquals_SameObjects() {
    assertEquals(testCookie, testCookie);
  }

  @Test
  void testEquals_NullComparison() {
    assertFalse(testCookie.equals(null));
  }

  @Test
  void testEquals_DifferentDataType() {
    assertFalse(testCookie.equals("String"));
  }


  @Test
  void testEquals_DifferentObjectSameValues() {
    Cookie otherCookie = new Cookie(expectedName, expectedIngredients, expectedQuantity,
        expectedCalories, expectedSugar, expectedFat, expectedProtein, expectedFiber,
        expectedContainsNuts, expectedContainsDairy, expectedGlutenFree);
    assertTrue(testCookie.equals(otherCookie));
  }

  @Test
  void testHashCode() {
    int expectedHashCode = Objects.hash(testCookie.getName(),
        testCookie.getQuantityPerServing(), testCookie.getCaloriesPerServing(), testCookie.getSugarPerServing(),
        testCookie.getFatPerServing(), testCookie.getProteinPerServing(), testCookie.getFiberPerServing(),
        testCookie.getContainsNuts(), testCookie.getContainsDairy(), testCookie.getGlutenFree());
    assertEquals(31 * expectedHashCode + Arrays.hashCode(testCookie.getIngredients()), testCookie.hashCode());
  }


  @Test
  void testToString() {
    String expectedStr = "Cookie{name='Chocolate Chip Cookie', ingredients=[flour, sugar, butter, chocolate chips], " +
        "quantityPerServing=1.0, caloriesPerServing=200.0, sugarPerServing=20.0, fatPerServing=10.0, " +
        "proteinPerServing=5.0, fiberPerServing=2.0, containsNuts=true, containsDairy=true, glutenFree=false}";
    assertEquals(expectedStr, testCookie.toString());
  }
}
