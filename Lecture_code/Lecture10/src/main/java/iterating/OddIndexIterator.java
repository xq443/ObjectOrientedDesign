package iterating;

import java.util.ArrayList;
import java.util.Iterator;

public class OddIndexIterator<X> implements Iterator<X> {

    private AList<X> listToIterate;

    public OddIndexIterator(Cons<X> listToIterate) {
        this.listToIterate = this.filterElements(listToIterate);
    }

    private AList<X> filterElements(Cons<X> elements){
        AList<X> listToReturn = (AList ) new Empty<X>(); //should be empty
        for(int i = 0; i < elements.size(); i++){
            if(i%2 != 0)
                listToReturn.add(elements.elementAt(i));
        }
        return listToReturn;
    }

    @Override
    public boolean hasNext() {
        return !this.listToIterate.isEmpty();
    }

    @Override
    public X next() {
        X element;
        try{
            element = this.listToIterate.getFirst();
            this.listToIterate = (Cons) listToIterate.getRest();
        } catch(NullPointerException e) {
            throw new GenericListException("This operation is not supported!");
        }
        return element;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Please dont' remove elements from a collection with an iterator!");
    }
}
