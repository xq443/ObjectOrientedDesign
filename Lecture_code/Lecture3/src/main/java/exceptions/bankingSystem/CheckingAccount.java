package exceptions.bankingSystem;

import java.util.Objects;

public class CheckingAccount {
  private Double balance = 0.0;
  private Integer number;
  private static final Double DEPOSIT_MAX = 2000.0;

  public CheckingAccount(Integer number) {
    this.number = number;
  }

  public void deposit(Double amount) throws IncorrectDepositAmountException, OverTheAllowedMaxException {

    if(amount > 0) {
      if (amount <= DEPOSIT_MAX) {
        this.balance += amount;
      }else {
        throw new OverTheAllowedMaxException("Your deposit amount exceeds the daily limit!");
      }
    }
    else{
      throw new IncorrectDepositAmountException("You cannot deposit negative amount!");
    }
  }

  public void withdraw(Double amount) throws InsufficientFundsException, IncorrectWithdrawalAmountException {
    if(amount > 0) {
      if (amount <= balance) {
        balance -= amount;
      } else {
        double needs = amount - balance;
        throw new InsufficientFundsException(needs);
      }
    }else {
      throw new IncorrectWithdrawalAmountException("You cannot withdraw a negative amount!");
    }
  }

  public Double getBalance() {
    return balance;
  }

  public Integer getNumber() {
    return number;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CheckingAccount that = (CheckingAccount) o;
    return Objects.equals(balance, that.balance) && Objects.equals(number,
        that.number);
  }

  @Override
  public int hashCode() {
    return Objects.hash(balance, number);
  }
}
