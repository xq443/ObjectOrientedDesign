package problem3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SwimmerIterator implements Iterator {
  private List<Swimmer> swimmers;
  private static final Double OLYMPIC_CUTOFF = 26.17;
  private static final int BUTTERFLY_TIME_CUTOFF = 5;

  public SwimmerIterator(List<Swimmer> swimmers) {
    this.swimmers = this.filterOutSwimmer(swimmers);
  }

  private List<Swimmer> filterOutSwimmer(List<Swimmer> swimmers) {
    List<Swimmer> filterSwimmer = new ArrayList<>();
    for(Swimmer swimmer : swimmers) {
      if(this.isSwimmerQualified(swimmer)) {
        filterSwimmer.add(swimmer);
      }
    }
    return filterSwimmer;
  }

  private Boolean isSwimmerQualified(Swimmer swimmer) {
    return (swimmer.getButterfly50mTimes().size() >= BUTTERFLY_TIME_CUTOFF) &&
        this.isFreeStyleQualified(swimmer);
  }
  private Boolean isFreeStyleQualified(Swimmer swimmer) {
    for(Double freeStyleTime : swimmer.getFreestyle50mTimes()) {
      if(freeStyleTime <= OLYMPIC_CUTOFF) return true;
    }
    return false;
  }

  @Override
  public boolean hasNext() {
    return this.swimmers.size() > 0;
  }

  @Override
  public Object next() {
    return this.swimmers.remove(0);
  }

  @Override
  public void remove() {
    throw new RuntimeException("Don't do this");
  }
}
