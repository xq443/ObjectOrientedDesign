import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonTest {

  private Person testPerson;
  private Name expectedName;

  @BeforeEach
  void setUp() {
    Name testName = new Name("Harry", "Bosch");
    testPerson = new Person(testName);
    expectedName = new Name("Harry", "Bosch");
  }

  @Test
  void getPersonsName() {
    assertEquals(expectedName, testPerson.getPersonsName());
  }

  @Test
  void setPersonsName() {
    expectedName = new Name("Maddy", "Bosch");
    testPerson.setPersonsName(expectedName);
    assertEquals(expectedName, testPerson.getPersonsName());
  }
}