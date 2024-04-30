package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerTest {
  private Customer customer;

  @BeforeEach
  void setUp() {
    customer = new Customer("123");
  }

  @Test
  void getCustomerId() {
    assertEquals("123", customer.getCustomerId());
  }

  @Test
  void testEquals() {
    Customer sameCustomer = new Customer("123");
    Customer differentCustomer = new Customer("456");

    assertTrue(customer.equals(customer));
    assertTrue(customer.equals(sameCustomer));
    assertFalse(customer.equals(null));
    assertFalse(customer.equals(5));
    assertFalse(customer.equals(differentCustomer));
  }

  @Test
  void testHashCode() {
    Customer sameCustomer = new Customer("123");
    Customer differentCustomer = new Customer("456");

    assertEquals(customer.hashCode(), sameCustomer.hashCode());
    assertNotEquals(customer.hashCode(), differentCustomer.hashCode());
  }

  @Test
  void testToString() {
    assertEquals("Customer{customerId='123'}", customer.toString());
  }
}