package problem2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MailItemTest {

  private MailItem testMailItem;
  private Recipient testRecipient;
  private Integer expWidth = 5;
  private Integer expHeight = 6;
  private Integer expDepth = 3;
  private Recipient expRecipient;


  @BeforeEach
  void setUp() {
    testRecipient = new Recipient("John", "Doe", "john.doe@example.com");
    testMailItem = new MailItem(5, 6, 3, testRecipient);
    expRecipient = new Recipient("John", "Doe", "john.doe@example.com");
  }

  @Test
  void getWidth() {
    assertEquals(expWidth, testMailItem.getWidth());
  }

  @Test
  void getHeight() {
    assertEquals(expHeight, testMailItem.getHeight());
  }

  @Test
  void getDepth() {
    assertEquals(expDepth, testMailItem.getDepth());
  }

  @Test
  void getRecipient() {
    assertEquals(expRecipient, testMailItem.getRecipient());
  }

  @Test
  void testEquals_SameObjects() {
    assertTrue(testMailItem.equals(testMailItem));
  }

  @Test
  void testEquals_NullObject() {
    assertFalse(testMailItem.equals(null));
  }

  @Test
  void testEquals_DifferentDataType() {
    assertFalse(testMailItem.equals("String"));
  }

  @Test
  void testEquals_DifferentWidth() {
    MailItem otherMailItem = new MailItem(8, 6, 3, testRecipient);
    assertFalse(testMailItem.equals(otherMailItem));
  }

  @Test
  void testEquals_DifferentHeight() {
    MailItem otherMailItem = new MailItem(5, 7, 3, testRecipient);
    assertFalse(testMailItem.equals(otherMailItem));
  }

  @Test
  void testEquals_DifferentDepth() {
    MailItem otherMailItem = new MailItem(5, 6, 4, testRecipient);
    assertFalse(testMailItem.equals(otherMailItem));
  }

  @Test
  void testEquals_DifferentRecipient() {
    Recipient otherRecipient = new Recipient("Jane", "Doe", "jane.doe@example.com");
    MailItem otherMailItem = new MailItem(5, 6, 3, otherRecipient);
    assertFalse(testMailItem.equals(otherMailItem));
  }

  @Test
  void testEquals_SameFields() {
    MailItem otherMailItem = new MailItem(5, 6, 3, testRecipient);
    assertTrue(testMailItem.equals(otherMailItem));
  }

  @Test
  void testHashCode() {
    int expHashCode = Objects.hash(expWidth, expHeight, expDepth, expRecipient);
    assertEquals(expHashCode, testMailItem.hashCode());
  }

  @Test
  void testToString() {
    String expectedToString = "MailItem{" +
        "width=" + expWidth +
        ", height=" + expHeight +
        ", depth=" + expDepth +
        ", recipient=" + expRecipient +
        '}';
    assertEquals(expectedToString, testMailItem.toString());
  }
}
