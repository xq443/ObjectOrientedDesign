package problem2;

import java.util.Objects;

public abstract class Soldier extends Piece{

  private static final Double MIN_STAMINA = 0.0;
  private static final Double MAX_STAMINA = 100.0;
  protected Double stamina;

  protected Boolean validateStamina(double stamina){
    return stamina >= MIN_STAMINA && stamina <= MAX_STAMINA;
  }

  public Soldier(Name name, Integer age, Double stamina)
      throws InvalidAgeException, InvalidStaminaException {
    super(name, age);
    if(this.validateStamina(stamina)) {
      this.stamina = stamina;
    }
    else throw new InvalidStaminaException("Invalid stamina value1");
  }

  public Double getStamina() {
    return stamina;
  }

  protected void increaseStamina(Double stamina){
    if(this.validateStamina(this.stamina + stamina)){
      this.stamina += stamina;
    }
  }

  protected void decreaseStamina(Double stamina){
    if(this.validateStamina(this.stamina - stamina))
      this.stamina -= stamina;
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
    Soldier soldier = (Soldier) o;
    return Objects.equals(stamina, soldier.stamina);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), stamina);
  }
}
