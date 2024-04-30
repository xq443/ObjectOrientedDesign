package problem1;

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
    testNode = new Node(2, "3");
    nextNode = new Node(3, "4");
  }

  @Test
  void testGetPriority() {
    assertEquals(2, testNode.getPriority());
  }

  @Test
  void testGetValue() {
    assertEquals("3", testNode.getValue());
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
  void testEquals_DifferentPriority() {
    Node otherNode = new Node(5, "3");
    assertFalse(testNode.equals(otherNode));
  }

  @Test
  void testEquals_DifferentValue() {
    Node otherNode = new Node(2, "9");
    assertFalse(testNode.equals(otherNode));
  }


  @Test
  void testEquals_SameValues() {
    Node otherNode = new Node(2, "3");
    assertTrue(testNode.equals(otherNode));
  }

  @Test
  void testHashCode() {
    Node otherNode = new Node(2, "3");
    assertEquals(testNode.hashCode(), otherNode.hashCode());
  }

  @Test
  void testToString() {
    String expStr = "Node{" +
        "priority=" + testNode.getPriority() +
        ", value='" + testNode.getValue() + '\'' +
        '}';
    assertEquals(expStr, testNode.toString());
  }
}