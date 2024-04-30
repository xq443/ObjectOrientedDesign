package bankingSystem;

import exceptions.bankingSystem.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckingAccountTest {

    CheckingAccount testAccount;

    @BeforeEach
    public void setup(){
        testAccount = new CheckingAccount(405);
    }

    @Test
    void depositSuccess() throws IncorrectDepositAmountException, OverTheAllowedMaxException {
        //try {
            testAccount.deposit(500.0);
        //} catch (Exception e) {
        //    fail("Deposit unsuccessful");
        //}
        assertEquals(500.0, testAccount.getBalance());
    }

    @Test
    void depositNegativeFailure() {
        Assertions.assertThrows(IncorrectDepositAmountException.class, () -> {
            testAccount.deposit(-200.0);
        });
    }

    @Test
    void depositOverMaxFailure() {
        Assertions.assertThrows(OverTheAllowedMaxException.class, () -> {
            testAccount.deposit(2500.0);
        });
    }

    @Test
    void withdrawInsufficientFunds() throws OverTheAllowedMaxException, IncorrectDepositAmountException {
        testAccount.deposit(300.0);
        Assertions.assertThrows(InsufficientFundsException.class, () -> {testAccount.withdraw(350.0);});
    }

    @Test
    void withdrawInvalidWithdrawalAmount() throws OverTheAllowedMaxException, IncorrectDepositAmountException {
        testAccount.deposit(300.0);
        Assertions.assertThrows(IncorrectWithdrawalAmountException.class, () -> {testAccount.withdraw(-350.0);});
    }

    @Test
    void getBalance() {
    }

    @Test
    void getNumber() {
    }
}