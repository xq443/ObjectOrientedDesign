package problem3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TransactionTest {
  private UniqueIdentifier testUniqueIdentifier;
  private Amount initialBalance;
  private Transaction initialTransaction;

  @BeforeEach
  void setUp() {
    testUniqueIdentifier = new UniqueIdentifier("cathyqin", 2024, "USA");
    initialBalance = new Amount(100, 50);
    initialTransaction = new Transaction(testUniqueIdentifier, initialBalance);
  }

  @Test
  void deposit() {
    Amount depositAmount = new Amount(30, 25);
    Transaction newTransaction = initialTransaction.deposit(depositAmount);

    assertEquals(130, newTransaction.getBalance().getDollars());
    assertEquals(75, newTransaction.getBalance().getCents());
  }

  @Test
  void withdraw_PositiveBalance() {
    Amount withdrawalAmount = new Amount(20, 50);
    Transaction newTransaction = initialTransaction.withdraw(withdrawalAmount);

    assertEquals(80, newTransaction.getBalance().getDollars());
    assertEquals(0, newTransaction.getBalance().getCents());
  }

  @Test
  void withdraw_NegativeBalance_ExceptionThrown() {
    Amount withdrawalAmount = new Amount(150, 75);

    try {
      initialTransaction.withdraw(withdrawalAmount);
    } catch (IllegalArgumentException e) {
      assertEquals("Withdrawal results in a negative balance", e.getMessage());
    }
  }
  @Test
  void withdraw_AdjustForNegativeCents() {
    Amount withdrawalAmount = new Amount(20, 75);
    Transaction newTransaction = initialTransaction.withdraw(withdrawalAmount);

    assertEquals(79, newTransaction.getBalance().getDollars());
    assertEquals(75, newTransaction.getBalance().getCents());
  }

  @Test
  void withdraw_CentsNegative_DollarsZero_ExceptionThrown() {
    Amount initialBalance = new Amount(0, 5); // Initial balance with 0 dollars
    Transaction initialTransaction = new Transaction(testUniqueIdentifier, initialBalance);

    Amount withdrawalAmount = new Amount(0, 25); // Results in negative cents

    try {
      initialTransaction.withdraw(withdrawalAmount);
    } catch (IllegalArgumentException e) {
      assertEquals("Withdrawal results in a negative balance", e.getMessage());
    }
  }

  @Test
  void convertToBTC() {
    double btcValue = initialTransaction.convertToBTC();

    assertEquals(0.0025, btcValue, 0.0001);
  }


  @Test
  void getUniqueIdentifier() {
    assertEquals(testUniqueIdentifier, initialTransaction.getUniqueIdentifier());
  }

  @Test
  void getBalance() {
    assertEquals(initialBalance, initialTransaction.getBalance());
  }

  @Test
  void testEquals_SameObjects() {
    assertTrue(initialTransaction.equals(initialTransaction));
  }

  @Test
  void testEquals_NullComparison() {
    assertFalse(initialTransaction.equals(null));
  }

  @Test
  void testEquals_DifferentDataType() {
    assertFalse(initialTransaction.equals("String"));
  }

  @Test
  void testEquals_DifferentObjectSameFields() {
    Transaction otherTransaction = new Transaction(testUniqueIdentifier, initialBalance);
    assertTrue(initialTransaction.equals(otherTransaction));
  }

  @Test
  void testEquals_DifferentObjectDifferentUniqueIdentifier() {
    UniqueIdentifier otherUniqueIdentifier = new UniqueIdentifier("john_doe", 2024, "USA");
    Transaction otherTransaction = new Transaction(otherUniqueIdentifier, initialBalance);
    assertFalse(initialTransaction.equals(otherTransaction));
  }

  @Test
  void testEquals_DifferentObjectDifferentBalance() {
    Amount differentBalance = new Amount(80, 25);
    Transaction otherTransaction = new Transaction(testUniqueIdentifier, differentBalance);
    assertFalse(initialTransaction.equals(otherTransaction));
  }

  @Test
  void testHashCode() {
    int expHashCode = initialTransaction.hashCode();
    assertEquals(expHashCode, initialTransaction.hashCode());
  }
}
