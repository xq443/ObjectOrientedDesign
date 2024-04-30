package inheritance;

import java.util.Objects;

public class Student extends Person {
  protected String studentID;

  public Student(String firstName, String lastName, String studentID) {
    super(firstName, lastName);
    this.studentID = studentID;
  }


  public Student(String firstName, String lastName,
                 String superFirstName, String studentID) {
    super(firstName, lastName);
    this.studentID = studentID;

    super.firstName = superFirstName;
  }

  public String getStudentID() {
    return studentID;
  }

  public void printStuff(){
    System.out.println(this.firstName);
    System.out.println(super.firstName);
  }

  @Override
  public void printToConsole(){
    System.out.println(this.firstName + super.firstName + this.lastName);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Student)) return false;
    if (!super.equals(o)) return false;
    Student student = (Student) o;
    return Objects.equals(getStudentID(), student.getStudentID());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getStudentID());
  }
}
