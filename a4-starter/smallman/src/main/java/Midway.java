public class Midway {
    class ArrayView {
        private int[] originalArray;
        private int start;
        private int end;
        private int size;

        public ArrayView(int[] array, int start, int end) {
            this.originalArray = array;
            this.start = start;
            this.end = end;
            this.size = end - start;
        }

        public int get(int i) {
            return originalArray[i];
        }

        public int size() {
            return size;
        }

        public ArrayView subarray(int start, int end) {
            return new ArrayView(this.originalArray, start, end);
        }
    }

    public static long remainingHelper(ArrayView disks, int from, int to, int aux) {
        int n = disks.size();
        if (n == 0) return 0;
        if (disks.get(n - 1) == to)
            return remainingHelper(disks.subarray(0, n - 1), aux, to, from);
        else
            return remainingHelper(disks.subarray(0, n - 1), from, aux, to) + (long) Math.pow(2, n - 1);
    }

    public static long stepsRemaining(int[] diskPos) {
        ArrayView arrayView = new Midway().new ArrayView(diskPos, 0, diskPos.length);
        return remainingHelper(arrayView, 0, 1, 2);
    }

    public static void main(String[] args) {
        System.out.println(stepsRemaining(new int[]{2, 2, 1, 1, 2, 2, 1}));
    }
}

