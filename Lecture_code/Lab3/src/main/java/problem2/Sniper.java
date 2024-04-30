package problem2;

public class Sniper extends Soldier{

  public Sniper(Name name, Integer age, Double stamina)
      throws InvalidAgeException, InvalidStaminaException {
    super(name, age, stamina);
  }

  @Override
  public String toString() {
    return "Sniper{" +
        "stamina=" + stamina +
        ", name=" + name +
        ", age=" + age +
        '}';
  }
}
