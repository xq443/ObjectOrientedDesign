package problem3;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SwimmerIterator implements Iterator {

    private static final int BUTTERFLY_SWIMTIMES_CUTOFF = 5;
    private static final Double OLYMPIC_CUTOFF = 26.17;
    private List<Swimmer> swimmers;

    public SwimmerIterator(List<Swimmer> swimmers) {
        this.swimmers = this.filterOutSwimmer(swimmers);
    }

    private List<Swimmer> filterOutSwimmer(List<Swimmer> swimmers){
        List<Swimmer> filteredSwimmers = new ArrayList<>();
        for(Swimmer swimmer: swimmers){
            if(this.isSwimmerQualified(swimmer))
                filteredSwimmers.add(swimmer);
        }
        return filteredSwimmers;
    }

    private Boolean isSwimmerQualified(Swimmer swimmer){
        return (swimmer.getButterfly50mTimes().size() >= BUTTERFLY_SWIMTIMES_CUTOFF)
                && this.isFreesytleQualified(swimmer);
    }

    private Boolean isFreesytleQualified(Swimmer swimmer){
        for(Double freestyleTime : swimmer.getFreestyle50mTimes()){
            if(freestyleTime <= OLYMPIC_CUTOFF)
                return true;
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
        throw new RuntimeException("Please don't do this!");
    }
}
