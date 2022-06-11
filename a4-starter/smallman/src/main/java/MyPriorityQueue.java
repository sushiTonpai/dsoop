import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyPriorityQueue<T> implements IPriorityQueue<T> {
    private List<T> queueItems;
    private int size = 0;
    private CompareWith<T> cc;

    public MyPriorityQueue(CompareWith<T> cc) {
        queueItems = new ArrayList<>();
        this.cc = cc;
    }

    public boolean lessThan(Integer a, Integer b) {
        return a < b;
    }

    @Override
    public void add(T item) {
        if (size == 0) {
            queueItems.add(item);
        } else {
            for (int i = 0; i < size; i++) {
                T pointer = queueItems.get(i);
                if (cc.lessThan(pointer, item)) {
                    queueItems.add(i, item);
                } else {
                    queueItems.add(size, item);
                }
            }
        }
        size++;
    }

    @Override
    public void addAll(List<T> items) {
        for (T item : items) {
            queueItems.add(item);
        }
    }

    @Override
    public T getMinimum() {
        return queueItems.get(0);
    }

    @Override
    public void removeMinimum() {
        queueItems.remove(0);
    }

    @Override
    public int size() {
        return this.size;
    }

    private class ArraySetIterator implements Iterator<T> {
        private int itPos; // pointer

        public ArraySetIterator() {
            itPos = 0;
        }

        public boolean hasNext() {
            return itPos < queueItems.size();
        }

        public T next() {
            return queueItems.get(itPos++);
        }

    }

    private class backIter implements Iterator<T> {
        private int itPos; // pointer

        public backIter() {
            itPos = size - 1;
        }

        public boolean hasNext() {
            return itPos > 0;
        }

        public T next() {
            return queueItems.get(itPos--);
        }

    }

    @Override
    public Iterator<T> iterator() {
        return new ArraySetIterator();
    }

    @Override
    public Iterator<T> revIterator() {
        return new backIter();
    }
}
