package problem1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class HourlyEmployeeTest {

  private HourlyEmployee testHourlyEmployee;
  private String expectedEmployeeId;
  private ContactInfo expectedContactInfo;
  private LocalDate expectedEmploymentDate;
  private EducationLevel expectedEducationLevel;
  private EmploymentLevel expectedEmploymentLevel;
  private Double expectedLastYearEarning;
  private Double expectedContractualNumberOfWorkedHours;
  private Double expectedActualNumberOfWorkedHours;
  private Double expectedBonusAndOvertimeEarnings;
  private Double expectedHourlyEarnings;
  private static final Integer Hourly_Earnings_Bonus = 3;

  @BeforeEach
  void setUp() {
    expectedEmployeeId = "123";
    expectedContactInfo = new ContactInfo(new Name("John", "Doe"), "123 Main St", "555-1234", new Name("Jane", "Smith"));
    expectedEmploymentDate = LocalDate.of(2023, 1, 1);
    expectedEducationLevel = EducationLevel.Bachelors_Degree;
    expectedEmploymentLevel = EmploymentLevel.Senior_Level;
    expectedLastYearEarning = 75000.0;
    expectedContractualNumberOfWorkedHours = 40.0;
    expectedActualNumberOfWorkedHours = 38.0;
    expectedBonusAndOvertimeEarnings = 2000.0;
    expectedHourlyEarnings = 13.0;

    testHourlyEmployee = new HourlyEmployee(expectedEmployeeId, expectedContactInfo, expectedEmploymentDate,
        expectedEducationLevel, expectedEmploymentLevel, expectedLastYearEarning,
        expectedContractualNumberOfWorkedHours, expectedActualNumberOfWorkedHours,
        expectedBonusAndOvertimeEarnings, expectedHourlyEarnings);
  }

  @Test
  void testGetHourlyEarnings() {
    assertEquals(expectedHourlyEarnings, testHourlyEmployee.getHourlyEarnings());
  }
  @Test
  void testGetTheContractualNumberOfWorkedHours() {
    assertEquals(expectedContractualNumberOfWorkedHours, testHourlyEmployee.getTheContractualNumberOfWorkedHours());
  }

  @Test
  void testGetTheActualNumberOfWorkedHours() {
    assertEquals(expectedActualNumberOfWorkedHours, testHourlyEmployee.getTheActualNumberOfWorkedHours());
  }


  @Test
  void testGetBonusAndOvertimeEarnings() {
    assertEquals(expectedBonusAndOvertimeEarnings, testHourlyEmployee.getBonusAndOvertimeEarnings());
  }
  @Test
  void testEquals_DifferentContractualNumberOfWorkedHours() {
    HourlyEmployee otherHourlyEmployee = new HourlyEmployee(expectedEmployeeId, expectedContactInfo, expectedEmploymentDate,
        expectedEducationLevel, expectedEmploymentLevel, expectedLastYearEarning,
        35.0, expectedActualNumberOfWorkedHours,
        expectedBonusAndOvertimeEarnings, expectedHourlyEarnings);

    assertFalse(testHourlyEmployee.equals(otherHourlyEmployee));
  }

  @Test
  void testEquals_DifferentActualNumberOfWorkedHours() {
    HourlyEmployee otherHourlyEmployee = new HourlyEmployee(expectedEmployeeId, expectedContactInfo, expectedEmploymentDate,
        expectedEducationLevel, expectedEmploymentLevel, expectedLastYearEarning,
        expectedContractualNumberOfWorkedHours, 37.0,
        expectedBonusAndOvertimeEarnings, expectedHourlyEarnings);

    assertFalse(testHourlyEmployee.equals(otherHourlyEmployee));
  }

  @Test
  void testEquals_DifferentBonusAndOvertimeEarnings() {
    HourlyEmployee otherHourlyEmployee = new HourlyEmployee(expectedEmployeeId, expectedContactInfo, expectedEmploymentDate,
        expectedEducationLevel, expectedEmploymentLevel, expectedLastYearEarning,
        expectedContractualNumberOfWorkedHours, expectedActualNumberOfWorkedHours,
        2500.0, expectedHourlyEarnings);

    assertFalse(testHourlyEmployee.equals(otherHourlyEmployee));
  }

  @Test
  void testEquals_DifferentEmployeeId() {
    HourlyEmployee otherHourlyEmployee = new HourlyEmployee("456", expectedContactInfo, expectedEmploymentDate,
        expectedEducationLevel, expectedEmploymentLevel, expectedLastYearEarning,
        expectedContractualNumberOfWorkedHours, expectedActualNumberOfWorkedHours,
        expectedBonusAndOvertimeEarnings, expectedHourlyEarnings);

    assertFalse(testHourlyEmployee.equals(otherHourlyEmployee));
  }

  @Test
  void testEquals_DifferentContactInfo() {
    ContactInfo differentContactInfo = new ContactInfo(new Name("Alice", "Jones"), "456 Oak St", "555-5678", new Name("Bob", "Johnson"));

    HourlyEmployee otherHourlyEmployee = new HourlyEmployee(expectedEmployeeId, differentContactInfo, expectedEmploymentDate,
        expectedEducationLevel, expectedEmploymentLevel, expectedLastYearEarning,
        expectedContractualNumberOfWorkedHours, expectedActualNumberOfWorkedHours,
        expectedBonusAndOvertimeEarnings, expectedHourlyEarnings);

    assertFalse(testHourlyEmployee.equals(otherHourlyEmployee));
  }

  @Test
  void testEquals_DifferentEmploymentDate() {
    HourlyEmployee otherHourlyEmployee = new HourlyEmployee(expectedEmployeeId, expectedContactInfo, LocalDate.of(2023, 2, 1),
        expectedEducationLevel, expectedEmploymentLevel, expectedLastYearEarning,
        expectedContractualNumberOfWorkedHours, expectedActualNumberOfWorkedHours,
        expectedBonusAndOvertimeEarnings, expectedHourlyEarnings);

    assertFalse(testHourlyEmployee.equals(otherHourlyEmployee));
  }
  @Test
  void testEquals_DifferentEducationLevel() {
    HourlyEmployee otherHourlyEmployee = new HourlyEmployee(expectedEmployeeId, expectedContactInfo, expectedEmploymentDate,
        EducationLevel.Masters_Degree, expectedEmploymentLevel, expectedLastYearEarning,
        expectedContractualNumberOfWorkedHours, expectedActualNumberOfWorkedHours,
        expectedBonusAndOvertimeEarnings, expectedHourlyEarnings);

    assertFalse(testHourlyEmployee.equals(otherHourlyEmployee));
  }

  @Test
  void testEquals_DifferentEmploymentLevel() {
    HourlyEmployee otherHourlyEmployee = new HourlyEmployee(expectedEmployeeId, expectedContactInfo, expectedEmploymentDate,
        expectedEducationLevel, EmploymentLevel.Entry_Level, expectedLastYearEarning,
        expectedContractualNumberOfWorkedHours, expectedActualNumberOfWorkedHours,
        expectedBonusAndOvertimeEarnings, expectedHourlyEarnings);

    assertFalse(testHourlyEmployee.equals(otherHourlyEmployee));
  }

  @Test
  void testEquals_DifferentLastYearEarning() {
    HourlyEmployee otherHourlyEmployee = new HourlyEmployee(expectedEmployeeId, expectedContactInfo, expectedEmploymentDate,
        expectedEducationLevel, expectedEmploymentLevel, 80000.0,
        expectedContractualNumberOfWorkedHours, expectedActualNumberOfWorkedHours,
        expectedBonusAndOvertimeEarnings, expectedHourlyEarnings);

    assertFalse(testHourlyEmployee.equals(otherHourlyEmployee));
  }




  @Test
  void testEquals_SameObjects() {
    assertEquals(testHourlyEmployee, testHourlyEmployee);
  }

  @Test
  void testEquals_NullComparison() {
    assertFalse(testHourlyEmployee.equals(null));
  }

  @Test
  void testEquals_DifferentDataType() {
    assertFalse(testHourlyEmployee.equals("String"));
  }

  @Test
  void testEquals_DifferentObject() {
    HourlyEmployee otherHourlyEmployee = new HourlyEmployee("456", expectedContactInfo, expectedEmploymentDate,
        expectedEducationLevel, expectedEmploymentLevel, expectedLastYearEarning,
        expectedContractualNumberOfWorkedHours, expectedActualNumberOfWorkedHours,
        expectedBonusAndOvertimeEarnings, expectedHourlyEarnings);

    assertFalse(testHourlyEmployee.equals(otherHourlyEmployee));
  }

  @Test
  void testEquals_DifferentObjectSameValues() {
    HourlyEmployee otherHourlyEmployee = new HourlyEmployee(expectedEmployeeId, expectedContactInfo, expectedEmploymentDate,
        expectedEducationLevel, expectedEmploymentLevel, expectedLastYearEarning,
        expectedContractualNumberOfWorkedHours, expectedActualNumberOfWorkedHours,
        expectedBonusAndOvertimeEarnings, expectedHourlyEarnings);

    assertTrue(testHourlyEmployee.equals(otherHourlyEmployee));
  }

  @Test
  void testEquals_DifferentHourlyEarnings() {
    HourlyEmployee otherHourlyEmployee = new HourlyEmployee(expectedEmployeeId, expectedContactInfo, expectedEmploymentDate,
        expectedEducationLevel, expectedEmploymentLevel, expectedLastYearEarning,
        expectedContractualNumberOfWorkedHours, expectedActualNumberOfWorkedHours,
        expectedBonusAndOvertimeEarnings, 15.0);

    assertFalse(testHourlyEmployee.equals(otherHourlyEmployee));
  }

  @Test
  void testHashCode() {
    int expectedHashCode = Objects.hash(expectedHourlyEarnings, expectedContractualNumberOfWorkedHours,
        expectedActualNumberOfWorkedHours, expectedBonusAndOvertimeEarnings, expectedEmployeeId,
        expectedContactInfo, expectedEmploymentDate, expectedEducationLevel, expectedEmploymentLevel,
        expectedLastYearEarning);
    assertEquals(expectedHashCode, testHourlyEmployee.hashCode());
  }

  @Test
  void testToString() {
    String expectedStr = "HourlyEmployee{" +
        "hourlyEarnings=" + expectedHourlyEarnings +
        ", theContractualNumberOfWorkedHours=" + expectedContractualNumberOfWorkedHours +
        ", theActualNumberOfWorkedHours=" + expectedActualNumberOfWorkedHours +
        ", bonusAndOvertimeEarnings=" + expectedBonusAndOvertimeEarnings +
        ", employeeId='" + expectedEmployeeId + '\'' +
        ", contactInfo=" + expectedContactInfo +
        ", employmentDate=" + expectedEmploymentDate +
        ", educationLevel=" + expectedEducationLevel +
        ", employmentLevel=" + expectedEmploymentLevel +
        ", lastYearEarning=" + expectedLastYearEarning +
        '}';
    assertEquals(expectedStr, testHourlyEmployee.toString());
  }

  @Test
  void testEstimateProductivity_BonusApplied() {
    // Test when hourly earnings is less than Hourly_Earnings_Bonus_Benchmark, bonus should be applied
    HourlyEmployee employeeWithBonus = new HourlyEmployee(
        expectedEmployeeId, expectedContactInfo, expectedEmploymentDate,
        expectedEducationLevel, expectedEmploymentLevel, expectedLastYearEarning,
        expectedContractualNumberOfWorkedHours, expectedActualNumberOfWorkedHours,
        expectedBonusAndOvertimeEarnings, 10.0);

    Double expectedProductivityWithBonus = employeeWithBonus.estimateProductivity();
    assertEquals(expectedProductivityWithBonus, testHourlyEmployee.estimateProductivity());
  }

  @Test
  void testEstimateProductivity_BonusNotApplied() {
    // Test when hourly earnings is greater than or equal to Hourly_Earnings_Bonus_Benchmark, bonus should not be applied
    HourlyEmployee employeeWithoutBonus = new HourlyEmployee(
        expectedEmployeeId, expectedContactInfo, expectedEmploymentDate,
        expectedEducationLevel, expectedEmploymentLevel, expectedLastYearEarning,
        expectedContractualNumberOfWorkedHours, expectedActualNumberOfWorkedHours,
        expectedBonusAndOvertimeEarnings, 15.0);

    Double expectedProductivityWithoutBonus = employeeWithoutBonus.estimateProductivity();
    assertEquals(expectedProductivityWithoutBonus, testHourlyEmployee.estimateProductivity() - Hourly_Earnings_Bonus, 0.001);
  }
}
