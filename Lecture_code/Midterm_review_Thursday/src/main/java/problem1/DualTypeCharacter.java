package problem1;

import java.util.Arrays;
import java.util.Objects;

public abstract class DualTypeCharacter extends AbstractCharacter{

  private static final int NUM_PRIMARY_ATTACKS_CUTOFF = 4;
  private static final int NUM_SPECIAL_ABILITIES_CUTOFF = 3;
  private static final Double DUAL_TYPE_CHARACTER_DECREASE = 0.65;
  protected static final Double BASIC_LEVEL = 1.0;
  protected PrimaryType primaryType;
  protected String[] primaryAttacks;
  protected String[] specialAbilities;

  public DualTypeCharacter(String name, Double weight, Double height, String[] regions,
      Double combatLevel, Double healthLevel, PrimaryType primaryType, String[] primaryAttacks,
      String[] specialAbilities) {
    super(name, weight, height, regions, combatLevel, healthLevel);
    this.primaryType = primaryType;
    this.primaryAttacks = primaryAttacks;
    this.specialAbilities = specialAbilities;
  }

  public PrimaryType getPrimaryType() {
    return primaryType;
  }

  public String[] getPrimaryAttacks() {
    return primaryAttacks;
  }

  public String[] getSpecialAbilities() {
    return specialAbilities;
  }

  protected Double calculateDualTypeCharacterCaptureDecrease(){
    if (this.primaryAttacks.length >= NUM_PRIMARY_ATTACKS_CUTOFF
        && this.specialAbilities.length >= NUM_SPECIAL_ABILITIES_CUTOFF)
      return DUAL_TYPE_CHARACTER_DECREASE;
    else return BASIC_LEVEL;
  }

  @Override
  public Double estimateCaptureLikelihood() {
    return super.estimateCaptureLikelihood() * this.calculateDualTypeCharacterCaptureDecrease();
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
    DualTypeCharacter that = (DualTypeCharacter) o;
    return primaryType == that.primaryType && Arrays.equals(primaryAttacks,
        that.primaryAttacks) && Arrays.equals(specialAbilities, that.specialAbilities);
  }

  @Override
  public int hashCode() {
    int result = Objects.hash(super.hashCode(), primaryType);
    result = 31 * result + Arrays.hashCode(primaryAttacks);
    result = 31 * result + Arrays.hashCode(specialAbilities);
    return result;
  }

  @Override
  public String toString() {
    return "DualTypeCharacter{" +
        "primaryType=" + primaryType +
        ", primaryAttacks=" + Arrays.toString(primaryAttacks) +
        ", specialAbilities=" + Arrays.toString(specialAbilities) +
        '}';
  }
}
