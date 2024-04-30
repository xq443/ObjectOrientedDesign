package inheritance;

import java.util.Objects;

public class GraduateStudent extends Student {

  protected String program;
  protected String university;
  protected Person advisor;

  public GraduateStudent(String firstName, String lastName, String studentID,
                         String program, String university, Person advisor) {
    super(firstName, lastName, studentID);
    this.program = program;
    this.university = university;
    this.advisor = advisor;
  }

  public String getProgram() {
    return program;
  }

  public String getUniversity() {
    return university;
  }

  public Person getAdvisor() {
    return advisor;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof GraduateStudent)) return false;
    if (!super.equals(o)) return false;
    GraduateStudent that = (GraduateStudent) o;
    return Objects.equals(getProgram(), that.getProgram()) &&
        Objects.equals(getUniversity(), that.getUniversity()) &&
        Objects.equals(getAdvisor(), that.getAdvisor());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getProgram(), getUniversity(), getAdvisor());
  }
}
