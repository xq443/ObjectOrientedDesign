package interfaceExample;

public class RemoteTeacher implements Teacher, SoftwareEngineer{

  @Override
  public void teach(String lessonName) {

  }

  @Override
  public String prepareAssignment(String lessonName) {
    return null;
  }

  @Override
  public void gradeClass(String classInformation) {

  }

  @Override
  public void holdOfficeHours() {

  }

  @Override
  public void writeCode(String projectName) {

  }

  @Override
  public Boolean reviewCode(String projectName) {
    return null;
  }

  @Override
  public void haveMeetings() {

  }

  @Override
  public Boolean interviewCandidate(String candidatesInformation) {
    return null;
  }
}
