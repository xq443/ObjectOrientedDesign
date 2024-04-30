public class Author {

  private Name name;
  private Email email;
  private Address address;

  public Author(Name name, Email email, Address address) {
    this.name = name;
    this.email = email;
    this.address = address;
  }

  public Name getName() {
    return name;
  }

  public Email getEmail() {
    return email;
  }

  public Address getAddress() {
    return address;
  }

  public void setName(Name name) {
    this.name = name;
  }

  public void setEmail(Email email) {
    this.email = email;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  @Override
  public String toString() {
    return "Author{" +
        "name=" + name +
        ", email=" + email +
        ", address=" + address +
        '}';
  }
}
