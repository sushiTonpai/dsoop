import java.util.Arrays;

public class Zombies {
    public static int NaiveZombies(int[] hs) {
        int badPairs = 0;
        for (int i = 0; i < hs.length; i++)
            for (int j = i + 1; j < hs.length; j++)
                if (hs[i] < hs[j]) badPairs++;
        return badPairs;
    }

    static void merge(int[] a, int[] l, int[] r) {
        int i = 0;
        int j = 0;
        int c = 0;
        for (int k = 0; k < a.length; k++) {
            if (i >= l.length) a[k] = r[j++];
            else if (j >= r.length) a[k] = l[i++];
//            compare l and r to insert.
            else if (l[i] <= r[j]) a[k] = l[i++];
            else {
                a[k] = r[j++];
                c++;
            }
        }
        System.out.println(c);
    }

    static void sort(int[] a) {
        int n = a.length;
        if (n <= 1) return;
        int[] l = Arrays.copyOfRange(a, 0, n / 2);
        int[] r = Arrays.copyOfRange(a, n / 2, n);

        sort(l);
        sort(r);
        merge(a, l, r);
    }
//    countBad = c given hs is sorted[Max of c] - (c*number of times c is called)
    public static int countBad(int[] hs) {
        return 0;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        int b = NaiveZombies(a);
        System.out.println(b);
        sort(a);
    }

}
