package studentInheritance;

import java.util.Arrays;
import java.util.Objects;

public class Undergraduate extends Student{

  private String major;
  private String[] minors;

  public Undergraduate(Name studentName, Email studentEmail, String studentID,
                       String major, String[] minors) {
    super(studentName, studentEmail, studentID);
    this.major = major;
    this.minors = minors;
  }

  @Override
  public Email getStudentEmail(){
    System.out.println(this.studentEmail.getUsername() + "@" + this.studentEmail.getDomain());
    return super.getStudentEmail();
  }

  public String getMajor() {
    return major;
  }

  public String[] getMinors() {
    return minors;
  }

  @Override
  public String toString() {
    return "Undergraduate{" +
        "major='" + major + '\'' +
        ", minors=" + Arrays.toString(minors) +
        ", studentName=" + studentName +
        ", studentEmail=" + studentEmail +
        ", studentID='" + studentID + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;
    Undergraduate that = (Undergraduate) o;
    return Objects.equals(major, that.major) && Arrays.equals(minors, that.minors);
  }

  @Override
  public int hashCode() {
    int result = Objects.hash(super.hashCode(), major);
    result = 31 * result + Arrays.hashCode(minors);
    return result;
  }
}
