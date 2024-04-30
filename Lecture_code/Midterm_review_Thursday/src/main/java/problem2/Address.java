package problem2;

import java.util.Objects;

/**
 * Class address stores information about an address, including street number and street name,
 * city and zip code.
 */
public class Address {

  private Integer streetNumber;
  private String streetName;
  private String streetSecondRow;
  private String city;
  private String zipCode;

  /**
   * Constructor for an address.
   * @param streetNumber street number, as anInteger
   * @param streetName street name, as a String
   * @param streetSecondRow second row for the street name, as a String
   * @param city city, as a String
   * @param zipCode zip code, as a String
   */
  public Address(Integer streetNumber, String streetName, String streetSecondRow, String city,
      String zipCode) {
    this.streetNumber = streetNumber;
    this.streetName = streetName;
    this.streetSecondRow = streetSecondRow;
    this.city = city;
    this.zipCode = zipCode;
  }

  /**
   * Constructor for an address.
   * @param streetNumber street number, as anInteger
   * @param streetName street name, as a String
   * @param city city, as a String
   * @param zipCode zip code, as a String
   */
  public Address(Integer streetNumber, String streetName, String city, String zipCode) {
    this.streetNumber = streetNumber;
    this.streetName = streetName;
    this.city = city;
    this.zipCode = zipCode;
  }

  public Integer getStreetNumber() {
    return streetNumber;
  }

  public String getStreetName() {
    return streetName;
  }

  public String getStreetSecondRow() {
    return streetSecondRow;
  }

  public String getCity() {
    return city;
  }

  public String getZipCode() {
    return zipCode;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Address address = (Address) o;
    return Objects.equals(streetNumber, address.streetNumber) && Objects.equals(
        streetName, address.streetName) && Objects.equals(streetSecondRow,
        address.streetSecondRow) && Objects.equals(city, address.city)
        && Objects.equals(zipCode, address.zipCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(streetNumber, streetName, streetSecondRow, city, zipCode);
  }

  @Override
  public String toString() {
    return "Address{" +
        "streetNumber=" + streetNumber +
        ", streetName='" + streetName + '\'' +
        ", streetSecondRow='" + streetSecondRow + '\'' +
        ", city='" + city + '\'' +
        ", zipCode='" + zipCode + '\'' +
        '}';
  }
}
