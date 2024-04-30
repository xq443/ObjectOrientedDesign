package pair;

/**
 * Represents a pair of values.
 */
public class Pair<X, Y> {
  private X first;
  private Y second;

  public Pair(X first, Y second) {
    this.first = first;
    this.second = second;
  }

  public X getFirst() {
    return first;
  }

  public void setFirst(X first) {
    this.first = first;
  }

  public Y getSecond() {
    return second;
  }

  public void setSecond(Y second) {
    this.second = second;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Pair<X, Y> pair = (Pair<X, Y>) o;

    if (getFirst() != null ? !getFirst().equals(pair.getFirst()) : pair.getFirst() != null) return false;

    return getSecond() != null ? getSecond().equals(pair.getSecond()) : pair.getSecond() == null;
  }

  @Override
  public int hashCode() {
    int result = getFirst() != null ? getFirst().hashCode() : 0;
    result = 31 * result + (getSecond() != null ? getSecond().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Pair{"
        + "first=" + first
        + ", second=" + second
        + '}';
  }
}