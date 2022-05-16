package a1;

public class Hidden {
    public static boolean isHidden(String s, String t) {
        int i = 0;
        int j = 0;
        do {
            if (s.charAt(i) == t.charAt(j)) {
                j++;
            }
            i++;
            if (j == t.length())
                return true;
        } while (i != s.length());
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isHidden("welcometothehotelcalifornia", "melon"));
        System.out.println(isHidden("welcometothehotelcalifornia", "space"));
        System.out.println(isHidden("TQ89MnQU3IC7t6", "MUIC"));
        System.out.println(isHidden("VhHTdipc07", "htc"));
        System.out.println(isHidden("VhHTdipc07","hTc"));
    }
}
