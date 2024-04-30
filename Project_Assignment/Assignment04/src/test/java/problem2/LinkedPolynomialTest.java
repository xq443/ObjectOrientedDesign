package problem2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LinkedPolynomialTest {

  private LinkedPolynomial testPolynomial;
  private LinkedPolynomial testPolynomial1;

  private LinkedPolynomial testPolynomial2;


  @BeforeEach
  void setUp() {

    Node nextNode = new Node(3, 4, null);
    Node head = new Node(2, 3, nextNode);
    testPolynomial = new LinkedPolynomial(head);

    Node next1 = new Node(3, 4, null);
    Node head1 = new Node(2, 3, next1);
    testPolynomial1 = new LinkedPolynomial(head1);

    Node next2 = new Node(3, 4, null);
    Node head2 = new Node(2, 3, next2);
    testPolynomial2 = new LinkedPolynomial(head2);
  }

  @Test
  void testGetDegree() {
    assertEquals(4, testPolynomial.getDegree());
  }

  @Test
  void testGetCoefficient() {
    assertEquals(2, testPolynomial.getCoefficient(3));
  }

  @Test
  void testAddTerm() {
    testPolynomial.addTerm(4, 5);
    assertEquals(2, testPolynomial.getCoefficient(3));
  }

  @Test
  void testRemoveTerm() {
    testPolynomial.removeTerm(3);
    assertEquals(0, testPolynomial.getCoefficient(3));

    testPolynomial.removeTerm(4);
    assertEquals(0, testPolynomial.getCoefficient(4));

    testPolynomial.removeTerm(9);
    assertEquals(0, testPolynomial.getCoefficient(9));
  }

  @Test
  void testIsSame_SamePolynomial() {
    LinkedPolynomial samePolynomial = new LinkedPolynomial(new Node(2, 3,  new Node(3, 4, null)));
    assertTrue(testPolynomial.isSame(samePolynomial));

    LinkedPolynomial otherPolynomial = new LinkedPolynomial(new Node(2, 9,  new Node(3, 4, null)));;
    assertFalse(testPolynomial.isSame(otherPolynomial));

    assertFalse(testPolynomial.isSame(null));
  }

  @Test
  void testIsSame_DifferentPolynomial() {
    LinkedPolynomial differentPolynomial = new LinkedPolynomial(new Node(9, 3,  new Node(3, 4, null)));
    assertFalse(testPolynomial.isSame(differentPolynomial));
  }

  @Test
  void testAdd() {
    Polynomial otherPolynomial = new LinkedPolynomial(new Node(2, 3,  new Node(3, 4, null)));
    Polynomial result = testPolynomial.add(otherPolynomial);
    assertEquals("6x^4+4x^3", result.printPolynomial());

    Polynomial otherPolynomial1 = new LinkedPolynomial(new Node(-2, 3,  new Node(-3, 4, null)));
    Polynomial result1 = testPolynomial.add(otherPolynomial1);
    assertNull(result1.printPolynomial());

    Polynomial otherPolynomial2 = new LinkedPolynomial(new Node(-2, 8,  new Node(-3, 9, null)));
    Polynomial result2 = testPolynomial.add(otherPolynomial2);
    assertEquals("-3x^9-2x^8+3x^4+2x^3", result2.printPolynomial());

    Polynomial otherPolynomial3 = new LinkedPolynomial(new Node(-2, 1,  new Node(-3, 2, null)));
    Polynomial result3 = testPolynomial.add(otherPolynomial3);
    assertEquals("3x^4+2x^3-3x^2-2x^1", result3.printPolynomial());

    Polynomial result4 = testPolynomial.add(null);
    //assertTrue(result4.printPolynomial().equals("3x^4+2x^3") || result4.printPolynomial().equals("2x^3+3x^4"));
    assertEquals(result4.printPolynomial(), "3x^4+2x^3");

    Polynomial otherPolynomial4 = new LinkedPolynomial(new Node(-2, 1,  new Node(-3, 0, null)));
    Polynomial result5 = testPolynomial.add(otherPolynomial4);
    assertEquals("3x^4+2x^3-2x^1-3", result5.printPolynomial());

    Polynomial otherPolynomial5 = new LinkedPolynomial(new Node(-3, 4,  new Node(-2, 3, null)));
    Polynomial result6 = testPolynomial.add(otherPolynomial5);
    assertNull(result6.printPolynomial());
  }

  @Test
  void testPrintPolynomial() {
    assertEquals("2x^3+3x^4", testPolynomial.printPolynomial());
  }

  @Test
  void testEquals_SameObject() {
    assertTrue(testPolynomial1.equals(testPolynomial1));
  }

  @Test
  void testEquals_NullComparison() {
    assertFalse(testPolynomial1.equals(null));
  }

  @Test
  void testEquals_DifferentType() {
    assertFalse(testPolynomial1.equals("String"));
  }

  @Test
  void testEquals_DifferentPolynomial() {
    LinkedPolynomial differentPolynomial = new LinkedPolynomial(new Node(9, 3,  new Node(3, 4, null)));
    assertFalse(testPolynomial1.equals(differentPolynomial));
  }

  @Test
  void testEquals_SameValues() {
    assertTrue(testPolynomial1.equals(testPolynomial2));
  }

  @Test
  void testHashCode() {
    assertEquals(testPolynomial1.hashCode(), testPolynomial2.hashCode());
  }

  @Test
  void testToString() {
    String expectedToString = "LinkedPolynomial{head=+2x^3}";
    assertEquals(expectedToString, testPolynomial1.toString());
  }
}
