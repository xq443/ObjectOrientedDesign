package problem2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * Represents a polynomial implemented as a linked list of nodes.
 */
public class LinkedPolynomial implements Polynomial{
  private Node head;
  private static final Integer MIN_POWER = -1;

  /**
   * Constructs an empty LinkedPolynomial.
   */
  public LinkedPolynomial(){
    this.head = null;
  }
  /**
   * Constructs a LinkedPolynomial with the given head node.
   *
   * @param head the head node of the linked list representing the polynomial
   */
  public LinkedPolynomial(Node head) {
    this.head = head;
  }

  /**
   * Creates and returns an empty Polynomial.
   *
   * @return an empty LinkedPolynomial
   */
  public Polynomial createEmpty(){
    return new LinkedPolynomial();
  }



  /**
   * Returns the degree of the polynomial.
   *
   * @return the highest power of the polynomial, or -1 if the polynomial is empty
   */
  @Override
  public Integer getDegree() {
    int maxPower = MIN_POWER;
    Node curr = this.head;
    while(curr != null){
      if (curr.getPower() > maxPower) {
        maxPower = curr.getPower();
      }
      curr = curr.getNext();
    }
    return maxPower;
  }



  /**
   * Returns the coefficient of the term with the specified power in the polynomial.
   *
   * @param power the power of the term
   * @return the coefficient of the term with the specified power, or 0 if the term doesn't exist
   */
  @Override
  public Integer getCoefficient(int power) {
    Node curr = this.head;
    while(curr != null) {
      if(curr.getPower() == power) return curr.getCoefficient();
      curr = curr.getNext();
    }
    return 0; // If the node with given power doesn't exist, return 0
  }


  /**
   * Adds a term to the polynomial with the given power and coefficient.
   * If a term with the same power already exists, its coefficient is updated by adding the new coefficient.
   *
   * @param power       the power of the term to add
   * @param coefficient the coefficient of the term to add
   */
  @Override
  public void addTerm(int power, int coefficient) {
    Node curr = this.head;
    while(curr != null){
      if(curr.getPower() == power){
        curr.setCoefficient(curr.getCoefficient() + coefficient);
      }
      curr = curr.getNext();
    }
  }

  /**
   * Removes the term with the specified power from the polynomial.
   *
   * @param power the power of the term to remove
   */
  @Override
  public void removeTerm(int power) {
    Node curr = this.head;
    while(curr != null){
      if (curr.getPower() == power) {
        curr.setCoefficient(0);
        break;
      }
      curr = curr.getNext();
    }
  }
  /**
   * Determines whether this polynomial is the same as another polynomial.
   *
   * @param polynomial the polynomial to compare with
   * @return true if the polynomials are the same, false otherwise
   */
  @Override
  public Boolean isSame(Polynomial polynomial) {
    if(polynomial == null) return  false;
    if(!Objects.equals(this.getDegree(), polynomial.getDegree())) return false;
    for(int i = 0; i < this.getDegree(); i++){
      if(!Objects.equals(this.getCoefficient(i), polynomial.getCoefficient(i))) return false;
    }
    return true;
  }

  /**
   * Adds sortedPower method to sort the getPower() in desc order
   *
   * @param polynomial the polynomial to add
   * @return polynomial object
   */
  private Polynomial sortedPower(Polynomial polynomial) {
    // Convert the polynomial into a list of nodes for sorting
    List<Node> termsList = new ArrayList<>();
    Node current = ((LinkedPolynomial) polynomial).head;
    while (current != null) {
      termsList.add(current);
      current = current.getNext();
    }
    // Sort based on powers in desc
    termsList.sort(new Comparator<Node>() {
      @Override
      public int compare(Node o1, Node o2) {
        return Integer.compare(o2.getPower(), o1.getPower());
      }
    });

    // Create a new sorted polynomial obj from the list of node
    LinkedPolynomial sortedPolynomial = new LinkedPolynomial();
    Node prev = null;
    for (Node curr : termsList) {
      Node newNode = new Node(curr.getCoefficient(), curr.getPower(), null);
      if (prev == null) {
        sortedPolynomial.head = newNode;
      } else {
        prev.setNext(newNode);
      }
      prev = newNode;
    }
    return sortedPolynomial;
  }

  /**
   * Adds another polynomial to this polynomial and returns the result.
   *
   * @param polynomial the polynomial to add
   * @return the result of adding the two polynomials
   */
  @Override
  public Polynomial add(Polynomial polynomial) {
    if (polynomial == null)
      return sortedPower(this);
    //create both new LinkedPolynomial obj based on powers in desc
    LinkedPolynomial theOne = (LinkedPolynomial) sortedPower(this);
    LinkedPolynomial other = (LinkedPolynomial) sortedPower(polynomial);
    Node currThis = theOne.head;
    Node currOther = other.head;

    // Create a new instance for the result polynomial
    LinkedPolynomial ret = (LinkedPolynomial) createEmpty();
    Node retCurr = null; // Track the current node in the result polynomial

    while (currThis != null || currOther != null) {
      int power;
      int coefficient;

      if (currThis == null) {
        power = currOther.getPower();
        coefficient = currOther.getCoefficient();
        currOther = currOther.getNext();
      } else if (currOther == null) {
        power = currThis.getPower();
        coefficient = currThis.getCoefficient();
        currThis = currThis.getNext();
      } else {
        if (Objects.equals(currThis.getPower(), currOther.getPower())) {
          power = currThis.getPower();
          coefficient = currThis.getCoefficient() + currOther.getCoefficient();
          currThis = currThis.getNext();
          currOther = currOther.getNext();
        } else if (currThis.getPower() > currOther.getPower()) {
          power = currThis.getPower();
          coefficient = currThis.getCoefficient();
          currThis = currThis.getNext();
        } else {
          power = currOther.getPower();
          coefficient = currOther.getCoefficient();
          currOther = currOther.getNext();
        }
      }
      if (coefficient != 0) {
        Node newNode = new Node(coefficient, power, null);
        if (ret.head == null) {
          ret.head = newNode;
          retCurr = newNode;
        } else {
          retCurr.setNext(newNode);
          retCurr = newNode;
        }
      }
    }
    return sortedPower(ret);
  }

  /**
   * Returns a string representation of the polynomial.
   *
   * @return a string representing the polynomial
   */

  @Override
  public String printPolynomial() {
    StringBuilder ret = new StringBuilder();
    Node curr = this.head;
    if(curr == null) return null;
    //deal with the head node: exclude the positive sign +
    if(curr.getCoefficient() > 0) {
      ret.append(curr.toString().substring(1));
      curr = curr.getNext();
    }
    while(curr != null){
      ret.append(curr.toString());
      curr = curr.getNext();
    }
    return ret.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LinkedPolynomial that = (LinkedPolynomial) o;
    return Objects.equals(this.head, that.head);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.head);
  }

  @Override
  public String toString() {
    return "LinkedPolynomial{" +
        "head=" + this.head +
        '}';
  }
}
