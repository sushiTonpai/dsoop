package a2.mydeque;

public class ArrayDeque<T> {
    private T[] items;

    //    getter
    public T[] getItems() {
        return items;
    }

    public int getEnd() {
        return end;
    }

    public int getStart() {
        return start;
    }

    public int getCircSize() {
        return circSize;
    }

    //    pointer
    private int end;
    private int start;
    private int circSize;

    //    constructor
    public ArrayDeque() {
        circSize = 3;
        items = (T[]) new Object[circSize];
        end = -1;
        start = -1;
    }

    //    deep copy
    public ArrayDeque(ArrayDeque<T> other) {
        items = (T[]) new Object[other.circSize];
        System.arraycopy(other.items, 0, items, 0, other.circSize);
        end = other.end;
        start = other.start;
    }

    //    check array condition
    public boolean isEmpty() {
        return (end == -1 && start == -1);
    }

    public boolean isFull() {
        return (end + 1) % circSize == start;
    }

    //    expand Arrays
    private void back_grow(int newCap) {
        T[] expand = (T[]) new Object[newCap];
        for (int i = 0; i < items.length; i++) {
            expand[i] = items[start];
            start = (start + 1) % circSize;
        }
        items = expand;
        start = 0;
        end = circSize - 1;
    }

//    private void grow_front(int newCap) {
//        T[] expand = (T[]) new Object[newCap];
//        System.arraycopy(items, 0, expand, 0, circSize);
//        items = expand;
//    }


    public int size() {
        if (this.isEmpty()) {
            return 0;
        }
        int pointer = start;
        int counter = 1;
        while (pointer != end) {
//            System.out.println(pointer);
            counter++;
            pointer = (pointer + 1) % circSize;
        }
//        System.out.println("start:" + start);
//        System.out.println("end:" + end);
        return counter;
    }


    public void addLast(T item) {
        if (this.isFull()) {
            back_grow(2 * circSize);
            circSize = circSize * 2;
        }
        if (this.isEmpty()) {
            start = 0;
            end = 0;
        } else {
            end = (end + 1) % circSize;
        }
        items[end] = item;
//        System.out.println(Arrays.toString(items));
    }

    public void addFirst(T item) {
        if (this.isFull()) {
            back_grow(2 * circSize);
            circSize = circSize * 2;
        }
        if (this.isEmpty()) {
            start = 0;
            end = 0;
        } else if (start == 0) {
            start = circSize - 1;
        } else
            start--;
        items[start] = item;
//        System.out.println(Arrays.toString(items));
    }

    public T removeLast() {
        if (this.isEmpty()) {
            return null;
        }
        T out = items[end];
        items[end] = null;
        if (start == end) {
            start = -1;
            end = -1;
        } else if (end == 0) {
            end = circSize - 1;
        } else
            end--;
        return out;
    }

    public T removeFirst() {
        if (this.isEmpty()) {
            return null;
        }
        T out = items[start];
        items[start] = null;
        if (start == end) {
            start = -1;
            end = -1;
        } else {
            start = (start + 1) % circSize;
        }
        return out;
    }


    public String toString() {
        String out = "";
        int pointer = start;
        while (pointer != end) {
//            System.out.println("String:Index" + pointer);
            out = out + items[pointer] + ", ";
            pointer = (pointer + 1) % circSize;
        }
        out += items[pointer];
        return out;
    }

    public T get(int index) {
        if (index <= -1 || index > this.size()) {
            return null;
        }
        if (this.isEmpty()) {
            return null;
        }
        return items[(start + index) % circSize];
    }


    public static void main(String[] args) {
        ArrayDeque<Integer> ad = new ArrayDeque<>();
//        System.out.println(ad.isEmpty());
//        ad.addFirst(2);
//        ad.addFirst(3);
//        ad.addLast(9);
//        ad.addLast(9);
//        ad.addFirst(5);
//        ad.addLast(6);
//        ad.addFirst(4);
//        ad.addLast(8);
//        ad.addLast(22);
//        System.out.println(ad.removeLast());
//        System.out.println(ad.removeFirst());
//        ad.removeFirst();
//        ad.removeLast();

        for (int i = 1; i <= 20; i++) {
            if (i % 2 == 0) {
                ad.addFirst(i * 3);
            } else
                ad.addLast(i * 2);
            System.out.println(ad);
            if (i % 4 == 0) {
                System.out.println("remove last ==>" + ad.removeLast());
                System.out.println("size:"+ad.size());
            } else if (i % 7 == 0) {
                System.out.println("remove first ==>" + ad.removeFirst());
                System.out.println("size:"+ad.size());
            }
        }
        System.out.println(ad.size());
        System.out.println(ad);
//        System.out.println(ad.get(6));

    }
}
