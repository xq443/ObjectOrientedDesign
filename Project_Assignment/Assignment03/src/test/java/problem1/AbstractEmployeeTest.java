package problem1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AbstractEmployeeTest {

  private AbstractEmployee testAbstractEmployee;
  private String expectedEmployeeId;
  private ContactInfo expectedContactInfo;
  private LocalDate expectedEmploymentDate;
  private EducationLevel expectedEducationLevel;
  private EmploymentLevel expectedEmploymentLevel;
  private Double expectedLastYearEarning;
  private static final Double Employment_Level_Bonus = 1.4;

  @BeforeEach
  void setUp() {
    expectedEmployeeId = "123";
    expectedContactInfo = new ContactInfo(new Name("John", "Doe"), "123 Main St", "555-1234", new Name("Jane", "Smith"));
    expectedEmploymentDate = LocalDate.of(2023, 1, 1);
    expectedEducationLevel = EducationLevel.Bachelors_Degree;
    expectedEmploymentLevel = EmploymentLevel.Intermediate_Level;
    expectedLastYearEarning = 60000.0;

    testAbstractEmployee = new AbstractEmployee(
        expectedEmployeeId, expectedContactInfo, expectedEmploymentDate,
        expectedEducationLevel, expectedEmploymentLevel, expectedLastYearEarning) {
    };
  }

  @Test
  void testEstimateProductivity() {
    // Check that the bonus for Intermediate_Level employment is applied
    assertEquals(Employment_Level_Bonus, testAbstractEmployee.estimateProductivity());
  }
}

