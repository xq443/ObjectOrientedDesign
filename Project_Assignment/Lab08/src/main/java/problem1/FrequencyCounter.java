package problem1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencyCounter {

  public FrequencyCounter() {
  }
  public static Map<Integer, Double> countFrequency(List<Integer> list) {
    Map<Integer, Double> ret = new HashMap<>();
    double defaultValue = (double) (1.0/list.size());
    for(Integer element : list) {
      double curr = ret.getOrDefault(element, 0.0);
      ret.put(element, curr + defaultValue);
    }
    return ret;
  }
}
