package lists.genericinterface;

import docsandvets.Vet;

public abstract class AList<X> implements List<X> {

  public static <Y> List<Y> createEmpty() {
    return new Empty<>();
  }

  // List<Integer> myList = AList<X>.createEmpty();

  @Override
  public List<X> add(X element) {

    return new Cons(element, this);
  }
//}

  List<String> names = AList.createEmpty();
  List<Double> numbers = AList.createEmpty();
  List<Vet> vets = AList.createEmpty();

  List<Integer> someOtherList = new Empty<>();
}