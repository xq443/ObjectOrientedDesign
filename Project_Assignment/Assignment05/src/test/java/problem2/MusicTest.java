package problem2;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MusicTest {

  private Music testMusic;
  private RecordingArtist testCreator;
  private String expectedTitle;
  private int expectedYear;

  @BeforeEach
  void setUp() {
    testCreator = new RecordingArtist("Vivian", "Wang");
    expectedTitle = "Music";
    expectedYear = 2022;
    testMusic = new Music(testCreator, expectedTitle, expectedYear);
  }
  @Test
  void testValidCreatorRecordingArtist() {
    assertDoesNotThrow(() -> {
      new Music(testCreator, expectedTitle, expectedYear);
    });
  }
  @Test
  void testValidCreatorBand() {
    List<RecordingArtist> members = new ArrayList<>();
    members.add(new RecordingArtist( "John", "Doe"));
    assertDoesNotThrow(() -> {
      Band band = new Band("Chris", members);
      new Music(band, expectedTitle, expectedYear);
    });
  }

  @Test
  void testGetCreator() {
    assertEquals(testCreator, testMusic.getCreator());
  }

  @Test
  void testEquals_SameObjects() {
    assertEquals(testMusic, testMusic);
  }

  @Test
  void testEquals_DifferentDataType() {
    assertEquals(false, testMusic.equals("String"));
  }

  @Test
  void testEquals_DifferentCreator() {
    Music otherMusic = new Music(new RecordingArtist("Jane", "Smith"), expectedTitle, expectedYear);
    assertEquals(false, testMusic.equals(otherMusic));
  }
  @Test
  void testEquals_DifferentTitle() {
    Music otherMusic = new Music(testCreator, "Grammy", expectedYear);
    assertEquals(false, testMusic.equals(otherMusic));
  }
  @Test
  void testEquals_DifferentYear()  {
    Music otherMusic = new Music(testCreator, expectedTitle, 2024);
    assertEquals(false, testMusic.equals(otherMusic));
  }

  @Test
  void testEquals_DifferentObjectSameValues() {
    Music otherMusic = new Music(testCreator, expectedTitle, expectedYear);
    assertEquals(true, testMusic.equals(otherMusic));
  }

  @Test
  void testHashCode()  {
    int expHashCode = Objects.hash(testCreator, expectedTitle, expectedYear);
    assertEquals(expHashCode, testMusic.hashCode());
  }
}
