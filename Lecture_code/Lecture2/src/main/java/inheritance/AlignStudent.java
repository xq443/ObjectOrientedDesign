package inheritance;

import java.util.Objects;

public class AlignStudent extends GraduateStudent {

  private Integer semesterInTheProgram;

  public AlignStudent(String firstName, String lastName, String studentID, String program, String university,
                      Person advisor, Integer semesterInTheProgram) {
    super(firstName, lastName, studentID, program, university, advisor);
    this.semesterInTheProgram = semesterInTheProgram;
  }

  public Integer getSemesterInTheProgram() {
    return semesterInTheProgram;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof AlignStudent)) return false;
    if (!super.equals(o)) return false;
    AlignStudent that = (AlignStudent) o;
    return Objects.equals(getSemesterInTheProgram(), that.getSemesterInTheProgram());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getSemesterInTheProgram());
  }
}
