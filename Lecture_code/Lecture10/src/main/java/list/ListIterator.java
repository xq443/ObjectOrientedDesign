package list;

import java.util.Iterator;

public class ListIterator<T> implements Iterator<T> {
  private IListADT<T> current;

  public ListIterator(IListADT<T> current) {
    this.current = current;
  }

  @Override
  public boolean hasNext() {
    return this.current.size() > 0;
  }

  @Override
  public T next() {
    T element = this.current.itemAt(0);
    this.current = this.current.getNext();
    return element;
  }

  @Override
  public void remove() {
    System.out.println("Don't even think about it!");
  }
}
