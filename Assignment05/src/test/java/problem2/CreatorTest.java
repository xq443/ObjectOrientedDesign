package problem2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CreatorTest {

  private Creator testCreator1;
  private Creator testCreator2;
  @BeforeEach
  void setUp() {
    testCreator1 = new Author("Cathy", "Qin");
    List<RecordingArtist> members = new ArrayList<>();
    members.add(new RecordingArtist("John", "Doe"));
    testCreator2 = new Band("Coldplay", members);
  }

  @Test
  void testEquals_SameObjects_ReturnsTrue() {
    assertTrue(testCreator1.equals(testCreator1));
  }

  @Test
  void testEquals_NullComparison_ReturnsFalse() {
    assertFalse(testCreator1.equals(null));
  }

  @Test
  void testEquals_DifferentDataType_ReturnsFalse() {
    assertFalse(testCreator1.equals("String"));
  }

  @Test
  void testEquals_DifferentObject_ReturnsFalse() {
    assertFalse(testCreator1.equals(testCreator2));
  }

  @Test
  void testHashCode() {
    Creator otherCreator = new Author("Cathy", "Qin");
    assertEquals(otherCreator.hashCode(), testCreator1.hashCode());
  }
}
