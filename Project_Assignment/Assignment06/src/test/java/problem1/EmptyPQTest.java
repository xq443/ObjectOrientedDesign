package problem1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmptyPQTest {

  private EmptyPQ emptyPQ;

  @BeforeEach
  void setUp() {
    emptyPQ = new EmptyPQ();
  }


  @Test
  void testIsEmpty() {
    assertTrue(emptyPQ.isEmpty());
  }

  @Test
  void testAdd() {
    PriorityQueue newPQ = emptyPQ.add(5, "Value");
    assertTrue(newPQ instanceof NonEmptyPQ);
  }

  @Test
  void testPeekThrowsException() {
    assertThrows(InvalidPeekException.class, () -> emptyPQ.peek());
  }

  @Test
  void testPopThrowsException() {
    assertThrows(InvalidPopException.class, () -> emptyPQ.pop());
  }
}
