package problem1;

import static problem1.DualTypeCharacter.BASIC_LEVEL;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

public class FireTypeCharacter extends PureTypeCharacter{

  private static final Double MEGA_EVOLVE_DECREASE = 0.9;
  private Boolean abilityToMegaEvolve;

  public FireTypeCharacter(String name, Double weight, Double height, String[] regions,
      Double combatLevel, Double healthLevel, String[] attacks, Double valueOfStrongestAttack,
      LocalDate dateOfLastBattle, Boolean abilityToMegaEvolve) {
    super(name, weight, height, regions, combatLevel, healthLevel, attacks, valueOfStrongestAttack,
        dateOfLastBattle);
    this.abilityToMegaEvolve = abilityToMegaEvolve;
  }

  public Boolean getAbilityToMegaEvolve() {
    return abilityToMegaEvolve;
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
    FireTypeCharacter that = (FireTypeCharacter) o;
    return Objects.equals(abilityToMegaEvolve, that.abilityToMegaEvolve);
  }

  private Double calculateFireTypeCaptureDecrease(){
    if (this.abilityToMegaEvolve)
      return MEGA_EVOLVE_DECREASE;
    else return BASIC_LEVEL;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), abilityToMegaEvolve);
  }

  @Override
  public String toString() {
    return "FireTypeCharacter{" +
        "abilityToMegaEvolve=" + abilityToMegaEvolve +
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
    return super.estimateCaptureLikelihood() * this.calculateFireTypeCaptureDecrease();
  }
}
