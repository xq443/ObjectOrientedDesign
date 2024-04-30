package problem4;

/**
 * Represents common behaviour between empty and non-empty Video Game classes.
 */
public abstract class AVideoGame implements VideoGamesCatalog {

  @Override
  public VideoGamesCatalog addGame(VideoGame game) {
    return new NonEmptyGame(game, this);
  }
}