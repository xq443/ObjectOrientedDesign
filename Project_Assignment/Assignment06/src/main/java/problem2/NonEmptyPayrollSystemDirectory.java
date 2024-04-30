package problem2;

import java.util.Objects;

/**
 * Represents a non-empty directory in a payroll system.
 * Implements the PayrollSystemDirectory interface.
 */
public class NonEmptyPayrollSystemDirectory implements PayrollSystemDirectory {

  private static final Double ANNUAL_EARNING_BENCHMARK = 150000.0;
  private Employee firstEmployee;
  private PayrollSystemDirectory restOfEmployees;

  /**
   * Constructs a NonEmptyPayrollSystemDirectory with the specified first employee
   * and the rest of the employees directory.
   *
   * @param firstEmployee   the first employee in the directory.
   * @param restOfEmployees the rest of the employees directory.
   */
  public NonEmptyPayrollSystemDirectory(Employee firstEmployee, PayrollSystemDirectory restOfEmployees) {
    this.firstEmployee = firstEmployee;
    this.restOfEmployees = restOfEmployees;
  }

  /**
   * Retrieves the first employee in the directory.
   *
   * @return the first employee in the directory.
   */
  public Employee getFirstEmployee() {
    return this.firstEmployee;
  }

  /**
   * Retrieves the rest of the employees directory.
   *
   * @return the rest of the employees directory.
   */
  public PayrollSystemDirectory getRestOfEmployees() {
    return this.restOfEmployees;
  }

  /**
   * Checks if the directory is empty.
   *
   * @return true if the directory is empty, false otherwise.
   */
  @Override
  public Boolean isEmpty() {
    return Boolean.FALSE;
  }

  /**
   * Counts the number of employees in the directory.
   *
   * @return the number of employees in the directory.
   */
  @Override
  public Integer count() {
    return 1 + this.restOfEmployees.count();
  }

  /**
   * Adds or updates an employee in the directory.
   *
   * @param employee the employee to add or update.
   * @return the updated directory after adding or updating the employee.
   * @throws EmployeeNotFoundException if the employee to be updated is not found in the directory.
   */
  @Override
  public PayrollSystemDirectory addOrUpdate(Employee employee) throws EmployeeNotFoundException {
    if (!check(employee.getEmployeeID())) return new NonEmptyPayrollSystemDirectory(employee, this);
    Employee existingEmployee = findById(employee.getEmployeeID());
    if (!existingEmployee.getCurrentRole().equals(employee.getCurrentRole())) {
      // If the roles are different, remove the existing employee and add the updated employee
      return new NonEmptyPayrollSystemDirectory(employee, this.remove(existingEmployee));
    } else {
      // If the roles are the same, no need to update, return the current directory
      return this;
    }
  }

  /**
   * Finds an employee in the directory by their ID.
   *
   * @param employeeID the ID of the employee to find.
   * @return the employee with the specified ID.
   * @throws EmployeeNotFoundException if the employee with the specified ID is not found.
   */
  @Override
  public Employee findById(String employeeID) throws EmployeeNotFoundException {
    if (this.firstEmployee.getEmployeeID().equals(employeeID))
      return this.firstEmployee;
    return this.restOfEmployees.findById(employeeID);
  }

  /**
   * Removes an employee from the directory.
   *
   * @param employee the employee to remove.
   * @return the updated directory after removing the employee.
   * @throws EmployeeNotFoundException if the employee to be removed is not found in the directory.
   */
  @Override
  public PayrollSystemDirectory remove(Employee employee) throws EmployeeNotFoundException {
    if (this.firstEmployee.equals(employee)) return this.restOfEmployees;
    return new NonEmptyPayrollSystemDirectory(this.firstEmployee, this.restOfEmployees.remove(employee));
  }

  /**
   * Checks if an employee with the given ID exists in the directory.
   *
   * @param employeeID the ID of the employee to check.
   * @return true if an employee with the given ID exists, false otherwise.
   */
  @Override
  public Boolean check(String employeeID) {
    // assumption: compare employee by unique employeeID
    if (this.firstEmployee.getEmployeeID().equals(employeeID)) return true;
    else return this.restOfEmployees.check(employeeID);
  }

  /**
   * Finds all employees in the directory whose annual earnings exceed a certain benchmark.
   *
   * @return a directory containing all employees with annual earnings exceeding the benchmark.
   */
  @Override
  public PayrollSystemDirectory findAllByAnnualEarnings() {
    if (isHighThanAnnualEarning(this.firstEmployee))
      return new NonEmptyPayrollSystemDirectory(this.firstEmployee, this.restOfEmployees.findAllByAnnualEarnings());
    else return this.restOfEmployees.findAllByAnnualEarnings();
  }

  /**
   * Finds all employees in the directory with the specified role.
   *
   * @param currentRole the role to filter employees by.
   * @return a directory containing all employees with the specified role.
   */
  @Override
  public PayrollSystemDirectory findAllByRole(String currentRole) {
    if (this.firstEmployee.getCurrentRole().equals(currentRole)) {
      return new NonEmptyPayrollSystemDirectory(this.firstEmployee, this.restOfEmployees.findAllByRole(currentRole));
    }
    return this.restOfEmployees.findAllByRole(currentRole);
  }

  /**
   * Finds all employees in the directory who joined the company in a specific year.
   *
   * @param year the year to filter employees by.
   * @return a directory containing all employees who joined the company in the specified year.
   */
  @Override
  public PayrollSystemDirectory findAllByYear(Integer year) {
    if (this.firstEmployee.getYearJoinedCompany().equals(year)) {
      return new NonEmptyPayrollSystemDirectory(this.firstEmployee, this.restOfEmployees.findAllByYear(year));
    }
    return this.restOfEmployees.findAllByYear(year);
  }

  /**
   * Compares this NonEmptyPayrollSystemDirectory to the specified object.
   *
   * @param o the object to compare.
   * @return true if the objects are equal, false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NonEmptyPayrollSystemDirectory that = (NonEmptyPayrollSystemDirectory) o;
    return Objects.equals(this.firstEmployee, that.firstEmployee) && Objects.equals(
        this.restOfEmployees, that.restOfEmployees);
  }

  /**
   * Returns a hash code value for the NonEmptyPayrollSystemDirectory.
   *
   * @return a hash code value for this NonEmptyPayrollSystemDirectory.
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.firstEmployee, this.restOfEmployees);
  }

  /**
   * Returns a string representation of the NonEmptyPayrollSystemDirectory object.
   *
   * @return a string representation of the NonEmptyPayrollSystemDirectory object.
   */
  @Override
  public String toString() {
    return "NonEmptyPayrollSystemDirectory{" +
        "firstEmployee=" + this.firstEmployee +
        ", restOfEmployees=" + this.restOfEmployees +
        '}';
  }

  /**
   * Checks if an employee's annual earnings exceed a certain benchmark.
   *
   * @param employee the employee to check.
   * @return true if the employee's annual earnings exceed the benchmark, false otherwise.
   */
  private Boolean isHighThanAnnualEarning(Employee employee) {
    return (employee.getAnnualEarnings() > ANNUAL_EARNING_BENCHMARK);
  }
}
