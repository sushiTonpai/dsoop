package a1;

public class Roman {
    public static int romanToInt(String romanNum) {
        int out;
        int res = 0;
        int last_out = 0;
        for (int i = romanNum.length() - 1; i >= 0; i--) {
            switch (romanNum.charAt(i)) {
                case 'I':
                    out = 1;
                    break;
                case 'V':
                    out = 5;
                    break;
                case 'X':
                    out = 10;
                    break;
                case 'L':
                    out = 50;
                    break;
                case 'C':
                    out = 100;
                    break;
                case 'D':
                    out = 500;
                    break;
                case 'M':
                    out = 1000;
                    break;
                default:
                    out = 0;
            }
            if (last_out > out) {
                res = res - out;
            } else {
                last_out = out;
                res = res + out;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(romanToInt(""));
        System.out.println(romanToInt("I"));
        System.out.println(romanToInt("II"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("VI"));
        System.out.println(romanToInt("LXXI"));
        System.out.println(romanToInt("XCVI"));
        System.out.println(romanToInt("XXXIV"));
        System.out.println(romanToInt("LVI"));

    }
}