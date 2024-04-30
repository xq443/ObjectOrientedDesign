package problem1;

import java.util.Objects;

/**
 * Represents a non-empty priority queue.
 */
public class NonEmptyPQ implements PriorityQueue {

  private Node headPQ;
  private PriorityQueue restOfPQ;

  /**
   * Constructs a non-empty priority queue with the given head node and the rest of the priority queue.
   *
   * @param headPQ   The head node of the priority queue.
   * @param restOfPQ The rest of the priority queue.
   */
  public NonEmptyPQ(Node headPQ, PriorityQueue restOfPQ) {
    this.headPQ = headPQ;
    this.restOfPQ = restOfPQ;
  }

  /**
   * Retrieves the head node of the priority queue.
   *
   * @return The head node of the priority queue.
   */
  public Node getHeadPQ() {
    return this.headPQ;
  }

  /**
   * Retrieves the rest of the priority queue.
   *
   * @return The rest of the priority queue.
   */
  public PriorityQueue getRestOfPQ() {
    return this.restOfPQ;
  }

  /**
   * Checks if the priority queue is empty.
   *
   * @return Always returns {@code false} since this is a non-empty priority queue.
   */
  @Override
  public Boolean isEmpty() {
    return Boolean.FALSE;
  }

  /**
   * Adds an element with the given priority to the priority queue.
   *
   * @param priority The priority of the element to be added.
   * @param value    The value of the element to be added.
   * @return The updated priority queue.
   */

  @Override
  public PriorityQueue add(Integer priority, String value) {
    // assume this is a max priority queue, with the priority listed in desc order
    if (priority > this.headPQ.getPriority()) {
      return new NonEmptyPQ(new Node(priority, value), this);
    } else {
      // Otherwise, recursively add the new node to the rest of the priority queue
      return new NonEmptyPQ(this.headPQ, this.restOfPQ.add(priority, value));
    }
  }

  /**
   * Retrieves the value of the element with the highest priority.
   *
   * @return The value of the element with the highest priority.
   */
  @Override
  public String peek() {
    // assume:  if the priority is the same, assume it will pop and peek the first added node's value
    if (this.restOfPQ.isEmpty()) return this.headPQ.getValue();
    return this.headPQ.getValue();
  }

  /**
   * Removes and returns the element with the highest priority from the priority queue.
   *
   * @return The updated priority queue after removing the element with the highest priority.
   */
  @Override
  public PriorityQueue pop()  {
    if (this.restOfPQ.isEmpty()) return new EmptyPQ();
    return this.restOfPQ;
  }

  /**
   * Checks if this non-empty priority queue is equal to another object.
   *
   * @param o The object to compare with.
   * @return {@code true} if the objects are equal, {@code false} otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NonEmptyPQ that = (NonEmptyPQ) o;
    return Objects.equals(this.headPQ, that.headPQ) && Objects.equals(this.restOfPQ,
        that.restOfPQ);
  }

  /**
   * Computes the hash code of this non-empty priority queue.
   *
   * @return The hash code of this non-empty priority queue.
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.headPQ, this.restOfPQ);
  }

  /**
   * Returns a string representation of this non-empty priority queue.
   *
   * @return A string representation of this non-empty priority queue.
   */
  @Override
  public String toString() {
    return "NonEmptyPQ{" +
        "headPQ=" + this.headPQ +
        ", restOfPQ=" + this.restOfPQ +
        '}';
  }
}
