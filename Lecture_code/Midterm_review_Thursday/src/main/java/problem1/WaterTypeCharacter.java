package problem1;

import static problem1.DualTypeCharacter.BASIC_LEVEL;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

public class WaterTypeCharacter extends PureTypeCharacter{

  private static final Integer NUM_EVOLUTION_GEMS_CUTOFF = 110;
  private static final Double WATER_TYPE_CAPTURE_DECREASE = 0.85;
  private String currentEvolution;
  private Integer numEvolutionGemsAvailable;

  public WaterTypeCharacter(String name, Double weight, Double height, String[] regions,
      Double combatLevel, Double healthLevel, String[] attacks, Double valueOfStrongestAttack,
      LocalDate dateOfLastBattle, String currentEvolution,
      Integer numEvolutionGemsAvailable) {
    super(name, weight, height, regions, combatLevel, healthLevel, attacks, valueOfStrongestAttack,
        dateOfLastBattle);
    this.currentEvolution = currentEvolution;
    this.numEvolutionGemsAvailable = numEvolutionGemsAvailable;
  }

  public String getCurrentEvolution() {
    return currentEvolution;
  }

  public Integer getNumEvolutionGemsAvailable() {
    return numEvolutionGemsAvailable;
  }

  private Double calculateWaterTypeCaptureDecrease(){
    if (this.numEvolutionGemsAvailable >= NUM_EVOLUTION_GEMS_CUTOFF)
      return WATER_TYPE_CAPTURE_DECREASE;
    else return BASIC_LEVEL;
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
    WaterTypeCharacter that = (WaterTypeCharacter) o;
    return Objects.equals(currentEvolution, that.currentEvolution)
        && Objects.equals(numEvolutionGemsAvailable, that.numEvolutionGemsAvailable);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), currentEvolution, numEvolutionGemsAvailable);
  }

  @Override
  public String toString() {
    return "WaterTypeCharacter{" +
        "currentEvolution='" + currentEvolution + '\'' +
        ", numEvolutionGemsAvailable=" + numEvolutionGemsAvailable +
        ", attacks=" + Arrays.toString(attacks) +
        ", valueOfStrongestAttack=" + valueOfStrongestAttack +
        ", dateOfLastBattle=" + dateOfLastBattle +
        ", name='" + name + '\'' +
        ", weight=" + weight +
        ", height=" + height +
        ", regions=" + Arrays.toString(regions) +
        ", combatLevel=" + combatLevel +
        ", healthLevel=" + healthLevel +
        '}';
  }

  @Override
  public Double estimateCaptureLikelihood() {
    return super.estimateCaptureLikelihood() * this.calculateWaterTypeCaptureDecrease();
  }
}
