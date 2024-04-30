package problem2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CivilianTest {

  private Farmer testFarmer;
  private Engineer testEngineer;
  private Name expectedName;
  private Integer expectedAge;
  private Double expectedWealth;

  @BeforeEach
  void setUp() {
    expectedName = new Name("Old", "McDonald");
    expectedAge = 55;
    expectedWealth = 2000000.0;
    try {
      testFarmer = new Farmer(new Name("Old", "McDonald"), 65, 1500000.0);
      testEngineer = new Engineer((new Name(" Rosie", "Revere")), 55, 2000000.0);
    } catch (InvalidAgeException e) {
      throw new RuntimeException(e);
    } catch (InvalidWealthException e) {
      throw new RuntimeException(e);
    }
  }

  @Test
  void testConstructor_Age1() {
    assertThrows(InvalidAgeException.class, ()-> {new Farmer(expectedName, -15, 1000.0);});
  }

  @Test
  void testConstructor_Age2() {
    assertThrows(InvalidAgeException.class, ()->{new Farmer(expectedName, 130, 1000.0);});
  }

  @Test
  void testConstructor_Wealth() {
    assertThrows(InvalidWealthException.class, ()->{new Farmer(expectedName, 55, -100.0);});
  }

  @Test
  void getName() {
    assertEquals(expectedName, testFarmer.getName());
  }

  @Test
  void getAge() {
    assertEquals(expectedAge, testEngineer.getAge());
  }

  @Test
  void getWealth() {
    assertEquals(expectedWealth, testEngineer.getWealth());
  }

  @Test
  void testValidateWealth_True() {
    assertTrue(testFarmer.validateWealth(10.2));
  }

  @Test
  void testValidateWealth_False() {
    assertFalse(testFarmer.validateWealth(-10.2));
  }

  @Test
  void increaseWealth() {
    testEngineer.increaseWealth(500000.0);
    Double expectedWealth = 2500000.0;
    assertEquals(expectedWealth, testEngineer.getWealth());
  }

  @Test
  void increaseWealth2() {
    testEngineer.increaseWealth(-2500000.0);
    Double expectedWealth = 2000000.0;
    assertEquals(expectedWealth, testEngineer.getWealth());
  }

  @Test
  void decreaseWealth() {
    testFarmer.decreaseWealth(500000.0);
    Double expectedWealth = 1000000.0;
    assertEquals(expectedWealth, testFarmer.getWealth());
  }

  @Test
  void decreaseWealth2() {
    testFarmer.decreaseWealth(2500000.0);
    Double expectedWealth = 1500000.0;
    assertEquals(expectedWealth, testFarmer.getWealth());
  }

  @Test
  void testEquals_SameObject() {
    assertTrue(testFarmer.equals(testFarmer));
  }

  @Test
  void testEquals_NullObject() {
    assertFalse(testFarmer.equals(null));
  }

  @Test
  void testEquals_DifferentDataTypes() {
    assertFalse(testFarmer.equals("String"));
  }

  @Test
  void testEquals_DifferentName() {
    try {
      Farmer otherFarmer = new Farmer(new Name("Jane", "McDonald"), 65, 1500000.0);
      assertFalse(testFarmer.equals(otherFarmer));
    } catch (InvalidAgeException e) {
      throw new RuntimeException(e);
    } catch (InvalidWealthException e) {
      throw new RuntimeException(e);
    }
  }

  @Test
  void testEquals_DifferentAge() {
    try {
      Farmer otherFarmer = new Farmer(new Name("Old", "McDonald"), 55, 1500000.0);
      assertFalse(testFarmer.equals(otherFarmer));
    } catch (InvalidAgeException e) {
      throw new RuntimeException(e);
    } catch (InvalidWealthException e) {
      throw new RuntimeException(e);
    }
  }

  @Test
  void testEquals_DifferentWealth() {
    try {
      Farmer otherFarmer = new Farmer(new Name("Old", "McDonald"), 65, 500000.0);
      assertFalse(testFarmer.equals(otherFarmer));
    } catch (InvalidAgeException e) {
      throw new RuntimeException(e);
    } catch (InvalidWealthException e) {
      throw new RuntimeException(e);
    }
  }

  @Test
  void testEquals_DifferentObjectSameValue() {
    try {
      Farmer otherFarmer = new Farmer(new Name("Old", "McDonald"), 65, 1500000.0);
      assertTrue(testFarmer.equals(otherFarmer));
    } catch (InvalidAgeException e) {
      throw new RuntimeException(e);
    } catch (InvalidWealthException e) {
      throw new RuntimeException(e);
    }
  }

  @Test
  void testHashCode() {
    int expectedHashCode = Objects.hash(Objects.hash(testEngineer.getName(), testEngineer.getAge()),
        testEngineer.getWealth());
    assertEquals(expectedHashCode, testEngineer.hashCode());
  }

  @Test
  void testToString_Farmer() {
    String expectedString = "Farmer{" +
        "wealth=" + testFarmer.getWealth() +
        ", name=" + testFarmer.getName() +
        ", age=" + testFarmer.getAge() +
        '}';
    assertEquals(expectedString, testFarmer.toString());
  }

  @Test
  void testToString_Engineer() {
    String expectedString = "Engineer{" +
        "wealth=" + testEngineer.getWealth() +
        ", name=" + testEngineer.getName() +
        ", age=" + testEngineer.getAge() +
        '}';
    assertEquals(expectedString, testEngineer.toString());
  }


}