package problem2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RecipientTest {

  private Recipient testRecipient;
  private String expFirstName;
  private String expLastName;
  private String expEmailAddress;

  @BeforeEach
  void setUp() {
    testRecipient = new Recipient("John", "Geter", "john.doe@gmail.com");
    expFirstName = "John";
    expLastName = "Geter";
    expEmailAddress = "john.doe@gmail.com";
  }

  @Test
  void getFirstName() {
    assertEquals("John", testRecipient.getFirstName());
  }

  @Test
  void getLastName() {
    assertEquals("Geter", testRecipient.getLastName());
  }

  @Test
  void getEmailAddress() {
    assertEquals("john.doe@gmail.com", testRecipient.getEmailAddress());
  }

  @Test
  void testEquals_SameObjects() {
    assertTrue(testRecipient.equals(testRecipient));
  }

  @Test
  void testEquals_NullObject() {
    assertFalse(testRecipient.equals(null));
  }

  @Test
  void testEquals_DifferentDataType() {
    assertFalse(testRecipient.equals("String"));
  }

  @Test
  void testEquals_DifferentFirstName() {
    Recipient otherRecipient = new Recipient("Jane", "Geter", "john.doe@gmail.com");
    assertFalse(testRecipient.equals(otherRecipient));
  }

  @Test
  void testEquals_DifferentLastName() {
    Recipient otherRecipient = new Recipient("John", "Smith", "john.doe@gmail.com");
    assertFalse(testRecipient.equals(otherRecipient));
  }

  @Test
  void testEquals_DifferentEmailAddress() {
    Recipient otherRecipient = new Recipient("John", "Geter", "john.geter@gmail.com");
    assertFalse(testRecipient.equals(otherRecipient));
  }

  @Test
  void testEquals_SameFields() {
    Recipient otherRecipient = new Recipient("John", "Geter", "john.doe@gmail.com");
    assertTrue(testRecipient.equals(otherRecipient));
  }

  @Test
  void testHashCode() {
    int expHashCode = Objects.hash(expFirstName,expLastName, expEmailAddress);
    assertEquals(expHashCode, testRecipient.hashCode());
  }

  @Test
  void testToString() {
    String expectedToString = "Recipient{" +
        "firstName='" + expFirstName + '\'' +
        ", lastName='" + expLastName + '\'' +
        ", emailAddress='" + expEmailAddress + '\'' +
        '}';
    assertEquals(expectedToString, testRecipient.toString());
  }
}
