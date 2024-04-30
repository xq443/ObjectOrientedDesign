package problem4;

public class EmptyGame extends AVideoGame{
  @Override
  public Integer countGames() {
    return 0;
  }

  @Override
  public VideoGamesCatalog findAllPopularGames() {
    return this;
  }
}
