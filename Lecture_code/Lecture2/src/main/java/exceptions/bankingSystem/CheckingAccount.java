package exceptions.bankingSystem;

public class CheckingAccount {
  private Double balance = 0.0;
  private Integer number;

  public CheckingAccount(Integer number) {
    this.number = number;
  }

  public void deposit(Double amount) throws IllegalDepositAmountException{
    if(amount > 0){
      this.balance += amount;
    }
    else throw new IllegalDepositAmountException("Cannot deposit a negative amount");
  }

  public void withdraw(Double amount) throws InsufficientFundsException, InfiniteAmountException {
    if (amount.isInfinite())
      throw new InfiniteAmountException("This amount is not allowed!");
    if(amount <= balance) {
      balance -= amount;
    }
    else {
      double needs = amount - balance;
      throw new InsufficientFundsException(needs);
    }
  }

  public Double getBalance() {
    return balance;
  }

  public Integer getNumber() {
    return number;
  }
}
