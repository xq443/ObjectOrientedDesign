import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudentTest {
  private Student testStudent;
  private String expectedFirstName;
  private String expectedMiddleName;
  private String expectedLastName;
  private String expectedStudentID;
  private String expectedEmail;


  @BeforeEach
  void setUp() {
    testStudent = new Student("Jon", "N/A", "Snow", "12345", "jon.snow@winterfell.org");
    expectedFirstName = "Jon";
    expectedMiddleName = "N/A";
    expectedLastName = "Snow";
    expectedStudentID = "12345";
    expectedEmail = "jon.snow@winterfell.org";
  }

  @Test
  void getFirstName() {
    assertEquals(expectedFirstName, testStudent.getFirstName());
  }

  @Test
  void getMiddleName() {
    assertEquals(expectedMiddleName, testStudent.getMiddleName());
  }

  @Test
  void getLastName() {
    assertEquals(expectedLastName, testStudent.getLastName());
  }

  @Test
  void getStudentID() {
    assertEquals(expectedStudentID, testStudent.getStudentID());
  }

  @Test
  void getEmailAddress() {
    assertEquals(expectedEmail, testStudent.getEmailAddress());
  }
}