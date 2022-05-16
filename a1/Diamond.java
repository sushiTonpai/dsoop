package a1;

public class Diamond {
    public static void printDiamond(int k) {
        for (int i = 0; i < k; i++) {
            for (int m = 0; m < k - i; m++) {
                System.out.printf("#");
            }
            for (int n = 0; n < 2 * i + 1; n++) {
                System.out.printf("*");
            }
            for (int m = 0; m < k - i; m++) {
                System.out.printf("#");
            }
            System.out.println();
        }
        for (int i = k - 1; i > 0; i--) {
            for (int m = 0; m < k - i + 1; m++) {
                System.out.printf("#");
            }
            for (int n = 0; n < 2 * i - 1; n++) {
                System.out.printf("*");
            }
            for (int m = 0; m < k - i + 1; m++) {
                System.out.printf("#");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 11; i++)
        {
            printDiamond(i);
        }
    }
}
