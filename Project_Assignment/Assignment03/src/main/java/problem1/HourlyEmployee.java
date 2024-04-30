package problem1;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Represents an Hourly Employee, extending the PartTimeEmployee class.
 * Contains attributes specific to hourly employees and methods for comparison and productivity estimation.
 */
public class HourlyEmployee extends PartTimeEmployee {

  /** The hourly earnings of the hourly employee. */
  private Double hourlyEarnings;

  /** The bonus applied when hourly earnings are below the benchmark. */
  private static final Integer Hourly_Earnings_Bonus = 3;

  /** The benchmark for hourly earnings to apply the bonus. */
  private static final Integer Hourly_Earnings_Bonus_Benchmark = 14;

  /**
   * Constructs a new HourlyEmployee with the specified attributes.
   *
   * @param employeeId                 The ID of the hourly employee.
   * @param contactInfo                The contact information of the hourly employee.
   * @param employmentDate             The date of employment.
   * @param educationLevel             The education level of the hourly employee.
   * @param employmentLevel            The employment level of the hourly employee.
   * @param lastYearEarning            The last year's earnings of the hourly employee.
   * @param theContractualNumberOfWorkedHours The contractual number of worked hours.
   * @param theActualNumberOfWorkedHours The actual number of worked hours.
   * @param bonusAndOvertimeEarnings  The bonus and overtime earnings of the hourly employee.
   * @param hourlyEarnings            The hourly earnings of the hourly employee.
   */
  public HourlyEmployee(String employeeId, ContactInfo contactInfo,
      LocalDate employmentDate, EducationLevel educationLevel,
      EmploymentLevel employmentLevel, Double lastYearEarning,
      Double theContractualNumberOfWorkedHours, Double theActualNumberOfWorkedHours,
      Double bonusAndOvertimeEarnings, Double hourlyEarnings) {
    super(employeeId, contactInfo, employmentDate, educationLevel, employmentLevel, lastYearEarning,
        theContractualNumberOfWorkedHours, theActualNumberOfWorkedHours, bonusAndOvertimeEarnings);
    this.hourlyEarnings = hourlyEarnings;
  }

  /**
   * Gets the hourly earnings of the hourly employee.
   *
   * @return The hourly earnings.
   */
  public Double getHourlyEarnings() {
    return hourlyEarnings;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HourlyEmployee hourlyEmployee = (HourlyEmployee) o;
    return Objects.equals(this.hourlyEarnings, hourlyEmployee.hourlyEarnings)
        && Objects.equals(this.theContractualNumberOfWorkedHours, hourlyEmployee.theContractualNumberOfWorkedHours)
        && Objects.equals(this.theActualNumberOfWorkedHours, hourlyEmployee.theActualNumberOfWorkedHours)
        && Objects.equals(this.bonusAndOvertimeEarnings, hourlyEmployee.bonusAndOvertimeEarnings)
        && Objects.equals(this.employeeId, hourlyEmployee.employeeId)
        && Objects.equals(this.contactInfo,hourlyEmployee.contactInfo)
        && Objects.equals(this.employmentDate, hourlyEmployee.employmentDate)
        && Objects.equals(this.educationLevel, hourlyEmployee.educationLevel)
        && Objects.equals(this.employmentLevel, hourlyEmployee.employmentLevel)
        && Objects.equals(this.lastYearEarning, hourlyEmployee.lastYearEarning);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.hourlyEarnings, this.theContractualNumberOfWorkedHours,
        this.theActualNumberOfWorkedHours, this.bonusAndOvertimeEarnings, this.employeeId,
        this.contactInfo, this.employmentDate, this.educationLevel, this.employmentLevel,
        this.lastYearEarning);
  }

  @Override
  public String toString() {
    return "HourlyEmployee{" +
        "hourlyEarnings=" + hourlyEarnings +
        ", theContractualNumberOfWorkedHours=" + theContractualNumberOfWorkedHours +
        ", theActualNumberOfWorkedHours=" + theActualNumberOfWorkedHours +
        ", bonusAndOvertimeEarnings=" + bonusAndOvertimeEarnings +
        ", employeeId='" + employeeId + '\'' +
        ", contactInfo=" + contactInfo +
        ", employmentDate=" + employmentDate +
        ", educationLevel=" + educationLevel +
        ", employmentLevel=" + employmentLevel +
        ", lastYearEarning=" + lastYearEarning +
        '}';
  }

  /**
   * Overrides the estimateProductivity method to include specific productivity calculations for hourly employees.
   *
   * @return The estimated productivity of the hourly employee.
   */
  @Override
  public Double estimateProductivity() {
    // hourly employee bonus
    if (this.hourlyEarnings < Hourly_Earnings_Bonus_Benchmark) {
      return super.estimateProductivity() + Hourly_Earnings_Bonus;
    }
    return super.estimateProductivity();
  }
}
