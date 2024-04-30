package problem3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Objects;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AmountTest {
  private Amount testAmount;
  private int expDollars;
  private int expCents;

  @BeforeEach
  void setUp() {
    testAmount = new Amount(50, 75);
    expDollars = 50;
    expCents = 75;
  }

  @Test
  void getDollars() {
    assertEquals(expDollars, testAmount.getDollars());
  }

  @Test
  void getCents() {
    assertEquals(expCents, testAmount.getCents());
  }

  @Test
  void testEquals_SameObjects() {
    assertTrue(testAmount.equals(testAmount));
  }

  @Test
  void testEquals_NullComparison() {
    assertFalse(testAmount.equals(null));
  }

  @Test
  void testEquals_DifferentDataType() {
    assertFalse(testAmount.equals("String"));
  }

  @Test
  void testEquals_DifferentObjectSameFields() {
    Amount otherAmount = new Amount(expDollars, expCents);
    assertTrue(testAmount.equals(otherAmount));
  }

  @Test
  void testEquals_DifferentObjectDifferentDollars() {
    Amount otherAmount = new Amount(60, expCents);
    assertFalse(testAmount.equals(otherAmount));
  }

  @Test
  void testEquals_DifferentObjectDifferentCents() {
    Amount otherAmount = new Amount(expDollars, 80);
    assertFalse(testAmount.equals(otherAmount));
  }

  @Test
  void testHashCode() {
    int expHashCode = Objects.hash(expDollars, expCents);
    assertEquals(expHashCode, testAmount.hashCode());
  }
}
