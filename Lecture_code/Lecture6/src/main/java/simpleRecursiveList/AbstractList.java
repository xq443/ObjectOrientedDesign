package simpleRecursiveList;

public abstract class AbstractList implements List{

  public List add(Integer element) {
    return new Cons(element, this);
  }

}
