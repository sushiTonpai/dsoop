public class Last {
    public static Integer binarySearch(int[] a, int left, int right, int x) {
        if (left <= right) {
            int midIndex = left + (right - left) / 2;
            if ((a[midIndex] == x) && (midIndex == a.length - 1 || x < a[midIndex + 1]))
                return midIndex;          // mid is x and mid is the last ele.
//            ele is in half left ==> mid is greater than ele.
            else if (a[midIndex] > x) return binarySearch(a, left, midIndex - 1, x);
//            ele is in half right.
            else return binarySearch(a, midIndex + 1, right, x);
        } else return null;
    }

    public static Integer binarySearchLast(int[] a, int k) {
        return binarySearch(a, 0, a.length - 1, k);
    }

    public static void main(String[] args) {
        int[] a = {1, 5, 5, 6, 6};
        System.out.println(binarySearchLast(a, 1));
    }
}
