package problem2;

public interface HalloweenDirectory {

  Boolean isEmpty();

  Integer numHouses();

  Boolean checkForAHouse(String houseNickname);

  HalloweenDirectory addHouse(House house);

  HalloweenDirectory removeHouse(House house) throws HouseNotFoundException;

  HalloweenDirectory findHousesWithHighDecorationAndCandyScores();

  HalloweenDirectory findHouseWithHighCandyScoreAndAllergyConscious();

  House findByHouseID(String houseID) throws HouseNotFoundException;



}
