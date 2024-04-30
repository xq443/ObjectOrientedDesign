package example_instructor;

import java.util.List;

public interface Instructor {

  void teach(String topic);
  void assignHomework(String topic);
  Boolean gradeAssignment(String topic, List<String> students);

}
