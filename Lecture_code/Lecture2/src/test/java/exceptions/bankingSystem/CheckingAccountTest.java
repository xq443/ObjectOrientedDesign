package exceptions.bankingSystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckingAccountTest {

    private CheckingAccount testAccount;

    @BeforeEach
    void setUp() {
        testAccount = new CheckingAccount(102);
    }

    @Test
    void deposit() throws IllegalDepositAmountException {
        Double expectedValue = 200.0;
        testAccount.deposit(expectedValue);
        assertEquals(200.0, testAccount.getBalance(), 0.001);
    }

    @Test
    void depositException() {
        assertThrows(IllegalDepositAmountException.class, () -> {testAccount.deposit(-300.0);});
    }
}