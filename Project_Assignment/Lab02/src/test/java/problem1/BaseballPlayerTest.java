package problem1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BaseballPlayerTest {

  private BaseballPlayer testPlayer;
  private Name expectedName;
  private Double expectedHeight;
  private Double expectedWeight;
  private String expectedLeague;
  private String expectedTeam;
  private Double expectedAvgBatting;
  private Integer expectedSeasonHomeRuns;

  @BeforeEach
  void setUp() {
    expectedName = new Name("John", "Doe", "Peterson");
    expectedHeight = 6.0;
    expectedWeight = 160.0;
    expectedLeague = "NTF";
    expectedTeam = "Baseball Team";
    expectedAvgBatting = 0.300;
    expectedSeasonHomeRuns = 25;
    Name testName = new Name("John", "Doe", "Peterson");
    testPlayer = new BaseballPlayer(testName, 6.0, 160.0, "NTF", "Baseball Team",
        0.300, 25);
  }

  @Test
  void getTeam() {
    assertEquals(expectedTeam, testPlayer.getTeam());
  }

  @Test
  void getAvgBatting() {
    assertEquals(expectedAvgBatting, testPlayer.getAvgBatting());
  }

  @Test
  void getSeasonHomeRuns() {
    assertEquals(expectedSeasonHomeRuns, testPlayer.getSeasonHomeRuns());
  }

  @Test
  void testEquals_SameObjects() {
    assertTrue(testPlayer.equals(testPlayer));
  }

  @Test
  void testEquals_NullComparison() {
    assertFalse(testPlayer.equals(null));
  }

  @Test
  void testEquals_DifferentDataType() {
    assertFalse(testPlayer.equals("BaseballPlayer"));
  }

  @Test
  void testEquals_DifferentObjectDifferentName() {
    Name otherName = new Name("Cathy", "Xujia", "Qin");
    BaseballPlayer otherPlayer = new BaseballPlayer(otherName, 6.0, 160.0, "NTF", "Other Team", 0.320, 30);
    assertFalse(testPlayer.equals(otherPlayer));
  }

  @Test
  void testEquals_DifferentObjectDifferentHeight() {
    BaseballPlayer otherPlayer = new BaseballPlayer(expectedName, 6.5, 160.0, expectedTeam, 0.300, 25);
    assertFalse(testPlayer.equals(otherPlayer));
  }

  @Test
  void testEquals_DifferentObjectDifferentWeight() {
    BaseballPlayer otherPlayer = new BaseballPlayer(expectedName, 6.0, 165.0, "NTF", expectedTeam, 0.300, 25);
    assertFalse(testPlayer.equals(otherPlayer));
  }
  @Test
  void testEquals_DifferentObjectDifferentTeam() {
    BaseballPlayer otherPlayer = new BaseballPlayer(expectedName, 6.0, 160.0, "NTF", "Chief", 0.300, 25);
    assertFalse(testPlayer.equals(otherPlayer));
  }

  @Test
  void testEquals_DifferentObjectDifferentAvgBatting() {
    BaseballPlayer otherPlayer = new BaseballPlayer(expectedName, 6.0, 160.0, "NTF", expectedTeam, 0.310, 25);
    assertFalse(testPlayer.equals(otherPlayer));
  }

  @Test
  void testEquals_DifferentObjectDifferentSeasonHomeRuns() {
    BaseballPlayer otherPlayer = new BaseballPlayer(expectedName, 6.0, 160.0, "NTF", expectedTeam, 0.300, 30);
    assertFalse(testPlayer.equals(otherPlayer));
  }

  @Test
  void testEquals_DifferentObjectSameFields() {
    BaseballPlayer otherPlayer = new BaseballPlayer(expectedName, 6.0, 160.0, "NTF", expectedTeam, 0.300, 25);
    assertTrue(testPlayer.equals(otherPlayer));
  }

  @Test
  void testHashCode() {
//    BaseballPlayer samePlayer = new BaseballPlayer(expectedName, expectedHeight, expectedWeight, expectedLeague,
//        expectedTeam, expectedAvgBatting, expectedSeasonHomeRuns);

    BaseballPlayer samePlayer = new BaseballPlayer(testPlayer.getAthletesName(), testPlayer.getHeight(), testPlayer.getWeight(), testPlayer.getLeague(),
        testPlayer.getTeam(), testPlayer.getAvgBatting(), testPlayer.getSeasonHomeRuns());

    // Ensure that equal objects produce the same hash code
    assertEquals(samePlayer.hashCode(), testPlayer.hashCode());
  }

  @Test
  void testToString() {
    String expectedStr = "BaseballPlayer{" +
        "team='" + expectedTeam + '\'' +
        ", avgBatting=" + expectedAvgBatting +
        ", seasonHomeRuns=" + expectedSeasonHomeRuns +
        '}';
    assertEquals(expectedStr, testPlayer.toString());
  }
}
