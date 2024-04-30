package problem1;

import java.time.LocalDate;

/**
 * Represents a part-time employee, extending the AbstractEmployee class.
 */
public abstract class PartTimeEmployee extends AbstractEmployee {

  /** The contractual number of worked hours for the part-time employee. */
  protected Double theContractualNumberOfWorkedHours;

  /** The actual number of worked hours for the part-time employee. */
  protected Double theActualNumberOfWorkedHours;

  /** Bonus and overtime earnings for the part-time employee. */
  protected Double bonusAndOvertimeEarnings;

  /** The base productivity ratio for part-time employees. */
  protected static final Double BaseProductivity_Partime_Ratio = 3.7;

  /**
   * Constructs a new PartTimeEmployee with the specified attributes.
   *
   * @param employeeId                       The employee ID.
   * @param contactInfo                      The contact information.
   * @param employmentDate                   The employment date.
   * @param educationLevel                   The education level.
   * @param employmentLevel                  The employment level.
   * @param lastYearEarning                  The last year earnings.
   * @param theContractualNumberOfWorkedHours The contractual number of worked hours.
   * @param theActualNumberOfWorkedHours      The actual number of worked hours.
   * @param bonusAndOvertimeEarnings         Bonus and overtime earnings.
   */
  public PartTimeEmployee(String employeeId, ContactInfo contactInfo,
      LocalDate employmentDate, EducationLevel educationLevel,
      EmploymentLevel employmentLevel, Double lastYearEarning,
      Double theContractualNumberOfWorkedHours, Double theActualNumberOfWorkedHours,
      Double bonusAndOvertimeEarnings) {
    super(employeeId, contactInfo, employmentDate, educationLevel, employmentLevel,
        lastYearEarning);
    this.theContractualNumberOfWorkedHours = theContractualNumberOfWorkedHours;
    this.theActualNumberOfWorkedHours = theActualNumberOfWorkedHours;
    this.bonusAndOvertimeEarnings = bonusAndOvertimeEarnings;
  }

  /**
   * Estimates the productivity of the part-time employee.
   *
   * @return The estimated productivity.
   */
  @Override
  public Double estimateProductivity() {
    // Base productivity estimate for part-time employees
    double baseProductivity = BaseProductivity_Partime_Ratio
        * (this.theActualNumberOfWorkedHours / this.theContractualNumberOfWorkedHours);

    return super.estimateProductivity() + baseProductivity;
  }

  /**
   * Gets the contractual number of worked hours for the part-time employee.
   *
   * @return The contractual number of worked hours.
   */
  public Double getTheContractualNumberOfWorkedHours() {
    return theContractualNumberOfWorkedHours;
  }

  /**
   * Gets the actual number of worked hours for the part-time employee.
   *
   * @return The actual number of worked hours.
   */
  public Double getTheActualNumberOfWorkedHours() {
    return theActualNumberOfWorkedHours;
  }

  /**
   * Gets the bonus and overtime earnings for the part-time employee.
   *
   * @return Bonus and overtime earnings.
   */
  public Double getBonusAndOvertimeEarnings() {
    return bonusAndOvertimeEarnings;
  }
}
