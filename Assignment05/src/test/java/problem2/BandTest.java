package problem2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BandTest {
  private Band band1;
  private Band band2;

  @BeforeEach
  void setUp() {
    List<RecordingArtist> members1 = new ArrayList<>();
    members1.add(new RecordingArtist("John", "Doe"));
    members1.add(new RecordingArtist("Jane", "Smith"));

    List<RecordingArtist> members2 = new ArrayList<>();
    members2.add(new RecordingArtist("Alice", "Jones"));
    members2.add(new RecordingArtist("Bob", "Brown"));

    band1 = new Band( "The Beatles", members1);
    band2 = new Band("Queen", members2);
  }

  @Test
  void testConstructorAndGetters() {
    assertEquals("The Beatles", band1.getName());
    assertEquals("Queen", band2.getName());
    assertEquals(2, band1.getMembers().size());
    assertEquals(2, band2.getMembers().size());
  }

  @Test
  void testEquals_SameObjects() {
    assertEquals(band1, band1);
  }

  @Test
  void testEquals_NullComparison() {
    assertNotEquals(band1, null);
  }

  @Test
  void testEquals_DifferentDataType() {
    assertNotEquals(band1, "String");
  }

  @Test
  void testEquals_DifferentObjectDifferentName() {
    Band otherBand = new Band("The Rolling Stones", new ArrayList<>());
    assertNotEquals(band1, otherBand);
  }

  @Test
  void testEquals_DifferentObjectDifferentMembers() {
    List<RecordingArtist> members = new ArrayList<>();
    members.add(new RecordingArtist("John", "Doe"));
    Band otherBand = new Band("The Beatles", members);
    assertNotEquals(band1, otherBand);
  }

  @Test
  void testEquals_DifferentObjectSameValues() {
    Band sameBand = new Band("The Beatles", new ArrayList<>(band1.getMembers()));
    assertEquals(band1, sameBand);
  }

  @Test
  void testHashCode() {
    Band sameBand = new Band("The Beatles", new ArrayList<>(band1.getMembers()));
    assertEquals(band1.hashCode(), sameBand.hashCode());
  }

  @Test
  void testToString() {
    String expStr =  "Band{" +
        "name='" + band1.getName() + '\'' +
        ", members=" + band1.getMembers() +
        '}';
    assertEquals(expStr, band1.toString());
  }
}
