package problem1;

/**
 * Interface for a priority queue.
 */
public interface PriorityQueue {

  /**
   * Creates and returns an empty priority queue.
   *
   * @return An empty priority queue.
   */
  static PriorityQueue createEmpty() {
    return new EmptyPQ();
  }

  /**
   * Checks if the priority queue is empty.
   *
   * @return {@code true} if the priority queue is empty, otherwise {@code false}.
   */
  Boolean isEmpty();

  /**
   * Adds an element with the given priority to the priority queue.
   *
   * @param priority The priority of the element to be added.
   * @param value    The value of the element to be added.
   * @return The updated priority queue.
   */
  PriorityQueue add(Integer priority, String value);

  /**
   * Retrieves the value of the element with the highest priority without removing it from the priority queue.
   *
   * @return The value of the element with the highest priority.
   * @throws InvalidPeekException If the priority queue is empty.
   */
  String peek() throws InvalidPeekException;

  /**
   * Removes and returns the element with the highest priority from the priority queue.
   *
   * @return The updated priority queue after removing the element with the highest priority.
   * @throws InvalidPopException If the priority queue is empty.
   */
  PriorityQueue pop() throws InvalidPopException;
}
