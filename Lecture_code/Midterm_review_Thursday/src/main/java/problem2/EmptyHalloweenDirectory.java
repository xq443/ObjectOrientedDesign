package problem2;

public class EmptyHalloweenDirectory implements HalloweenDirectory {

  @Override
  public Boolean isEmpty() {
    return Boolean.TRUE;
  }

  @Override
  public Integer numHouses() {
    return 0;
  }

  @Override
  public Boolean checkForAHouse(String houseNickname) {
    return Boolean.FALSE;
  }

  @Override
  public HalloweenDirectory addHouse(House house) {
    return new NonEmptyHalloweenDirectory(house, this);
  }

  @Override
  public HalloweenDirectory removeHouse(House house) throws HouseNotFoundException {
    throw new HouseNotFoundException("This house is not part of the Halloween neighborhood!");
  }

  @Override
  public HalloweenDirectory findHousesWithHighDecorationAndCandyScores() {
    return this;
  }

  @Override
  public HalloweenDirectory findHouseWithHighCandyScoreAndAllergyConscious() {
    return this;
  }

  @Override
  public House findByHouseID(String houseID) throws HouseNotFoundException {
    throw new HouseNotFoundException("This house is not a part of the neighborhood!");
  }

  @Override
  public int hashCode() {
    return 47;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
   return !(obj == null || getClass() != obj.getClass());
  }
}
