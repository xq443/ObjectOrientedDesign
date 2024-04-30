package problem2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SoldierTest {

  private Marine testMarine;
  private Soldier testSoldier;
  private Double expectedStamina;

  @BeforeEach
  void setUp() {
    try {
      testMarine = new Marine(new Name("G.I.", "Joe"), 35, 100.0);
      testSoldier = new Sniper(new Name("G.I.", "Jane"), 30, 100.0);
    } catch (InvalidAgeException e) {
      throw new RuntimeException(e);
    } catch (InvalidStaminaException e) {
      throw new RuntimeException(e);
    }
  }

  @Test
  void testConstructor_Age1(){
    assertThrows(InvalidAgeException.class, ()-> {new Marine(new Name("G.I.", "Joe"), -35, 100.0);});
  }

  @Test
  void testConstructor_Age2(){
    assertThrows(InvalidAgeException.class, ()-> {new Marine(new Name("G.I.", "Joe"), 135, 100.0);});
  }

  @Test
  void testConstructor_Stamina1(){
    assertThrows(InvalidStaminaException.class, ()-> {new Marine(new Name("G.I.", "Joe"), 35, -10.0);});
  }

  @Test
  void testConstructor_Stamina2(){
    assertThrows(InvalidStaminaException.class, ()-> {new Marine(new Name("G.I.", "Joe"), 35, 110.0);});
  }

  @Test
  void validateStamina_True() {
    assertTrue(testMarine.validateStamina(25.0));
  }

  @Test
  void getStamina() {
  }

  @Test
  void validateStamina_False() {
    assertFalse(testMarine.validateStamina(-25.0));
  }

  @Test
  void increaseStamina1() {
    testMarine.increaseStamina(25.0);
    assertEquals(100.0, testMarine.getStamina());
  }

  @Test
  void increaseStamina2() {
    testMarine.increaseStamina(-25.0);
    assertEquals(75.0, testMarine.getStamina());
  }

  @Test
  void decreaseStamina1() {
    testMarine.decreaseStamina(125.0);
    assertEquals(100.0, testMarine.getStamina());
  }

  @Test
  void decreaseStamina2() {
    testMarine.decreaseStamina(25.0);
    assertEquals(75.0, testMarine.getStamina());
  }

  @Test
  void testEquals_SameObject() {
    assertTrue(testMarine.equals(testMarine));
  }

  @Test
  void testEquals_NullObject() {
    assertFalse(testMarine.equals(null));
  }

  @Test
  void testEquals_DifferentDataType() {
    assertFalse(testMarine.equals("String"));
  }


  @Test
  void testEquals_DifferentName() {
    try {
      Marine otherMarine = new Marine(new Name("G.I.", "Mike"), 35, 100.0);
      assertFalse(testMarine.equals(otherMarine));
    } catch (InvalidAgeException e) {
      throw new RuntimeException(e);
    } catch (InvalidStaminaException e) {
      throw new RuntimeException(e);
    }
  }

  @Test
  void testEquals_DifferentAge() {
    try {
      Marine otherMarine = new Marine(new Name("G.I.", "Joe"), 25, 100.0);
      assertFalse(testMarine.equals(otherMarine));
    } catch (InvalidAgeException e) {
      throw new RuntimeException(e);
    } catch (InvalidStaminaException e) {
      throw new RuntimeException(e);
    }
  }

  @Test
  void testEquals_DifferentStamina() {
    try {
      Marine otherMarine = new Marine(new Name("G.I.", "Joe"), 35, 20.0);
      assertFalse(testMarine.equals(otherMarine));
    } catch (InvalidAgeException e) {
      throw new RuntimeException(e);
    } catch (InvalidStaminaException e) {
      throw new RuntimeException(e);
    }
  }

  @Test
  void testEquals_DifferentObjectsSameValue() {
    try {
      Marine otherMarine = new Marine(new Name("G.I.", "Joe"), 35, 100.0);
      assertTrue(testMarine.equals(otherMarine));
    } catch (InvalidAgeException e) {
      throw new RuntimeException(e);
    } catch (InvalidStaminaException e) {
      throw new RuntimeException(e);
    }
  }


  @Test
  void testHashCode() {
    int expectedHashCode = Objects.hash(Objects.hash(testMarine.getName(),
        testMarine.getAge()), testMarine.getStamina());
    assertEquals(expectedHashCode, testMarine.hashCode());
  }

  @Test
  void testToString_Sniper() {
    String expectedString = "Sniper{" +
        "stamina=" + testSoldier.getStamina() +
        ", name=" + testSoldier.getName() +
        ", age=" + testSoldier.getAge() +
        '}';
    assertEquals(expectedString, testSoldier.toString());
  }

  @Test
  void testToString_Marine() {
    String expectedString = "Marine{" +
        "stamina=" + testMarine.getStamina() +
        ", name=" + testMarine.getName() +
        ", age=" + testMarine.getAge() +
        '}';
    assertEquals(expectedString, testMarine.toString());
  }


}