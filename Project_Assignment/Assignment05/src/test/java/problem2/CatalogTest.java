package problem2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CatalogTest {

  private Catalog catalog;
  private List<Item> items;

  @BeforeEach
  void setUp(){
    items = new ArrayList<>();
    // Add test items
    Item book = new Book(new Author("John", "Doe"), "Introduction to Programming", 2021);
    Item music = new Music(new RecordingArtist("Bob", "Marley"), "Greatest Hits", 2000);

    // Create a band with one member
    List<RecordingArtist> bandMembers = new ArrayList<>();
    bandMembers.add(new RecordingArtist( "Alice", "Jones"));
    bandMembers.add(new RecordingArtist("Chris", "Martin"));
    Band band = new Band("Test Band", bandMembers);
    items.add(book);
    items.add(music);
    Item music1 = new Music(band, "1989", 2013);
    items.add(music1);

    catalog = new Catalog(items);
  }

  @Test
  void testConstructorWithItems() {
    assertEquals(items, catalog.getItems());
  }

  @Test
  void testConstructorWithoutItems() {
    Catalog emptyCatalog = new Catalog();
    assertTrue(emptyCatalog.getItems().isEmpty());
  }

  @Test
  void testAddItem() {
    Item newItem = new Book(new Author("Jane", "Smith"), "Advanced Programming", 2023);
    catalog.addItem(newItem);
    assertTrue(catalog.getItems().contains(newItem));
  }

  @Test
  void testRemoveItem() {
    Item itemToRemove = catalog.getItems().get(0);
    catalog.removeItem(itemToRemove);
    assertTrue(!catalog.getItems().contains(itemToRemove));
  }

  @Test
  void testSearchByKeyword() {
    List<Item> searchResult = catalog.search("Programming");
    assertEquals(1, searchResult.size());
    assertEquals("Introduction to Programming", searchResult.get(0).getTitle());
  }

  @Test
  void testSearchByAuthor() {
    List<Item> searchResult = catalog.search(new Author("John", "Doe"));
    assertEquals(1, searchResult.size());
    assertEquals("Introduction to Programming", searchResult.get(0).getTitle());
  }

  @Test
  void testSearchByRecordingArtist() {
    List<Item> searchResult = catalog.search(new RecordingArtist("Bob", "Marley"));
    assertEquals(1, searchResult.size());
    assertEquals("Greatest Hits", searchResult.get(0).getTitle());
  }

  @Test
  void testSearchByRecordingArtistInBand() {
    // Search for items by an artist who is a member of a band
    List<Item> searchResult = catalog.search(new RecordingArtist("Chris", "Martin"));
    assertEquals(1, searchResult.size());
    assertEquals("1989", searchResult.get(0).getTitle());
  }

  @Test
  void testEquals_SameCatalogInstance() {
    assertTrue(catalog.equals(catalog));
  }

  @Test
  void testEquals_EqualCatalogs() {
    Catalog catalog2 = new Catalog(new ArrayList<>(items));
    assertTrue(catalog.equals(catalog2));
  }

  @Test
  void testEquals_NullCatalog() {
    assertFalse(catalog.equals(null));
  }

  @Test
  void testEquals_DifferentClass() {
    assertFalse(catalog.equals(new Object()));
  }

  @Test
  void testEquals_DifferentItems() {
    Catalog differentCatalog = new Catalog(new ArrayList<>());
    assertFalse(catalog.equals(differentCatalog));
  }

  @Test
  void testToString() {
    String expectedToString = "Catalog{items=" + items + '}';
    assertEquals(expectedToString, catalog.toString());
  }

  @Test
  void testHashCode() {
    assertEquals(Objects.hash(items), catalog.hashCode());
  }
}
