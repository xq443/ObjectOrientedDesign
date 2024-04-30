package problem2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookTest {

  private Book testBook;
  private Author testAuthor;
  private String expectedTitle;
  private Integer expectedYear;

  @BeforeEach
  void setUp() {
    testAuthor = new Author("John", "Doe");
    expectedTitle = "Test Book";
    expectedYear = 2022;
    testBook = new Book(testAuthor, expectedTitle, expectedYear);
  }

  @Test
  void getTitle() {
    assertEquals(expectedTitle, testBook.getTitle());
  }

  @Test
  void getYear() {
    assertEquals(expectedYear, testBook.getYear());
  }

  @Test
  void getAuthor() {
    assertEquals(testAuthor, testBook.getCreator());
  }

  @Test
  void testEquals_SameObjects() {
    assertEquals(testBook, testBook);
  }

  @Test
  void testEquals_NullComparison() {
    assertFalse(testBook.equals(null));
  }

  @Test
  void testEquals_DifferentDataType() {
    assertFalse(testBook.equals(10000));
  }
  @Test
  void testEquals_DifferentAuthor() {
    Author differentAuthor = new Author("Jane", "Smith");
    Book otherBook = new Book(differentAuthor, expectedTitle, expectedYear);
    assertFalse(testBook.equals(otherBook));
  }

  @Test
  void testEquals_DifferentTitle() {
    Book otherBook = new Book(testAuthor, "Three Unions", expectedYear);
    assertFalse(testBook.equals(otherBook));
  }

  @Test
  void testEquals_DifferentYear() {
    Book otherBook = new Book(testAuthor, expectedTitle, 2223);
    assertFalse(testBook.equals(otherBook));
  }

  @Test
  void testEquals_DifferentObjectSameValues() {
    Book otherBook = new Book(testAuthor, expectedTitle, expectedYear);
    assertTrue(testBook.equals(otherBook));
  }

  @Test
  void testHashCode() {
    Book otherBook = new Book(testAuthor, expectedTitle, expectedYear);
    assertEquals(otherBook.hashCode(), testBook.hashCode());
  }

  @Test
  void testToString() {
    String expectedStr = "Item{" +
        "creator=" + testAuthor +
        ", title='" + expectedTitle + '\'' +
        ", year=" + expectedYear +
        '}';
    assertEquals(expectedStr, testBook.toString());
  }
  @Test
  void testEquals_DifferentClass() {
    Object differentObject = new Object();
    assertFalse(testBook.equals(differentObject)); // Should return false
  }

  @Test
  void testEquals_NullCreator() {
    // Create a book with null creator
    Book nullCreatorBook = new Book(null, expectedTitle, expectedYear);
    assertFalse(testBook.equals(nullCreatorBook)); // Should return false
  }

  @Test
  void testEquals_NullTitle() {
    // Create a book with null title
    Book nullTitleBook = new Book(testAuthor, null, expectedYear);
    assertFalse(testBook.equals(nullTitleBook)); // Should return false
  }

  @Test
  void testEquals_NullYear() {
    // Create a book with null year
    Book nullYearBook = new Book(testAuthor, expectedTitle, null);
    assertFalse(testBook.equals(nullYearBook)); // Should return false
  }

}