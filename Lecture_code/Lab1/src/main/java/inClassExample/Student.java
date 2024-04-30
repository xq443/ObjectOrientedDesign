package inClassExample;

public class Student {

  private String studentsName;
  private String studentsID;
  private String studentsEmail;
  private String major;
  private String minor;
  private Float currentGPA;

  public Student(String studentsName, String studentsID, String studentsEmail, String major,
      String minor, Float currentGPA) {
    this.studentsName = studentsName;
    this.studentsID = studentsID;
    this.studentsEmail = studentsEmail;
    this.major = major;
    this.minor = minor;
    this.currentGPA = currentGPA;
  }

  public String getStudentsName() {
    return studentsName;
  }

  public String getStudentsID() {
    return studentsID;
  }

  public String getStudentsEmail() {
    return studentsEmail;
  }

  public String getMajor() {
    return major;
  }

  public String getMinor() {
    return minor;
  }

  public Float getCurrentGPA() {
    return currentGPA;
  }

  public void setStudentsName(String studentsName) {
    this.studentsName = studentsName;
  }

  public void setStudentsID(String studentsID) {
    this.studentsID = studentsID;
  }

  public void setStudentsEmail(String studentsEmail) {
    this.studentsEmail = studentsEmail;
  }

  public void setMajor(String major) {
    this.major = major;
  }

  public void setMinor(String minor) {
    this.minor = minor;
  }

  public void setCurrentGPA(Float currentGPA) {
    this.currentGPA = currentGPA;
  }

  public void displayStudentInfo(){
    System.out.println(this.toString());

    //The other way
    /*
    String resultingString = "Student{" +
        "studentsName='" + this.studentsName + '\'' +
        ", studentsID='" + this.studentsID + '\'' +
        ", studentsEmail='" + this.studentsEmail + '\'' +
        ", major='" + this.major + '\'' +
        ", minor='" + this.minor + '\'' +
        ", currentGPA=" + this.currentGPA +
        '}';
    System.out.println(resultingString);
     */
  }

  @Override
  public String toString() {
    return "Student{" +
        "studentsName='" + studentsName + '\'' +
        ", studentsID='" + studentsID + '\'' +
        ", studentsEmail='" + studentsEmail + '\'' +
        ", major='" + major + '\'' +
        ", minor='" + minor + '\'' +
        ", currentGPA=" + currentGPA +
        '}';
  }
}
