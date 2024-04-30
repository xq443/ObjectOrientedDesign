package problem2;

import java.util.Objects;

/**
 * Represents an abstract class for individual creators.
 * This class extends the {@link Creator} class and provides basic functionalities for managing individual creators.
 */
public abstract class IndividualCreator extends Creator {

  /** The first name of the individual creator. */
  protected String firstName;

  /** The last name of the individual creator. */
  protected String lastName;

  /**
   * Constructs an IndividualCreator object with the specified first name and last name.
   *
   * @param firstName the first name of the individual creator
   * @param lastName the last name of the individual creator
   */
  public IndividualCreator(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   * Retrieves the first name of the individual creator.
   *
   * @return the first name of the individual creator
   */
  public String getFirstName() {
    return this.firstName;
  }

  /**
   * Retrieves the last name of the individual creator.
   *
   * @return the last name of the individual creator
   */
  public String getLastName() {
    return this.lastName;
  }

  /**
   * Indicates whether some other object is "equal to" this one.
   * This method compares two IndividualCreator objects based on their first name and last name.
   *
   * @param o the reference object with which to compare
   * @return true if this IndividualCreator is the same as the object argument; false otherwise
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IndividualCreator that = (IndividualCreator) o;
    return Objects.equals(this.firstName, that.firstName) && Objects.equals(this.lastName, that.lastName);
  }

  /**
   * Returns a hash code value for the IndividualCreator object.
   * This method computes a hash code based on the first name and last name.
   *
   * @return a hash code value for this IndividualCreator object
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.firstName, this.lastName);
  }

  /**
   * Returns a string representation of the IndividualCreator object.
   * The string representation includes the first name and last name of the individual creator.
   *
   * @return a string representation of this IndividualCreator object
   */
  @Override
  public String toString() {
    return "IndividualCreator{" +
        "firstName='" + this.firstName + '\'' +
        ", lastName='" + this.lastName + '\'' +
        '}';
  }
}
