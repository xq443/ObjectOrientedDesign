package problem3;

import java.util.Objects;

public class NonEmptyRegatta implements RegattaDirectory{
  private Regatta firstRegatta;
  private RegattaDirectory restOfRegatta;

  public NonEmptyRegatta(Regatta firstRegatta, RegattaDirectory restOfRegatta) {
    this.firstRegatta = firstRegatta;
    this.restOfRegatta = restOfRegatta;
  }

  public Regatta getFirstRegatta() {
    return this.firstRegatta;
  }

  public RegattaDirectory getRestOfRegatta() {
    return this.restOfRegatta;
  }

  @Override
  public Boolean isEmpty() {
    return Boolean.FALSE;
  }

  @Override
  public Boolean containsRegatta(String regattaName) {
    if (this.firstRegatta.getRegattaName().equals(regattaName))
      return Boolean.TRUE;
    else return this.restOfRegatta.containsRegatta(regattaName);
  }

  @Override
  public RegattaDirectory removeRegatta(String regattaName) throws RegattaNotFoundException {
    if(this.firstRegatta.getRegattaName().equals(regattaName))
      return this.restOfRegatta;
    else return new NonEmptyRegatta(this.firstRegatta, this.restOfRegatta.removeRegatta(regattaName));
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NonEmptyRegatta that = (NonEmptyRegatta) o;
    return Objects.equals(this.firstRegatta, that.firstRegatta) && Objects.equals(
        this.restOfRegatta, that.restOfRegatta);
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = (prime * result) + ((this.firstRegatta == null) ? 0 : this.firstRegatta.hashCode());
    result = (prime * result) + ((this.restOfRegatta == null) ? 0 : this.restOfRegatta.hashCode());
    return result;
  }

  @Override
  public String toString() {
    return "NonEmptyRegatta{" +
        "firstRegatta=" + this.firstRegatta +
        ", restOfRegatta=" + this.restOfRegatta +
        '}';
  }
}
