import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NameTest {

  private Name testName;
  private String expectedFirstName;
  private String expectedLastName;

  @BeforeEach
  void setUp() {
    testName = new Name("Maddy", "Smith");
    expectedFirstName = "Maddy";
    expectedLastName = "Smith";
  }

  @Test
  void getFirstName() {
    assertEquals(expectedFirstName, testName.getFirstName());
  }

  @Test
  void getLastName() {
    assertEquals(expectedLastName, testName.getLastName());
  }

  @Test
  void testToString() {
    String resultingString = "Name{" +
        "firstName='" + "Maddy" + '\'' +
        ", lastName='" + "Smith" + '\'' +
        '}';
    assertEquals(resultingString, testName.toString());
  }
}