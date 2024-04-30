package problem1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NodeTest {

  private Node testNode;
  private Cookie testCookie;
  private Node nextNode;

  @BeforeEach
  void setUp() {
    testCookie = new Cookie("Chocolate Chip Cookie",
        new String[]{"flour", "sugar", "butter", "chocolate chips"},
        1.0, 200.0, 20.0, 10.0, 5.0, 2.0, true, true, false);

    nextNode = new Node(new Cookie("Next Cookie", new String[]{"flour", "sugar"}, 1.5, 150.0, 15.0, 8.0, 3.0, 1.5, false, false, true), null);

    testNode = new Node(testCookie, nextNode);
  }

  @Test
  void testGetCookie() {
    assertEquals(testCookie, testNode.getCookie());
  }

  @Test
  void testSetCookie() {
    Cookie newCookie = new Cookie("New Cookie", new String[]{"flour", "sugar"}, 1.5, 150.0, 15.0, 8.0, 3.0, 1.5, false, false, true);
    testNode.setCookie(newCookie);
    assertEquals(newCookie, testNode.getCookie());
  }

  @Test
  void testGetNext() {
    assertEquals(nextNode, testNode.getNext());
  }

  @Test
  void testSetNext() {
    Node newNextNode = new Node(new Cookie("New Next Cookie", new String[]{"flour", "sugar"}, 1.5, 150.0, 15.0, 8.0, 3.0, 1.5, false, false, true), null);
    testNode.setNext(newNextNode);
    assertEquals(newNextNode, testNode.getNext());
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
  void testEquals_DifferentCookie() {
    Node otherNode = new Node(new Cookie("Other Cookie", new String[]{"flour", "sugar"},
        1.5, 150.0, 15.0, 8.0, 3.0,
        1.5, false, false, true), null);
    assertFalse(testNode.equals(otherNode));
  }

  @Test
  void testEquals_DifferentNext() {
    Node otherNode = new Node(testCookie, new Node(new Cookie("Next Cookie", new String[]{"flour", "sugar"},
        1.5, 150.0, 15.0, 8.0, 3.0,
        1.0, false, false, true), null));
    assertFalse(testNode.equals(otherNode));
  }

  @Test
  void testEquals_SameValues() {
    Node otherNode = new Node(new Cookie("Chocolate Chip Cookie", new String[]{"flour", "sugar", "butter", "chocolate chips"},
        1.0, 200.0, 20.0, 10.0, 5.0, 2.0,
        true, true, false), nextNode);
    assertTrue(testNode.equals(otherNode));
  }

  @Test
  void testHashCode() {
    assertEquals(testNode.hashCode(), new Node(testCookie, nextNode).hashCode());
  }

  @Test
  void testToString() {
    String expectedToString = "Node{" +
        "cookie=" + testCookie +
        ", next=" + nextNode +
        '}';
    assertEquals(expectedToString, testNode.toString());
  }
}
