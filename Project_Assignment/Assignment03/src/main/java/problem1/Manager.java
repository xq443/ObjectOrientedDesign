package problem1;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Represents a Manager, extending the FullTimeEmployee class.
 * Contains attributes specific to managers and methods for comparison and productivity estimation.
 */
public class Manager extends FullTimeEmployee {

  /** The number of employees managed by the manager. */
  private Integer theNumberOfEmployeesTheyManage;

  /** Bonus applied for managers. */
  private static final Double Manager_Bonus = 1.8;

  /** Bonus applied based on the number of employees managed for managers. */
  private static final Integer Manager_Bonus_Employee = 8;

  /**
   * Constructs a new Manager with the specified attributes.
   *
   * @param employeeId                       The ID of the manager.
   * @param contactInfo                      The contact information of the manager.
   * @param employmentDate                   The date of employment.
   * @param educationLevel                   The education level of the manager.
   * @param employmentLevel                  The employment level of the manager.
   * @param lastYearEarning                   The last year's earnings of the manager.
   * @param basePay                           The base pay of the manager.
   * @param bonuses                           The bonuses received by the manager.
   * @param overTime                          The overtime hours worked by the manager.
   * @param dateOfTheLastPromotion           The date of the last promotion.
   * @param numberOfProjects                 The number of projects completed by the manager.
   * @param theNumberOfEmployeesTheyManage   The number of employees managed by the manager.
   */
  public Manager(String employeeId, ContactInfo contactInfo, LocalDate employmentDate,
      EducationLevel educationLevel, EmploymentLevel employmentLevel, Double lastYearEarning,
      Double basePay, Double bonuses, Double overTime, LocalDate dateOfTheLastPromotion,
      Integer numberOfProjects, Integer theNumberOfEmployeesTheyManage) {
    super(employeeId, contactInfo, employmentDate, educationLevel, employmentLevel, lastYearEarning,
        basePay, bonuses, overTime, dateOfTheLastPromotion, numberOfProjects);
    this.theNumberOfEmployeesTheyManage = theNumberOfEmployeesTheyManage;
  }

  /**
   * Gets the number of employees managed by the manager.
   *
   * @return The number of employees managed.
   */
  public Integer getTheNumberOfEmployeesTheyManage() {
    return theNumberOfEmployeesTheyManage;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Manager manager = (Manager) o;
    return Objects.equals(this.theNumberOfEmployeesTheyManage,
        manager.theNumberOfEmployeesTheyManage)
        && Objects.equals(this.basePay, manager.basePay)
        && Objects.equals(this.bonuses, manager.bonuses)
        && Objects.equals(this.overTime, manager.overTime)
        && Objects.equals(this.dateOfTheLastPromotion, manager.dateOfTheLastPromotion)
        && Objects.equals(this.numberOfProjects, manager.numberOfProjects)
        && Objects.equals(this.employeeId, manager.employeeId)
        && Objects.equals(this.contactInfo,manager.contactInfo)
        && Objects.equals(this.employmentDate, manager.employmentDate)
        && Objects.equals(this.educationLevel, manager.educationLevel)
        && Objects.equals(this.employmentLevel, manager.employmentLevel)
        && Objects.equals(this.lastYearEarning, manager.lastYearEarning);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.theNumberOfEmployeesTheyManage, this.basePay, this.bonuses,
                this.overTime, this.dateOfTheLastPromotion,this.numberOfProjects, this.employeeId,
                this.contactInfo, this.employmentDate, this.educationLevel, this.employmentLevel,
                this.lastYearEarning);
  }

  @Override
  public String toString() {
    return "Manager{" +
        "theNumberOfEmployeesTheyManage=" + theNumberOfEmployeesTheyManage +
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
   * Overrides the estimateProductivity method to include specific productivity calculations for managers.
   *
   * @return The estimated productivity of the manager.
   */
  @Override
  public Double estimateProductivity() {
    // Manager bonus
    if (this.theNumberOfEmployeesTheyManage > Manager_Bonus_Employee) {
      return super.estimateProductivity() + Manager_Bonus;
    }
    return super.estimateProductivity();
  }
}
