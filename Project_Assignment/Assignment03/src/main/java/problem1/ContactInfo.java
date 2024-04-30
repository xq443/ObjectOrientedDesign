package problem1;

import java.util.Objects;

/**
 * Represents contact information including name, address, phone number, and emergency contact.
 */
public class ContactInfo {

  /**
   * The name associated with the contact information.
   */
  private Name name;

  /**
   * The address associated with the contact information.
   */
  private String address;

  /**
   * The phone number associated with the contact information.
   */
  private String phoneNumber;

  /**
   * The emergency contact associated with the contact information.
   */
  private Name emergencyContact;

  /**
   * Constructs a ContactInfo object with the specified details.
   *
   * @param name             The name associated with the contact information.
   * @param address          The address associated with the contact information.
   * @param phoneNumber      The phone number associated with the contact information.
   * @param emergencyContact The emergency contact associated with the contact information.
   */
  public ContactInfo(Name name, String address, String phoneNumber, Name emergencyContact) {
    this.name = name;
    this.address = address;
    this.phoneNumber = phoneNumber;
    this.emergencyContact = emergencyContact;
  }

  /**
   * Retrieves the name associated with the contact information.
   *
   * @return The name associated with the contact information.
   */
  public Name getName() {
    return name;
  }

  /**
   * Retrieves the address associated with the contact information.
   *
   * @return The address associated with the contact information.
   */
  public String getAddress() {
    return address;
  }

  /**
   * Retrieves the phone number associated with the contact information.
   *
   * @return The phone number associated with the contact information.
   */
  public String getPhoneNumber() {
    return phoneNumber;
  }

  /**
   * Retrieves the emergency contact associated with the contact information.
   *
   * @return The emergency contact associated with the contact information.
   */
  public Name getEmergencyContact() {
    return emergencyContact;
  }

  /**
   * Checks if this ContactInfo is equal to another object.
   *
   * @param o The object to compare.
   * @return true if the objects are equal, false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContactInfo that = (ContactInfo) o;
    return Objects.equals(name, that.name) && Objects.equals(address,
        that.address) && Objects.equals(phoneNumber, that.phoneNumber)
        && Objects.equals(emergencyContact, that.emergencyContact);
  }

  /**
   * Generates a hash code for this ContactInfo.
   *
   * @return The hash code for this ContactInfo.
   */
  @Override
  public int hashCode() {
    return Objects.hash(name, address, phoneNumber, emergencyContact);
  }

  /**
   * Returns a string representation of this ContactInfo.
   *
   * @return A string representation of this ContactInfo.
   */
  @Override
  public String toString() {
    return "ContactInfo{" +
        "name=" + name +
        ", address='" + address + '\'' +
        ", phoneNumber='" + phoneNumber + '\'' +
        ", emergencyContact=" + emergencyContact +
        '}';
  }
}
