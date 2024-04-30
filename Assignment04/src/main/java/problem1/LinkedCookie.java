package problem1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * LinkedCookie represents a catalog of cookies implemented using a linked list data structure.
 * It implements the CookieCatalog interface.
 */
public class LinkedCookie implements CookieCatalog {

  private Node head; // Reference to the first node in the linked list
  private int size; // Number of cookies in the catalog

  /**
   * Constructs an empty LinkedCookie catalog.
   */
  public LinkedCookie() {
    this.head = null;
    this.size = 0;
  }

  /**
   * Constructs a LinkedCookie catalog with the specified head node and size.
   *
   * @param head The head node of the linked list
   * @param size The number of cookies in the catalog
   */
  public LinkedCookie(Node head, int size) {
    this.head = head;
    this.size = size;
  }

  /**
   * Creates an empty LinkedCookie catalog.
   *
   * @return An empty LinkedCookie catalog
   */
  public CookieCatalog createEmpty() {
    return new LinkedCookie();
  }

  /**
   * Checks if the catalog is empty.
   *
   * @return true if the catalog is empty, false otherwise
   */
  @Override
  public Boolean isEmpty() {
    return this.size == 0;
  }

  /**
   * Returns the number of cookies in the catalog.
   *
   * @return The number of cookies in the catalog
   */
  @Override
  public Integer countCookies() {
    return this.size;
  }
  /**
   * Checks if a cookie with the specified name exists in the catalog.
   *
   * @param cookieName The name of the cookie to check
   * @return true if a cookie with the specified name exists, false otherwise
   */
  @Override
  public Boolean checkCookie(String cookieName) {
    Node curr = this.head;
    while (curr != null) {
      if (curr.getCookie().getName().equals(cookieName)) {
        return true;
      }
      curr = curr.getNext();
    }
    return false;
  }

  /**
   * Adds a new cookie to the catalog.
   * The cookie is added only if a cookie with the same name does not already exist.
   *
   * @param cookie The cookie to add to the catalog
   */
  @Override
  public void addCookie(Cookie cookie) {
    if (!this.checkCookie(cookie.getName())) {
      this.head = new Node(cookie, this.head);
      this.size++;
    }
  }

  /**
   * Removes the specified cookie from the catalog.
   * Throws a CookieNotFoundException if the specified cookie does not exist in the catalog.
   *
   * @param cookie The cookie to remove from the catalog
   * @throws CookieNotFoundException if the specified cookie does not exist in the catalog
   */
  @Override
  public void removeCookie(Cookie cookie) throws CookieNotFoundException {
    if (!this.checkCookie(cookie.getName())) {
      throw new CookieNotFoundException("Cookie Not found");
    }
    if (this.head.getCookie().equals(cookie)) {
      this.head = this.head.getNext();
      this.size--;
    } else {
      Node curr = this.head;
      while (curr.getNext() != null) {
        Node toRemove = curr.getNext();
        if (toRemove.getCookie().equals(cookie)) {
          curr.setNext(toRemove.getNext());
          this.size--;
          return;
        }
        curr = curr.getNext();
      }
    }
  }

  /**
   * Finds and returns a list of cookies that are gluten-free and have less than 30 grams of sugar per serving.
   *
   * @return A list of gluten-free, sugar-lite cookies
   */
  @Override
  public List<Cookie> findGlutenFreeSugarLiteCookies() {
    List<Cookie> ret = new ArrayList<>();
    Node curr = this.head;
    while (curr != null) {
      Cookie currCookie = curr.getCookie();
      if (currCookie.getGlutenFree() && currCookie.getSugarPerServing() < 30) {
        ret.add(currCookie);
      }
      curr = curr.getNext();
    }
    return ret;
  }

  /**
   * Finds and returns a list of cookies that contain both nuts and dairy.
   *
   * @return A list of cookies containing nuts and dairy
   */
  @Override
  public List<Cookie> findNutsAndDairyCookies() {
    List<Cookie> ret = new ArrayList<>();
    Node curr = this.head;
    while (curr != null) {
      Cookie currCookie = curr.getCookie();
      if (currCookie.getContainsDairy() && currCookie.getContainsNuts()) {
        ret.add(currCookie);
      }
      curr = curr.getNext();
    }
    return ret;
  }


  /**
   * Finds and returns a list of cookies that add Cookie objects
   *
   * @return A list of cookies
   *
   * The aim of creating this is just to test the createEmpty and constructor
   * addCookie() methods please follow the void methods above
   */
  @Override
  public LinkedCookie addCookie1(Cookie cookie) {
    LinkedCookie newCookie = (LinkedCookie) createEmpty();
    if (!this.checkCookie(cookie.getName())) {
      newCookie.head = new Node(cookie, this.head);
      newCookie.size++;
    }
    return newCookie;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LinkedCookie that = (LinkedCookie) o;
    return this.size == that.size && Objects.equals(this.head, that.head);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.head, this.size);
  }

  @Override
  public String toString() {
    return "LinkedCookie{" +
        "head=" + this.head +
        ", size=" + this.size +
        '}';
  }
}
