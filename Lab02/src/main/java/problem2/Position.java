package problem2;

import java.util.Objects;

public class Position {
  private Integer xCoordinate;
  private Integer yCoordinate;

  public Position(Integer xCoordinate, Integer yCoordinate) {
    this.xCoordinate = xCoordinate;
    this.yCoordinate = yCoordinate;
  }

  public Integer getxCoordinate() {
    return xCoordinate;
  }

  public Integer getyCoordinate() {
    return yCoordinate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Position position = (Position) o;
    return Objects.equals(xCoordinate, position.xCoordinate) && Objects.equals(
        yCoordinate, position.yCoordinate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(xCoordinate, yCoordinate);
  }
}
