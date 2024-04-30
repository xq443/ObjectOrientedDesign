package problem1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Objects;

public abstract class PureTypeCharacter extends AbstractCharacter{

  private static final int NUM_ATTACKS_CUTOFF = 5;
  private static final Double PURE_TYPE_CHARACTER_CAPTURE_DECREASE = 0.7;
  private static final Double BASIC_RATE = 1.0;
  private static final long DAYS_CUTOFF = 14;
  private static final Double DATE_OF_LAST_BATTLE_INCREASE = 1.1;
  protected String[] attacks;
  protected Double valueOfStrongestAttack;
  protected LocalDate dateOfLastBattle;

  public PureTypeCharacter(String name, Double weight, Double height, String[] regions,
      Double combatLevel, Double healthLevel, String[] attacks, Double valueOfStrongestAttack,
      LocalDate dateOfLastBattle) {
    super(name, weight, height, regions, combatLevel, healthLevel);
    this.attacks = attacks;
    this.valueOfStrongestAttack = valueOfStrongestAttack;
    this.dateOfLastBattle = dateOfLastBattle;
  }

  public String[] getAttacks() {
    return attacks;
  }

  public Double getValueOfStrongestAttack() {
    return valueOfStrongestAttack;
  }

  public LocalDate getDateOfLastBattle() {
    return dateOfLastBattle;
  }

  protected Double calculatePureTypeCharacterCaptureDecrease(){
    if (this.attacks.length >= NUM_ATTACKS_CUTOFF)
        return PURE_TYPE_CHARACTER_CAPTURE_DECREASE;
    else return BASIC_RATE;
  }

  protected Double calculateDateOfLastBattleIncrease(){
    LocalDate now = LocalDate.now();
    if (now.until(this.dateOfLastBattle, ChronoUnit.DAYS) >= DAYS_CUTOFF)
      return DATE_OF_LAST_BATTLE_INCREASE;
    else return BASIC_RATE;
  }

  @Override
  public Double estimateCaptureLikelihood() {
    return super.estimateCaptureLikelihood() * this.calculateDateOfLastBattleIncrease()
        * this.calculatePureTypeCharacterCaptureDecrease();
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
    PureTypeCharacter that = (PureTypeCharacter) o;
    return Arrays.equals(attacks, that.attacks) && Objects.equals(
        valueOfStrongestAttack, that.valueOfStrongestAttack) && Objects.equals(
        dateOfLastBattle, that.dateOfLastBattle);
  }

  @Override
  public int hashCode() {
    int result = Objects.hash(super.hashCode(), valueOfStrongestAttack, dateOfLastBattle);
    result = 31 * result + Arrays.hashCode(attacks);
    return result;
  }

  @Override
  public String toString() {
    return "PureTypeCharacter{" +
        "attacks=" + Arrays.toString(attacks) +
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
}
