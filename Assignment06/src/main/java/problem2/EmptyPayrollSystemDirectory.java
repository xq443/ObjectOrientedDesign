package problem2;

/**
 * The EmptyPayrollSystemDirectory class represents an empty directory in a payroll system.
 * It implements the PayrollSystemDirectory interface.
 */
public class EmptyPayrollSystemDirectory implements PayrollSystemDirectory {

  /**
   * Checks if the directory is empty.
   *
   * @return true since the directory is always empty.
   */
  @Override
  public Boolean isEmpty() {
    return Boolean.TRUE;
  }

  /**
   * Counts the number of employees in the directory.
   *
   * @return 0 since the directory is empty.
   */
  @Override
  public Integer count() {
    return 0;
  }

  /**
   * Adds or updates an employee in the directory.
   *
   * @param employee the employee to add or update.
   * @return a new NonEmptyPayrollSystemDirectory containing the specified employee.
   */
  @Override
  public PayrollSystemDirectory addOrUpdate(Employee employee) {
    return new NonEmptyPayrollSystemDirectory(employee, this);
  }

  /**
   * Removes an employee from the directory.
   *
   * @param employee the employee to remove.
   * @return a new EmptyPayrollSystemDirectory since the directory is already empty.
   * @throws EmployeeNotFoundException since there are no employees to remove.
   */
  @Override
  public PayrollSystemDirectory remove(Employee employee) throws EmployeeNotFoundException {
    throw new EmployeeNotFoundException("Employee not found.");
  }

  /**
   * Checks if an employee with the given ID exists in the directory.
   *
   * @param employeeID the ID of the employee to check.
   * @return false since there are no employees in the directory.
   */
  @Override
  public Boolean check(String employeeID) {
    return Boolean.FALSE;
  }

  /**
   * Finds all employees in the directory whose annual earnings exceed a certain benchmark.
   *
   * @return an empty directory since there are no employees.
   */
  @Override
  public PayrollSystemDirectory findAllByAnnualEarnings() {
    return this;
  }

  /**
   * Finds all employees in the directory with the specified role.
   *
   * @param currentRole the role to filter employees by.
   * @return an empty directory since there are no employees.
   */
  @Override
  public PayrollSystemDirectory findAllByRole(String currentRole) {
    return this;
  }

  /**
   * Finds all employees in the directory who joined the company in a specific year.
   *
   * @param year the year to filter employees by.
   * @return an empty directory since there are no employees.
   */
  @Override
  public PayrollSystemDirectory findAllByYear(Integer year) {
    return this;
  }

  /**
   * Finds an employee in the directory by their ID.
   *
   * @param employeeID the ID of the employee to find.
   * @return never returns an employee since the directory is empty.
   * @throws EmployeeNotFoundException since there are no employees to find.
   */
  @Override
  public Employee findById(String employeeID) throws EmployeeNotFoundException {
    throw new EmployeeNotFoundException("Employee not found.");
  }
}
