package problem2;

/**
 * Represents a book, subclass of Item.
 */
public class Book extends Item {

  /**
   * Constructs a book with the specified author, title, and publication year.
   *
   * @param author The author of the book: polymorphism of creator class
   * @param title  The title of the book.
   * @param year   The publication year of the book.
   */
  public Book(Author author, String title, Integer year) {
    super(author, title, year);
  }

//  @Override
//  public Boolean checkCreator(RecordingArtist recordingArtist) {
//    return Boolean.FALSE;
//  }
}
