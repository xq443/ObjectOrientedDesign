package problem1;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PriorityQueueTest {

  @Test
  void testCreateEmpty() {
    PriorityQueue emptyQueue = PriorityQueue.createEmpty();
    assertTrue(emptyQueue.isEmpty());
  }
}