package problem3;

import java.util.Objects;

/**
 * Represents a financial transaction involving a unique identifier and a monetary amount.
 */
public class Transaction {

  private final UniqueIdentifier uniqueIdentifier;
  private final Amount balance;

  /**
   * Constructs a new Transaction with the specified unique identifier and balance.
   *
   * @param uniqueIdentifier The unique identifier of the account holder.
   * @param balance          The monetary amount involved in the transaction.
   */
  public Transaction(UniqueIdentifier uniqueIdentifier, Amount balance) {
    this.uniqueIdentifier = uniqueIdentifier;
    this.balance = balance;
  }

  /**
   * Handles a deposit event, creating a new Transaction with an increased balance.
   *
   * @param depositAmount The amount to be deposited.
   * @return A new Transaction with the increased balance.
   */
  public Transaction deposit(Amount depositAmount) {
    int newDollars = this.balance.getDollars() + depositAmount.getDollars();
    int newCents = this.balance.getCents() + depositAmount.getCents();
    return new Transaction(this.uniqueIdentifier, new Amount(newDollars, newCents));
  }

  /**
   * Handles a withdrawal event, creating a new Transaction with a decreased balance.
   *
   * @param withdrawalAmount The amount to be withdrawn.
   * @return A new Transaction with the decreased balance.
   * @throws IllegalArgumentException if the withdrawal results in a negative balance.
   */
  public Transaction withdraw(Amount withdrawalAmount) {
    int newDollars = this.balance.getDollars() - withdrawalAmount.getDollars();
    int newCents = this.balance.getCents() - withdrawalAmount.getCents();

    if (newDollars < 0) {
      throw new IllegalArgumentException("Withdrawal results in a negative balance");
    }

    // Adjust for negative cents by borrowing from dollars
    if (newCents < 0 && newDollars != 0) {
      newCents += 100;
      newDollars -= 1;
    }else if(newCents < 0){
      throw new IllegalArgumentException("Withdrawal results in a negative balance");
    }

    return new Transaction(this.uniqueIdentifier, new Amount(newDollars, newCents));
  }


  /**
   * Converts the balance to Bitcoins (BTC) based on a predefined conversion rate.
   *
   * @return The value of the balance in Bitcoins.
   */
  public double convertToBTC() {
    double conversionRate = 0.000025;
    double totalUSD = this.balance.getDollars() + (this.balance.getCents() / 100.0);
    return totalUSD * conversionRate;
  }

  /**
   * Gets the unique identifier associated with this transaction.
   *
   * @return The unique identifier.
   */
  public UniqueIdentifier getUniqueIdentifier() {
    return uniqueIdentifier;
  }

  /**
   * Gets the balance associated with this transaction.
   *
   * @return The monetary amount involved in the transaction.
   */
  public Amount getBalance() {
    return balance;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Transaction that = (Transaction) o;
    return Objects.equals(uniqueIdentifier, that.uniqueIdentifier)
        && Objects.equals(balance, that.balance);
  }

  /**
   * Generates a hash code for this Transaction.
   *
   * @return The hash code.
   */
  @Override
  public int hashCode() {
    return Objects.hash(uniqueIdentifier, balance);
  }
}
