package problem2;

import java.util.Objects;

public class GameCharacter {

  private static final Double COMBAT_POWER_LIMIT = 0.0;
  private static final Double MIN_HEALTH_LEVEL = 0.0;
  private static final Double MAX_HEALTH_LEVEL = 100.0;
  private static final Integer LOWEST_WEALTH_LEVEL = 0;
  private static final Integer HIGHEST_WEALTH_LEVEL = 100;
  protected Name name;
  protected Integer age;
  protected Double combatPower;
  protected Double healthLevel;
  protected Double wealthLevel;

  public GameCharacter(Name name, Integer age, Double combatPower, Double healthLevel)
      throws CombatPowerException, HealthLevelException {
    if(this.validateCombatPower(combatPower) && this.validateHealthLevel(healthLevel)) {
      this.name = name;
      this.age = age;
      this.combatPower = combatPower;
      this.healthLevel = healthLevel;
      this.wealthLevel = 0.0;
    }
  }

  private Boolean validateCombatPower(Double combatPower) throws CombatPowerException {
    if (combatPower > COMBAT_POWER_LIMIT)
      return Boolean.TRUE;
    else throw new CombatPowerException("Invalid combat power limit");
  }

  private Boolean validateHealthLevel(Double healthLevel) throws HealthLevelException {
    if ((healthLevel >= MIN_HEALTH_LEVEL) && (healthLevel <= MAX_HEALTH_LEVEL))
      return Boolean.TRUE;
    else throw new HealthLevelException("Invalid health level");
  }

  public Name getName() {
    return name;
  }

  public Integer getAge() {
    return age;
  }

  public Double getCombatPower() {
    return combatPower;
  }

  public Double getHealthLevel() {
    return healthLevel;
  }

  public Double getWealthLevel() {
    return wealthLevel;
  }

  //YOUR CODE HERE
  private Boolean validWealthLevel(Double wealthLevel) throws WealthLevelException {
    return (wealthLevel >= LOWEST_WEALTH_LEVEL) && (wealthLevel <= HIGHEST_WEALTH_LEVEL);
  }
  public void increaseWealthLevel(Double wealthLevel) throws WealthLevelException {
    Double newWealthLevel = this.wealthLevel + wealthLevel;
    if(validWealthLevel(newWealthLevel)){
      this.wealthLevel = newWealthLevel;
    }else {
      throw new WealthLevelException("Invalid updated wealth level");
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GameCharacter that = (GameCharacter) o;
    return Objects.equals(name, that.name) && Objects.equals(age, that.age)
        && Objects.equals(combatPower, that.combatPower) && Objects.equals(
        healthLevel, that.healthLevel) && Objects.equals(wealthLevel, that.wealthLevel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, age, combatPower, healthLevel, wealthLevel);
  }

  @Override
  public String toString() {
    return "GameCharacter{" +
        "name=" + name +
        ", age=" + age +
        ", combatPower=" + combatPower +
        ", healthLevel=" + healthLevel +
        ", wealthLevel=" + wealthLevel +
        '}';
  }
}
