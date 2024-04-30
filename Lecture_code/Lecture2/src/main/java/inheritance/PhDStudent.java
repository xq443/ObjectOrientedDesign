package inheritance;

public class PhDStudent extends GraduateStudent{

  public PhDStudent(String firstName, String lastName, String studentID, String program,
                    String university, Person advisor) {
    super(firstName, lastName, studentID, program, university, advisor);
  }
}
