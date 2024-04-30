package problem1and2;

import java.util.Objects;

public abstract class Vehicle {

  protected String id;
  protected Float averageSpeed;
  protected Float maxSpeed;

  public Vehicle(String id, Float averageSpeed, Float maxSpeed) {
    this.id = id;
    this.averageSpeed = averageSpeed;
    this.maxSpeed = maxSpeed;
  }

  public String getId() {
    return id;
  }

  public Float getAverageSpeed() {
    return averageSpeed;
  }

  public Float getMaxSpeed() {
    return maxSpeed;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Vehicle vehicle = (Vehicle) o;
    return Objects.equals(id, vehicle.id) && Objects.equals(averageSpeed,
        vehicle.averageSpeed) && Objects.equals(maxSpeed, vehicle.maxSpeed);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, averageSpeed, maxSpeed);
  }

  @Override
  public String toString() {
    return "Vehicle{" +
        "id='" + id + '\'' +
        ", averageSpeed=" + averageSpeed +
        ", maxSpeed=" + maxSpeed +
        '}';
  }
}
