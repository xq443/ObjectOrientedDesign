package problem2;

import java.util.Objects;

/**
 * Represents an abstract class for items.
 */
public abstract class Item {
  protected Creator creator;
  protected String title;
  protected Integer year;

  /**
   * Constructs an item with the specified creator, title, and year.
   *
   * @param creator The creator of the item.
   * @param title   The title of the item.
   * @param year    The year of publication/release of the item.
   */
  public Item(Creator creator, String title, Integer year) {
    this.creator = creator;
    this.title = title;
    this.year = year;
  }

  /**
   * Gets the creator of the item.
   *
   * @return The creator of the item.
   */
  public Creator getCreator() {
    return this.creator;
  }

  /**
   * Gets the title of the item.
   *
   * @return The title of the item.
   */
  public String getTitle() {
    return this.title;
  }

  /**
   * Gets the year of publication/release of the item.
   *
   * @return The year of publication/release of the item.
   */
  public Integer getYear() {
    return this.year;
  }

  //determine if an Item has specified Author or RecordingArtist without checking the Item type

  public Integer determineCreator(Creator creator) {
    return 0;
  }
//
//  public abstract Boolean checkCreator(RecordingArtist recordingArtist);


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Item item = (Item) o;
    return Objects.equals(this.creator, item.creator) && Objects.equals(this.title,
        item.title) && Objects.equals(this.year, item.year);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.creator, this.title, this.year);
  }

  @Override
  public String toString() {
    return "Item{" +
        "creator=" + this.creator +
        ", title='" + this.title + '\'' +
        ", year=" + this.year +
        '}';
  }
}
