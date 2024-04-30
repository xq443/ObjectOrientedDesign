package problem3;

import problem1.ListOfIntegers;

public class EmptyListOfLists implements ListOfListsOfInteger{


  @Override
  public Integer size() {
    return 0;
  }

  @Override
  public Integer length() {
    return 0;
  }

  @Override
  public Integer sum() {
    return 0;
  }

  @Override
  public Boolean isEmpty() {
    return Boolean.TRUE;
  }

  @Override
  public ListOfListsOfInteger add(ListOfIntegers list) {
    return new NonEmptyListOfLists(list, this);
  }

  @Override
  public ListOfListsOfInteger removeInteger(Integer element) {
    return this;
  }

  @Override
  public ListOfListsOfInteger removeAllInteger(Integer element) {
    return this;
  }
}
