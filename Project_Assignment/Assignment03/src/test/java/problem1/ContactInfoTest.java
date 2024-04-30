package problem1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactInfoTest {

  private ContactInfo testContactInfo;
  private Name testName;
  private String expectedAddress;
  private String expectedPhoneNumber;
  private Name expectedEmergencyContact;

  @BeforeEach
  void setUp() {
    testName = new Name("Jillian", "Martin");
    expectedAddress = "123 Main St";
    expectedPhoneNumber = "555-1234";
    expectedEmergencyContact = new Name("John", "Smith");

    testContactInfo = new ContactInfo(testName, expectedAddress, expectedPhoneNumber, expectedEmergencyContact);
  }

  @Test
  void getName() {
    assertEquals(testName, testContactInfo.getName());
  }

  @Test
  void getAddress() {
    assertEquals(expectedAddress, testContactInfo.getAddress());
  }

  @Test
  void getPhoneNumber() {
    assertEquals(expectedPhoneNumber, testContactInfo.getPhoneNumber());
  }

  @Test
  void getEmergencyContact() {
    assertEquals(expectedEmergencyContact, testContactInfo.getEmergencyContact());
  }

  @Test
  void testEquals_SameObjects() {
    assertEquals(testContactInfo, testContactInfo);
  }

  @Test
  void testEquals_NullComparison() {
    assertFalse(testContactInfo.equals(null));
  }

  @Test
  void testEquals_DifferentDataType() {
    assertFalse(testContactInfo.equals("String"));
  }

  @Test
  void testEquals_DifferentObject() {
    ContactInfo otherContactInfo = new ContactInfo(new Name("Cathy", "Martin"),
        "456 Oak St", "555-5678", new Name("Jane", "Smith"));

    assertFalse(testContactInfo.equals(otherContactInfo));
  }
  @Test
  void testEquals_DifferentName() {
    ContactInfo otherContactInfo = new ContactInfo(new Name("Cathy", "Qin"),
        "123 Main St", "555-1234", new Name("John", "Smith"));

    assertFalse(testContactInfo.equals(otherContactInfo));
  }

  @Test
  void testEquals_DifferentAddress() {
    ContactInfo otherContactInfo = new ContactInfo(new Name("Jillian", "Martin"),
        "456 Oak St", "555-1234", new Name("John", "Smith"));

    assertFalse(testContactInfo.equals(otherContactInfo));
  }

  @Test
  void testEquals_DifferentPhoneNum() {
    ContactInfo otherContactInfo = new ContactInfo(new Name("Jillian", "Martin"),
        "123 Main St", "555-5678", new Name("John", "Smith"));

    assertFalse(testContactInfo.equals(otherContactInfo));
  }

  @Test
  void testEquals_DifferentEmergencyContact() {
    ContactInfo otherContactInfo = new ContactInfo(new Name("Jillian", "Martin"),
        "123 Main St", "555-1234", new Name("Jane", "Doe"));

    assertFalse(testContactInfo.equals(otherContactInfo));
  }
  @Test
  void testEquals_DifferentObjectSameFields() {
    ContactInfo otherContactInfo = new ContactInfo(new Name("Jillian", "Martin"),
        "123 Main St", "555-1234", new Name("John", "Smith"));

    assertTrue(testContactInfo.equals(otherContactInfo));
  }

  @Test
  void testHashCode() {
    int expectedHashCode = Objects.hash(testName, expectedAddress, expectedPhoneNumber,expectedEmergencyContact);
    assertEquals(expectedHashCode, testContactInfo.hashCode());
  }

  @Test
  void testToString() {
    String expectedStr = "ContactInfo{" +
        "name=" + testName +
        ", address='" + expectedAddress + '\'' +
        ", phoneNumber='" + expectedPhoneNumber + '\'' +
        ", emergencyContact=" + expectedEmergencyContact +
        '}';
    assertEquals(expectedStr, testContactInfo.toString());
  }
}
