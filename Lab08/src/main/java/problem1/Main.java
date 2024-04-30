package problem1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>();
    list.add(3);
    list.add(7);
    list.add(3);
    list.add(7);
    list.add(3);
    list.add(5);

    Map<Integer, Double> ret = FrequencyCounter.countFrequency(list);
    for(Map.Entry<Integer, Double> entry : ret.entrySet()) {
      System.out.println("Num " + entry.getKey() + " appear in the given list " + entry.getValue());
    }


  }

}
