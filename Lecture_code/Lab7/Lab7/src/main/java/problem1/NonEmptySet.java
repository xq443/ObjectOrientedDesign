package problem1;

import java.util.Objects;

public class NonEmptySet<T> implements Set<T> {

  private T firstElement;
  private Set<T> restOfTheSet;

  public NonEmptySet(T firstElement, Set<T> restOfTheSet) {
    this.firstElement = firstElement;
    this.restOfTheSet = restOfTheSet;
  }

  public NonEmptySet(T firstElement) {
    this.firstElement = firstElement;
    this.restOfTheSet = this.emptySet();
  }

  @Override
  public Set<T> emptySet() {
    return new EmptySet<>();
  }

  @Override
  public Boolean isEmpty() {
    return Boolean.FALSE;
  }

  @Override
  public Set<T> add(T element) {
    if(this.contains(element))
      return this;
    else return new NonEmptySet(element, this);
  }

  @Override
  public Boolean contains(T element) {
    if(this.firstElement.equals(element))
      return true;
    else return this.restOfTheSet.contains(element);
  }

  @Override
  public Set<T> remove(T element) {
    if(!this.contains(element))
      return this;
    else if (this.firstElement.equals(element))
      return this.restOfTheSet;
    else return new NonEmptySet(this.firstElement, this.restOfTheSet.remove(element));
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NonEmptySet<?> that = (NonEmptySet<?>) o;
    return Objects.equals(firstElement, that.firstElement) && Objects.equals(
        restOfTheSet, that.restOfTheSet);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstElement, restOfTheSet);
  }
}
