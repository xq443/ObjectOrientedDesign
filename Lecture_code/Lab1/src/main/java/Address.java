public class Address {

  private String street;
  private String city;
  private String county;
  private String zipCode;
  private String state;

  public Address(String street, String city, String county, String zipCode, String state) {
    this.street = street;
    this.city = city;
    this.county = county;
    this.zipCode = zipCode;
    this.state = state;
  }

  public String getStreet() {
    return street;
  }

  public String getCity() {
    return city;
  }

  public String getCounty() {
    return county;
  }

  public String getZipCode() {
    return zipCode;
  }

  public String getState() {
    return state;
  }

  @Override
  public String toString() {
    return "Address{" +
        "street='" + street + '\'' +
        ", city='" + city + '\'' +
        ", county='" + county + '\'' +
        ", zipCode='" + zipCode + '\'' +
        ", state='" + state + '\'' +
        '}';
  }
}
