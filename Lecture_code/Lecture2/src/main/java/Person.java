import java.util.Objects;

public class Person {

  private Name personsName;

  public Person(Name personsName) {
    this.personsName = personsName;
  }

  public Name getPersonsName() {
    return personsName;
  }

  public void setPersonsName(Name personsName) {
    this.personsName = personsName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Person person = (Person) o;
    return Objects.equals(personsName, person.personsName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(personsName);
  }

  @Override
  public String toString() {
    return "Person{" +
        "personsName=" + personsName +
        '}';
  }
}
