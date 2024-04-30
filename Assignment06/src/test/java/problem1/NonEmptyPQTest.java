package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NonEmptyPQTest {

  private NonEmptyPQ nonEmptyPQ;

  @BeforeEach
  void setUp() {
    nonEmptyPQ = new NonEmptyPQ(new Node(5, "Value1"),
        new EmptyPQ()); // Initialize restOfPQ as null
  }

  @Test
  void testIsEmpty() {
    assertFalse(nonEmptyPQ.isEmpty());
  }

  @Test
  void testGetRestOfPQ() {
    // Creating a non-empty priority queue
    Node head = new Node(1, "A");
    PriorityQueue rest = new NonEmptyPQ(new Node(2, "B"), new EmptyPQ());
    NonEmptyPQ pq = new NonEmptyPQ(head, rest);

    // Ensure that getRestOfPQ returns the correct rest of the queue
    assertEquals(rest, pq.getRestOfPQ());
  }

  @Test
  void testAdd() {
    // Test adding a node with higher priority
    PriorityQueue newPQ = nonEmptyPQ.add(10, "Value2");
    assertTrue(newPQ instanceof NonEmptyPQ);
    assertEquals(10, ((NonEmptyPQ) newPQ).getHeadPQ().getPriority());
    assertEquals("Value2", ((NonEmptyPQ) newPQ).getHeadPQ().getValue());

    // Test adding a node with lower priority
    newPQ = nonEmptyPQ.add(13, "Value3");
    assertTrue(newPQ instanceof NonEmptyPQ);
    assertEquals(13, ((NonEmptyPQ) newPQ).getHeadPQ().getPriority());
    assertEquals("Value3", ((NonEmptyPQ) newPQ).getHeadPQ().getValue());
  }

  @Test
  void testPeek() throws InvalidPeekException {
    assertEquals("Value1", nonEmptyPQ.peek());
  }

  @Test
  void testPopEmptyQueue() throws InvalidPopException {
    PriorityQueue emptyPQ = new EmptyPQ();
    NonEmptyPQ nonEmptyPQ = new NonEmptyPQ(new Node(1, "Value"), emptyPQ);
    PriorityQueue result = nonEmptyPQ.pop();
    assertTrue(result instanceof EmptyPQ);
  }

  @Test
  void testPopNonEmptyQueue() throws InvalidPopException {
    // Create a non-empty priority queue with two elements
    PriorityQueue emptyPQ = new EmptyPQ();
    PriorityQueue nonEmptyPQ = new NonEmptyPQ(new Node(1, "Value"), emptyPQ);
    NonEmptyPQ nonEmptyPQWithRest = new NonEmptyPQ(new Node(2, "New Value"), nonEmptyPQ);
    PriorityQueue result = nonEmptyPQWithRest.pop();
    assertEquals("NonEmptyPQ{headPQ=Node{priority=1, value='Value'}, restOfPQ=" + emptyPQ.toString() + "}", result.toString());
  }

  @Test
  void testPeek_MoreThanTwoNodes_Diffpriority() {
    // Add more nodes
    nonEmptyPQ = (NonEmptyPQ) nonEmptyPQ.add(1000, "1");
    nonEmptyPQ = (NonEmptyPQ) nonEmptyPQ.add(10, "2");
    nonEmptyPQ = (NonEmptyPQ) nonEmptyPQ.add(8, "Value3");
    nonEmptyPQ = (NonEmptyPQ) nonEmptyPQ.add(10, "1000");
    // Ensure that peek returns the value of the highest priority node
    assertEquals("1", nonEmptyPQ.peek());
  }

  @Test
  void testPeek_MoreThanTwoNodes_SamePriority()  {
    // Add more nodes
    nonEmptyPQ = (NonEmptyPQ) nonEmptyPQ.add(10, "2");
    nonEmptyPQ = (NonEmptyPQ) nonEmptyPQ.add(8, "Value3");
    nonEmptyPQ = (NonEmptyPQ) nonEmptyPQ.add(10, "1000");
    // Ensure that peek returns the first added node's value
    assertEquals("2", nonEmptyPQ.peek());
  }

  @Test
  void testEquals() {
    NonEmptyPQ differentPQ1 = new NonEmptyPQ(new Node(1, "Value1"), new EmptyPQ());
    NonEmptyPQ differentPQ2 = new NonEmptyPQ(new Node(5, "Value2"), new EmptyPQ());
    assertTrue(nonEmptyPQ.equals(nonEmptyPQ));
    assertFalse(nonEmptyPQ.equals(null));
    assertFalse(nonEmptyPQ.equals("String"));
    assertFalse(nonEmptyPQ.equals(differentPQ1));
    assertFalse(nonEmptyPQ.equals(differentPQ2));
  }
  @Test
  void testHashCode() {
    int expHashCode = Objects.hash(nonEmptyPQ.getHeadPQ(), nonEmptyPQ.getRestOfPQ());
    assertEquals(expHashCode, nonEmptyPQ.hashCode());
  }

  @Test
  void testToString() {
    String expStr = "NonEmptyPQ{" +
        "headPQ=" + nonEmptyPQ.getHeadPQ() +
        ", restOfPQ=" + nonEmptyPQ.getRestOfPQ() +
        '}';
    assertEquals(expStr, nonEmptyPQ.toString());
  }
}