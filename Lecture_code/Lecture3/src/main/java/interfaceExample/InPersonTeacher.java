package interfaceExample;

public class InPersonTeacher implements Teacher{

  @Override
  public void teach(String lessonName) {
    System.out.println("Today we're going to talk about intefaces...");
  }

  @Override
  public String prepareAssignment(String lessonName) {
    return new String("This is HW3");
  }

  @Override
  public void gradeClass(String classInformation) {
    System.out.println("Everyone gets an A!");

  }

  @Override
  public void holdOfficeHours() {
    System.out.println("See you on Friday");
  }
}
