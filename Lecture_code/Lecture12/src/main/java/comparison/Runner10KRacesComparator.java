package comparison;

import java.util.Comparator;

public class Runner10KRacesComparator implements Comparator<Runner> {

    @Override
    public int compare(Runner o1, Runner o2) {
        return o1.getTenKRaceTimes().size() - o2.getTenKRaceTimes().size();
    }
}
