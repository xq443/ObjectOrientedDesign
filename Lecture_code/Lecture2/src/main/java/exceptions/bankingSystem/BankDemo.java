package exceptions.bankingSystem;

public class BankDemo {

  private static final Integer CHECKING_ACCOUNT_NUMBER = 101;

  public static void main(String [] args) throws IllegalDepositAmountException {
    CheckingAccount checkingAccount = new CheckingAccount(CHECKING_ACCOUNT_NUMBER);

    System.out.println("Depositing $500...");
    checkingAccount.deposit(500.00);

    try {
      System.out.println("Trying to deposit -20...");
      checkingAccount.deposit(-20.0);
    }catch (IllegalDepositAmountException e){
      System.out.println(e.getMessage());
    }

    try {
      System.out.println("\n Withdrawing $100...");
      checkingAccount.withdraw(100.00);

      System.out.println("\nWithdrawing $600...");
      checkingAccount.withdraw(600.00);
    }catch(InsufficientFundsException | InfiniteAmountException e) {
      System.out.println("Sorry, but you are short $");
    }
  }
}