package problem2;

import java.util.Objects;

/**
 * The Recipient class represents a person who is the intended recipient of a mail item.
 */
public class Recipient {
  private String firstName;
  private String lastName;
  private String emailAddress;

  /**
   * Constructs a new Recipient with the specified first name, last name, and email address.
   *
   * @param firstName    The first name of the recipient.
   * @param lastName     The last name of the recipient.
   * @param emailAddress The email address of the recipient.
   */
  public Recipient(String firstName, String lastName, String emailAddress) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.emailAddress = emailAddress;
  }

  /**
   * Gets the first name of the recipient.
   * @return The first name of the recipient: String
   */
  public String getFirstName() {
    return this.firstName;
  }

  /**
   * Gets the last name of the recipient.
   * @return The last name of the recipient: String
   */
  public String getLastName() {
    return this.lastName;
  }

  /**
   * Gets the email address of the recipient.
   * @return The email address of the recipient: String
   */
  public String getEmailAddress() {
    return this.emailAddress;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Recipient recipient = (Recipient) o;
    return Objects.equals(firstName, recipient.firstName) && Objects.equals(
        lastName, recipient.lastName) && Objects.equals(emailAddress,
        recipient.emailAddress);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName, emailAddress);
  }

  @Override
  public String toString() {
    return "Recipient{" +
        "firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", emailAddress='" + emailAddress + '\'' +
        '}';
  }
}
