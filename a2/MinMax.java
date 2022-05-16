package a2;

import java.util.ArrayList;
import java.util.Arrays;


public class MinMax {
    public static int arraysTomax(ArrayList<Integer> numbers){
        int maxsofar = numbers.get(0);
        for (int i =1;i < numbers.size();i++){
            if (maxsofar < numbers.get(i))
                maxsofar = numbers.get(i);
        }
        return maxsofar;
    }
    public static int arraysTomin(ArrayList<Integer> numbers){
        int minsofar = numbers.get(0);
        for (int i = 1;i < numbers.size();i++){
            if (minsofar > numbers.get(i))
                minsofar = numbers.get(i);
        }
        return minsofar;
    }
    public static double minMaxAverage(int[] numbers){
        int myMin;
        int myMax;
        ArrayList<Integer> w = new ArrayList<>();
        ArrayList<Integer> l = new ArrayList<>();
        int size = numbers.length;
        int oddkeeper = numbers[0];

        if (numbers.length % 2 != 0){
            size = numbers.length-1;
            oddkeeper = numbers[numbers.length-1];
        }
        for (int i = 0;i < size;i = i+2){
            if (numbers[i] < numbers[i+1]){
                l.add(numbers[i]);
                w.add(numbers[i+1]);
            }
            else{
                w.add(numbers[i]);
                l.add(numbers[i+1]);
            }
        }
        myMin = arraysTomin(l);
        myMax = arraysTomax(w);

        if (myMax < oddkeeper){
            myMax = oddkeeper;
        }
        else if (myMin > oddkeeper){
            myMin = oddkeeper;
        }
        return (myMin+myMax)/2;
    }

    public static void main(String[] args) {
        int[] lst = new int[99];
        for (int i =1 ;i < 100;i++){
            lst[i-1] = i;
        }
        System.out.println(Arrays.toString(lst));
        System.out.println(minMaxAverage(lst));
    }
}