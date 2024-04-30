/**
 * This class represents a course. A course has a name, code, enrollment number (number of enrolled students), and indicator
 * whether or not it is in session.
 */
public class Course {

  private String courseName;
  private String courseCode;
  private Integer enrollmentNumber;
  private Boolean inSession;

  /**
   * Construct a Course object that has the
   * provided name, code, enrollment number, and in-session indicator
   *
   * @param courseName - the name of the course
   * @param courseCode - the course code
   * @param enrollmentNumber - the number of students enrolled in the course
   * @param inSession - a Boolean, indicating whether or not the course is in session
   */

  public Course(String courseName, String courseCode, Integer enrollmentNumber, Boolean inSession) {
    this.courseName = courseName;
    this.courseCode = courseCode;
    this.enrollmentNumber = enrollmentNumber;
    this.inSession = inSession;
  }

  public String getCourseName() {
    return courseName;
  }

  public String getCourseCode() {
    return courseCode;
  }

  public Integer getEnrollmentNumber() {
    return enrollmentNumber;
  }

  public Boolean getInSession() {
    return inSession;
  }
}
