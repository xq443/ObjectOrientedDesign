package problem1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IndividualContributorTest {

  private IndividualContributor testIndividualContributor;
  private String expectedEmployeeId;
  private ContactInfo expectedContactInfo;
  private LocalDate expectedEmploymentDate;
  private EducationLevel expectedEducationLevel;
  private EmploymentLevel expectedEmploymentLevel;
  private Double expectedLastYearEarning;
  private Double expectedBasePay;
  private Double expectedBonuses;
  private Double expectedOverTime;
  private LocalDate expectedDateOfTheLastPromotion;
  private Integer expectedNumberOfProjects;
  private Integer expectedNumberOfPatents;
  private Integer expectedNumberOfPublications;
  private Integer expectedNumberOfExternalCollaborations;

  private static final Double Individual_Contributor_Bonus = 1.3;

  @BeforeEach
  void setUp() {
    expectedEmployeeId = "123";
    expectedContactInfo = new ContactInfo(new Name("John", "Doe"), "123 Main St", "555-1234", new Name("Jane", "Smith"));
    expectedEmploymentDate = LocalDate.of(2023, 1, 1);
    expectedEducationLevel = EducationLevel.Bachelors_Degree;
    expectedEmploymentLevel = EmploymentLevel.Entry_Level;
    expectedLastYearEarning = 75000.0;
    expectedBasePay = 60000.0;
    expectedBonuses = 5000.0;
    expectedOverTime = 2000.0;
    expectedDateOfTheLastPromotion = LocalDate.of(2023, 6, 1);
    expectedNumberOfProjects = 3;
    expectedNumberOfPatents = 5;
    expectedNumberOfPublications = 3;
    expectedNumberOfExternalCollaborations = 2;

    testIndividualContributor = new IndividualContributor(
        expectedEmployeeId, expectedContactInfo, expectedEmploymentDate,
        expectedEducationLevel, expectedEmploymentLevel, expectedLastYearEarning,
        expectedBasePay, expectedBonuses, expectedOverTime, expectedDateOfTheLastPromotion,
        expectedNumberOfProjects, expectedNumberOfPatents, expectedNumberOfPublications,
        expectedNumberOfExternalCollaborations);
  }

  @Test
  void getTheNumberOfPatents() {
    assertEquals(expectedNumberOfPatents, testIndividualContributor.getTheNumberOfPatents());
  }

  @Test
  void getTheNumberOfPublications() {
    assertEquals(expectedNumberOfPublications, testIndividualContributor.getTheNumberOfPublications());
  }

  @Test
  void getTheNumberOfExternalCollaborations() {
    assertEquals(expectedNumberOfExternalCollaborations, testIndividualContributor.getTheNumberOfExternalCollaborations());
  }
  @Test
  void getEmployeeId() {
    assertEquals(expectedEmployeeId, testIndividualContributor.getEmployeeId());
  }

  @Test
  void getContactInfo() {
    assertEquals(expectedContactInfo, testIndividualContributor.getContactInfo());
  }

  @Test
  void getEmploymentDate() {
    assertEquals(expectedEmploymentDate, testIndividualContributor.getEmploymentDate());
  }

  @Test
  void getEducationLevel() {
    assertEquals(expectedEducationLevel, testIndividualContributor.getEducationLevel());
  }

  @Test
  void getEmploymentLevel() {
    assertEquals(expectedEmploymentLevel, testIndividualContributor.getEmploymentLevel());
  }

  @Test
  void getLastYearEarning() {
    assertEquals(expectedLastYearEarning, testIndividualContributor.getLastYearEarning());
  }

  @Test
  void getBasePay() {
    assertEquals(expectedBasePay, testIndividualContributor.getBasePay());
  }

  @Test
  void getBonuses() {
    assertEquals(expectedBonuses, testIndividualContributor.getBonuses());
  }

  @Test
  void getOverTime() {
    assertEquals(expectedOverTime, testIndividualContributor.getOverTime());
  }

  @Test
  void getDateOfTheLastPromotion() {
    assertEquals(expectedDateOfTheLastPromotion, testIndividualContributor.getDateOfTheLastPromotion());
  }

  @Test
  void getNumberOfProjects() {
    assertEquals(expectedNumberOfProjects, testIndividualContributor.getNumberOfProjects());
  }

  @Test
  void testEquals_SameObjects() {
    assertEquals(testIndividualContributor, testIndividualContributor);
  }

  @Test
  void testEquals_NullComparison() {
    assertFalse(testIndividualContributor.equals(null));
  }

  @Test
  void testEquals_DifferentDataType() {
    assertFalse(testIndividualContributor.equals("String"));
  }

  @Test
  void testEquals_DifferentObject() {
    IndividualContributor otherIndividualContributor = new IndividualContributor(
        "456", expectedContactInfo, expectedEmploymentDate,
        expectedEducationLevel, expectedEmploymentLevel, expectedLastYearEarning,
        expectedBasePay, expectedBonuses, expectedOverTime, expectedDateOfTheLastPromotion,
        expectedNumberOfProjects, expectedNumberOfPatents, expectedNumberOfPublications,
        expectedNumberOfExternalCollaborations + 1);

    assertFalse(testIndividualContributor.equals(otherIndividualContributor));
  }

  @Test
  void testEquals_DifferentObjectSameValues() {
    IndividualContributor otherIndividualContributor = new IndividualContributor(
        expectedEmployeeId, expectedContactInfo, expectedEmploymentDate,
        expectedEducationLevel, expectedEmploymentLevel, expectedLastYearEarning,
        expectedBasePay, expectedBonuses, expectedOverTime, expectedDateOfTheLastPromotion,
        expectedNumberOfProjects, expectedNumberOfPatents, expectedNumberOfPublications,
        expectedNumberOfExternalCollaborations);

    assertTrue(testIndividualContributor.equals(otherIndividualContributor));
  }

  @Test
  void testEquals_DifferentExpectedEmployeeId() {
    IndividualContributor otherIndividualContributor = new IndividualContributor(
        "456", expectedContactInfo, expectedEmploymentDate,
        expectedEducationLevel, expectedEmploymentLevel, expectedLastYearEarning,
        expectedBasePay, expectedBonuses, expectedOverTime, expectedDateOfTheLastPromotion,
        expectedNumberOfProjects, expectedNumberOfPatents, expectedNumberOfPublications,
        expectedNumberOfExternalCollaborations);

    assertFalse(testIndividualContributor.equals(otherIndividualContributor));
  }

  @Test
  void testEquals_DifferentContactInfo() {
    IndividualContributor otherIndividualContributor = new IndividualContributor(
        expectedEmployeeId, new ContactInfo(new Name("Jane", "Doe"), "456 Oak St", "555-5678", new Name("John", "Smith")),
        expectedEmploymentDate, expectedEducationLevel, expectedEmploymentLevel, expectedLastYearEarning,
        expectedBasePay, expectedBonuses, expectedOverTime, expectedDateOfTheLastPromotion,
        expectedNumberOfProjects, expectedNumberOfPatents, expectedNumberOfPublications,
        expectedNumberOfExternalCollaborations);

    assertFalse(testIndividualContributor.equals(otherIndividualContributor));
  }

  @Test
  void testEquals_DifferentEmploymentDate() {
    IndividualContributor otherIndividualContributor = new IndividualContributor(
        expectedEmployeeId, expectedContactInfo, LocalDate.of(2022, 1, 1),
        expectedEducationLevel, expectedEmploymentLevel, expectedLastYearEarning,
        expectedBasePay, expectedBonuses, expectedOverTime, expectedDateOfTheLastPromotion,
        expectedNumberOfProjects, expectedNumberOfPatents, expectedNumberOfPublications,
        expectedNumberOfExternalCollaborations);

    assertFalse(testIndividualContributor.equals(otherIndividualContributor));
  }

  @Test
  void testEquals_DifferentEducationLevel() {
    IndividualContributor otherIndividualContributor = new IndividualContributor(
        expectedEmployeeId, expectedContactInfo, expectedEmploymentDate,
        EducationLevel.Masters_Degree, expectedEmploymentLevel, expectedLastYearEarning,
        expectedBasePay, expectedBonuses, expectedOverTime, expectedDateOfTheLastPromotion,
        expectedNumberOfProjects, expectedNumberOfPatents, expectedNumberOfPublications,
        expectedNumberOfExternalCollaborations);

    assertFalse(testIndividualContributor.equals(otherIndividualContributor));
  }

  @Test
  void testEquals_DifferentEmploymentLevel() {
    IndividualContributor otherIndividualContributor = new IndividualContributor(
        expectedEmployeeId, expectedContactInfo, expectedEmploymentDate,
        expectedEducationLevel, EmploymentLevel.Intermediate_Level, expectedLastYearEarning,
        expectedBasePay, expectedBonuses, expectedOverTime, expectedDateOfTheLastPromotion,
        expectedNumberOfProjects, expectedNumberOfPatents, expectedNumberOfPublications,
        expectedNumberOfExternalCollaborations);

    assertFalse(testIndividualContributor.equals(otherIndividualContributor));
  }

  @Test
  void testEquals_DifferentLastYearEarning() {
    IndividualContributor otherIndividualContributor = new IndividualContributor(
        expectedEmployeeId, expectedContactInfo, expectedEmploymentDate,
        expectedEducationLevel, expectedEmploymentLevel, 80000.0,
        expectedBasePay, expectedBonuses, expectedOverTime, expectedDateOfTheLastPromotion,
        expectedNumberOfProjects, expectedNumberOfPatents, expectedNumberOfPublications,
        expectedNumberOfExternalCollaborations);

    assertFalse(testIndividualContributor.equals(otherIndividualContributor));
  }

  @Test
  void testEquals_DifferentBasePay() {
    IndividualContributor otherIndividualContributor = new IndividualContributor(
        expectedEmployeeId, expectedContactInfo, expectedEmploymentDate,
        expectedEducationLevel, expectedEmploymentLevel, expectedLastYearEarning,
        65000.0, expectedBonuses, expectedOverTime, expectedDateOfTheLastPromotion,
        expectedNumberOfProjects, expectedNumberOfPatents, expectedNumberOfPublications,
        expectedNumberOfExternalCollaborations);

    assertFalse(testIndividualContributor.equals(otherIndividualContributor));
  }

  @Test
  void testEquals_DifferentBonuses() {
    IndividualContributor otherIndividualContributor = new IndividualContributor(
        expectedEmployeeId, expectedContactInfo, expectedEmploymentDate,
        expectedEducationLevel, expectedEmploymentLevel, expectedLastYearEarning,
        expectedBasePay, 6000.0, expectedOverTime, expectedDateOfTheLastPromotion,
        expectedNumberOfProjects, expectedNumberOfPatents, expectedNumberOfPublications,
        expectedNumberOfExternalCollaborations);

    assertFalse(testIndividualContributor.equals(otherIndividualContributor));
  }

  @Test
  void testEquals_DifferentOverTime() {
    IndividualContributor otherIndividualContributor = new IndividualContributor(
        expectedEmployeeId, expectedContactInfo, expectedEmploymentDate,
        expectedEducationLevel, expectedEmploymentLevel, expectedLastYearEarning,
        expectedBasePay, expectedBonuses, 2500.0, expectedDateOfTheLastPromotion,
        expectedNumberOfProjects, expectedNumberOfPatents, expectedNumberOfPublications,
        expectedNumberOfExternalCollaborations);

    assertFalse(testIndividualContributor.equals(otherIndividualContributor));
  }

  @Test
  void testEquals_DifferentDateOfTheLastPromotion() {
    IndividualContributor otherIndividualContributor = new IndividualContributor(
        expectedEmployeeId, expectedContactInfo, expectedEmploymentDate,
        expectedEducationLevel, expectedEmploymentLevel, expectedLastYearEarning,
        expectedBasePay, expectedBonuses, expectedOverTime, LocalDate.of(2022, 6, 1),
        expectedNumberOfProjects, expectedNumberOfPatents, expectedNumberOfPublications,
        expectedNumberOfExternalCollaborations);

    assertFalse(testIndividualContributor.equals(otherIndividualContributor));
  }

  @Test
  void testEquals_DifferentNumberOfProjects() {
    IndividualContributor otherIndividualContributor = new IndividualContributor(
        expectedEmployeeId, expectedContactInfo, expectedEmploymentDate,
        expectedEducationLevel, expectedEmploymentLevel, expectedLastYearEarning,
        expectedBasePay, expectedBonuses, expectedOverTime, expectedDateOfTheLastPromotion,
        4, expectedNumberOfPatents, expectedNumberOfPublications,
        expectedNumberOfExternalCollaborations);

    assertFalse(testIndividualContributor.equals(otherIndividualContributor));
  }

  @Test
  void testEquals_DifferentNumberOfPatents() {
    IndividualContributor otherIndividualContributor = new IndividualContributor(
        expectedEmployeeId, expectedContactInfo, expectedEmploymentDate,
        expectedEducationLevel, expectedEmploymentLevel, expectedLastYearEarning,
        expectedBasePay, expectedBonuses, expectedOverTime, expectedDateOfTheLastPromotion,
        expectedNumberOfProjects, 7, expectedNumberOfPublications,
        expectedNumberOfExternalCollaborations);

    assertFalse(testIndividualContributor.equals(otherIndividualContributor));
  }

  @Test
  void testEquals_DifferentNumberOfPublications() {
    IndividualContributor otherIndividualContributor = new IndividualContributor(
        expectedEmployeeId, expectedContactInfo, expectedEmploymentDate,
        expectedEducationLevel, expectedEmploymentLevel, expectedLastYearEarning,
        expectedBasePay, expectedBonuses, expectedOverTime, expectedDateOfTheLastPromotion,
        expectedNumberOfProjects, expectedNumberOfPatents, 5,
        expectedNumberOfExternalCollaborations);

    assertFalse(testIndividualContributor.equals(otherIndividualContributor));
  }

  @Test
  void testEquals_DifferentNumberOfExternalCollaborations() {
    IndividualContributor otherIndividualContributor = new IndividualContributor(
        expectedEmployeeId, expectedContactInfo, expectedEmploymentDate,
        expectedEducationLevel, expectedEmploymentLevel, expectedLastYearEarning,
        expectedBasePay, expectedBonuses, expectedOverTime, expectedDateOfTheLastPromotion,
        expectedNumberOfProjects, expectedNumberOfPatents, expectedNumberOfPublications,
        expectedNumberOfExternalCollaborations + 1);

    assertFalse(testIndividualContributor.equals(otherIndividualContributor));
  }

  @Test
  void testHashCode() {
    IndividualContributor sameIndividualContributor = new IndividualContributor(
        expectedEmployeeId, expectedContactInfo, expectedEmploymentDate,
        expectedEducationLevel, expectedEmploymentLevel, expectedLastYearEarning,
        expectedBasePay, expectedBonuses, expectedOverTime, expectedDateOfTheLastPromotion,
        expectedNumberOfProjects, expectedNumberOfPatents, expectedNumberOfPublications,
        expectedNumberOfExternalCollaborations);

    assertEquals(testIndividualContributor.hashCode(), sameIndividualContributor.hashCode());
  }

  @Test
  void testToString() {
    String expectedToString = "IndividualContributor{" +
        "theNumberOfPatents=" + expectedNumberOfPatents +
        ", theNumberOfPublications=" + expectedNumberOfPublications +
        ", theNumberOfExternalCollaborations=" + expectedNumberOfExternalCollaborations +
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

    assertEquals(expectedToString, testIndividualContributor.toString());
  }

  @Test
  void testEstimateProductivity_WithBonus() {
    // Test when the number of publications is greater than 4, bonus should be applied
    IndividualContributor contributorWithBonus = new IndividualContributor(
        expectedEmployeeId, expectedContactInfo, expectedEmploymentDate,
        expectedEducationLevel, expectedEmploymentLevel, expectedLastYearEarning,
        expectedBasePay, expectedBonuses, expectedOverTime, expectedDateOfTheLastPromotion,
        expectedNumberOfProjects, expectedNumberOfPatents, 5,
        expectedNumberOfExternalCollaborations);

    Double expectedProductivityWithBonus = contributorWithBonus.estimateProductivity();
    assertEquals(expectedProductivityWithBonus, testIndividualContributor.estimateProductivity() +  + Individual_Contributor_Bonus);
  }
  @Test
  void testEstimateProductivity_WithoutBonus() {
    // Test when the number of publications is less than or equal to 4, bonus should not be applied
    IndividualContributor contributorWithoutBonus = new IndividualContributor(
        expectedEmployeeId, expectedContactInfo, expectedEmploymentDate,
        expectedEducationLevel, expectedEmploymentLevel, expectedLastYearEarning,
        expectedBasePay, expectedBonuses, expectedOverTime, expectedDateOfTheLastPromotion,
        expectedNumberOfProjects, expectedNumberOfPatents, 3,
        expectedNumberOfExternalCollaborations);

    Double expectedProductivityWithoutBonus = contributorWithoutBonus.estimateProductivity();
    assertEquals(expectedProductivityWithoutBonus, testIndividualContributor.estimateProductivity());
  }

}
