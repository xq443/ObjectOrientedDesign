package problem2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NodeTest {

  private Node testNode;
  private Node nextNode;

  @BeforeEach
  void setUp() {
    testNode = new Node(2, 3, null);
    nextNode = new Node(3, 4, null);
  }

  @Test
  void testGetCoefficient() {
    assertEquals(2, testNode.getCoefficient());
  }

  @Test
  void testGetPower() {
    assertEquals(3, testNode.getPower());
  }

  @Test
  void testGetNext() {
    assertEquals(null, testNode.getNext());
  }
  @Test
  void testSetCoefficient() {
    testNode.setCoefficient(5);
    assertEquals(5, testNode.getCoefficient());
  }

  @Test
  void testSetPower() {
    testNode.setPower(4);
    assertEquals(4, testNode.getPower());
  }

  @Test
  void testSetNext() {
    testNode.setNext(nextNode);
    assertEquals(nextNode, testNode.getNext());
  }

  @Test
  void testEquals_SameObject() {
    assertTrue(testNode.equals(testNode));
  }

  @Test
  void testEquals_NullComparison() {
    assertFalse(testNode.equals(null));
  }

  @Test
  void testEquals_DifferentType() {
    assertFalse(testNode.equals("String"));
  }

  @Test
  void testEquals_DifferentCoefficient() {
    Node otherNode = new Node(3, 3, null);
    assertFalse(testNode.equals(otherNode));
  }

  @Test
  void testEquals_DifferentPower() {
    Node otherNode = new Node(2, 4, null);
    assertFalse(testNode.equals(otherNode));
  }

  @Test
  void testEquals_DifferentNext() {
    Node otherNode = new Node(2, 3, nextNode);
    assertFalse(testNode.equals(otherNode));
  }

  @Test
  void testEquals_SameValues() {
    Node otherNode = new Node(2, 3, null);
    assertTrue(testNode.equals(otherNode));
  }

  @Test
  void testHashCode() {
    Node otherNode = new Node(2, 3, null);
    assertEquals(testNode.hashCode(), otherNode.hashCode());
  }

  @Test
  void testToString_PositivePower() {
    Node node = new Node(2, 3, null);
    assertEquals("+2x^3", node.toString());
  }

  @Test
  void testToString_ZeroPower() {
    Node node = new Node(2, 0, null);
    assertEquals("+2", node.toString());
  }
  @Test
  void testToString_NegativeFirstCoeffient() {
    Node node = new Node(-2, 0, null);
    assertEquals("-2", node.toString());
  }
}
