package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BaseballPlayerTest {

  BaseballPlayer testBaseballPlayer;
  Double expectedBattingScore;
  Integer expectedHomeRuns;

  String expectedTeam;

  @BeforeEach
  void setUp() {
    Name playersName = new Name("John", "Mark", "Adams");
    testBaseballPlayer = new BaseballPlayer(playersName, 6.0, 175.0, "Seattle Mariners",
        145.2, 3);
    expectedTeam = "Seattle Mariners";
    expectedBattingScore = 145.2;
    expectedHomeRuns = 3;

  }

  @Test
  void getTeam() {
    assertEquals(expectedTeam, testBaseballPlayer.getTeam());
  }

  @Test
  void getAvgBattingScore() {
    assertEquals(expectedBattingScore, testBaseballPlayer.getAvgBattingScore());
  }

  @Test
  void getSeasonHomeRuns() {
    assertEquals(expectedHomeRuns, testBaseballPlayer.getSeasonHomeRuns());
  }

  @Test
  void testEquals_SameObjects() {
    assertTrue(testBaseballPlayer.equals(testBaseballPlayer));
  }

  @Test
  void testEquals_NullObjects() {
    assertFalse(testBaseballPlayer.equals(null));
  }

  @Test
  void testEquals_DifferentDataType() {
    assertFalse(testBaseballPlayer.equals("String"));
  }

  @Test
  void testEquals_DifferentName() {
    Name playersName = new Name("Taylor", "Mark", "Adams");
    BaseballPlayer otherPlayer = new BaseballPlayer(playersName, 6.0, 175.0, "MLB", "Seattle Mariners",
        145.2, 3);
    assertFalse(testBaseballPlayer.equals(otherPlayer));
  }

  @Test
  void testEquals_DifferentHeight() {
    Name playersName = new Name("John", "Mark", "Adams");
    BaseballPlayer otherPlayer = new BaseballPlayer(playersName, 6.2, 175.0, "Seattle Mariners",
        145.2, 3);
    assertFalse(testBaseballPlayer.equals(otherPlayer));
  }

  @Test
  void testEquals_DifferentWeight() {
    Name playersName = new Name("John", "Mark", "Adams");
    BaseballPlayer otherPlayer = new BaseballPlayer(playersName, 6.0, 185.0, "Seattle Mariners",
        145.2, 3);
    assertFalse(testBaseballPlayer.equals(otherPlayer));
  }

  @Test
  void testEquals_DifferentLeague() {
    Name playersName = new Name("John", "Mark", "Adams");
    BaseballPlayer otherPlayer = new BaseballPlayer(playersName, 6.0, 175.0, "MLB", "Seattle Mariners",
        145.2, 3);
    assertFalse(testBaseballPlayer.equals(otherPlayer));
  }

  @Test
  void testEquals_DifferentBattingScore() {
    Name playersName = new Name("John", "Mark", "Adams");
    BaseballPlayer otherPlayer = new BaseballPlayer(playersName, 6.0, 175.0, "Seattle Mariners",
        105.2, 3);
    assertFalse(testBaseballPlayer.equals(otherPlayer));
  }

  @Test
  void testEquals_DifferentHomeRuns() {
    Name playersName = new Name("John", "Mark", "Adams");
    BaseballPlayer otherPlayer = new BaseballPlayer(playersName, 6.0, 175.0, "Seattle Mariners",
        145.2, 12);
    assertFalse(testBaseballPlayer.equals(otherPlayer));
  }

  @Test
  void testEquals_DifferentTeam() {
    Name playersName = new Name("John", "Mark", "Adams");
    BaseballPlayer otherPlayer = new BaseballPlayer(playersName, 6.0, 175.0, "Boston Red Sox",
        145.2, 3);
    assertFalse(testBaseballPlayer.equals(otherPlayer));
  }

  @Test
  void testEquals_DifferentObjectsSameValues() {
    Name playersName = new Name("John", "Mark", "Adams");
    BaseballPlayer otherPlayer = new BaseballPlayer(playersName, 6.0, 175.0, "Seattle Mariners",
        145.2, 3);
    assertTrue(testBaseballPlayer.equals(otherPlayer));
  }

  @Test
  void testHashCode() {
    int hashCode = Objects.hash(Objects.hash(testBaseballPlayer.getAthletesName(),
        testBaseballPlayer.getHeight(), testBaseballPlayer.getWeight(), testBaseballPlayer.getLeague()),
        testBaseballPlayer.getTeam(), testBaseballPlayer.getAvgBattingScore(),
        testBaseballPlayer.getSeasonHomeRuns());
    assertEquals(hashCode, testBaseballPlayer.hashCode());
  }

  @Test
  void testToString() {
    assertEquals("BaseballPlayer{}", testBaseballPlayer.toString());
  }
}