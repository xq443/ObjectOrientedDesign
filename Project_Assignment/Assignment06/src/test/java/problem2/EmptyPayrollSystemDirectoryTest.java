package problem2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmptyPayrollSystemDirectoryTest {
  private EmptyPayrollSystemDirectory emptyDirectory;

  @BeforeEach
  void setUp() {
    emptyDirectory = new EmptyPayrollSystemDirectory();
  }

  @Test
  void testIsEmpty() {
    assertTrue(emptyDirectory.isEmpty());
  }

  @Test
  void testCount() {
    assertEquals(0, emptyDirectory.count());
  }

  @Test
  void testAddOrUpdate() throws EmployeeNotFoundException {
    Name employeeName = new Name("Cathy", "Qin", "");
    ContactInfo contactInfo = new ContactInfo("301 Minor Ave", "Seattle", "WA", "98109", "123-456-7890", "cathyqin@gmail.com");
    Employee employee = new Employee(employeeName, contactInfo, null, "1", 2022, "Role", 2022, 100000.0);
    PayrollSystemDirectory updatedDirectory = emptyDirectory.addOrUpdate(employee);
    assertTrue(updatedDirectory instanceof NonEmptyPayrollSystemDirectory);
  }

  @Test
  void testRemove() {
    assertThrows(EmployeeNotFoundException.class, () -> emptyDirectory.remove(new Employee(new Name("Cathy", "", ""), new ContactInfo("", "", "", "", "", ""), null, "1", 2022, "Role", 2022, 100000.0)));
  }

  @Test
  void testCheck() {
    assertFalse(emptyDirectory.check("1"));
  }

  @Test
  void testFindAllByAnnualEarnings() {
    assertEquals(emptyDirectory, emptyDirectory.findAllByAnnualEarnings());
  }

  @Test
  void testFindAllByRole() {
    assertEquals(emptyDirectory, emptyDirectory.findAllByRole("Role"));
  }

  @Test
  void testFindAllByYear() {
    assertEquals(emptyDirectory, emptyDirectory.findAllByYear(2022));
  }

  @Test
  void testFindById() {
    assertThrows(EmployeeNotFoundException.class, () -> emptyDirectory.findById("1"));
  }
}
