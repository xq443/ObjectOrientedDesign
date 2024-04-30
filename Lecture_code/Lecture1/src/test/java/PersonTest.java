import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonTest {

  private Person testPerson;
  private String expectedFirstName;
  private String expectedLastName;
  private int expectedYearOfBirth;

  @BeforeEach
  void setUp() {
    testPerson = new Person("Sansa", "Stark", 285);
    expectedFirstName = "Sansa";
    expectedLastName = "Stark";
    expectedYearOfBirth = 285;
  }

  @Test
  void getFirstName() {
    assertEquals(expectedFirstName, testPerson.getFirstName());
  }

  @Test
  void getLastName() {
    assertEquals(expectedLastName, testPerson.getLastName());
  }

  @Test
  void getYearOfBirth() {
    assertEquals(expectedYearOfBirth, testPerson.getYearOfBirth());
  }
}