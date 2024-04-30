package problem2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents a catalog of items.
 */
public class Catalog {
  private List<Item> items;

  /**
   * Attribute a catalog with the specified list of items.
   *
   * @param items The list of items to initialize the catalog.
   */
  public Catalog(List<Item> items) {
    this.items = items;
  }

  /**
   * Constructs an empty catalog.
   */
  public Catalog() {
    this.items = new ArrayList<>();
  }

  /**
   * Gets the list of items in the catalog.
   *
   * @return The list of items in the catalog.
   */
  public List<Item> getItems() {
    return this.items;
  }

  /**
   * Adds an item to the catalog.
   *
   * @param item The item to be added to the catalog.
   */
  public void addItem(Item item) {
    this.items.add(item);
  }

  /**
   * Removes an item from the catalog.
   *
   * @param item The item to be removed from the catalog.
   */
  public void removeItem(Item item) {
    this.items.remove(item);
  }

  /**
   * Searches for items in the catalog by keyword.
   *
   * @param keyword The keyword to search for in the item titles.
   * @return A list of items matching the keyword.
   */
  public List<Item> search(String keyword) {
    List<Item> result = new ArrayList<>();
    for (Item item : this.items) {
      String title = item.getTitle().toLowerCase();
      if (title.contains(keyword.toLowerCase())) {
        result.add(item);
      }
    }
    return result;
  }

  /**
   * Searches for items in the catalog by author.
   *
   * @param author The author to search for.
   * @return A list of items written by the author.
   */
  public List<Item> search(Author author) {
    List<Item> result = new ArrayList<>();
    for (Item item : this.items) {
      if (item.getCreator().equals(author)) {
        result.add(item);
      }
    }
    return result;
  }

  /**
   * Searches for items in the catalog by recording artist.
   *
   * @param artist The recording artist to search for.
   * @return A list of items associated with the recording artist.
   */
  public List<Item> search(RecordingArtist artist) {
    List<Item> result = new ArrayList<>();
    for (Item item : this.items) {
      if(item.getCreator().checkCreator(artist)) {
        result.add(item);
      }

//      if (item.getCreator().equals(artist)) {
//        result.add(item);
//      } else if (item.getCreator().getClass() ==  Band.class) {
//        Band band = (Band) item.getCreator();
//        if (band.getMembers().contains(artist)) {
//          result.add(item);
//        }
//      }
    }
    return result;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Catalog catalog = (Catalog) o;
    return Objects.equals(this.items, catalog.items);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.items);
  }

  @Override
  public String toString() {
    return "Catalog{" +
        "items=" + this.items +
        '}';
  }
}
