package problem1;


import java.util.Objects;

public class ElementNode implements ListOfIntegers{
  private Integer elementValue;
  private ListOfIntegers pointerToRest;

  public ElementNode(Integer elementValue, ListOfIntegers pointerToRest) {
    this.elementValue = elementValue;
    this.pointerToRest = pointerToRest;
  }

  public ElementNode(Integer elementValue) {
    this.pointerToRest = new EmptyNode();
    this.elementValue = elementValue;
  }

  public Integer getElementValue() {
    return elementValue;
  }

  public ListOfIntegers getPointerToRest() {
    return pointerToRest;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ElementNode that = (ElementNode) o;
    return Objects.equals(elementValue, that.elementValue) && Objects.equals(
        pointerToRest, that.pointerToRest);
  }

  @Override
  public int hashCode() {
    return Objects.hash(elementValue, pointerToRest);
  }

  @Override
  public Boolean contains(Integer element) {
    if(this.elementValue.equals(element)) return Boolean.TRUE; // if(this.elementValue == element)
    else return this.pointerToRest.contains(element); // recursive call - tail recursion
  }

  @Override
  public Integer elementAt(Integer index) {
    // index validity check
    if(index < 0 || index >= this.count()) throw new IllegalArgumentException("An element with this index "
        + "des not exist in the list");
    // have found an element with the requested index
    else if (index.equals(0)) return this.elementValue;
    else return this.pointerToRest.elementAt(index - 1);
  }

  @Override
  public Integer count() {
    return 1 + this.pointerToRest.count();
  }
  @Override
  public Integer sumElements() {
    return this.elementValue + this.pointerToRest.sumElements();
  }

  @Override
  public ListOfIntegers remove(Integer element) {
    if(!this.contains(element)) return this;
    else if(this.elementValue.equals(element)) return this.pointerToRest;
    else return new ElementNode(this.elementValue, this.pointerToRest.remove(element));
  }
}
