package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AthleteTest {

  private Athlete testAthlete;
  private Name expectedName;
  private Double expectedHeight;
  private Double expectedWeight;
  private String expectedLeague;

  @BeforeEach
  void setUp() {
    Name athletesName = new Name("Jason", "Max", "Parker");
    testAthlete = new Athlete(athletesName, 6.2, 185.0, "NHL");
    expectedName = new Name("Jason", "Max", "Parker");
    expectedHeight = 6.2;
    expectedWeight = 185.0;
    expectedLeague = "NHL";
  }

  @Test
  void getAthletesName() {
    assertEquals(expectedName, testAthlete.getAthletesName());
  }

  @Test
  void getHeight() {
    assertEquals(expectedHeight, testAthlete.getHeight(), 0.01);
  }

  @Test
  void getWeight() {
    assertEquals(expectedWeight, testAthlete.getWeight(), 0.01);
  }

  @Test
  void getLeague() {
    assertEquals(expectedLeague, testAthlete.getLeague());
  }

  @Test
  void testEquals_SameObjects() {
    assertTrue(testAthlete.equals(testAthlete));
  }

  @Test
  void tesEquals_NullObject() {
    assertFalse(testAthlete.equals(null));
  }

  @Test
  void tesEquals_DifferentDataType() {
    assertFalse(testAthlete.equals("Athlete"));
  }

  @Test
  void tesEquals_DifferentObjectDifferentName() {
    Name otherName = new Name("Sarah", "Chloe", "Peterson");
    Athlete otherAthlete = new Athlete(otherName, 6.2, 185.0, "NHL");
    assertFalse(testAthlete.equals(otherAthlete));
  }

  @Test
  void tesEquals_DifferentObjectDifferentHeight() {
    Athlete otherAthlete = new Athlete(expectedName, 5.8, 185.0, "NHL");
    assertFalse(testAthlete.equals(otherAthlete));
  }

  @Test
  void tesEquals_DifferentObjectDifferentWeight() {
    Athlete otherAthlete = new Athlete(expectedName, 6.2, 145.0, "NHL");
    assertFalse(testAthlete.equals(otherAthlete));
  }

  @Test
  void tesEquals_DifferentObjectDifferentLeague() {
    Athlete otherAthlete = new Athlete(expectedName, 6.2, 185.0);
    assertFalse(testAthlete.equals(otherAthlete));
  }

  @Test
  void tesEquals_DifferentObjectSameFields() {
    Athlete otherAthlete = new Athlete(expectedName, 6.2, 185.0, "NHL");
    assertTrue(testAthlete.equals(otherAthlete));
  }

  @Test
  void testHashCode() {
    int expectedHashCode = Objects.hash(testAthlete.getAthletesName(), testAthlete.getHeight(),
        testAthlete.getWeight(), testAthlete.getLeague());
    assertEquals(expectedHashCode, testAthlete.hashCode());
  }

  @Test
  void testToString() {
    String expectedString =  "Athlete{" +
        "athletesName=" + testAthlete.getAthletesName() +
        ", height=" + testAthlete.getHeight() +
        ", weight=" + testAthlete.getWeight() +
        ", league='" + testAthlete.getLeague() + '\'' +
        '}';
    assertEquals(expectedString, testAthlete.toString());

  }
}