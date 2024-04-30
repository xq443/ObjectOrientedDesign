package problem4;

import java.util.Objects;

public class NonEmptyGame extends AVideoGame{

  private static final Integer DOWNLOADS_BENCHMARK = 500000;
  private static final Integer CREATOR_NUM_BENCHMARK = 5;
  private VideoGame firstGame;
  private VideoGamesCatalog restOfGames;

  public NonEmptyGame(VideoGame firstGame, VideoGamesCatalog restOfGames) {
    this.firstGame = firstGame;
    this.restOfGames = restOfGames;
  }

  public VideoGame getFirstGame() {
    return this.firstGame;
  }

  public VideoGamesCatalog getRestOfGames() {
    return this.restOfGames;
  }

  @Override
  public Integer countGames() {
    return  1 + this.restOfGames.countGames();
  }

  @Override
  public VideoGamesCatalog findAllPopularGames() {
    if(this.isHigherDownloadsAndCreatedByMoreThanFiveCreator(this.firstGame))
      return new NonEmptyGame(this.firstGame, this.restOfGames.findAllPopularGames());
    else return this.restOfGames.findAllPopularGames();
  }
  private Boolean isHigherDownloadsAndCreatedByMoreThanFiveCreator(VideoGame game){
    return game.getNumDownloads() > DOWNLOADS_BENCHMARK && game.getCreators().length > CREATOR_NUM_BENCHMARK;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NonEmptyGame that = (NonEmptyGame) o;
    return Objects.equals(this.firstGame, that.firstGame) && Objects.equals(
        this.restOfGames, that.restOfGames);
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = (prime * result) + ((this.firstGame == null) ? 0 : this.firstGame.hashCode());
    result = (prime * result) + ((this.restOfGames == null) ? 0 : this.restOfGames.hashCode());
    return result;
  }

  @Override
  public String toString() {
    return "NonEmptyGame{" +
        "firstGame=" + this.firstGame +
        ", restOfGames=" + this.restOfGames +
        '}';
  }
}
