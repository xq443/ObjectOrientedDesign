package buildings;

import java.time.LocalDate;

public class ApartmentBuilding extends Building{
  private Integer numUnits;

  public ApartmentBuilding(Location location, Double sqFootage, Double cost,
      LocalDate yearBuilt, Integer numUnits) {
    super(location, sqFootage, cost, yearBuilt);
    this.numUnits = numUnits;
  }

  public Integer getNumUnits() {
    return numUnits;
  }
}
