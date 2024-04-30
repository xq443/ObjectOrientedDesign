package model;

import java.util.Objects;

/**
 * The Customer class represents a customer who requests a ride.
 */
public class Customer {

  private String customerId;

  /**
   * Constructs a new Customer with the specified customer ID.
   *
   * @param customerId the unique identifier for the customer
   */
  public Customer(String customerId) {
    this.customerId = customerId;
  }

  /**
   * Returns the customer ID of this Customer.
   *
   * @return the customer ID
   */
  public String getCustomerId() {
    return customerId;
  }

  /**
   * Indicates whether some other object is "equal to" this one.
   *
   * @param o the reference object with which to compare
   * @return true if this object is the same as the obj argument; false otherwise
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Customer customer = (Customer) o;
    return Objects.equals(customerId, customer.customerId);
  }

  /**
   * Returns a hash code value for the Customer.
   *
   * @return a hash code value for this Customer
   */
  @Override
  public int hashCode() {
    return Objects.hash(customerId);
  }

  /**
   * Returns a string representation of the Customer.
   *
   * @return a string representation of the Customer
   */
  @Override
  public String toString() {
    return "Customer{" +
        "customerId='" + customerId + '\'' +
        '}';
  }
}
