package problem2;

/**
 * Represents an author, subclass of Creator.
 */
public class Author extends IndividualCreator {

  /**
   * Constructs an author with the specified first name and last name.
   *
   * @param firstName The first name of the author.
   * @param lastName  The last name of the author.
   */

  public Author(String firstName, String lastName) {
    super(firstName, lastName);
  }

  @Override
  public Boolean checkCreator(Creator creator) {
    return this.equals(creator);
  }
}
