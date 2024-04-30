package problem2;

public class NonEmptyHalloweenDirectory implements HalloweenDirectory {

  private House firstHouse;
  private HalloweenDirectory restOfTheDirectory;
  private static final Double HISTORIC_DECORATION_SCORE = 25.6;
  private static final Double HISTORIC_CANDY_SCORE = 35.7;
  private static final Double ANOTHER_HISTORIC_CANDY_SCORE = 42.3;


  public NonEmptyHalloweenDirectory(House firstHouse, HalloweenDirectory restOfTheDirectory) {
    this.firstHouse = firstHouse;
    this.restOfTheDirectory = restOfTheDirectory;
  }

  @Override
  public Boolean isEmpty() {
    return Boolean.FALSE;
  }

  @Override
  public Integer numHouses() {
    return 1 + this.restOfTheDirectory.numHouses();
  }

  @Override
  public Boolean checkForAHouse(String houseNickname) {
    if (this.firstHouse.getHouseNickname().equals(houseNickname))
      return Boolean.TRUE;
    else return this.restOfTheDirectory.checkForAHouse(houseNickname);
  }

  @Override
  public HalloweenDirectory addHouse(House house) {
    try {
      this.findByHouseID(house.getHouseID());
    } catch (HouseNotFoundException e) {
      return new NonEmptyHalloweenDirectory(house, this);
    }
    return this;
  }

  @Override
  public HalloweenDirectory removeHouse(House house) throws HouseNotFoundException {
    //if(this.findByHouseID(house.getHouseID()) != null){
    //  if(this.firstHouse.equals(house))
    //    return this.restOfTheDirectory;
    //  else return this.restOfTheDirectory.removeHouse(house);
    // }
    //return this;

    //The approach below is by far preferred
    if(this.firstHouse.equals(house))
      return this.restOfTheDirectory;
    else return new NonEmptyHalloweenDirectory(this.firstHouse, this.restOfTheDirectory.removeHouse(house));
  }

  @Override
  public HalloweenDirectory findHousesWithHighDecorationAndCandyScores() {
    if(this.isHighDecorationAndCandyScore(this.firstHouse))
      return new NonEmptyHalloweenDirectory(this.firstHouse, this.restOfTheDirectory.findHousesWithHighDecorationAndCandyScores());
    else return this.restOfTheDirectory.findHousesWithHighDecorationAndCandyScores();
  }

  @Override
  public HalloweenDirectory findHouseWithHighCandyScoreAndAllergyConscious() {
    if(this.isHighCandyScoreAndAllergyConscious(this.firstHouse))
      return new NonEmptyHalloweenDirectory(this.firstHouse, this.restOfTheDirectory.findHouseWithHighCandyScoreAndAllergyConscious());
    else return this.restOfTheDirectory.findHouseWithHighCandyScoreAndAllergyConscious();
  }

  private Boolean isHighDecorationAndCandyScore(House house){
    return house.getHistoricHalloweenDecorationScore() >= HISTORIC_DECORATION_SCORE &&
        house.getHistoricHalloweenCandyStore() >= HISTORIC_CANDY_SCORE;
  }

  private Boolean isHighCandyScoreAndAllergyConscious(House house){
    return house.getHistoricHalloweenCandyStore() >= ANOTHER_HISTORIC_CANDY_SCORE && house.getAllergyConscious();
  }

  @Override
  public House findByHouseID(String houseID) throws HouseNotFoundException {
    if(this.firstHouse.getHouseID().equals(houseID))
      return this.firstHouse;
    else
      return this.restOfTheDirectory.findByHouseID(houseID);
  }
}
