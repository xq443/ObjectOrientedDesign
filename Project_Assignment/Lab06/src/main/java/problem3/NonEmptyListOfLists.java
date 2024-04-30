package problem3;

import problem1.ListOfIntegers;

public class NonEmptyListOfLists implements ListOfListsOfInteger {
  private ListOfIntegers headList;
  private ListOfListsOfInteger restOfTheListOfLists;

  public NonEmptyListOfLists(ListOfIntegers headList, ListOfListsOfInteger restOfTheListOfLists) {
    this.headList = headList;
    this.restOfTheListOfLists = restOfTheListOfLists;
  }

  public NonEmptyListOfLists(ListOfIntegers headList) {
    this.headList = headList;
    this.restOfTheListOfLists = new EmptyListOfLists();
  }

  public ListOfIntegers getHeadList() {
    return headList;
  }

  public ListOfListsOfInteger getRestOfTheListOfLists() {
    return restOfTheListOfLists;
  }

  @Override
  public Integer size() {
    return 1 + this.restOfTheListOfLists.size();
  }

  @Override
  public Integer length() {
    return this.headList.count() + this.restOfTheListOfLists.length();
  }

  @Override
  public Integer sum() {
    return this.headList.sumElements() + this.restOfTheListOfLists.sum();
  }

  @Override
  public Boolean isEmpty() {
    return Boolean.FALSE;
  }

  @Override
  public ListOfListsOfInteger add(ListOfIntegers list) {
    return new NonEmptyListOfLists(list, this);
  }

  @Override
  public ListOfListsOfInteger removeInteger(Integer element) {
    if(this.headList.contains(element)) return new NonEmptyListOfLists(this.headList.remove(element),
        this.getRestOfTheListOfLists());
    else return new NonEmptyListOfLists(this.headList, this.getRestOfTheListOfLists().removeInteger(element));
  }
  @Override
  public ListOfListsOfInteger removeAllInteger(Integer element) {
    if(this.headList.contains(element)) return new NonEmptyListOfLists(this.headList.remove(element), this.getRestOfTheListOfLists().removeAllInteger(element));
    else return new NonEmptyListOfLists(this.headList, this.getRestOfTheListOfLists().removeInteger(element));
  }
}
