package buildings;

import java.time.LocalDate;
import java.util.Objects;

public class FamilyHome extends Building{

  private Double yardSqFootage;
  private Integer numCarsInGarage;

  public FamilyHome(Location location, Double sqFootage, Double cost, LocalDate yearBuilt,
      Double yardSqFootage, Integer numCarsInGarage) {
    super(location, sqFootage, cost, yearBuilt);
    if(yardSqFootage > 300.0) {
      this.yardSqFootage = yardSqFootage;
      this.numCarsInGarage = numCarsInGarage;
    }
  }

  public Double getYardSqFootage() {
    return yardSqFootage;
  }

  public Integer getNumCarsInGarage() {
    return numCarsInGarage;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o))
      return false;
    FamilyHome that = (FamilyHome) o;
    return Objects.equals(yardSqFootage, that.yardSqFootage) && Objects.equals(
        numCarsInGarage, that.numCarsInGarage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), yardSqFootage, numCarsInGarage);
  }
}
