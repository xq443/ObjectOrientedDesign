(a)
```agsl
/**
* Constructs a new GameCharacter with the specified attributes.
*
* @param name The name of the game character, represented as custom class Name
* @param age The age of the game character, represented as custom class Age
* @param combatPower The combat power of the game character, represented as a Double
* @param healthLevel The health level of the game character, represented as a Double
* @throws CombatPowerException if the specified combat power is invalid, represented as a custom exception class CombatPowerException
* @throws HealthLevelException if the specified health level is invalid, represented as a custom exception class HealthLevelException
*/
  public GameCharacter(Name name, Integer age, Double combatPower, Double healthLevel) throws CombatPowerException, HealthLevelException {
      if (this.validateCombatPower(combatPower) && this.validateHealthLevel(healthLevel)) {
      this.name = name;
      this.age = age;
      this.combatPower = combatPower;
      this.healthLevel = healthLevel;
      this.wealthLevel = 0.0;
  }
 }
```

(b) 
