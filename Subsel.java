package a1;

import java.util.Arrays;

public class Subsel {
    public static int[] takeEvery(int[] a , int stride, int beginWith){
        int out_len;
        if (stride > 0) {
            out_len = (a.length - beginWith) / stride;
            out_len = (a.length - beginWith) % stride == 0 ? out_len : out_len + 1;
        } else {
            out_len = (beginWith + 1) / Math.abs(stride);
            out_len = (beginWith + 1) % Math.abs(stride) == 0 ? out_len : out_len + 1;
        }
        if (a.length == 0){
            int[] out = new int[0];
            return out;
        }
        int[] out = new int[out_len];
        for (int i = 0;i < out.length;i++){
            out[i] = a[beginWith + i*stride];
        }
        return out;
    }
    public static int[] takeEvery(int[] a, int stride){
        return takeEvery(a,stride,0);
    }

    public static void main(String[] args) {
        int[] a = new int[3];
        a[0] = 0;
        a[1] = 1;

        System.out.println(a[2]);
        System.out.println(Arrays.toString(takeEvery(new int[]{}, -1, 0)));
        System.out.println(Arrays.toString(takeEvery(new int[]{1, 2, 3, 4}, 2)));
        System.out.println(Arrays.toString(takeEvery(new int[]{2, 7, 1, 8, 4, 5}, 3, 2)));
        System.out.println(Arrays.toString(takeEvery(new int[] {3, 1, 4, 5, 9, 2, 6, 5}, -1, 5)));

    }
}
