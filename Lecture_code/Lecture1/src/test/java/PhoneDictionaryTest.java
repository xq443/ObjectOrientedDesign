import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PhoneDictionaryTest {

  private PhoneDictionary testDirectory1;
  private PhoneDictionary testDirectory2;
  private Person testPerson;
  private Person expectedPerson1;
  private Person expectedPerson2;


  @BeforeEach
  void setUp() {
    testPerson = new Person("Arya", "Stark", 287);
    testDirectory1 = new PhoneDictionary(testPerson);
    testDirectory2 = new PhoneDictionary("Elia", "Martell", 275);
    expectedPerson1 = new Person("Arya", "Stark", 287);
    expectedPerson2 = new Person("Elia", "Martell", 275);
  }

  @Test
  void getUser() {
    assertEquals(expectedPerson1, testDirectory1.getUser());
  }


  @Test
  void getUser2() {
    assertEquals(expectedPerson2, testDirectory2.getUser());
  }

  @Test
  void setUser() {
    testDirectory1.setUser(expectedPerson2);
    assertEquals(expectedPerson2, testDirectory1.getUser());
  }
}