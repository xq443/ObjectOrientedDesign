package problem2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RecordingArtistTest {
  private RecordingArtist artist1;

  @BeforeEach
  void setUp() {
    artist1 = new RecordingArtist("Cathy", "Qin");
  }

  @Test
  void testConstructorAndGetters() {
    assertEquals("Cathy", artist1.getFirstName());
    assertEquals("Qin", artist1.getLastName());

  }

  @Test
  void testEquals_SameObjects() {
    assertEquals(artist1, artist1);
  }

  @Test
  void testEquals_NullComparison() {
    assertNotEquals(artist1, null);
  }

  @Test
  void testEquals_DifferentDataType() {
    assertNotEquals(artist1, "String");
  }

  @Test
  void testEquals_DifferentObjectDifferentFirstName() {
    RecordingArtist otherArtist = new RecordingArtist("Cmathy", "Qin");
    assertNotEquals(artist1, otherArtist);
  }

  @Test
  void testEquals_DifferentObjectDifferentLastName() {
    RecordingArtist otherArtist = new RecordingArtist("Cathy", "Qinn");
    assertNotEquals(artist1, otherArtist);
  }

  @Test
  void testEquals_DifferentObjectSameValues() {
    RecordingArtist otherArtist = new RecordingArtist("Cathy", "Qin");
    assertEquals(artist1, otherArtist);
  }

  @Test
  void testHashCode() {
    RecordingArtist otherArtist = new RecordingArtist("Cathy", "Qin");
    assertEquals(artist1.hashCode(), otherArtist.hashCode());
  }

  @Test
  void testToString() {
    String expStr = "IndividualCreator{" +
        "firstName='" + artist1.getFirstName() + '\'' +
        ", lastName='" + artist1.getLastName() + '\'' +
        '}';
    assertEquals(expStr, artist1.toString());
  }
}
