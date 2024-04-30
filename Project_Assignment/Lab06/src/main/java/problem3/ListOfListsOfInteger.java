package problem3;

import problem1.ListOfIntegers;

public interface ListOfListsOfInteger {

  /**
   * returns the number of list of integers inside this list, e.g., ((), (1), (2 3)) returns 3
   * @return
   */
  Integer size();
  /**
   * returns the number of total integers inside this list, e.g., ((), (), (2, 3)) returns 2
   * @return
   */
  Integer length();


  /**
   * returns the sum of all integers inside this list, e.g., ((), (1), (2 3)) returns 6
   * @return
   */
  Integer sum();

  Boolean isEmpty();

  /**
   * takes a list of integers and prepends (adds) it to this list of list of integers
   * @return
   */
  ListOfListsOfInteger add(ListOfIntegers list);

  /**
   * takes an integer and removes the first occurrence of this integer in the list
   * @return
   */
  ListOfListsOfInteger removeInteger(Integer element);

  /**
   * takes an integer and removes the all occurrence of this integer in the list
   * @param element
   * @return
   */
  ListOfListsOfInteger removeAllInteger(Integer element);


















}
