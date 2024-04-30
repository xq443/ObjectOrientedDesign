package problem1;

import java.util.List;

/**
 * The CookieCatalog interface represents a catalog of cookies.
 * It provides methods to interact with the catalog such as adding, removing, and finding cookies.
 */
public interface CookieCatalog {
  CookieCatalog createEmpty();
  /**
   * Checks if the cookie catalog is empty.
   *
   * @return true if the catalog is empty, false otherwise.
   */
  Boolean isEmpty();

  /**
   * Counts the number of cookies in the catalog.
   *
   * @return the number of cookies in the catalog.
   */
  Integer countCookies();

  /**
   * Checks if a cookie with the given name exists in the catalog.
   *
   * @param cookieName the name of the cookie to check.
   * @return true if a cookie with the given name exists, false otherwise.
   */
  Boolean checkCookie(String cookieName);

  /**
   * Adds a cookie to the catalog.
   *
   * @param cookie the cookie to add to the catalog.
   */
  void addCookie(Cookie cookie);

  /**
   * Removes a cookie from the catalog.
   *
   * @param cookie the cookie to remove from the catalog.
   * @throws CookieNotFoundException if the cookie is not found in the catalog.
   */
  void removeCookie(Cookie cookie) throws CookieNotFoundException;

  /**
   * Finds and returns a list of gluten-free sugar-lite cookies from the catalog.
   *
   * @return a list of gluten-free sugar-lite cookies.
   */
  List<Cookie> findGlutenFreeSugarLiteCookies();

  /**
   * Finds and returns a list of cookies containing both nuts and dairy from the catalog.
   *
   * @return a list of cookies containing both nuts and dairy.
   */
  List<Cookie> findNutsAndDairyCookies();

  /**
   * The aim of creating this additional method is just to test the createEmpty and constructor
   * for addCookie() methods please follow the void methods above
   */
  LinkedCookie addCookie1(Cookie cookie);
}
