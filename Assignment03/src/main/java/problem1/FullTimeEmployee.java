package problem1;

import java.time.LocalDate;

/**
 * This abstract class represents a full-time employee and extends the AbstractEmployee class.
 * It includes attributes specific to full-time employees such as base pay, bonuses, overtime, date of the last promotion,
 * and the number of projects.
 */
public abstract class FullTimeEmployee extends AbstractEmployee {

  /** The base pay of the full-time employee. */
  protected Double basePay;

  /** The bonuses received by the full-time employee. */
  protected Double bonuses;

  /** The overtime hours worked by the full-time employee. */
  protected Double overTime;

  /** The date of the last promotion for the full-time employee. */
  protected LocalDate dateOfTheLastPromotion;

  /** The number of projects managed by the full-time employee. */
  protected Integer numberOfProjects;

  /** The bonus applied when the number of projects exceeds the benchmark. */
  protected static final Double Number_Of_Projects_Bonus = 1.5;

  /** The benchmark for the number of projects to apply the bonus. */
  protected static final Integer Number_Of_Projects_Benchmark = 2;

  /** The penalty applied if the last promotion was more than specified years ago. */
  protected static final Double Last_Promotion_Penalty = -0.8;

  /** The number of years after which the last promotion penalty is applied. */
  protected static final Integer Last_Promotion_Penalty_Year = 3;

  /**
   * Constructs a new FullTimeEmployee with the specified attributes.
   *
   * @param employeeId              The ID of the employee.
   * @param contactInfo             The contact information of the employee.
   * @param employmentDate          The date of employment.
   * @param educationLevel          The education level of the employee.
   * @param employmentLevel         The employment level of the employee.
   * @param lastYearEarning         The last year's earnings of the employee.
   * @param basePay                 The base pay of the employee.
   * @param bonuses                 The bonuses received by the employee.
   * @param overTime                The overtime hours worked by the employee.
   * @param dateOfTheLastPromotion  The date of the last promotion.
   * @param numberOfProjects        The number of projects managed by the employee.
   */
  public FullTimeEmployee(String employeeId, ContactInfo contactInfo, LocalDate employmentDate,
      EducationLevel educationLevel, EmploymentLevel employmentLevel, Double lastYearEarning,
      Double basePay, Double bonuses, Double overTime, LocalDate dateOfTheLastPromotion,
      Integer numberOfProjects) {
    super(employeeId, contactInfo, employmentDate, educationLevel, employmentLevel, lastYearEarning);
    this.basePay = basePay;
    this.bonuses = bonuses;
    this.overTime = overTime;
    this.dateOfTheLastPromotion = dateOfTheLastPromotion;
    this.numberOfProjects = numberOfProjects;
  }

  /**
   * {@inheritDoc}
   * Overrides the estimateProductivity method to include specific productivity calculations for full-time employees.
   */
  @Override
  public Double estimateProductivity() {
    // Base productivity estimate for full-time employees
    double baseProductivity = super.lastYearEarning / this.basePay;

    // Number of projects bonus
    if (this.numberOfProjects > Number_Of_Projects_Benchmark) {
      baseProductivity += Number_Of_Projects_Bonus;
    }

    // Last promotion penalty
    if (this.dateOfTheLastPromotion.plusYears(Last_Promotion_Penalty_Year).isBefore(LocalDate.now())) {
      baseProductivity -= Last_Promotion_Penalty;
    }
    return super.estimateProductivity() + baseProductivity;
  }

  /**
   * Gets the base pay of the full-time employee.
   *
   * @return The base pay.
   */
  public Double getBasePay() {
    return basePay;
  }

  /**
   * Gets the bonuses received by the full-time employee.
   *
   * @return The bonuses.
   */
  public Double getBonuses() {
    return bonuses;
  }

  /**
   * Gets the overtime hours worked by the full-time employee.
   *
   * @return The overtime hours.
   */
  public Double getOverTime() {
    return overTime;
  }

  /**
   * Gets the date of the last promotion for the full-time employee.
   *
   * @return The date of the last promotion.
   */
  public LocalDate getDateOfTheLastPromotion() {
    return dateOfTheLastPromotion;
  }

  /**
   * Gets the number of projects managed by the full-time employee.
   *
   * @return The number of projects.
   */
  public Integer getNumberOfProjects() {
    return numberOfProjects;
  }
}
