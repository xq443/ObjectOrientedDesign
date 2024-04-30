package problem1;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Represents an Individual Contributor, extending the FullTimeEmployee class.
 * Contains attributes specific to individual contributors and methods for comparison and productivity estimation.
 */
public class IndividualContributor extends FullTimeEmployee {

  /** The number of patents held by the individual contributor. */
  private Integer theNumberOfPatents;

  /** The number of publications authored by the individual contributor. */
  private Integer theNumberOfPublications;

  /** The number of external collaborations participated in by the individual contributor. */
  private Integer theNumberOfExternalCollaborations;

  /** Bonus applied for individual contributors. */
  private static final Double Individual_Contributor_Bonus = 1.3;

  /** Bonus applied based on the number of publications for individual contributors. */
  private static final Integer Individual_Contributor_Bonus_Publications = 4;

  /**
   * Constructs a new IndividualContributor with the specified attributes.
   *
   * @param employeeId                       The ID of the individual contributor.
   * @param contactInfo                      The contact information of the individual contributor.
   * @param employmentDate                   The date of employment.
   * @param educationLevel                   The education level of the individual contributor.
   * @param employmentLevel                  The employment level of the individual contributor.
   * @param lastYearEarning                   The last year's earnings of the individual contributor.
   * @param basePay                           The base pay of the individual contributor.
   * @param bonuses                           The bonuses received by the individual contributor.
   * @param overTime                          The overtime hours worked by the individual contributor.
   * @param dateOfTheLastPromotion           The date of the last promotion.
   * @param numberOfProjects                 The number of projects completed by the individual contributor.
   * @param theNumberOfPatents               The number of patents held by the individual contributor.
   * @param theNumberOfPublications          The number of publications authored by the individual contributor.
   * @param theNumberOfExternalCollaborations The number of external collaborations participated in.
   */
  public IndividualContributor(String employeeId, ContactInfo contactInfo,
      LocalDate employmentDate, EducationLevel educationLevel,
      EmploymentLevel employmentLevel, Double lastYearEarning,
      Double basePay, Double bonuses, Double overTime,
      LocalDate dateOfTheLastPromotion, Integer numberOfProjects,
      Integer theNumberOfPatents, Integer theNumberOfPublications,
      Integer theNumberOfExternalCollaborations) {
    super(employeeId, contactInfo, employmentDate, educationLevel, employmentLevel, lastYearEarning,
        basePay, bonuses, overTime, dateOfTheLastPromotion, numberOfProjects);
    this.theNumberOfPatents = theNumberOfPatents;
    this.theNumberOfPublications = theNumberOfPublications;
    this.theNumberOfExternalCollaborations = theNumberOfExternalCollaborations;
  }

  /**
   * Gets the number of patents held by the individual contributor.
   *
   * @return The number of patents.
   */
  public Integer getTheNumberOfPatents() {
    return theNumberOfPatents;
  }

  /**
   * Gets the number of publications authored by the individual contributor.
   *
   * @return The number of publications.
   */
  public Integer getTheNumberOfPublications() {
    return theNumberOfPublications;
  }

  /**
   * Gets the number of external collaborations participated in by the individual contributor.
   *
   * @return The number of external collaborations.
   */
  public Integer getTheNumberOfExternalCollaborations() {
    return theNumberOfExternalCollaborations;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IndividualContributor individualContributor = (IndividualContributor) o;
    return Objects.equals(this.theNumberOfPatents, individualContributor.theNumberOfPatents)
        && Objects.equals(this.theNumberOfPublications, individualContributor.theNumberOfPublications)
        && Objects.equals(this.theNumberOfExternalCollaborations,
        individualContributor.theNumberOfExternalCollaborations)
        && Objects.equals(this.basePay, individualContributor.basePay)
        && Objects.equals(this.bonuses, individualContributor.bonuses)
        && Objects.equals(this.overTime, individualContributor.overTime)
        && Objects.equals(this.dateOfTheLastPromotion, individualContributor.dateOfTheLastPromotion)
        && Objects.equals(this.numberOfProjects, individualContributor.numberOfProjects)
        && Objects.equals(this.employeeId, individualContributor.employeeId)
        && Objects.equals(this.contactInfo,individualContributor.contactInfo)
        && Objects.equals(this.employmentDate, individualContributor.employmentDate)
        && Objects.equals(this.educationLevel, individualContributor.educationLevel)
        && Objects.equals(this.employmentLevel, individualContributor.employmentLevel)
        && Objects.equals(this.lastYearEarning, individualContributor.lastYearEarning);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.theNumberOfPatents, this.theNumberOfPublications,
        this.theNumberOfExternalCollaborations, this.basePay, this.bonuses,
        this.overTime, this.dateOfTheLastPromotion,this.numberOfProjects, this.employeeId,
        this.contactInfo, this.employmentDate, this.educationLevel, this.employmentLevel,
        this.lastYearEarning);
  }

  @Override
  public String toString() {
    return "IndividualContributor{" +
        "theNumberOfPatents=" + theNumberOfPatents +
        ", theNumberOfPublications=" + theNumberOfPublications +
        ", theNumberOfExternalCollaborations=" + theNumberOfExternalCollaborations +
        ", basePay=" + basePay +
        ", bonuses=" + bonuses +
        ", overTime=" + overTime +
        ", dateOfTheLastPromotion=" + dateOfTheLastPromotion +
        ", numberOfProjects=" + numberOfProjects +
        ", employeeId='" + employeeId + '\'' +
        ", contactInfo=" + contactInfo +
        ", employmentDate=" + employmentDate +
        ", educationLevel=" + educationLevel +
        ", employmentLevel=" + employmentLevel +
        ", lastYearEarning=" + lastYearEarning +
        '}';
  }
  /**
   * Overrides the estimateProductivity method to include specific productivity calculations for individual contributors.
   *
   * @return The estimated productivity of the individual contributor.
   */
  @Override
  public Double estimateProductivity() {
    if (this.theNumberOfPublications > Individual_Contributor_Bonus_Publications) {
      return super.estimateProductivity() + Individual_Contributor_Bonus;
    }
    return super.estimateProductivity();
  }
}
