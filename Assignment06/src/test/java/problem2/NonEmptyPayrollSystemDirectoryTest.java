package problem2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NonEmptyPayrollSystemDirectoryTest {
  private NonEmptyPayrollSystemDirectory nonEmptyDirectory;
  private NonEmptyPayrollSystemDirectory nonEmptyDirectory1;
  private Employee firstEmployee;
  private PayrollSystemDirectory restOfEmployees;

  @BeforeEach
  void setUp() {
    firstEmployee = new Employee(new Name("John", "", "Doe"),
        new ContactInfo("", "", "", "", "", ""), null,
        "1", 2022, "Role", 2022, 200000.0);
    restOfEmployees = new EmptyPayrollSystemDirectory();
    nonEmptyDirectory = new NonEmptyPayrollSystemDirectory(firstEmployee, restOfEmployees);
  }

  @Test
  void testGetFirstEmployee() {
    assertEquals(firstEmployee, nonEmptyDirectory.getFirstEmployee());
  }

  @Test
  void testGetRestOfEmployees() {
    assertEquals(restOfEmployees, nonEmptyDirectory.getRestOfEmployees());
  }

  @Test
  void testIsEmpty() {
    assertFalse(nonEmptyDirectory.isEmpty());
  }

  @Test
  void testCount() {
    assertEquals(1, nonEmptyDirectory.count());
  }

  @Test
  void testAddOrUpdate() throws EmployeeNotFoundException {
    Employee newEmployee = new Employee(new Name("Jane", "", "Doe"),
        new ContactInfo("", "", "", "", "", ""), null,
        "2", 2022, "Role", 2022, 200000.0);
    PayrollSystemDirectory updatedDirectory = nonEmptyDirectory.addOrUpdate(newEmployee);
    assertEquals(2, updatedDirectory.count());
  }

  @Test
  void testAddOrUpdateNewEmployeeWhenDirectoryIsEmpty() throws EmployeeNotFoundException {
    Employee employee = new Employee(new Name("John", "", "Doe"),
        new ContactInfo("", "", "", "", "", ""), null,
        "1", 2022, "Role", 2022, 100000.0);
    PayrollSystemDirectory emptyDirectory = new EmptyPayrollSystemDirectory();
    NonEmptyPayrollSystemDirectory nonEmptyDirectory = new NonEmptyPayrollSystemDirectory(employee, emptyDirectory);

    PayrollSystemDirectory updatedDirectory = nonEmptyDirectory.addOrUpdate(employee);

    assertEquals(nonEmptyDirectory, updatedDirectory); // Nothing should change
  }

  @Test
  void testAddOrUpdateNewEmployeeWithDifferentRole() throws EmployeeNotFoundException {
    Employee existingEmployee = new Employee(new Name("John", "", "Doe"),
        new ContactInfo("", "", "", "", "", ""), null,
        "1", 2022, "Role1", 2022, 100000.0);
    PayrollSystemDirectory restOfEmployees = new EmptyPayrollSystemDirectory();
    NonEmptyPayrollSystemDirectory nonEmptyDirectory = new NonEmptyPayrollSystemDirectory(existingEmployee, restOfEmployees);

    Employee updatedEmployee = new Employee(new Name("John", "", "Doe"),
        new ContactInfo("", "", "", "", "", ""), null,
        "1", 2022, "Role2", 2022, 100000.0);

    PayrollSystemDirectory updatedDirectory = nonEmptyDirectory.addOrUpdate(updatedEmployee);

    assertTrue(updatedDirectory.check("1"));
    assertEquals(updatedEmployee, updatedDirectory.findById("1"));
  }


  @Test
  void testRemove() throws EmployeeNotFoundException {
    PayrollSystemDirectory updatedDirectory = nonEmptyDirectory.remove(firstEmployee);
    assertTrue(updatedDirectory.isEmpty());
  }

  @Test
  void testRemoveEmployeeFromRestOfEmployees() throws EmployeeNotFoundException {
    Employee firstEmployee = new Employee(new Name("John", "", "Doe"),
        new ContactInfo("", "", "", "", "", ""), null,
        "1", 2022, "Role", 2022, 100000.0);
    Employee employeeToRemove = new Employee(new Name("Jane", "", "Doe"),
        new ContactInfo("", "", "", "", "", ""), null,
        "2", 2022, "Role", 2022, 100000.0);
    PayrollSystemDirectory restOfEmployees = new NonEmptyPayrollSystemDirectory(employeeToRemove, new EmptyPayrollSystemDirectory());
    NonEmptyPayrollSystemDirectory nonEmptyDirectory = new NonEmptyPayrollSystemDirectory(firstEmployee, restOfEmployees);

    PayrollSystemDirectory updatedDirectory = nonEmptyDirectory.remove(employeeToRemove);

    assertFalse(updatedDirectory.isEmpty());
    assertFalse(updatedDirectory.check("2"));
  }

  @Test
  void testCheck() {
    assertTrue(nonEmptyDirectory.check("1"));
    assertFalse(nonEmptyDirectory.check("2"));
  }

  @Test
  void testFindAllByAnnualEarnings() {
    PayrollSystemDirectory resultDirectory = nonEmptyDirectory.findAllByAnnualEarnings();
    assertEquals(1, resultDirectory.count());
  }

  @Test
  public void testFindAllByAnnualEarnings_MultipleEmployee() throws EmployeeNotFoundException {
    Employee firstEmployee = new Employee(new Name("John", "", "Doe"),
        new ContactInfo("", "", "", "", "", ""), null,
        "1", 2022, "Role", 2022, 200000.0);
    Employee secondEmployee = new Employee(new Name("Cathy", "", "Qin"),
        new ContactInfo("", "", "", "", "", ""), null,
        "1", 2022, "Role1", 2022, 100000.0);
    Employee thirdEmployee =  new Employee(new Name("John", "", "Irish"),
        new ContactInfo("", "", "", "", "", ""), null,
        "1", 2022, "Role1", 2021, 100000.0);

    PayrollSystemDirectory directory = new NonEmptyPayrollSystemDirectory(firstEmployee,
        new NonEmptyPayrollSystemDirectory(secondEmployee,
            new NonEmptyPayrollSystemDirectory(thirdEmployee, new EmptyPayrollSystemDirectory())));

    PayrollSystemDirectory result = directory.findAllByAnnualEarnings();
    assertEquals(result.count(), 1);
  }

  @Test
  void testFindAllByRole() {
    PayrollSystemDirectory resultDirectory = nonEmptyDirectory.findAllByRole("Role");
    assertTrue(resultDirectory instanceof NonEmptyPayrollSystemDirectory);
    assertEquals(1, resultDirectory.count());
  }

  @Test
  public void testFindAllByRole_MultipleEmployee() throws EmployeeNotFoundException {
    Employee firstEmployee = new Employee(new Name("John", "", "Doe"),
        new ContactInfo("", "", "", "", "", ""), null,
        "1", 2022, "Role", 2022, 100000.0);
    Employee secondEmployee = new Employee(new Name("Cathy", "", "Qin"),
        new ContactInfo("", "", "", "", "", ""), null,
        "1", 2022, "Role1", 2022, 100000.0);
    Employee thirdEmployee =  new Employee(new Name("John", "", "Irish"),
        new ContactInfo("", "", "", "", "", ""), null,
        "1", 2022, "Role1", 2021, 100000.0);

    PayrollSystemDirectory directory = new NonEmptyPayrollSystemDirectory(firstEmployee,
        new NonEmptyPayrollSystemDirectory(secondEmployee,
            new NonEmptyPayrollSystemDirectory(thirdEmployee, new EmptyPayrollSystemDirectory())));

    PayrollSystemDirectory result = directory.findAllByRole("Role1");
    // Assert that all employees with "Role1" are retrieved
    assertEquals(result.count(), 2);
  }

  @Test
  void testFindAllByYear() {
    PayrollSystemDirectory resultDirectory = nonEmptyDirectory.findAllByYear(2022);
    assertEquals(1, resultDirectory.count());
  }

  @Test
  void testFindAllByYearEmployeeInRestOfEmployees() {
    int yearToFind = 2022;
    Employee firstEmployee = new Employee(new Name("John", "", "Doe"),
        new ContactInfo("", "", "", "", "", ""), null,
        "1", 2020, "Role", 2022, 100000.0);
    Employee employeeToFind = new Employee(new Name("Jane", "", "Doe"),
        new ContactInfo("", "", "", "", "", ""), null,
        "2", yearToFind, "Role", 2022, 100000.0);
    PayrollSystemDirectory restOfEmployees = new NonEmptyPayrollSystemDirectory(employeeToFind, new EmptyPayrollSystemDirectory());
    NonEmptyPayrollSystemDirectory nonEmptyDirectory = new NonEmptyPayrollSystemDirectory(firstEmployee, restOfEmployees);

    PayrollSystemDirectory foundEmployees = nonEmptyDirectory.findAllByYear(yearToFind);

    assertTrue(foundEmployees instanceof NonEmptyPayrollSystemDirectory);
    assertTrue(foundEmployees.check(employeeToFind.getEmployeeID()));
  }


  @Test
  void testFindByIdEmployeeExistsInFirstEmployee() throws EmployeeNotFoundException {
    assertEquals(firstEmployee, nonEmptyDirectory.findById("1"));
  }

  @Test
  void testFindByIdEmployeeExistsInRestOfEmployees() throws EmployeeNotFoundException {
    Employee firstEmployee = new Employee(new Name("John", "", "Doe"),
        new ContactInfo("", "", "", "", "", ""), null,
        "1", 2022, "Role", 2022, 100000.0);
    Employee secondEmployee = new Employee(new Name("Jane", "", "Doe"),
        new ContactInfo("", "", "", "", "", ""), null,
        "2", 2022, "Role", 2022, 100000.0);
    PayrollSystemDirectory restOfEmployees = new NonEmptyPayrollSystemDirectory(secondEmployee, new EmptyPayrollSystemDirectory());
    NonEmptyPayrollSystemDirectory nonEmptyDirectory = new NonEmptyPayrollSystemDirectory(firstEmployee, restOfEmployees);

    assertEquals(secondEmployee, nonEmptyDirectory.findById("2"));
  }

  @Test
  void testFindByIdEmployeeNotFound() {
    assertThrows(EmployeeNotFoundException.class, () -> nonEmptyDirectory.findById("2"));
  }
  @Test
  void testEquals() {
    assertTrue(nonEmptyDirectory.equals(nonEmptyDirectory));
    assertFalse(nonEmptyDirectory.equals(null));
    assertFalse(nonEmptyDirectory.equals("String"));


    Employee firstEmployee1 = new Employee(new Name("Cathy", "", "Doe"),
        new ContactInfo("", "", "", "", "", ""), null,
        "1", 2022, "Role", 2022, 200000.0);

    nonEmptyDirectory1 = new NonEmptyPayrollSystemDirectory(firstEmployee1, restOfEmployees);


    assertFalse(nonEmptyDirectory.equals(nonEmptyDirectory1));

    NonEmptyPayrollSystemDirectory sameDirectory = new NonEmptyPayrollSystemDirectory(firstEmployee, restOfEmployees);
    assertTrue(nonEmptyDirectory.equals(sameDirectory));
  }

  @Test
  void testHashCode() {
    NonEmptyPayrollSystemDirectory directoryCopy = new NonEmptyPayrollSystemDirectory(firstEmployee, restOfEmployees);
    assertEquals(nonEmptyDirectory.hashCode(), directoryCopy.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "NonEmptyPayrollSystemDirectory{" +
        "firstEmployee=" + firstEmployee +
        ", restOfEmployees=" + restOfEmployees +
        '}';
    assertEquals(expectedString, nonEmptyDirectory.toString());
  }
}
