import java.util.*;

public class str_to_in {
    public static int myAtoi(String str) {
        int num = 0;
        boolean is_minus = false;
        for (int i = 0;i < str.length(); ++i) {
            char c = str.charAt(i);
            char next_c = ' ';
            if (i + 1 < str.length())
                next_c = str.charAt(i + 1);
            if (c == ' ' || (c == '+' && Character.isDigit(next_c))) continue;
            else if (c == '-' && Character.isDigit(next_c)) is_minus = true;
            else if (Character.isDigit(c)) {
                num = ((long) (num * 10 + c - '0')) <= Integer.MAX_VALUE ? num * 10 + c - '0' : Integer.MAX_VALUE;
                if (!Character.isDigit(next_c))
                    break;
            }
        }
        if (is_minus) {
            if (-num < Integer.MIN_VALUE)
                num = Integer.MIN_VALUE;
            else
                num = -num;
        }

        return num;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(myAtoi(s));
        System.out.println(Integer.MAX_VALUE);
    }
}
