package problem1;

import java.util.Arrays;
import java.util.Objects;

public abstract class AbstractCharacter implements Character{

  protected String name;
  protected Double weight;
  protected Double height;
  protected String[] regions;
  protected Double combatLevel;
  protected Double healthLevel;

  public AbstractCharacter(String name, Double weight, Double height, String[] regions,
      Double combatLevel, Double healthLevel) {
    this.name = name;
    this.weight = weight;
    this.height = height;
    this.regions = regions;
    this.combatLevel = combatLevel;
    this.healthLevel = healthLevel;
  }

  public String getName() {
    return name;
  }

  public Double getWeight() {
    return weight;
  }

  public Double getHeight() {
    return height;
  }

  public String[] getRegions() {
    return regions;
  }

  public Double getCombatLevel() {
    return combatLevel;
  }

  public Double getHealthLevel() {
    return healthLevel;
  }

  protected Double calculateBaseCaptureLikelihood(){
    return this.combatLevel/this.healthLevel;
  }

  @Override
  public Double estimateCaptureLikelihood() {
    return this.calculateBaseCaptureLikelihood();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AbstractCharacter that = (AbstractCharacter) o;
    return Objects.equals(name, that.name) && Objects.equals(weight, that.weight)
        && Objects.equals(height, that.height) && Arrays.equals(regions,
        that.regions) && Objects.equals(combatLevel, that.combatLevel)
        && Objects.equals(healthLevel, that.healthLevel);
  }

  @Override
  public int hashCode() {
    int result = Objects.hash(name, weight, height, combatLevel, healthLevel);
    result = 31 * result + Arrays.hashCode(regions);
    return result;
  }

  @Override
  public String toString() {
    return "AbstractCharacter{" +
        "name='" + name + '\'' +
        ", weight=" + weight +
        ", height=" + height +
        ", regions=" + Arrays.toString(regions) +
        ", combatLevel=" + combatLevel +
        ", healthLevel=" + healthLevel +
        '}';
  }
}
