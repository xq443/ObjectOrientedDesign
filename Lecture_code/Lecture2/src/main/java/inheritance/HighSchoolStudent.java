package inheritance;

public class HighSchoolStudent extends Student{

  private String highSchoolName;
  private Integer grade;
  private Float gpa;

  public HighSchoolStudent(String firstName, String lastName, String studentID,
                           String highSchoolName, Integer grade, Float gpa) {
    super(firstName, lastName, studentID);
    this.highSchoolName = highSchoolName;
    this.grade = grade;
    this.gpa = gpa;
  }

  public String getHighSchoolName() {
    return highSchoolName;
  }

  public Integer getGrade() {
    return grade;
  }

  public Float getGpa() {
    return gpa;
  }
}
