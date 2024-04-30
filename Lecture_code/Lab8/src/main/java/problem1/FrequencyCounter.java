package problem1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencyCounter {

    public FrequencyCounter() {
    }

    public static Map<Integer, Double> countFrequnecies(List<Integer> integersList){

        Map<Integer, Double> frequencyMap = new HashMap<>();
        Double defaultValue = (double) (1.0/integersList.size());
        for(Integer elem: integersList){
            double count = frequencyMap.getOrDefault(elem, 0.0);
            frequencyMap.put(elem, count + defaultValue);
        }
        return frequencyMap;
    }
}
