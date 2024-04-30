public class Student {

  private String firstName;
  private String middleName;
  private String lastName;
  //private Name studentsName; //this is a better way to go
  private String studentID;
  private String emailAddress;

  public Student(String firstName, String middleName, String lastName, String studentID, String emailAddress) {
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.studentID = studentID;
    this.emailAddress = emailAddress;
  }

  public Student(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.middleName = null;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public String getMiddleName() {
    return this.middleName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public String getStudentID() {
    return studentID;
  }

  public String getEmailAddress() {
    return emailAddress;
  }
}
