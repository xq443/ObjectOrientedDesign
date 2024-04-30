package interfaceExample;

public class HybridTeacher implements Teacher{
    @Override
    public void teach(String lessonName) {

        System.out.println("Today we talk about interfaces");
    }

    @Override
    public String prepareAssignment(String lessonName) {
        return null;
    }

    @Override
    public void gradeClass(String classInformation) {
        System.out.println("Everyone gets an A!");
    }

    @Override
    public void holdOfficeHours() {
        System.out.println("Come tomorrow after the lab.");
    }
}
