package problem4;

public interface VideoGamesCatalog {
  /**
   * Counts the number of VideoGames in the catalog.
   *
   * @return the number of VideoGames in the catalog.
   */
  Integer countGames();

  /**
   * Adds a VideoGame into the catalog.
   *
   * @param game the VideoGame to add to the catalog : duplication allowed
   */
  VideoGamesCatalog addGame(VideoGame game);

  /**
   * Finds and returns all VideoGames from the VideoGamesCatalog that have more than
   * 500,000 downloads and have been created by more than five creators.
   *
   * @return VideoGamesCatalog that contains VideoGames that meet the criteria.
   */
  VideoGamesCatalog findAllPopularGames();
}
