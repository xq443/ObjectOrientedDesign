package linkedlist;

public class EmptyListOfStrings<String> implements ILinkedList<String> {

  @Override
  public Integer count() {
    return 0;
  }

  @Override
  public String getItem() {
    return null;
  }

  @Override
  public ILinkedList getRest() {
    return this;
  }

  @Override
  public ILinkedList insert(String item) {
    return new RecursiveListOfStrings(item, this);
  }

  @Override
  public ILinkedList insertAt(String item, Integer index) throws IndexOutOfBoundsException {
    if(index == 0)
      return new RecursiveListOfStrings(item, this);
    else throw new IndexOutOfBoundsException("No can't do this!");

  }
}
