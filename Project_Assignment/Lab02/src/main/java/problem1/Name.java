package problem1;

import java.util.Objects;

/**
 * The Name class represents a person's name with first, middle, and last name components.
 */
public class Name {

  private String firstName;
  private String middleName;
  private String lastName;

  /**
   * Constructs a Name object with the specified first, middle, and last names.
   *
   * @param firstName  The first name of the person.
   * @param middleName The middle name of the person.
   * @param lastName   The last name of the person.
   */
  public Name(String firstName, String middleName, String lastName) {
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
  }

  /**
   * Gets the first name.
   *
   * @return The first name of the person.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Gets the middle name.
   *
   * @return The middle name of the person.
   */
  public String getMiddleName() {
    return middleName;
  }

  /**
   * Gets the last name.
   *
   * @return The last name of the person.
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Checks if this Name object is equal to another object.
   *
   * @param o The object to compare.
   * @return True if the objects are equal, false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Name name = (Name) o;
    return Objects.equals(firstName, name.firstName) && Objects.equals(middleName,
        name.middleName) && Objects.equals(lastName, name.lastName);
  }

  /**
   * Generates a hash code for this Name object.
   *
   * @return The hash code.
   */
  @Override
  public int hashCode() {
    return Objects.hash(firstName, middleName, lastName);
  }

  /**
   * Returns a string representation of this Name object.
   *
   * @return A string representation of the object.
   */
  @Override
  public String toString() {
    return "Name{" +
        "firstName='" + firstName + '\'' +
        ", middleName='" + middleName + '\'' +
        ", lastName='" + lastName + '\'' +
        '}';
  }
}
