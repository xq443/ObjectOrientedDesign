package problem2;

import java.util.Objects;

/**
 * Represents a node in a linked list used for polynomial representation.
 * Each node contains coefficient, power, and a reference to the next node.
 */
public class Node {
  private Integer coefficient;
  private Integer power;
  private Node next;

  /**
   * Constructs a Node with the specified coefficient, power, and reference to the next node.
   *
   * @param coefficient the coefficient of the term
   * @param power       the power of the term
   * @param next        the reference to the next node in the linked list
   */
  public Node(Integer coefficient, Integer power, Node next) {
    this.coefficient = coefficient;
    this.power = power;
    this.next = next;
  }

  /**
   * Returns the coefficient of the term.
   *
   * @return the coefficient of the term
   */
  public Integer getCoefficient() {
    return coefficient;
  }

  /**
   * Returns the power of the term.
   *
   * @return the power of the term
   */
  public Integer getPower() {
    return power;
  }

  /**
   * Returns the reference to the next node in the linked list.
   *
   * @return the reference to the next node
   */
  public Node getNext() {
    return next;
  }

  /**
   * Sets the coefficient of the term.
   *
   * @param coefficient the coefficient to set
   */
  public void setCoefficient(Integer coefficient) {
    this.coefficient = coefficient;
  }

  /**
   * Sets the power of the term.
   *
   * @param power the power to set
   */
  public void setPower(Integer power) {
    this.power = power;
  }

  /**
   * Sets the reference to the next node in the linked list.
   *
   * @param next the reference to the next node
   */
  public void setNext(Node next) {
    this.next = next;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Node term = (Node) o;
    return Objects.equals(coefficient, term.coefficient) && Objects.equals(power,
        term.power) && Objects.equals(next, term.next);
  }

  @Override
  public int hashCode() {
    return Objects.hash(coefficient, power, next);
  }

  @Override
  public String toString() { //deal with '^'
    StringBuilder ret = new StringBuilder();
    if(this.coefficient > 0) ret.append('+');
    if(this.getPower() >= 1){
      ret.append(this.coefficient).append('x').append('^').append(this.power);
    }else{ //this.getPower() == 0
      ret.append(this.coefficient);
    }
    return ret.toString();
  }
}
