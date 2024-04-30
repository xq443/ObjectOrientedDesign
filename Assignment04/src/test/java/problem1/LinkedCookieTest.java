package problem1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LinkedCookieTest {

  private LinkedCookie linkedCookie;
  private LinkedCookie linkedCookie1;
  private LinkedCookie linkedCookie2;
  private Cookie cookie1;
  private Cookie cookie2;
  private Cookie cookie3;

  @BeforeEach
  void setUp() {
    cookie1 = new Cookie("Cookie1", new String[]{"ingredient1", "ingredient2"}, 1.0, 100.0, 0.0, 5.0, 3.0, 1.0, true, false, true);
    cookie2 = new Cookie("Cookie2", new String[]{"ingredient3", "ingredient4"}, 1.5, 150.0, 15.0, 8.0, 3.0, 1.5, true, true, false);
    cookie3 = new Cookie("Cookie3", new String[]{"ingredient5", "ingredient4"}, 1.5, 180.0, 15.0, 8.0, 3.0, 1.5, true, true, false);
    linkedCookie1 = new LinkedCookie(null, 0);
    linkedCookie2 = new LinkedCookie(null, 0);
    linkedCookie = new LinkedCookie(null, 0);
  }

  @Test
  void testIsEmpty() {
    assertTrue(linkedCookie.isEmpty());
    linkedCookie.addCookie(cookie1);
    assertFalse(linkedCookie.isEmpty());
  }

  @Test
  void countCookies() {
    assertEquals(0, linkedCookie.countCookies());
  }

  @Test
  void checkCookie() {
    linkedCookie.addCookie(cookie1);
    assertTrue(linkedCookie.checkCookie("Cookie1"));
    assertFalse(linkedCookie.checkCookie("Cookie2"));
  }

  @Test
  void addCookie() {
    linkedCookie.addCookie(cookie1);
    assertEquals(1, linkedCookie.countCookies());
    linkedCookie.addCookie(cookie2);
    assertEquals(2, linkedCookie.countCookies());
    assertTrue(linkedCookie.checkCookie("Cookie2"));
  }

  @Test
  void removeCookie() throws CookieNotFoundException {
    linkedCookie.addCookie(cookie1); // Add some cookies to the catalog
    linkedCookie.addCookie(cookie2);
    linkedCookie.addCookie(cookie3);

    // Test removing a cookie from the beginning
    linkedCookie.removeCookie(cookie1);
    assertFalse(linkedCookie.checkCookie(cookie1.getName())); // Ensure the cookie1 is removed
    assertEquals(2, linkedCookie.countCookies()); // Ensure the size is updated correctly

    // Test removing a cookie from the middle
    linkedCookie.removeCookie(cookie2);
    assertFalse(linkedCookie.checkCookie(cookie2.getName())); // Ensure the cookie2 is removed
    assertEquals(1, linkedCookie.countCookies()); // Ensure the size is updated correctly

    // Test removing a cookie from the end
    linkedCookie.removeCookie(cookie3);
    assertFalse(linkedCookie.checkCookie(cookie3.getName())); // Ensure the cookie3 is removed
    assertEquals(0, linkedCookie.countCookies()); // Ensure the size is updated correctly

    // Test removing a cookie that doesn't exist
    assertThrows(CookieNotFoundException.class, () -> linkedCookie.removeCookie(cookie1));
  }


  @Test
  void findGlutenFreeSugarLiteCookies() {
    linkedCookie.addCookie(cookie1);
    linkedCookie.addCookie(cookie2);
    List<Cookie> glutenFreeSugarLiteCookies = linkedCookie.findGlutenFreeSugarLiteCookies();

    assertTrue(glutenFreeSugarLiteCookies.contains(cookie1));
    assertEquals(1, glutenFreeSugarLiteCookies.size());
    assertFalse(glutenFreeSugarLiteCookies.contains(cookie2));
  }

  @Test
  void findNutsAndDairyCookies() {
    linkedCookie.addCookie(cookie1);
    linkedCookie.addCookie(cookie2);

    List<Cookie> nutsAndDairyCookies = linkedCookie.findNutsAndDairyCookies();
    assertEquals(1, nutsAndDairyCookies.size());
    assertTrue(nutsAndDairyCookies.contains(cookie2));
    assertFalse(nutsAndDairyCookies.contains(cookie1));
  }
  @Test
  void testAddCookie1_AddNewCookie() {
    Cookie cookie4 = new Cookie("Cookie4", new String[]{"ingredient5", "ingredient4"}, 1.5, 188.0, 15.0, 8.0, 3.0, 1.5, true, true, false);

    linkedCookie = linkedCookie.addCookie1(cookie4);

    assertTrue(linkedCookie.checkCookie("Cookie4"));
    assertEquals(1, linkedCookie.countCookies());
  }


  @Test
  void testEquals_SameObject() {
    assertTrue(linkedCookie.equals(linkedCookie));
  }

  @Test
  void testEquals_NullComparison() {
    assertFalse(linkedCookie.equals(null));
  }

  @Test
  void testEquals_DifferentType() {
    assertFalse(linkedCookie.equals("String"));
  }

  @Test
  void testEquals_DifferentSize() {
    LinkedCookie linkedCookie3 = new LinkedCookie(null, 1);
    assertFalse(linkedCookie.equals(linkedCookie3));
  }

  @Test
  void testEquals_DifferentHead() {
    Node head1 = new Node(new Cookie("Cookie1", new String[]{"ingredient1", "ingredient2"}, 1.0, 100.0, 0.0, 5.0, 3.0, 1.0, true, false, true), null);
    Node head2 = new Node(new Cookie("Cookie2", new String[]{"ingredient3", "ingredient4"}, 1.5, 150.0, 15.0, 8.0, 3.0, 1.5, true, true, false), null);
    LinkedCookie linkedCookie3 = new LinkedCookie(head1, 1);
    LinkedCookie linkedCookie4 = new LinkedCookie(head2, 1);
    assertFalse(linkedCookie3.equals(linkedCookie4));
  }

  @Test
  void testEquals_SameValues() {
    assertTrue(linkedCookie1.equals(linkedCookie2));
  }

  @Test
  void testHashCode() {
    assertEquals(linkedCookie1.hashCode(), linkedCookie2.hashCode());
  }

  @Test
  void testToString() {
    String expectedToString = "LinkedCookie{" +
        "head=null" +
        ", size=0" +
        '}';
    assertEquals(expectedToString, linkedCookie1.toString());
  }
}
