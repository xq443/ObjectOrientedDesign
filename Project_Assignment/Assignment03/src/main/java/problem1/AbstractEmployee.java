package problem1;

import java.time.LocalDate;

/**
 * An abstract class representing an employee with common attributes and methods.
 * Extends the {@link Employee} interface.
 */
public abstract class AbstractEmployee implements Employee {

  /**
   * The unique identifier of the employee.
   */
  protected String employeeId;

  /**
   * The contact information of the employee.
   */
  protected ContactInfo contactInfo;

  /**
   * The date when the employee started their employment.
   */
  protected LocalDate employmentDate;

  /**
   * The education level of the employee.
   */
  protected EducationLevel educationLevel;

  /**
   * The employment level of the employee.
   */
  protected EmploymentLevel employmentLevel;

  /**
   * The earnings of the employee in the last year.
   */
  protected Double lastYearEarning;

  /**
   * The bonus applied to the productivity based on the employment level.
   */
  protected static final Double Employment_Level_Bonus = 1.4;

  /**
   * Constructs an AbstractEmployee with the specified attributes.
   *
   * @param employeeId      The unique identifier of the employee.
   * @param contactInfo     The contact information of the employee.
   * @param employmentDate  The date when the employee started their employment.
   * @param educationLevel  The education level of the employee.
   * @param employmentLevel The employment level of the employee.
   * @param lastYearEarning The earnings of the employee in the last year.
   */
  public AbstractEmployee(String employeeId, ContactInfo contactInfo, LocalDate employmentDate,
      EducationLevel educationLevel, EmploymentLevel employmentLevel, Double lastYearEarning) {
    this.employeeId = employeeId;
    this.contactInfo = contactInfo;
    this.employmentDate = employmentDate;
    this.educationLevel = educationLevel;
    this.employmentLevel = employmentLevel;
    this.lastYearEarning = lastYearEarning;
  }

  /**
   * Retrieves the employee's unique identifier.
   *
   * @return The unique identifier of the employee.
   */
  public String getEmployeeId() {
    return employeeId;
  }

  /**
   * Retrieves the contact information of the employee.
   *
   * @return The contact information of the employee.
   */
  public ContactInfo getContactInfo() {
    return contactInfo;
  }

  /**
   * Retrieves the date when the employee started their employment.
   *
   * @return The employment date of the employee.
   */
  public LocalDate getEmploymentDate() {
    return employmentDate;
  }

  /**
   * Retrieves the education level of the employee.
   *
   * @return The education level of the employee.
   */
  public EducationLevel getEducationLevel() {
    return educationLevel;
  }

  /**
   * Retrieves the employment level of the employee.
   *
   * @return The employment level of the employee.
   */
  public EmploymentLevel getEmploymentLevel() {
    return employmentLevel;
  }

  /**
   * Retrieves the earnings of the employee in the last year.
   *
   * @return The earnings of the employee in the last year.
   */
  public Double getLastYearEarning() {
    return lastYearEarning;
  }

  /**
   * Estimates the productivity of the employee based on the employment level.
   *
   * @return The estimated productivity of the employee.
   */
  @Override
  public Double estimateProductivity() {
    double baseProductivity = 0.0;
    if (this.employmentLevel == EmploymentLevel.Intermediate_Level) {
      baseProductivity += Employment_Level_Bonus;
    }
    return baseProductivity;
  }
}
