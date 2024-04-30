package problem1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RunnerTest {

  private Runner testRunner;
  private Name expectedName;
  private Double expectedHeight;
  private Double expectedWeight;
  private String expectedLeague;
  private Double expectedBest5kRunTime;
  private Double expectedBestHalfMarathonRunTime;
  private String expectedFavoriteRunningEvent;

  @BeforeEach
  void setUp() {
    expectedName = new Name("John", "Doe","Peterson");
    expectedHeight = 6.0;
    expectedWeight = 160.0;
    expectedLeague = "NTF";
    expectedBest5kRunTime = 20.5;
    expectedBestHalfMarathonRunTime = 120.0;
    expectedFavoriteRunningEvent = "Half Marathon";
    Name testName = new Name("John", "Doe","Peterson");
    testRunner = new Runner(testName, 6.0, 160.0, 20.5,
        120.0, "Half Marathon");
  }

  @Test
  void getBestHalfMarathonRunTime() {
    assertEquals(expectedBestHalfMarathonRunTime, testRunner.getBestHalfMarathonRunTime());
  }

  @Test
  void getFavoriteRunningEvent() {
    assertEquals(expectedFavoriteRunningEvent, testRunner.getFavoriteRunningEvent());
  }

  @Test
  void getBest5kRunTime() {

    assertEquals(expectedBest5kRunTime, testRunner.getBest5kRunTime());
  }

  @Test
  void testEquals_SameObjects() {

    assertTrue(testRunner.equals(testRunner));
  }
  @Test
  void testEquals_NullComparison(){
    assertFalse(testRunner.equals(null));
  }

  @Test
  void testEquals_DifferentDataType(){
    assertFalse(testRunner.equals("Runner"));
  }

  @Test
  void testEquals_DifferentObjectDifferentName(){
    Name otherName = new Name("Cathy", "Xujia", "Qin");
    Runner otherRunner = new Runner(otherName, 6.0, 160.0, "NTF",20.5,
        120.0, "Half Marathon");
    assertFalse(testRunner.equals(otherRunner));
  }

  @Test
  void testEquals_DifferentObjectDifferentHeight(){
    Runner otherRunner = new Runner(expectedName, 6.5, 160.0, 20.5,
        120.0, "Half Marathon");
    assertFalse(testRunner.equals(otherRunner));
  }
  @Test
  void testEquals_DifferentObjectDifferentWeight(){
    Runner otherRunner = new Runner(expectedName, 6.0, 165.0, 20.5,
        120.0, "Half Marathon");
    assertFalse(testRunner.equals(otherRunner));
  }
  @Test
  void testEquals_DifferentObjectDifferentBest5kRunTime(){
    Runner otherRunner = new Runner(expectedName, 6.0, 160.0, 22.5,
        120.0, "Half Marathon");
    assertFalse(testRunner.equals(otherRunner));
  }
  @Test
  void testEquals_DifferentObjectDifferentBestHalfMarathonRunTime(){
    Runner otherRunner = new Runner(expectedName, 6.0, 160.0, 20.5,
        125.0, "Half Marathon");
    assertFalse(testRunner.equals(otherRunner));
  }
  @Test
  void testEquals_DifferentObjectDifferentFavoriteRunningEvent(){
    Runner otherRunner = new Runner(expectedName, 6.0, 160.0, 20.5,
        120.0, "5K");
    assertFalse(testRunner.equals(otherRunner));
  }
  @Test
  void testEquals_DifferentObjectSameFields(){
    Runner otherRunner = new Runner(expectedName, 6.0, 160.0, 20.5,
        120.0, "Half Marathon");
    assertTrue(testRunner.equals(otherRunner));
  }

  @Test
  void testHashCode() {
    Runner sameRunner = new Runner(expectedName, expectedHeight, expectedWeight,
        expectedBest5kRunTime, expectedBestHalfMarathonRunTime, expectedFavoriteRunningEvent);

    // Ensure that equal objects produce the same hash code
    assertEquals(sameRunner.hashCode(), testRunner.hashCode());
}

  @Test
  void testToString() {
    String expectedStr = "Runner{" +
        "best5kRunTime=" + expectedBest5kRunTime +
        ", bestHalfMarathonRunTime=" + expectedBestHalfMarathonRunTime +
        ", favoriteRunningEvent='" + expectedFavoriteRunningEvent + '\'' +
        '}';
    assertEquals(expectedStr, testRunner.toString());
  }
}