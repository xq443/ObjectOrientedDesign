package problem2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ItemTest {

  private Item testItem;
  private Creator testCreator;
  private String expectedTitle;
  private Integer expectedYear;

  @BeforeEach
  void setUp(){
    testCreator = new Author("Cathy", "QIN");
    expectedTitle = "Title";
    expectedYear = 2022;
    testItem = new Book((Author) testCreator, expectedTitle, expectedYear);
  }
  @Test
  void test_getCreator() {
    assertEquals(testCreator, testItem.getCreator());
  }
}
