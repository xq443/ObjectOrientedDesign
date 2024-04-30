package problem2;

import java.util.Objects;

public abstract class Civilian extends Piece{

  protected Double wealth;

  public Civilian(Name name, Integer age, Double wealth)
      throws InvalidAgeException, InvalidWealthException {
    super(name, age);
    if(this.validateWealth(wealth)) {
      this.wealth = wealth;
    }
    else throw new InvalidWealthException("Invalid wealth provided!");
  }

  protected Boolean validateWealth(double wealth){
    return wealth >= 0.0;
  }

  public Double getWealth() {
    return wealth;
  }

  public void increaseWealth(Double wealth){
    if(this.validateWealth(wealth)){
      this.wealth += wealth;
    }
  }

  public void decreaseWealth(Double wealth){
    if(this.validateWealth(this.wealth - wealth))
      this.wealth -= wealth;
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
    Civilian civilian = (Civilian) o;
    return Objects.equals(wealth, civilian.wealth);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), wealth);
  }
}
