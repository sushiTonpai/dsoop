package histogram;

import java.util.HashMap;
import java.util.Iterator;

// TODO: Uncomment this and make sure to implement all the methods
public class SimpleHistogram<DT> implements Histogram<DT>, Iterable<DT> {
    private HashMap<DT, Integer> ht = new HashMap<>();

    public int getTotalCount() {
        int total = 0;
        for (DT key : ht.keySet()){
            total += ht.get(key);
        }
        return total;
    }

    public int getCount(DT item) {
        return ht.get(item);
    }

    public void setCount(DT item, int count) {
        if (!ht.containsKey(item)){ht.put(item, 1);}
        else
        {
            ht.put(item, count);
        }
    }


    // constructor
    public SimpleHistogram() {
        ht = new HashMap<>();
    }

    public SimpleHistogram(DT[] items) {
        for (DT item : items) {
            if (ht.containsKey(item)) {
                ht.put(item, ht.get(item) + 1);
            } else ht.put(item, 1);
        }
    }

    public SimpleHistogram(Histogram<DT> hist) {
        for (DT item : hist){
            ht.put(item , hist.getCount(item));
        }
    }

    // iterator
    public Iterator<DT> iterator(){
        return new htIterator();
    }

    class htIterator implements Iterator<DT>{
        Iterator<DT> pointer = ht.keySet().iterator();
//        public htIterator(SimpleHistogram<DT> dts) {
//        }

        @Override
        public boolean hasNext() {
            return pointer.hasNext();
        }

        @Override
        public DT next() {
            return pointer.next();
        }
    }
// toString
// equals
}
