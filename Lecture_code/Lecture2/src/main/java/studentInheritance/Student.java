package studentInheritance;

import java.util.Objects;

public class Student {

  protected Name studentName;
  protected Email studentEmail;
  protected String studentID;

  public Student(Name studentName, Email studentEmail, String studentID) {
    this.studentName = studentName;
    this.studentEmail = studentEmail;
    this.studentID = studentID;
  }

  public Name getStudentName() {
    return studentName;
  }

  public Email getStudentEmail() {
    return studentEmail;
  }

  public String getStudentID() {
    return studentID;
  }

  @Override
  public String toString() {
    return "Student{" +
        "studentName=" + studentName +
        ", studentEmail=" + studentEmail +
        ", studentID='" + studentID + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Student student = (Student) o;
    return Objects.equals(studentName, student.studentName) &&
            Objects.equals(studentEmail, student.studentEmail) && Objects.equals(studentID, student.studentID);
  }

  @Override
  public int hashCode() {
    return Objects.hash(studentName, studentEmail, studentID);
  }
}
