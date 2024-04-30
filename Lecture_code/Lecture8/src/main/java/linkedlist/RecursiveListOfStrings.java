package linkedlist;

public class RecursiveListOfStrings<String> implements ILinkedList<String> {

  private String item;
  private ILinkedList<String> rest;

  public RecursiveListOfStrings(String item, ILinkedList<String> rest) {
    this.item = item;
    this.rest = rest;
  }

  @Override
  public Integer count() {
    return 1 + this.rest.count();
  }

  @Override
  public String getItem() {
    return this.item;
  }

  @Override
  public ILinkedList getRest() {
    return this.rest;
  }

  @Override
  public ILinkedList insert(String item) {
    return new RecursiveListOfStrings(item, this);
  }

  @Override
  public ILinkedList insertAt(String item, Integer index) throws IndexOutOfBoundsException {
    if (index.equals(0)) {
      ILinkedList<String> thisCopy = new ElementNode(this.item, this.rest);
      return new ElementNode(item, thisCopy);
    } else {
      return new ElementNode<>(this.item, this.rest.insertAt(item, index - 1));
    }
  }
}
