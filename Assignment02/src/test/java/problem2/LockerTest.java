package problem2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LockerTest {

  private Locker testlocker;
  private MailItem testMailItem;
  private Recipient testRecipient;

  private Integer expWidth;
  private Integer expHeight;
  private Integer expDepth;

  private Integer expMaxWidth;
  private Integer expMaxHeight;
  private Integer expMaxDepth;
  private MailItem expMailItem;
  private Locker testLockerOther;


  @BeforeEach
  void setUp() {
    testlocker = new Locker(10, 20, 8);
    testRecipient = new Recipient("John", "Doe", "john.doe@example.com");
    testMailItem = new MailItem(5, 15, 4, testRecipient);
    expMaxDepth = 8;
    expMaxHeight = 20;
    expMaxWidth = 10;
    expDepth = 8;
    expHeight = 20;
    expWidth = 10;
    expMailItem = new MailItem(expWidth, expHeight, expDepth, testRecipient);
  }

  @Test
  void getMaxWidth() {
    assertEquals(expMaxWidth, testlocker.getMaxWidth());
  }

  @Test
  void getMaxHeight() {
    assertEquals(expMaxHeight, testlocker.getMaxHeight());
  }

  @Test
  void getMaxDepth() {
    assertEquals(expMaxDepth, testlocker.getMaxDepth());
  }

  @Test
  void getStoredMail() {
    assertNull(testlocker.getStoredMail());
  }


  @Test
  void addMail_Success() {
    try {
      testLockerOther = new Locker(10, 20, 8);
      assertNotNull(testLockerOther);
      testLockerOther.addMail(expMailItem);
    } catch (LockerOccupiedException | MailItemTooLargeException e) {
      e.printStackTrace();
      fail("Add Unsuccessful");
    }
    assertEquals(expMailItem, testLockerOther.getStoredMail());
  }

  @Test
  void addMail_LockerOccupiedException() {
    assertThrows(LockerOccupiedException.class, () -> {
      testlocker.addMail(expMailItem);
      testlocker.addMail(expMailItem);
    });
  }

  @Test
  void addMail_MailItemTooLargeWidthException(){
    assertThrows(MailItemTooLargeException.class, () -> {
      testlocker.addMail(new MailItem(15, 20, 8, testRecipient));
    });
  }
  @Test
  void addMail_MailItemTooLargeHeightException(){
    assertThrows(MailItemTooLargeException.class, () -> {
      testlocker.addMail(new MailItem(10, 30, 8, testRecipient));
    });
  }
  @Test
  void addMail_MailItemTooLargeDepthException(){
    assertThrows(MailItemTooLargeException.class, () -> {
      testlocker.addMail(new MailItem(10, 20, 10, testRecipient));
    });
  }

  @Test
  void pickupMail_Success() throws RecipientUnableMatchException, NoMailItemMatchException {
    try {
      testLockerOther = new Locker(10, 20, 8);
      testLockerOther.addMail(expMailItem);
    } catch (LockerOccupiedException | MailItemTooLargeException e) {
      fail("Pick up Unsuccessful");
    }
    assertEquals(expMailItem, testLockerOther.pickupMail(testRecipient));
  }

  @Test
  void pickupMail_RecipientDoesNotMatch() {
    Recipient anotherRecipient = new Recipient("Jane", "Doe", "jane.doe@example.com");

    try {
      testlocker.addMail(expMailItem);
    } catch (LockerOccupiedException | MailItemTooLargeException e) {
      fail("Pick up Unsuccessful");
    }
    assertThrows(RecipientUnableMatchException.class, () -> {
      assertNull(testlocker.pickupMail(anotherRecipient));
    });
  }

  @Test
  void pickupMail_NoMailInLocker() {
    assertThrows(NoMailItemMatchException.class, () -> {
      assertNull(testlocker.pickupMail(testRecipient));
    });
  }
  @Test
  void equals_SameObjects() {
    assertTrue(testlocker.equals(testlocker));
  }

  @Test
  void equals_NullObject() {
    assertFalse(testlocker.equals(null));
  }

  @Test
  void equals_DifferentDataType() {
    assertFalse(testlocker.equals("String"));
  }

  @Test
  void equals_DifferentWidth() {
    Locker otherLocker = new Locker(12, 20, 8);
    assertFalse(testlocker.equals(otherLocker));
  }

  @Test
  void equals_DifferentHeight() {
    Locker otherLocker = new Locker(10, 22, 8);
    assertFalse(testlocker.equals(otherLocker));
  }

  @Test
  void equals_DifferentDepth() {
    Locker otherLocker = new Locker(10, 20, 6);
    assertFalse(testlocker.equals(otherLocker));
  }

  @Test
  void equals_DifferentStoredMail() throws LockerOccupiedException, MailItemTooLargeException {
    Locker otherLocker = new Locker(10, 20, 8);
    otherLocker.addMail(new MailItem(5, 15, 4, testRecipient));
    assertFalse(testlocker.equals(otherLocker));
  }

  @Test
  void equals_SameFields() {
    Locker otherLocker = new Locker(10, 20, 8);
    assertTrue(testlocker.equals(otherLocker));
  }

  @Test
  void hashCode_EqualsObjects() {
    int expHashCode = Objects.hash(expMaxWidth, expMaxHeight, expMaxDepth, null);
    assertEquals(expHashCode, testlocker.hashCode());
  }

  @Test
  void toString_ValidString() {
    String expectedToString = "Locker{" +
        "maxWidth=" + expMaxWidth +
        ", maxHeight=" + expMaxHeight +
        ", maxDepth=" + expMaxDepth +
        ", storedMail=" + null +
        '}';
    assertEquals(expectedToString, testlocker.toString());
  }
}
