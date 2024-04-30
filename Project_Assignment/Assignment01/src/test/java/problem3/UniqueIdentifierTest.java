package problem3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UniqueIdentifierTest {
  private UniqueIdentifier testUniqueIdentifier;
  private String expUsername;
  private int expYear;
  private String expCountry;

  @BeforeEach
  void setUp() {
    testUniqueIdentifier = new UniqueIdentifier("cathyqin", 2024, "USA");
    expYear = 2024;
    expCountry = "USA";
    expUsername = "cathyqin";
  }

  @Test
  void getUsername() {
    assertEquals(expUsername, testUniqueIdentifier.getUsername());
  }

  @Test
  void getCreationYear() {
    assertEquals(expYear, testUniqueIdentifier.getYear());
  }

  @Test
  void getCountry() {
    assertEquals(expCountry, testUniqueIdentifier.getCountry());
  }

  @Test
  void testEquals_SameObjects() {
    assertTrue(testUniqueIdentifier.equals(testUniqueIdentifier));
  }
  @Test
  void testEquals_NullComparison(){
    assertFalse(testUniqueIdentifier.equals(null));
  }

  @Test
  void testEquals_DifferentDataType(){
    assertFalse(testUniqueIdentifier.equals("String"));
  }

  @Test
  void testEquals_DifferentObjectSameFields(){
    UniqueIdentifier otherUniqueIdentifier = new UniqueIdentifier(expUsername,expYear, expCountry);
    assertTrue(testUniqueIdentifier.equals(otherUniqueIdentifier));
  }
  @Test
  void testEquals_DifferentObjectDifferentUsername(){
    UniqueIdentifier otherUniqueIdentifier = new UniqueIdentifier("xujia",expYear, expCountry);
    assertFalse(testUniqueIdentifier.equals(otherUniqueIdentifier));
  }
  @Test
  void testEquals_DifferentObjectDifferentYear(){
    UniqueIdentifier otherUniqueIdentifier = new UniqueIdentifier(expUsername,2019, expCountry);
    assertFalse(testUniqueIdentifier.equals(otherUniqueIdentifier));
  }
  @Test
  void testEquals_DifferentObjectDifferentCountry(){
    UniqueIdentifier otherUniqueIdentifier = new UniqueIdentifier(expUsername,expYear, "China");
    assertFalse(testUniqueIdentifier.equals(otherUniqueIdentifier));
  }

  @Test
  void testHashCode() {
    int expHashCode = Objects.hash(expUsername, expYear, expCountry);
    assertEquals(expHashCode, testUniqueIdentifier.hashCode());
  }
}
