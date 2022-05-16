package a1;

import java.util.Arrays;

public class Happy {

    public static long sumOfDigitsSquared(long n) {
        long dig;
        long res = 0;
        do {
            dig = n % 10;
            res = res + dig * dig;
            n = n / 10;
        } while (n >= 1);
        return res;
    }

    public static boolean isHappy(long n) {
        long i = n;
        while (true) {
            i = sumOfDigitsSquared(i);
            if (i == 1) return true;
            else if (i == 4) return false;
        }
    }

    public static long[] firstK(int k) {
        long[] out = new long[k];
        int i = 0;
        long nums = 1;
        do {
            if (isHappy(nums)) {
                out[i] = nums;
                i++;
            }
            nums++;
        } while (i != k);
        return out;
    }

    public static void main(String[] args) {
        System.out.println(sumOfDigitsSquared(99999999));
        System.out.println(isHappy(7777777));
        System.out.println(isHappy(111));
        System.out.println(isHappy(1234));
        System.out.println(isHappy(989));
        System.out.println(isHappy(2));
        System.out.println(isHappy(69));
        System.out.println(Arrays.toString(firstK(40)));
    }
}

