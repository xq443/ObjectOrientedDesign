package problem1;

public class SteelFireTypeCharacter extends DualTypeCharacter{

  public SteelFireTypeCharacter(String name, Double weight, Double height, String[] regions,
      Double combatLevel, Double healthLevel, PrimaryType primaryType, String[] primaryAttacks,
      String[] specialAbilities) {
    super(name, weight, height, regions, combatLevel, healthLevel, primaryType, primaryAttacks,
        specialAbilities);
  }

  @Override
  public Double estimateCaptureLikelihood() {
    return super.estimateCaptureLikelihood();
  }
}
