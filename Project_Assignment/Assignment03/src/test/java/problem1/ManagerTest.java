package problem1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ManagerTest {

  private Manager testManager;
  private String expectedEmployeeId;
  private ContactInfo expectedContactInfo;
  private LocalDate expectedEmploymentDate;
  private EducationLevel expectedEducationLevel;
  private EmploymentLevel expectedEmploymentLevel;
  private EmploymentLevel expectedEmploymentLevel1;
  private Double expectedLastYearEarning;
  private Double expectedBasePay;
  private Double expectedBonuses;
  private Double expectedOverTime;
  private LocalDate expectedDateOfTheLastPromotion;
  private Integer expectedNumberOfProjects;
  private Integer expectedNumberOfEmployeesTheyManage;
  private Integer expectedNumberOfEmployeesTheyManage1;
  private static final Double Manager_Bonus = 1.8;
  private static final Integer Last_Promotion_Penalty_Year = 3;
  private static final Double Last_Promotion_Penalty = -0.8;
  private static final Integer Number_Of_Projects_Benchmark = 2;
  private static final Double Number_Of_Projects_Bonus = 1.5;

  @BeforeEach
  void setUp() {
    expectedEmployeeId = "123";
    expectedContactInfo = new ContactInfo(new Name("John", "Doe"), "123 Main St", "555-1234", new Name("Jane", "Smith"));
    expectedEmploymentDate = LocalDate.of(2023, 1, 2);
    expectedEducationLevel = EducationLevel.Bachelors_Degree;
    expectedEmploymentLevel1 = EmploymentLevel.Intermediate_Level;
    expectedEmploymentLevel = EmploymentLevel.Senior_Level;
    expectedLastYearEarning = 75000.0;
    expectedBasePay = 60000.0;
    expectedBonuses = 5000.0;
    expectedOverTime = 2000.0;
    expectedDateOfTheLastPromotion = LocalDate.of(2023, 6, 1);
    expectedNumberOfProjects = 3;
    expectedNumberOfEmployeesTheyManage = 10;
    expectedNumberOfEmployeesTheyManage1 = 7;


    testManager = new Manager(expectedEmployeeId, expectedContactInfo, expectedEmploymentDate,
        expectedEducationLevel, expectedEmploymentLevel, expectedLastYearEarning,
        expectedBasePay, expectedBonuses, expectedOverTime, expectedDateOfTheLastPromotion,
        expectedNumberOfProjects, expectedNumberOfEmployeesTheyManage);
  }

  @Test
  void testEstimateProductivity_NumberOfProjectsBonus() {
    // Set the number of projects to a value greater than the benchmark
    int projectsAboveBenchmark = Number_Of_Projects_Benchmark + 1;
    Manager managerWithBonus = new Manager(expectedEmployeeId, expectedContactInfo, expectedEmploymentDate,
        expectedEducationLevel, expectedEmploymentLevel, expectedLastYearEarning,
        expectedBasePay, expectedBonuses, expectedOverTime, expectedDateOfTheLastPromotion,
        projectsAboveBenchmark, expectedNumberOfEmployeesTheyManage);

    double expectedProductivityWithBonus = testManager.estimateProductivity();

    assertEquals(expectedProductivityWithBonus, managerWithBonus.estimateProductivity());
  }

  @Test
  void testEstimateProductivity_NoNumberOfProjectsBonus() {
    // Set the number of projects to a value less than or equal to the benchmark
    int projectsBelowBenchmark = Number_Of_Projects_Benchmark - 1;
    Manager managerWithoutBonus = new Manager(expectedEmployeeId, expectedContactInfo, expectedEmploymentDate,
        expectedEducationLevel, expectedEmploymentLevel, expectedLastYearEarning,
        expectedBasePay, expectedBonuses, expectedOverTime, expectedDateOfTheLastPromotion,
        projectsBelowBenchmark, expectedNumberOfEmployeesTheyManage);

    // Calculate the expected productivity without the number of projects bonus
    double expectedProductivityWithoutBonus = testManager.estimateProductivity() - Number_Of_Projects_Bonus;

    assertEquals(expectedProductivityWithoutBonus, managerWithoutBonus.estimateProductivity());
  }

  @Test
  void testEstimateProductivity_LastPromotionPenalty() {
    // Set the last promotion date to be before the penalty year
    LocalDate lastPromotionDate = LocalDate.now().minusYears(Last_Promotion_Penalty_Year).minusDays(1);
    Manager managerWithPenalty = new Manager(expectedEmployeeId, expectedContactInfo, expectedEmploymentDate,
        expectedEducationLevel, expectedEmploymentLevel, expectedLastYearEarning,
        expectedBasePay, expectedBonuses, expectedOverTime, lastPromotionDate,
        expectedNumberOfProjects, expectedNumberOfEmployeesTheyManage);

    // Calculate the expected productivity with the last promotion penalty
    double expectedProductivityWithPenalty = testManager.estimateProductivity() - Last_Promotion_Penalty;

    assertEquals(expectedProductivityWithPenalty, managerWithPenalty.estimateProductivity());
  }

  @Test
  void testEstimateProductivity_NoLastPromotionPenalty() {
    // Set the last promotion date to be within the penalty year
    LocalDate lastPromotionDate = LocalDate.now().minusYears(Last_Promotion_Penalty_Year).plusDays(1);
    Manager managerWithoutPenalty = new Manager(expectedEmployeeId, expectedContactInfo, expectedEmploymentDate,
        expectedEducationLevel, expectedEmploymentLevel, expectedLastYearEarning,
        expectedBasePay, expectedBonuses, expectedOverTime, lastPromotionDate,
        expectedNumberOfProjects, expectedNumberOfEmployeesTheyManage);

    // Calculate the expected productivity without the last promotion penalty
    double expectedProductivityWithoutPenalty = testManager.estimateProductivity();

    assertEquals(expectedProductivityWithoutPenalty, managerWithoutPenalty.estimateProductivity());
  }



  @Test
  void getTheNumberOfEmployeesTheyManage() {
    assertEquals(expectedNumberOfEmployeesTheyManage, testManager.getTheNumberOfEmployeesTheyManage());
  }

  @Test
  void estimateProductivity_ManagerBonus() {
    // Test when the manager manages more than 8 employees (Manager_Bonus_Employee)
    Manager managerWithBonus = new Manager(
        expectedEmployeeId, expectedContactInfo, expectedEmploymentDate,
        expectedEducationLevel, expectedEmploymentLevel, expectedLastYearEarning,
        expectedBasePay, expectedBonuses, expectedOverTime, expectedDateOfTheLastPromotion,
        expectedNumberOfProjects, expectedNumberOfEmployeesTheyManage);

    Double expectedProductivityWithBonus = managerWithBonus.estimateProductivity();
    assertEquals(expectedProductivityWithBonus, testManager.estimateProductivity());
  }

  @Test
  void estimateProductivity_NoManagerBonus() {
    // Test when the manager manages less than or equal to 8 employees (Manager_Bonus_Employee)
    Manager managerWithoutBonus = new Manager(
        expectedEmployeeId, expectedContactInfo, expectedEmploymentDate,
        expectedEducationLevel, expectedEmploymentLevel, expectedLastYearEarning,
        expectedBasePay, expectedBonuses, expectedOverTime, expectedDateOfTheLastPromotion,
        expectedNumberOfProjects, expectedNumberOfEmployeesTheyManage1);

    Double expectedProductivityWithoutBonus = managerWithoutBonus.estimateProductivity();
    assertEquals(expectedProductivityWithoutBonus, testManager.estimateProductivity() - Manager_Bonus);
  }

  @Test
  void testEquals_SameObjects() {
    assertEquals(testManager, testManager);
  }

  @Test
  void testEquals_NullComparison() {
    assertFalse(testManager.equals(null));
  }

  @Test
  void testEquals_DifferentDataType() {
    assertFalse(testManager.equals("String"));
  }

  @Test
  void testEquals_DifferentObject() {
    Manager otherManager = new Manager("456", expectedContactInfo, expectedEmploymentDate,
        expectedEducationLevel, expectedEmploymentLevel, expectedLastYearEarning,
        expectedBasePay, expectedBonuses, expectedOverTime, expectedDateOfTheLastPromotion,
        expectedNumberOfProjects, 9);

    assertFalse(testManager.equals(otherManager));
  }

  @Test
  void testEquals_DifferentObjectSameValues() {
    Manager otherManager = new Manager(expectedEmployeeId, expectedContactInfo, expectedEmploymentDate,
        expectedEducationLevel, expectedEmploymentLevel, expectedLastYearEarning,
        expectedBasePay, expectedBonuses, expectedOverTime, expectedDateOfTheLastPromotion,
        expectedNumberOfProjects, expectedNumberOfEmployeesTheyManage);

    assertTrue(testManager.equals(otherManager));
  }
  @Test
  void testEquals_DifferentExpectedEmployeeId() {
    Manager otherManager = new Manager("456", expectedContactInfo, expectedEmploymentDate,
        expectedEducationLevel, expectedEmploymentLevel, expectedLastYearEarning,
        expectedBasePay, expectedBonuses, expectedOverTime, expectedDateOfTheLastPromotion,
        expectedNumberOfProjects, expectedNumberOfEmployeesTheyManage);

    assertFalse(testManager.equals(otherManager));
  }

  @Test
  void testEquals_DifferentContactInfo() {
    Manager otherManager = new Manager(expectedEmployeeId, new ContactInfo(new Name("Jane", "Doe"), "456 Oak St", "555-5678", new Name("John", "Smith")),
        expectedEmploymentDate, expectedEducationLevel, expectedEmploymentLevel, expectedLastYearEarning,
        expectedBasePay, expectedBonuses, expectedOverTime, expectedDateOfTheLastPromotion,
        expectedNumberOfProjects, expectedNumberOfEmployeesTheyManage);

    assertFalse(testManager.equals(otherManager));
  }

  @Test
  void testEquals_DifferentEmploymentDate() {
    Manager otherManager = new Manager(expectedEmployeeId, expectedContactInfo, LocalDate.of(2022, 1, 1),
        expectedEducationLevel, expectedEmploymentLevel, expectedLastYearEarning,
        expectedBasePay, expectedBonuses, expectedOverTime, expectedDateOfTheLastPromotion,
        expectedNumberOfProjects, expectedNumberOfEmployeesTheyManage);

    assertFalse(testManager.equals(otherManager));
  }
  @Test
  void testEquals_DifferentEducationLevel() {
    Manager otherManager = new Manager(expectedEmployeeId, expectedContactInfo, expectedEmploymentDate,
        EducationLevel.Masters_Degree, expectedEmploymentLevel, expectedLastYearEarning,
        expectedBasePay, expectedBonuses, expectedOverTime, expectedDateOfTheLastPromotion,
        expectedNumberOfProjects, expectedNumberOfEmployeesTheyManage);

    assertFalse(testManager.equals(otherManager));
  }

  @Test
  void testEquals_DifferentEmploymentLevel() {
    Manager otherManager = new Manager(expectedEmployeeId, expectedContactInfo, expectedEmploymentDate,
        expectedEducationLevel, EmploymentLevel.Intermediate_Level, expectedLastYearEarning,
        expectedBasePay, expectedBonuses, expectedOverTime, expectedDateOfTheLastPromotion,
        expectedNumberOfProjects, expectedNumberOfEmployeesTheyManage);

    assertFalse(testManager.equals(otherManager));
  }

  @Test
  void testEquals_DifferentLastYearEarning() {
    Manager otherManager = new Manager(expectedEmployeeId, expectedContactInfo, expectedEmploymentDate,
        expectedEducationLevel, expectedEmploymentLevel, 80000.0,
        expectedBasePay, expectedBonuses, expectedOverTime, expectedDateOfTheLastPromotion,
        expectedNumberOfProjects, expectedNumberOfEmployeesTheyManage);

    assertFalse(testManager.equals(otherManager));
  }

  @Test
  void testEquals_DifferentBasePay() {
    Manager otherManager = new Manager(expectedEmployeeId, expectedContactInfo, expectedEmploymentDate,
        expectedEducationLevel, expectedEmploymentLevel, expectedLastYearEarning,
        65000.0, expectedBonuses, expectedOverTime, expectedDateOfTheLastPromotion,
        expectedNumberOfProjects, expectedNumberOfEmployeesTheyManage);

    assertFalse(testManager.equals(otherManager));
  }


  @Test
  void testEquals_DifferentBonuses() {
    Manager otherManager = new Manager(expectedEmployeeId, expectedContactInfo, expectedEmploymentDate,
        expectedEducationLevel, expectedEmploymentLevel, expectedLastYearEarning,
        expectedBasePay, 6000.0, expectedOverTime, expectedDateOfTheLastPromotion,
        expectedNumberOfProjects, expectedNumberOfEmployeesTheyManage);

    assertFalse(testManager.equals(otherManager));
  }

  @Test
  void testEquals_DifferentOverTime() {
    Manager otherManager = new Manager(expectedEmployeeId, expectedContactInfo, expectedEmploymentDate,
        expectedEducationLevel, expectedEmploymentLevel, expectedLastYearEarning,
        expectedBasePay, expectedBonuses, 2500.0, expectedDateOfTheLastPromotion,
        expectedNumberOfProjects, expectedNumberOfEmployeesTheyManage);

    assertFalse(testManager.equals(otherManager));
  }

  @Test
  void testEquals_DifferentDateOfTheLastPromotion() {
    Manager otherManager = new Manager(expectedEmployeeId, expectedContactInfo, expectedEmploymentDate,
        expectedEducationLevel, expectedEmploymentLevel, expectedLastYearEarning,
        expectedBasePay, expectedBonuses, expectedOverTime, LocalDate.of(2022, 6, 1),
        expectedNumberOfProjects, expectedNumberOfEmployeesTheyManage);

    assertFalse(testManager.equals(otherManager));
  }

  @Test
  void testEquals_DifferentNumberOfProjects() {
    Manager otherManager = new Manager(expectedEmployeeId, expectedContactInfo, expectedEmploymentDate,
        expectedEducationLevel, expectedEmploymentLevel, expectedLastYearEarning,
        expectedBasePay, expectedBonuses, expectedOverTime, expectedDateOfTheLastPromotion,
        4, expectedNumberOfEmployeesTheyManage);

    assertFalse(testManager.equals(otherManager));
  }

  @Test
  void testEquals_DifferentNumberOfEmployeesTheyManage() {
    Manager otherManager = new Manager(expectedEmployeeId, expectedContactInfo, expectedEmploymentDate,
        expectedEducationLevel, expectedEmploymentLevel, expectedLastYearEarning,
        expectedBasePay, expectedBonuses, expectedOverTime, expectedDateOfTheLastPromotion,
        expectedNumberOfProjects, 15);

    assertFalse(testManager.equals(otherManager));
  }


  @Test
  void testHashCode() {
    int expectedHashCode = Objects.hash(expectedNumberOfEmployeesTheyManage, expectedBasePay, expectedBonuses,
        expectedOverTime, expectedDateOfTheLastPromotion, expectedNumberOfProjects, expectedEmployeeId,
        expectedContactInfo, expectedEmploymentDate, expectedEducationLevel, expectedEmploymentLevel,
        expectedLastYearEarning);
    assertEquals(expectedHashCode, testManager.hashCode());
  }

  @Test
  void testToString() {
    String expectedStr = "Manager{" +
        "theNumberOfEmployeesTheyManage=" + expectedNumberOfEmployeesTheyManage +
        ", basePay=" + expectedBasePay +
        ", bonuses=" + expectedBonuses +
        ", overTime=" + expectedOverTime +
        ", dateOfTheLastPromotion=" + expectedDateOfTheLastPromotion +
        ", numberOfProjects=" + expectedNumberOfProjects +
        ", employeeId='" + expectedEmployeeId + '\'' +
        ", contactInfo=" + expectedContactInfo +
        ", employmentDate=" + expectedEmploymentDate +
        ", educationLevel=" + expectedEducationLevel +
        ", employmentLevel=" + expectedEmploymentLevel +
        ", lastYearEarning=" + expectedLastYearEarning +
        '}';
    assertEquals(expectedStr, testManager.toString());
  }
}
