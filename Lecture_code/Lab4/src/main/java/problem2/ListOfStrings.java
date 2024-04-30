package problem2;

public interface ListOfStrings {

    Boolean isEmpty();
    Integer size();
    Boolean contains(String elem);
    Boolean containsAll(ListOfStrings sublist);
    ListOfStrings filterLargerThan(Integer cuttoffSize);
    Boolean hasDuplicates();

    ListOfStrings removeDuplicates();

}
