package problem1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    list.add("NEU");
    list.add("NEU");
    list.add("Cathy");
    list.add("Seattle");
    list.add("Seattle");
    list.add("Seattle");

    Map<String, Integer> ret = TrendingTopics.countTopics_traditional(list);
    for(Map.Entry<String, Integer> entry : ret.entrySet()) {
      System.out.println("String " + entry.getKey() + " appear in the given list " + entry.getValue());
    }
  }
}
