package problem2;

import java.util.Objects;

public abstract class Piece {

  private static final Integer MIN_AGE = 0;
  private static final Integer MAX_AGE = 128;
  protected Name name;
  protected Integer age;

  protected Boolean validateAge(int age){
    return age >= MIN_AGE && age <= MAX_AGE;
  }

  public Piece(Name name, Integer age) throws InvalidAgeException {
    if(this.validateAge(age)) {
      this.name = name;
      this.age = age;
    }
    else throw new InvalidAgeException("Invalid age provided1");
  }

  public Name getName() {
    return name;
  }

  public Integer getAge() {
    return age;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Piece piece = (Piece) o;
    return Objects.equals(name, piece.name) && Objects.equals(age, piece.age);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, age);
  }
}
