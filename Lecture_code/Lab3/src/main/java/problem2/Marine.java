package problem2;

public class Marine extends Soldier{

  public Marine(Name name, Integer age, Double stamina)
      throws InvalidAgeException, InvalidStaminaException {
    super(name, age, stamina);
  }

  @Override
  public String toString() {
    return "Marine{" +
        "stamina=" + stamina +
        ", name=" + name +
        ", age=" + age +
        '}';
  }
}
