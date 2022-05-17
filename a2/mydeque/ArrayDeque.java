package a2.mydeque;

public class ArrayDeque<T> {
    private T[] items;

    //    pointer
    private int end;
    private int start;
    private int circSize;

    //    constructor
    public ArrayDeque() {
        circSize = 8;
        items = (T[]) new Object[circSize];
        end = 0;
        start = 0;
    }
//    deep copy
    public ArrayDeque(ArrayDeque<T> other){

    }


    private void grow(int newCap) {
        T[] expand = (T[]) new Object[newCap];
        System.arraycopy(items, 0, expand, 0, circSize);
        items = expand;
    }


    public int size(){
        return end-start;
    }
    public void addLast(T item) {
        items[end] = item;
        end++;
    }

    public void addFirst(T item) {
        items[start] = item;
        start++;
    }

    public T removeLast() {
        return null;

    }

    public T removeFirst(){
        return null;
    }
    public boolean isEmpty() {
    return (end - start == 0);
    }

    public String toString(){
        String out = "";
        for (int pointer = start;pointer < end-1; pointer++){
            out = out + (items[pointer]) + ", ";
        }
    return out + items[end-1];
    }

    public T get(int index){
        if(index < 0 || index > end-start)
            return null;
        T out =  items[0];
        for (int pointer = 0; pointer <= index;pointer++){
            out = items[pointer];
        }
        return out;
    }


    public static void main(String[] args) {
        ArrayDeque<Integer>  ad = new ArrayDeque<>();
        System.out.println(ad.isEmpty());
        ad.addLast(2);
        ad.addLast(3);
        System.out.println(ad.isEmpty());
//        System.out.println(ad.get(0));
        System.out.println(ad);
    }
}
