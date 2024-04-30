import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CourseTest {

  private Course testCourse;
  private String expectedName;
  private String expectedCourseCode;
  private Integer expectedEnrollmentNumber;
  private Boolean expectedInSessionIndicator;

  @BeforeEach
  void setUp() {
    testCourse = new Course("Object-Oriented Design and Analysis", "OOD", 21, Boolean.TRUE);
    expectedName = "Object-Oriented Design and Analysis";
    expectedCourseCode = "OOD";
    expectedEnrollmentNumber = 21;
    expectedInSessionIndicator = Boolean.TRUE;

  }

  @Test
  void getCourseName() {
    assertEquals(expectedName, testCourse.getCourseName());
  }

  @Test
  void getCourseCode() {
    assertEquals(expectedCourseCode, testCourse.getCourseCode());
  }

  @Test
  void getEnrollmentNumber() {
    assertEquals(expectedEnrollmentNumber, testCourse.getEnrollmentNumber());
  }

  @Test
  void getInSession() {
    assertEquals(expectedInSessionIndicator, testCourse.getInSession());
  }
}