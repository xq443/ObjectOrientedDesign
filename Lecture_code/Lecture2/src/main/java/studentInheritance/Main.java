package studentInheritance;

public class Main {

  public static void main(String[] args){

    Name name = new Name("Daniel", "Joseph", "Smith");
    Email email = new Email("ddjsmith", "gmail.com");
    Student someStudent = new Student(name, email, "1234567");
    String[] minors = new String[3];
    minors[0] = "CS";
    minors[1] = "Biology";
    minors[2] = "Math";
    Undergraduate someUndergrad = new Undergraduate(name, email, "1234567", "Math", minors);

    System.out.println(someStudent.getStudentEmail());
    System.out.println(someUndergrad.getStudentEmail() + someUndergrad.getMajor());


  }

}
