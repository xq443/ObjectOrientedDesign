package problem2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NameTest {

  private Name testName;
  private String expectedFirstName;
  private String expectedLastName;
  private String expectedMiddleName;



  @BeforeEach
  void setUp() {
    testName = new Name("Jillian", "Alice", "Martin");
    expectedFirstName = "Jillian";
    expectedLastName = "Martin";
    expectedMiddleName = "Alice";
  }

  @Test
  void getFirstName() {
    assertEquals(expectedFirstName, testName.getFirstName());
  }
  @Test
  void getMiddleName() {
    assertEquals(expectedMiddleName, testName.getMiddleName());
  }

  @Test
  void getLastName() {
    assertEquals(expectedLastName, testName.getLastName());
  }

  @Test
  void testEquals_SameObjects() {
    assertEquals(testName, testName);
  }

  @Test
  void testEquals_NullComparison() {
    assertFalse(testName.equals(null));
  }

  @Test
  void testEquals_DifferentDataType() {
    assertFalse(testName.equals("String"));
  }

  @Test
  void testEquals_DifferentObjectDifferentFirstName() {
    Name otherName = new Name("Cathy", "Alice", "Martin");
    assertFalse(testName.equals(otherName));
  }

  @Test
  void testEquals_DifferentObjectDifferentLastName() {
    Name otherName = new Name("Jillian", "Alice", "Qin");
    assertFalse(testName.equals(otherName));
  }


  @Test
  void testEquals_DifferentObjectDifferentMiddleame() {
    Name otherName = new Name("Jillian", "Alien", "Qin");
    assertFalse(testName.equals(otherName));
  }

  @Test
  void testEquals_DifferentObjectSameValues() {
    Name otherName = new Name("Jillian", "Alice", "Martin");
    assertTrue(testName.equals(otherName));
  }

  @Test
  void testHashCode() {
    int expectedHashCode = Objects.hash(expectedFirstName, expectedMiddleName, expectedLastName);
    assertEquals(expectedHashCode, testName.hashCode());
  }


  @Test
  void testToString() {
    String expectedStr = "Name{" +
        "firstName='" + testName.getFirstName() + '\'' +
        ", middleName='" + testName.getMiddleName() + '\'' +
        ", lastName='" + testName.getLastName() + '\'' +
        '}';
    assertEquals(expectedStr, testName.toString());
  }
}