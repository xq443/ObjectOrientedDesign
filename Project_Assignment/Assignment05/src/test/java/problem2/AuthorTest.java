package problem2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AuthorTest {
  private Author author1;

  @BeforeEach
  void setUp() {

    author1 = new Author("Cathy", "Qin");
  }

  @Test
  void testConstructorAndGetters() {
    assertEquals("Cathy", author1.getFirstName());
    assertEquals("Qin", author1.getLastName());
  }

  @Test
  void testEquals_SameObjects() {
    assertEquals(author1, author1);
  }

  @Test
  void testEquals_NullComparison() {
    assertNotEquals(author1, null);
  }

  @Test
  void testEquals_DifferentDataType() {
    assertNotEquals(author1, "String");
  }

  @Test
  void testEquals_DifferentObjectDifferentFirstName() {
    Author otherAuthor = new Author("John", "Qin");
    assertNotEquals(author1, otherAuthor);
  }

  @Test
  void testEquals_DifferentObjectDifferentLastName() {
    Author otherAuthor = new Author("Cathy", "Doe");
    assertNotEquals(author1, otherAuthor);
  }

  @Test
  void testEquals_DifferentObjectSameValues() {
    Author otherAuthor = new Author("Cathy", "Qin");
    assertEquals(author1, otherAuthor);
  }

  @Test
  void testHashCode() {
    Author sameAuthor = new Author("Cathy", "Qin");
    assertEquals(author1.hashCode(), sameAuthor.hashCode());
  }

  @Test
  void testToString() {
    String expStr = "IndividualCreator{" +
        "firstName='" + author1.getFirstName() + '\'' +
        ", lastName='" + author1.getLastName() + '\'' +
        '}';
    assertEquals(expStr, author1.toString());
  }
}
