import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameTest {

  private Name testName;
  private String expectedFirstName;
  private String expectedLastName = "Doe";

  @BeforeEach
  void setUp() {
    expectedFirstName = "Jane";
    expectedLastName = "Doe";
    testName = new Name("Jane", "Doe");
  }

  @Test
  void upperCaseLastName() {
    expectedLastName = "Smith";
    testName = new Name(expectedFirstName, expectedLastName);
    //System.out.println(expectedLastName);
    //System.out.println("This is the test last name: " + testName.getLastName());
    assertEquals(expectedLastName.toUpperCase(), testName.upperCaseLastName());
  }

  //@Test
  //void getFirstName() {
  //}

  @Test
  void getLastName() {

    assertEquals(expectedLastName, testName.getLastName());
  }

  //@Test
  //void getFullName() {
  //}

  //@Test
  //void getBrithdate() {
  //}

}