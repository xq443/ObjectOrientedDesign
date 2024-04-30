package problem1;

import java.time.LocalDate;

public class ElectricTypeCharacter extends PureTypeCharacter{

  public ElectricTypeCharacter(String name, Double weight, Double height, String[] regions,
      Double combatLevel, Double healthLevel, String[] attacks, Double valueOfStrongestAttack,
      LocalDate dateOfLastBattle) {
    super(name, weight, height, regions, combatLevel, healthLevel, attacks, valueOfStrongestAttack,
        dateOfLastBattle);
  }

  @Override
  public Double estimateCaptureLikelihood() {
    return super.estimateCaptureLikelihood();
  }
}
