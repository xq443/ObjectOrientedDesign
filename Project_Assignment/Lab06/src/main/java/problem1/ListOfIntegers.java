package problem1;

public interface ListOfIntegers {
  Boolean contains(Integer element);
  Integer elementAt(Integer index);
  Integer count();

  // include for the sake of p3
  Integer sumElements();
  ListOfIntegers remove(Integer element);

}
