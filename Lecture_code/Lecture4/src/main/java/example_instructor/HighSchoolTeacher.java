package example_instructor;

import java.util.List;

public class HighSchoolTeacher implements Instructor{


  @Override
  public void teach(String topic) {
    System.out.println("I am teaching!");
  }

  @Override
  public void assignHomework(String topic) {

  }

  @Override
  public Boolean gradeAssignment(String topic, List<String> students) {
    return null;
  }
}
