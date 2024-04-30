package inheritance;

import java.util.Objects;

public class UndergraduateStudent extends Student {

  private String university;
  private String major;

  public UndergraduateStudent(String firstName, String lastName, String studentID, String university, String major) {
    super(firstName, lastName, studentID);
    this.university = university;
    this.major = major;
  }

  @Override
  public String getFirstName(){
    return firstName + " " + lastName;
  }

  public String getUniversity() {
    return university;
  }

  public String getMajor() {
    return major;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    UndergraduateStudent that = (UndergraduateStudent) o;
    return Objects.equals(university, that.university) && Objects.equals(major, that.major);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), university, major);
  }
}
