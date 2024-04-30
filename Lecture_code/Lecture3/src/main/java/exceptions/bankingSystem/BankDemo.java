package exceptions.bankingSystem;

import java.util.Scanner;

public class BankDemo {

  public static void main(String [] args) throws OverTheAllowedMaxException, IncorrectDepositAmountException,
          MyOtherException, InsufficientFundsException, IncorrectWithdrawalAmountException {
    CheckingAccount checkingAccount = new CheckingAccount(101);

    System.out.println("Depositing $500...");
    checkingAccount.deposit(500.00);

    try {
      System.out.println("\n Withdrawing $100...");
      checkingAccount.withdraw(100.00);

      System.out.println("\nWithdrawing $600...");
      checkingAccount.withdraw(600.00);
    }catch(InsufficientFundsException | IncorrectWithdrawalAmountException e) {
      //System.out.println("Sorry, but you are short $");
      //checkingAccount.withdraw(600.00);
      System.out.println("Incorrect amount, would you like to try again?");
      Scanner myConsole = new Scanner(System.in);
      double newAmount = Double.parseDouble(myConsole.next()) ;
      checkingAccount.withdraw(newAmount);
      System.out.println("This is the value you want to withdraw now." + newAmount);
      //checkingAccount.withdraw(50.00);
    }
    try {
      checkingAccount.withdraw(-700.00);
    } catch (InsufficientFundsException | IncorrectWithdrawalAmountException e) {
      e.printStackTrace();
    }
  }
}