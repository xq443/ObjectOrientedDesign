package composition;

public class Student {

  private Name studentName;
  private String studentID;

  public Student(Name studentName, String studentID) {
    this.studentName = studentName;
    this.studentID = studentID;
  }

  public Name getStudentName() {
    return studentName;
  }

  public String getStudentID() {
    return studentID;
  }
}
