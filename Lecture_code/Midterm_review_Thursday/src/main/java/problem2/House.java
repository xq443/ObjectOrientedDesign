package problem2;

import java.util.Objects;

/**
 * Class House stores information about a house, relevant for the Halloween directory system.
 */
public class House {

  private String houseID;
  private String houseNickname;
  private Address address;
  private Double historicHalloweenDecorationScore;
  private Double historicHalloweenCandyStore;
  private Boolean allergyConscious;

  /**
   * Constructor for a class House.
   * @param houseID house ID, as a String.
   * @param houseNickname house nickname, as a String.
   * @param address address, as a custom class Address.
   * @param historicHalloweenDecorationScore historical Halloween decoration score, as a Double.
   * @param historicHalloweenCandyStore historical Halloween candy score, as a Double.
   * @param allergyConscious Boolean flag indicating if the house gives away allergy free candy.
   */
  public House(String houseID, String houseNickname, Address address,
      Double historicHalloweenDecorationScore, Double historicHalloweenCandyStore,
      Boolean allergyConscious) {
    this.houseID = houseID;
    this.houseNickname = houseNickname;
    this.address = address;
    this.historicHalloweenDecorationScore = historicHalloweenDecorationScore;
    this.historicHalloweenCandyStore = historicHalloweenCandyStore;
    this.allergyConscious = allergyConscious;
  }

  /**
   * Getter for house ID.
   * @return house ID, as a String.
   */
  public String getHouseID() {
    return houseID;
  }

  /**
   * Getter for house nickname.
   * @return house nickname, as a String.
   */
  public String getHouseNickname() {
    return houseNickname;
  }

  /**
   * Getter for an address.
   * @return address, as a custom class Address.
   */
  public Address getAddress() {
    return address;
  }

  /**
   * Getter for historical Halloween decoration score, as a Double. The higher value indicates better
   * decorations.
   * @return historical Halloween candy score, as a Double
   */
  public Double getHistoricHalloweenDecorationScore() {
    return historicHalloweenDecorationScore;
  }

  /**
   * Getter for historical Halloween candy score, as a Double. The higher value indicates better
   * candy.
   * @return historical Halloween candy score, as a Double
   */
  public Double getHistoricHalloweenCandyStore() {
    return historicHalloweenCandyStore;
  }

  /**
   * Getter for a Boolean flag, indicating an allergy conscious house.
   * @return Boolean flag, if set to True, indicating that the house gives away allergy free candy.
   */
  public Boolean getAllergyConscious() {
    return allergyConscious;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    House house = (House) o;
    return Objects.equals(houseID, house.houseID) && Objects.equals(houseNickname,
        house.houseNickname) && Objects.equals(address, house.address)
        && Objects.equals(historicHalloweenDecorationScore,
        house.historicHalloweenDecorationScore) && Objects.equals(
        historicHalloweenCandyStore, house.historicHalloweenCandyStore) && Objects.equals(
        allergyConscious, house.allergyConscious);
  }

  @Override
  public int hashCode() {
    return Objects.hash(houseID, houseNickname, address, historicHalloweenDecorationScore,
        historicHalloweenCandyStore, allergyConscious);
  }

  @Override
  public String toString() {
    return "House{" +
        "houseID='" + houseID + '\'' +
        ", houseNickname='" + houseNickname + '\'' +
        ", address=" + address +
        ", historicHalloweenDecorationScore=" + historicHalloweenDecorationScore +
        ", historicHalloweenCandyStore=" + historicHalloweenCandyStore +
        ", allergyConscious=" + allergyConscious +
        '}';
  }
}
