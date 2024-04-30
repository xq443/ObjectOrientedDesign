package problem1;

import java.util.Objects;

/**
 * Represents a node in a priority queue.
 */
public class Node {
  private Integer priority;
  private String value;

  /**
   * Constructs a new node with the given priority and value.
   *
   * @param priority The priority of the node.
   * @param value    The value of the node.
   */
  public Node(Integer priority, String value) {
    this.priority = priority;
    this.value = value;
  }

  /**
   * Retrieves the priority of the node.
   *
   * @return The priority of the node.
   */
  public Integer getPriority() {
    return this.priority;
  }

  /**
   * Retrieves the value of the node.
   *
   * @return The value of the node.
   */
  public String getValue() {
    return this.value;
  }

  /**
   * Checks if this node is equal to another object.
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
    Node node = (Node) o;
    return Objects.equals(this.priority, node.priority) && Objects.equals(this.value, node.value);
  }

  /**
   * Computes the hash code of this node.
   *
   * @return The hash code of this node.
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.priority, this.value);
  }

  /**
   * Returns a string representation of this node.
   *
   * @return A string representation of this node.
   */
  @Override
  public String toString() {
    return "Node{" +
        "priority=" + this.priority +
        ", value='" + this.value + '\'' +
        '}';
  }
}