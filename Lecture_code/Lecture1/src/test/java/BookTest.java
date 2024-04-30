import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookTest {

  private Book testBook;
  private Person testAuthor;
  private Person expectedAuthor;
  private String expectedTitle;
  private Double expectedPrice;

  @BeforeEach
  void setUp() {
    testAuthor = new Person("George", "Martin", 1948);
    testBook = new Book("Fire & Blood", testAuthor, 25.00);
    expectedAuthor = new Person("George", "Martin", 1948);;
    expectedTitle = "Fire & Blood";
    expectedPrice = 25.00;
  }

  @Test
  void getTitle() {
    assertEquals(expectedTitle, testBook.getTitle());
  }

  @Test
  void getPrice() {
    assertEquals(expectedPrice, testBook.getPrice());
  }

  @Test
  void getAuthor() {
    assertEquals(expectedAuthor, testBook.getAuthor());
  }
}