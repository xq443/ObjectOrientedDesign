package inheritance;

public class MastersStudent extends GraduateStudent {

  public MastersStudent(String firstName, String lastName, String studentID,
                        String program, String university, Person advisor) {
    super(firstName, lastName, studentID, program, university, advisor);
  }
}
