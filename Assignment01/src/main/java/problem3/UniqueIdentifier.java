package problem3;

import java.util.Objects;

/**
 * Represents a unique identifier associated with an account holder.
 */
public class UniqueIdentifier {

  private String username;
  private int year;
  private String country;

  /**
   * Constructs a new UniqueIdentifier with the specified username, creation year, and country.
   *
   * @param username     The username of the account holder.
   * @param year         The year the account was created.
   * @param country      The country where the account was created.
   */
  public UniqueIdentifier(String username, int year, String country) {
    this.username = username;
    this.year = year;
    this.country = country;
  }

  /**
   * Gets the username associated with this unique identifier.
   *
   * @return The username.
   */
  public String getUsername() {
    return username;
  }

  /**
   * Gets the creation year associated with this unique identifier.
   *
   * @return The creation year.
   */
  public int getYear() {
    return year;
  }

  /**
   * Gets the country associated with this unique identifier.
   *
   * @return The country.
   */
  public String getCountry() {
    return country;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UniqueIdentifier that = (UniqueIdentifier) o;
    return year == that.year && Objects.equals(username, that.username)
        && Objects.equals(country, that.country);
  }

  /**
   * Generates a hash code for this UniqueIdentifier.
   *
   * @return The hash code.
   */
  @Override
  public int hashCode() {
    return Objects.hash(username, year, country);
  }
}
