package problem1;

import java.util.Arrays;
import java.util.Objects;

public class IceRockTypeCharacter extends DualTypeCharacter {

  private static final Double ICE_ROCK_TYPE_CAPTURE_DECREASE = 0.75;
  private Boolean isLegendary;

  public IceRockTypeCharacter(String name, Double weight, Double height, String[] regions,
      Double combatLevel, Double healthLevel, PrimaryType primaryType, String[] primaryAttacks,
      String[] specialAbilities, Boolean isLegendary) {
    super(name, weight, height, regions, combatLevel, healthLevel, primaryType, primaryAttacks,
        specialAbilities);
    this.isLegendary = isLegendary;
  }

  public Boolean getLegendary() {
    return isLegendary;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    IceRockTypeCharacter that = (IceRockTypeCharacter) o;
    return Objects.equals(isLegendary, that.isLegendary);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), isLegendary);
  }

  @Override
  public String toString() {
    return "IceRockTypeCharacter{" +
        "isLegendary=" + isLegendary +
        ", primaryType=" + primaryType +
        ", primaryAttacks=" + Arrays.toString(primaryAttacks) +
        ", specialAbilities=" + Arrays.toString(specialAbilities) +
        ", name='" + name + '\'' +
        ", weight=" + weight +
        ", height=" + height +
        ", regions=" + Arrays.toString(regions) +
        ", combatLevel=" + combatLevel +
        ", healthLevel=" + healthLevel +
        '}';
  }

  private Double calculateIceRockTypeCaptureDecrease(){
    if (this.isLegendary)
      return ICE_ROCK_TYPE_CAPTURE_DECREASE;
    else return BASIC_LEVEL;
  }

  @Override
  public Double estimateCaptureLikelihood() {
    return super.estimateCaptureLikelihood() * this.calculateIceRockTypeCaptureDecrease();
  }
}
