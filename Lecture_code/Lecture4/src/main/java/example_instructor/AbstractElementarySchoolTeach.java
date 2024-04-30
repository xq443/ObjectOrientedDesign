package example_instructor;

import java.util.Objects;

public abstract class AbstractElementarySchoolTeach implements Instructor{

  protected Integer numStudents;

  public Integer getNumStudents() {
    return numStudents;
  }

  public AbstractElementarySchoolTeach(Integer numStudents) {
    this.numStudents = numStudents;
  }

  @Override
  public void teach(String topic){
    System.out.println("This is my topic" + topic);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AbstractElementarySchoolTeach that = (AbstractElementarySchoolTeach) o;
    return Objects.equals(numStudents, that.numStudents);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numStudents);
  }
}
