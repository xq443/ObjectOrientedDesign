package problem1;

import java.util.Objects;

/**
 * A node in a linked list representing a Cookie object.
 */
public class Node {
  private Cookie cookie;
  private Node next;

  /**
   * Constructs a new node with the specified Cookie object and next node reference.
   *
   * @param cookie The Cookie object to be stored in the node
   * @param next   The reference to the next node in the linked list
   */
  public Node(Cookie cookie, Node next) {
    this.cookie = cookie;
    this.next = next;
  }

  /**
   * Retrieves the Cookie object stored in this node.
   *
   * @return The Cookie object stored in the node
   */
  public Cookie getCookie() {
    return this.cookie;
  }

  /**
   * Sets the Cookie object to be stored in this node.
   *
   * @param cookie The Cookie object to be stored in the node
   */
  public void setCookie(Cookie cookie) {
    this.cookie = cookie;
  }

  /**
   * Retrieves the reference to the next node in the linked list.
   *
   * @return The reference to the next node
   */
  public Node getNext() {
    return this.next;
  }

  /**
   * Sets the reference to the next node in the linked list.
   *
   * @param next The reference to the next node
   */
  public void setNext(Node next) {
    this.next = next;
  }

  /**
   * Compares this node with the specified object for equality.
   *
   * @param o The object to compare with this node
   * @return true if the specified object is equal to this node, false otherwise
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
    return Objects.equals(this.cookie, node.cookie) && Objects.equals(this.next, node.next);
  }

  /**
   * Computes a hash code for this node.
   *
   * @return The hash code value for this node
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.cookie, this.next);
  }

  /**
   * Returns a string representation of this node.
   *
   * @return A string representation of this node
   */
  @Override
  public String toString() {
    return "Node{" +
        "cookie=" + this.cookie +
        ", next=" + this.next +
        '}';
  }
}
