package a2.mydeque;

public class LinkedListDeque<T> {
    private T head;
    private LinkedListDeque<T> rest;
    private LinkedListDeque<T> prev;

    //        constructor
    public LinkedListDeque(T head, LinkedListDeque<T> rest, LinkedListDeque<T> prev) {
        this.head = head;
        this.rest = rest;
        this.prev = prev;
    }

    // deep copy
    public LinkedListDeque(LinkedListDeque<T> other) {
        new LinkedListDeque<T>();
        while (true) {
            other = other.rest;
            if (other.rest == null){
                break;
            }
            this.addLast(other.head);
        }
    }

    private LinkedListDeque<T> sen;
    private int size;

    public LinkedListDeque() {
        sen = new LinkedListDeque<>(null, null, null);
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String toString() {
        LinkedListDeque<T> current = sen.rest;
        String out = "";
        if (current == null) {
            return out;
        }
        while (current.rest != null) {
            out = out + current.head + ", ";
            current = current.rest;
        }
        out = out + current.head;
        return out;
    }

    public void addFirst(T item) {
        LinkedListDeque<T> newNode = new LinkedListDeque<>(item, sen.rest, sen);
        if (sen.rest == null) {
            sen.prev = newNode;
        } else {
            sen.rest.prev = newNode;
        }
        sen.rest = newNode;
        size++;
    }

    public void addLast(T item) {
        LinkedListDeque<T> newNode = new LinkedListDeque<>(item, null, sen.prev);
        if (sen.prev == null) {
            sen.rest = newNode;
        } else {
            sen.prev.rest = newNode;
        }
        sen.prev = newNode;
        size++;
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        LinkedListDeque<T> home = sen.rest;
        if (sen.rest.rest != null) {
            sen.rest.rest.prev = sen;
            sen.rest = sen.rest.rest;
        } else {
            sen.rest = null;
            sen.prev = null;
        }
        size--;
        return home.head;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        LinkedListDeque<T> last = sen.prev;
        if (size > 1) {
            sen.prev = sen.prev.prev;
            sen.prev.rest = null;
        } else {
            sen.prev = null;
            sen.rest = null;
        }
        size--;
        return last.head;
    }

    public T get(int index) {
        LinkedListDeque<T> pointer = sen.rest;
        if (size == 0)
            return null;
        for (int i = 0; i < index; i++) {
            pointer = pointer.rest;
            if (pointer == null) {
                return null;
            }
        }
        return pointer.head;
    }

    public static void main(String[] args) {
        LinkedListDeque<Integer> a = new LinkedListDeque<>();
        LinkedListDequeTest.checkEmpty(true, a.isEmpty());

//        System.out.println(a.isEmpty());
        a.addLast(1);
//        a.addLast(9);
//        a.addLast(0);
        System.out.println(a);
//        a.removeLast();
//        System.out.println(a);
        System.out.println(a.removeLast());
//        System.out.println(a.isEmpty());

        System.out.println(a.get(0));
        System.out.println(a.get(1));
        System.out.println(a.get(2));

//        System.out.println(a);

    }
}
