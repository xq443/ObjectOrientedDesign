package studentInheritance;

public class Graduate extends Student {

    private String program;
    private Boolean researchBased;
    private Integer year;
    private double gpa;

    public Graduate(Name studentName, Email studentEmail, String studentID, String program,
                    Boolean researchBased, Integer year, double gpa) {
        super(studentName, studentEmail, studentID);
        this.program = program;
        this.researchBased = researchBased;
        this.year = year;
        this.gpa = gpa;
    }

    public String getProgram() {
        return program;
    }
}
