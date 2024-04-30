package forEachLoop;

import java.util.*;

public class Main {

  public static void main(String[] args) {
    List<String> names = new ArrayList<>();
    names.add("Jane Doe");
    names.add("John Smith");
    names.add("Paul Sing");

    for(String name: names){
      System.out.println(name);
    }

    Set<String> nameSet = new TreeSet<>();
    nameSet.add("Paul Sing");
    nameSet.add("Jane Doe");
    nameSet.add("John Smith");

    for(String name: nameSet){
      System.out.println("A " + name);
    }

    Map<Integer, String> indexedNames = new HashMap<>();
    indexedNames.put(1, "Jane Doe");
    indexedNames.put(2, "John Smith");
    indexedNames.put(3, "Paul Sing");

    for(Map.Entry<Integer, String> mapElement: indexedNames.entrySet()){
      System.out.println("The index is: "+ mapElement.getKey());
      System.out.println("The value is: " + mapElement.getValue());
    }
  }
}
