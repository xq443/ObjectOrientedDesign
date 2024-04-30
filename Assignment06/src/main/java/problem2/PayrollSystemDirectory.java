package problem2;

/**
 * The PayrollSystemDirectory interface represents a directory of employees in a payroll system.
 * It provides methods for managing and querying the directory.
 */
public interface PayrollSystemDirectory {

  /**
   * Checks if the directory is empty.
   *
   * @return true if the directory is empty, false otherwise.
   */
  Boolean isEmpty();

  /**
   * Counts the number of employees in the directory.
   *
   * @return the number of employees in the directory.
   */
  Integer count();

  /**
   * Adds or updates an employee in the directory.
   *
   * @param employee the employee to add or update.
   * @return the updated directory after adding or updating the employee.
   * @throws EmployeeNotFoundException if the employee to be updated is not found in the directory.
   */
  PayrollSystemDirectory addOrUpdate(Employee employee) throws EmployeeNotFoundException;

  /**
   * Removes an employee from the directory.
   *
   * @param employee the employee to remove.
   * @return the updated directory after removing the employee.
   * @throws EmployeeNotFoundException if the employee to be removed is not found in the directory.
   */
  PayrollSystemDirectory remove(Employee employee) throws EmployeeNotFoundException;

  /**
   * Checks if an employee with the given ID exists in the directory.
   *
   * @param employeeID the ID of the employee to check.
   * @return true if an employee with the given ID exists, false otherwise.
   */
  Boolean check(String employeeID);

  /**
   * Finds all employees in the directory whose annual earnings exceed a certain benchmark.
   *
   * @return a directory containing all employees with annual earnings exceeding the benchmark.
   */
  PayrollSystemDirectory findAllByAnnualEarnings();

  /**
   * Finds all employees in the directory with the specified role.
   *
   * @param currentRole the role to filter employees by.
   * @return a directory containing all employees with the specified role.
   */
  PayrollSystemDirectory findAllByRole(String currentRole);

  /**
   * Finds all employees in the directory who joined the company in a specific year.
   *
   * @param year the year to filter employees by.
   * @return a directory containing all employees who joined the company in the specified year.
   */
  PayrollSystemDirectory findAllByYear(Integer year);

  /**
   * Finds an employee in the directory by their ID.
   *
   * @param employeeID the ID of the employee to find.
   * @return the employee with the specified ID.
   * @throws EmployeeNotFoundException if the employee with the specified ID is not found.
   */
  Employee findById(String employeeID) throws EmployeeNotFoundException;
}
