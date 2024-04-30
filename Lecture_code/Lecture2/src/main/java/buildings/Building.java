package buildings;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Objects;

public class Building {

  protected Location location;
  protected Double sqFootage;
  protected Double cost;
  protected LocalDate yearBuilt;

  public Building(Location location, Double sqFootage, Double cost, LocalDate yearBuilt) {
    this.location = location;
    this.sqFootage = sqFootage;
    this.cost = cost;
    this.yearBuilt = yearBuilt;
  }

  public Location getLocation() {
    return location;
  }

  public Double getSqFootage() {
    return sqFootage;
  }

  public Double getCost() {
    return cost;
  }

  public LocalDate getYearBuilt() {
    return yearBuilt;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Building building = (Building) o;
    return Objects.equals(location, building.location) && Objects.equals(
        sqFootage, building.sqFootage) && Objects.equals(cost, building.cost)
        && Objects.equals(yearBuilt, building.yearBuilt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(location, sqFootage, cost, yearBuilt);
  }
}
