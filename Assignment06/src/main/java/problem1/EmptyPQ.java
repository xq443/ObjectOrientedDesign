package problem1;

/**
 * Represents an empty priority queue class.
 */
public class EmptyPQ implements PriorityQueue {

  /**
   * Checks if the priority queue is empty.
   *
   * @return Always returns {@code true} since this is an empty priority queue.
   */
  @Override
  public Boolean isEmpty() {
    return Boolean.TRUE;
  }

  /**
   * Adds an element with the given priority to the priority queue.
   *
   * @param priority The priority of the element to be added.
   * @param value    The value of the element to be added.
   * @return A new priority queue containing only the added element.
   */
  @Override
  public PriorityQueue add(Integer priority, String value) {
    return new NonEmptyPQ(new Node(priority, value), this);
  }

  /**
   * Retrieves the value of the element with the highest priority without removing it from the priority queue.
   *
   * @return This method always throws an {@link InvalidPeekException} since the priority queue is empty.
   * @throws InvalidPeekException If attempting to peek from an empty priority queue.
   */
  @Override
  public String peek() throws InvalidPeekException {
    throw new InvalidPeekException("Cannot peek from an empty priority queue");
  }

  /**
   * Removes and returns the element with the highest priority from the priority queue.
   *
   * @return This method always throws an {@link InvalidPopException} since the priority queue is empty.
   * @throws InvalidPopException If attempting to pop from an empty priority queue.
   */
  @Override
  public PriorityQueue pop() throws InvalidPopException {
    throw new InvalidPopException("Cannot pop from an empty priority queue");
  }
}
