

```agsl
public class NonEmptyGame implements VideoGamesCatalog{

  private static final Integer DOWNLOADS_BENCHMARK = 500000;
  private static final Integer CREATOR_NUM_BENCHMARK = 5;
  private VideoGame firstGame;
  private VideoGamesCatalog restOfGames;
  
  ...
  
  @Override
  public VideoGamesCatalog findAllPopularGames() {
    if(this.isHigherDownloadsAndCreatedByMoreThanFiveCreator(this.firstGame))
      return new NonEmptyGame(this.firstGame, this.restOfGames.findAllPopularGames());
    else return this.restOfGames.findAllPopularGames();
  }
  private Boolean isHigherDownloadsAndCreatedByMoreThanFiveCreator(VideoGame game){
    return game.getNumDownloads() > DOWNLOADS_BENCHMARK && game.getCreators().length > CREATOR_NUM_BENCHMARK;
  }
  ...
```
(a) 
I created DOWNLOADS_BENCHMARK and CREATOR_NUM_BENCHMARK local variables to avoid magic number references.


(b)
isHigherDownloadsAndCreatedByMoreThanFiveCreator() method is used internally to check if a game meets the condition, aka, 
 more than 500,000 downloads and more than five creators
Writing the helper method can better encapsulate the logic for checking this condition for a game.
