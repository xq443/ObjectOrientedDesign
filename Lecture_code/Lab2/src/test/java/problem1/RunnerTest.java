package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RunnerTest {

  Runner testRunner;
  Double expectedBest5KRunTime;
  Double expectedBestHalfMarathonTime;
  String expectedFavoriteEvent;

  @BeforeEach
  void setUp() {
    Name runnersName = new Name("Elaine",  "Thompson",  "Herah");
    testRunner = new Runner(runnersName, 5.6, 123.0, 22.0,
        110.15, "Prefontaine Classic");
    expectedBest5KRunTime = 22.0;
    expectedBestHalfMarathonTime = 110.15;
    expectedFavoriteEvent = "Prefontaine Classic";
  }

  @Test
  void getBest5KRunTime() {
    assertEquals(expectedBest5KRunTime, testRunner.getBest5KRunTime());
  }

  @Test
  void getBestHalfMarathonRunTime() {
    assertEquals(expectedBestHalfMarathonTime, testRunner.getBestHalfMarathonRunTime());
  }

  @Test
  void getFavoriteRunningEvent() {
    assertEquals(expectedFavoriteEvent, testRunner.getFavoriteRunningEvent());
  }

  @Test
  void testEquals_SameObjects() {
    assertTrue(testRunner.equals(testRunner));
  }

  @Test
  void testEquals_NullObject() {
    assertFalse(testRunner.equals(null));
  }

  @Test
  void testEquals_DifferentDataType() {
    assertFalse(testRunner.equals("String"));
  }

  @Test
  void testEquals_DifferentName() {
    Name runnersName = new Name("Jamie",  "Thompson",  "Herah");
    Runner otherRunner = new Runner(runnersName, 5.6, 123.0, 22.0,
        110.15, "Prefontaine Classic");
    assertFalse(testRunner.equals(otherRunner));
  }

  @Test
  void testEquals_DifferentHeight() {
    Name runnersName = new Name("Elaine",  "Thompson",  "Herah");
    Runner otherRunner = new Runner(runnersName, 5.8, 123.0, "RRCA", 22.0,
        110.15, "Prefontaine Classic");
    assertFalse(testRunner.equals(otherRunner));
  }

  @Test
  void testEquals_DifferentWeight() {
    Name runnersName = new Name("Elaine",  "Thompson",  "Herah");
    Runner otherRunner = new Runner(runnersName, 5.6, 113.0, "RRCA", 22.0,
        110.15, "Prefontaine Classic");
    assertFalse(testRunner.equals(otherRunner));
  }

  @Test
  void testEquals_DifferentLeague() {
    Name runnersName = new Name("Elaine",  "Thompson",  "Herah");
    Runner otherRunner = new Runner(runnersName, 5.6, 123.0, "RRCA", 22.0,
        110.15, "Prefontaine Classic");
    assertFalse(testRunner.equals(otherRunner));
  }

  @Test
  void testEquals_Different5KRunTime() {
    Name runnersName = new Name("Elaine",  "Thompson",  "Herah");
    Runner otherRunner = new Runner(runnersName, 5.6, 123.0, 23.0,
        110.15, "Prefontaine Classic");
    assertFalse(testRunner.equals(otherRunner));
  }

  @Test
  void testEquals_DifferentHalfTimeRunTime() {
    Name runnersName = new Name("Elaine",  "Thompson",  "Herah");
    Runner otherRunner = new Runner(runnersName, 5.6, 123.0, 22.0,
        115.15, "Prefontaine Classic");
    assertFalse(testRunner.equals(otherRunner));
  }

  @Test
  void testEquals_DifferentFavoriteEvent() {
    Name runnersName = new Name("Elaine",  "Thompson",  "Herah");
    Runner otherRunner = new Runner(runnersName, 5.6, 123.0, 22.0,
        110.15, "Boston Winter Classic");
    assertFalse(testRunner.equals(otherRunner));
  }

  @Test
  void testEquals_DifferentObjectSameValues() {
    Name runnersName = new Name("Elaine",  "Thompson",  "Herah");
    Runner otherRunner = new Runner(runnersName, 5.6, 123.0, 22.0,
        110.15, "Prefontaine Classic");
    assertTrue(testRunner.equals(otherRunner));
  }


  @Test
  void testHashCode() {
    int hashCode = Objects.hash(Objects.hash(testRunner.athletesName, testRunner.getHeight(),
        testRunner.getWeight(), testRunner.getLeague()), testRunner.getBest5KRunTime(),
        testRunner.getBestHalfMarathonRunTime(),
        testRunner.getFavoriteRunningEvent());
    assertEquals(hashCode, testRunner.hashCode());
  }

  @Test
  void testToString() {
    assertEquals("Runner{}", testRunner.toString());
  }
}