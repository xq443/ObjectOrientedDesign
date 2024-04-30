package ood_design_exercise_P3;

/**
 * Interface BookCirculationSystem defines operations of a book circulation
 * and management system. The system is defined to be immutable.
 */
public interface BookCirculationSystem {

  /**
   * Method check if the book circulation system is empty.
   * @return Boolean true if the system contains no books
   */
  Boolean isEmpty();

  /**
   * Method adds a new book into the circulation system, and returns a new instance
   * of a book circulations system, with book added (i.e., immutable implementation).
   * The book is added at the head of the existing system.
   * @param book - book to be added into the system
   * @return new instance of the book circulation system
   */
  BookCirculationSystem addBook(Book book);

  /**
   * Method removes a book from the book circulation system, and returns a
   * new instance of the system, without the removed book (i.e., immutable implementation).
   * If the book doesn't exist, the method throws an exception.
   * @param book - book to be removed
   * @return new instance of the book circulation system
   * @throws BookNotFoundException, exception thrown if book not found
   */
  BookCirculationSystem removeBook(Book book) throws BookNotFoundException;

  /**
   * Method returns a Boolean value, indicating if at least one copy of the
   * book exists in the system.
   * @param book - sought after book
   * @return Boolean true if the book exists in the system
   */
  Boolean containsBook(Book book);

  /**
   * Method returns a number of books in the system
   * @return - number of books in the system
   */
  Integer getNumBooks();

  /**
   * Method returns some arbitrary book from the system. In this implementation,
   * method returns the first book from the system.
   * @return - some arbitrary book from the system.
   */
  Book getRandomBook();

  /**
   * Method returns a book based on the specified ISBN.
   * @param ISBN - ISBN, given as String
   * @return - book, based on ISBN
   * @throws InvalidISBNException - exception thrown if book doesn't exist
   */
  Book getBookByISBN(String ISBN) throws InvalidISBNException;



}
