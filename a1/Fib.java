package a1;

import java.math.BigInteger;

public class Fib {
    public static BigInteger fib(int k){
        if (k <= 2)
            return BigInteger.ONE;
        else
            return fib(k - 1).add(fib(k - 2));
    }
    public static int firstNDigit(int n){
        BigInteger first = BigInteger.ONE;
        BigInteger second = BigInteger.ZERO;
        BigInteger keeper;

        int count = 1;
        if (n <= 0)
            return 0;
        while (first.toString().length() < n)
        {
            keeper = first;
            first = first.add(second);
            second = keeper;

            count++;
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println(firstNDigit(-2));
        System.out.println(firstNDigit(2));
        System.out.println(firstNDigit(400));
    }
}
