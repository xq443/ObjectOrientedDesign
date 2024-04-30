import java.time.LocalDate;
import java.util.Objects;

public class Name {

  private String firstName;

  private String lastName;
  private static final double PI = 3.14;
  private static final String HELLO = "Hello";
  private static final String TITLE = "Ms.";

  public Name(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getFullName(){
    return TITLE + this.getFirstName() + this.getLastName();
  }

  public LocalDate getBirthdate(){
    LocalDate birthday = LocalDate.now();
    //return LocalDate.now();
    return birthday;
  }

  public String upperCaseLastName(){
    return this.lastName.toUpperCase();
  }

  public static void main(String[] args){
    Name myName = new Name("Ash", "Catcham");
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
}
