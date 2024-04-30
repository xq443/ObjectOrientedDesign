package problem1;

import java.util.Objects;

/**
 * Represents a person's name with a first name and last name.
 */
public class Name {

  /** The first name of the person. */
  private String firstName;

  /** The last name of the person. */
  private String lastName;

  /**
   * Constructs a new Name with the specified first name and last name.
   *
   * @param firstName The first name of the person.
   * @param lastName  The last name of the person.
   */
  public Name(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   * Gets the first name of the person.
   *
   * @return The first name.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Gets the last name of the person.
   *
   * @return The last name.
   */
  public String getLastName() {
    return lastName;
  }
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Name name = (Name) o;
    return Objects.equals(firstName, name.firstName) && Objects.equals(lastName,
        name.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName);
  }

  @Override
  public String toString() {
    return "Name{" +
        "firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        '}';
  }
}
